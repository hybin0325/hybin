package service

import (
	"encoding/base64"
	"encoding/json"
	"net/http"

	"github.com/hybin/im-go/internal/broker"
	"github.com/hybin/im-go/internal/protocol"
	"github.com/hybin/im-go/internal/store"
)

type Gateway struct {
	producer *broker.Producer
	offline  *store.OfflineStore
}

func NewGateway(producer *broker.Producer, offline *store.OfflineStore) *Gateway {
	return &Gateway{producer: producer, offline: offline}
}

func (g *Gateway) HandleSend(w http.ResponseWriter, r *http.Request) {
	var req struct {
		Payload string `json:"payload"`
	}
	if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}
	raw, err := base64.StdEncoding.DecodeString(req.Payload)
	if err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}
	env, err := protocol.Unmarshal(raw)
	if err != nil || env.GetChatMessage() == nil {
		http.Error(w, "invalid chat protobuf", http.StatusBadRequest)
		return
	}
	chat := env.GetChatMessage()
	if err = g.producer.Publish(r.Context(), chat.ToUserID, raw); err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	_ = json.NewEncoder(w).Encode(map[string]any{"status": "ok", "partition_key": chat.ToUserID})
}

func (g *Gateway) HandlePullOffline(w http.ResponseWriter, r *http.Request) {
	uid := r.URL.Query().Get("uid")
	if uid == "" {
		http.Error(w, "uid required", http.StatusBadRequest)
		return
	}
	items, err := g.offline.PullOfflineMessages(r.Context(), uid, 200)
	if err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	_ = json.NewEncoder(w).Encode(map[string]any{"uid": uid, "messages": items})
}

func (g *Gateway) HandleAckOffline(w http.ResponseWriter, r *http.Request) {
	var req struct {
		UID string   `json:"uid"`
		IDs []string `json:"ids"`
	}
	if err := json.NewDecoder(r.Body).Decode(&req); err != nil {
		http.Error(w, err.Error(), http.StatusBadRequest)
		return
	}
	if req.UID == "" {
		http.Error(w, "uid required", http.StatusBadRequest)
		return
	}
	if err := g.offline.AckOfflineMessages(r.Context(), req.UID, req.IDs); err != nil {
		http.Error(w, err.Error(), http.StatusInternalServerError)
		return
	}
	_ = json.NewEncoder(w).Encode(map[string]any{"status": "ok", "acked": len(req.IDs)})
}
