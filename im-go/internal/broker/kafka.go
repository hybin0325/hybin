package broker

import (
	"bufio"
	"context"
	"encoding/base64"
	"fmt"
	"hash/fnv"
	"os"
	"path/filepath"
	"strings"
	"sync"
	"time"
)

type Message struct {
	Key       string
	Value     []byte
	Partition int
}

type Producer struct {
	mu         sync.Mutex
	topic      string
	partitions int
}

func NewProducer(_ []string, topic string, partitions int) *Producer {
	if partitions <= 0 {
		partitions = 1
	}
	_ = os.MkdirAll("data/queue", 0o755)
	return &Producer{topic: topic, partitions: partitions}
}

func (p *Producer) Publish(_ context.Context, key string, value []byte) error {
	p.mu.Lock()
	defer p.mu.Unlock()
	part := partitionFor(key, p.partitions)
	path := queueFile(p.topic, part)
	f, err := os.OpenFile(path, os.O_CREATE|os.O_WRONLY|os.O_APPEND, 0o644)
	if err != nil {
		return err
	}
	defer f.Close()
	_, err = f.WriteString(key + "|" + base64.StdEncoding.EncodeToString(value) + "\n")
	return err
}

func (p *Producer) Close() error { return nil }

type Consumer struct {
	topic       string
	partitions  int
	workerID    int
	workerCount int
	offsets     map[int]int
}

func NewConsumer(_ []string, topic, _ string, partitions, workerID, workerCount int) *Consumer {
	if partitions <= 0 {
		partitions = 1
	}
	if workerCount <= 0 {
		workerCount = 1
	}
	if workerID < 0 {
		workerID = 0
	}
	_ = os.MkdirAll("data/queue", 0o755)
	return &Consumer{topic: topic, partitions: partitions, workerID: workerID, workerCount: workerCount, offsets: map[int]int{}}
}

func (c *Consumer) Fetch(ctx context.Context) (Message, error) {
	for {
		select {
		case <-ctx.Done():
			return Message{}, ctx.Err()
		default:
		}
		for part := 0; part < c.partitions; part++ {
			if part%c.workerCount != c.workerID {
				continue
			}
			lines, err := readLines(queueFile(c.topic, part))
			if err != nil {
				return Message{}, err
			}
			offset := c.offsets[part]
			if offset >= len(lines) {
				continue
			}
			line := lines[offset]
			c.offsets[part] = offset + 1
			parts := strings.SplitN(line, "|", 2)
			if len(parts) != 2 {
				continue
			}
			v, err := base64.StdEncoding.DecodeString(parts[1])
			if err != nil {
				continue
			}
			return Message{Key: parts[0], Value: v, Partition: part}, nil
		}
		time.Sleep(80 * time.Millisecond)
	}
}

func (c *Consumer) Close() error { return nil }

func partitionFor(key string, partitions int) int {
	h := fnv.New32a()
	_, _ = h.Write([]byte(key))
	return int(h.Sum32()) % partitions
}

func queueFile(topic string, part int) string {
	return filepath.Join("data/queue", fmt.Sprintf("%s-p%03d.queue", topic, part))
}

func readLines(path string) ([]string, error) {
	f, err := os.OpenFile(path, os.O_CREATE|os.O_RDONLY, 0o644)
	if err != nil {
		return nil, err
	}
	defer f.Close()
	var lines []string
	s := bufio.NewScanner(f)
	for s.Scan() {
		lines = append(lines, s.Text())
	}
	if err := s.Err(); err != nil {
		return nil, err
	}
	return lines, nil
}
