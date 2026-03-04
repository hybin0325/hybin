package main

import (
	"log"
	"net/http"

	"github.com/hybin/im-go/internal/broker"
	"github.com/hybin/im-go/internal/config"
	"github.com/hybin/im-go/internal/service"
	"github.com/hybin/im-go/internal/store"
)

func main() {
	cfg := config.Load()
	producer := broker.NewProducer(cfg.KafkaBrokers, cfg.KafkaTopic, cfg.KafkaParts)
	defer producer.Close()
	offlineStore := store.NewOfflineStore(cfg.RedisAddr, cfg.RedisPassword, cfg.RedisDB)
	defer offlineStore.Close()

	gw := service.NewGateway(producer, offlineStore)
	http.HandleFunc("/send", gw.HandleSend)
	http.HandleFunc("/offline/pull", gw.HandlePullOffline)
	http.HandleFunc("/offline/ack", gw.HandleAckOffline)
	log.Printf("gateway start :%s", cfg.GatewayPort)
	if err := http.ListenAndServe(":"+cfg.GatewayPort, nil); err != nil {
		log.Fatal(err)
	}
}
