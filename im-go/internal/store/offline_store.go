package store

import (
	"bufio"
	"context"
	"encoding/base64"
	"encoding/json"
	"os"
	"path/filepath"
)

type OfflineStore struct {
	base string
}

type OfflineItem struct {
	ID      string `json:"id"`
	Payload string `json:"payload"`
}

func NewOfflineStore(_, _ string, _ int) *OfflineStore {
	base := filepath.Join("data", "offline")
	_ = os.MkdirAll(base, 0o755)
	return &OfflineStore{base: base}
}

func (s *OfflineStore) SaveOfflineMessage(_ context.Context, userID, messageID string, payload []byte) error {
	path := filepath.Join(s.base, userID+".msg")
	f, err := os.OpenFile(path, os.O_CREATE|os.O_APPEND|os.O_WRONLY, 0o644)
	if err != nil {
		return err
	}
	defer f.Close()
	line, _ := json.Marshal(OfflineItem{ID: messageID, Payload: base64.StdEncoding.EncodeToString(payload)})
	_, err = f.WriteString(string(line) + "\n")
	return err
}

func (s *OfflineStore) PullOfflineMessages(_ context.Context, userID string, limit int64) ([]OfflineItem, error) {
	path := filepath.Join(s.base, userID+".msg")
	f, err := os.Open(path)
	if os.IsNotExist(err) {
		return nil, nil
	}
	if err != nil {
		return nil, err
	}
	defer f.Close()

	var out []OfflineItem
	sc := bufio.NewScanner(f)
	for sc.Scan() && int64(len(out)) < limit {
		var item OfflineItem
		if err = json.Unmarshal(sc.Bytes(), &item); err == nil {
			out = append(out, item)
		}
	}
	return out, sc.Err()
}

func (s *OfflineStore) AckOfflineMessages(_ context.Context, userID string, ids []string) error {
	if len(ids) == 0 {
		return nil
	}
	path := filepath.Join(s.base, userID+".msg")
	items, err := s.PullOfflineMessages(context.Background(), userID, 1<<62)
	if err != nil {
		return err
	}
	ackSet := map[string]struct{}{}
	for _, id := range ids {
		ackSet[id] = struct{}{}
	}
	f, err := os.OpenFile(path, os.O_CREATE|os.O_WRONLY|os.O_TRUNC, 0o644)
	if err != nil {
		return err
	}
	defer f.Close()
	for _, item := range items {
		if _, ok := ackSet[item.ID]; ok {
			continue
		}
		line, _ := json.Marshal(item)
		if _, err = f.WriteString(string(line) + "\n"); err != nil {
			return err
		}
	}
	return nil
}

func (s *OfflineStore) Close() error { return nil }
