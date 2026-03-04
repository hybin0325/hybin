# Go IM 系统（新工程）

这是一个面向高并发 IM 的 Go 工程骨架，覆盖：

- Protobuf 消息协议（`proto/im.proto`）
- 扩散写发送（按 `to_user_id` hash 到分区）
- Fanout Worker 分片消费
- 离线消息拉取 + ACK
- Docker / Compose 部署

> 当前环境限制无法下载第三方依赖，工程默认使用标准库实现“文件分区队列 + 文件离线存储”，但接口分层与 Kafka/Redis 版本一致，可平滑替换。

## 架构

```text
Client -> Gateway(/send)
              -> Partitioned Fanout Queue(topic-p000...pNNN)
              -> Fanout Worker(按 worker_id/worker_count 认领分区)
              -> Offline Store

Client -> Gateway(/offline/pull, /offline/ack)
```

## API

### 发送消息

`POST /send`

```json
{
  "payload": "<base64 protobuf envelope>"
}
```

### 拉取离线

`GET /offline/pull?uid=u1001`

### ACK 离线

`POST /offline/ack`

```json
{
  "uid": "u1001",
  "ids": ["m1", "m2"]
}
```

## 运行

```bash
docker compose up --build
```

## 扩容建议

- 设置 `KAFKA_PARTITIONS`（例如 256/512）提升 fanout 并行度。
- 启动多个 worker，并设置：
  - `WORKER_COUNT=<总 worker 数>`
  - `WORKER_ID=<当前 worker 序号，从 0 开始>`
- 生产落地时替换 `internal/broker` 和 `internal/store` 为 Kafka/Redis 实现。
