package main

import (
	"context"
	"log"
	"os/signal"
	"syscall"

	"github.com/hybin/im-go/internal/broker"
	"github.com/hybin/im-go/internal/config"
	"github.com/hybin/im-go/internal/protocol"
	"github.com/hybin/im-go/internal/store"
)

func main() {
	cfg := config.Load()
	consumer := broker.NewConsumer(cfg.KafkaBrokers, cfg.KafkaTopic, "fanout-worker", cfg.KafkaParts, cfg.WorkerID, cfg.WorkerCount)
	defer consumer.Close()
	offlineStore := store.NewOfflineStore(cfg.RedisAddr, cfg.RedisPassword, cfg.RedisDB)
	defer offlineStore.Close()

	ctx, stop := signal.NotifyContext(context.Background(), syscall.SIGINT, syscall.SIGTERM)
	defer stop()

	log.Printf("fanout worker started, worker=%d/%d", cfg.WorkerID, cfg.WorkerCount)
	for {
		msg, err := consumer.Fetch(ctx)
		if err != nil {
			if ctx.Err() != nil {
				return
			}
			log.Printf("fetch err: %v", err)
			continue
		}
		env, err := protocol.Unmarshal(msg.Value)
		if err != nil {
			log.Printf("decode err: %v", err)
			continue
		}
		chat := env.GetChatMessage()
		if chat == nil {
			continue
		}
		if err = offlineStore.SaveOfflineMessage(ctx, chat.ToUserID, chat.MessageID, msg.Value); err != nil {
			log.Printf("save offline err: %v", err)
		}
	}
}
