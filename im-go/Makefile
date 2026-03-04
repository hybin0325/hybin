PROTO_FILE=proto/im.proto
PROTO_OUT=internal/protocol/pb

.PHONY: proto run-gateway run-worker test

proto:
	protoc --go_out=$(PROTO_OUT) --go_opt=paths=source_relative $(PROTO_FILE)

run-gateway:
	go run ./cmd/gateway

run-worker:
	go run ./cmd/fanout-worker

test:
	go test ./...
