package config

import (
	"os"
	"strconv"
)

type Config struct {
	GatewayPort   string
	KafkaBrokers  []string
	KafkaTopic    string
	KafkaParts    int
	RedisAddr     string
	RedisPassword string
	RedisDB       int
	WorkerID      int
	WorkerCount   int
}

func Load() Config {
	return Config{
		GatewayPort:   getEnv("GATEWAY_PORT", "8080"),
		KafkaBrokers:  []string{getEnv("KAFKA_BROKER", "kafka:9092")},
		KafkaTopic:    getEnv("KAFKA_TOPIC", "im_messages"),
		KafkaParts:    getInt("KAFKA_PARTITIONS", 64),
		RedisAddr:     getEnv("REDIS_ADDR", "redis:6379"),
		RedisPassword: getEnv("REDIS_PASSWORD", ""),
		RedisDB:       getInt("REDIS_DB", 0),
		WorkerID:      getInt("WORKER_ID", 0),
		WorkerCount:   getInt("WORKER_COUNT", 1),
	}
}

func getEnv(key, fallback string) string {
	if v, ok := os.LookupEnv(key); ok {
		return v
	}
	return fallback
}

func getInt(key string, fallback int) int {
	s, ok := os.LookupEnv(key)
	if !ok {
		return fallback
	}
	v, err := strconv.Atoi(s)
	if err != nil {
		return fallback
	}
	return v
}
