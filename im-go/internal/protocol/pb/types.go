package pb

type Envelope struct {
	Seq         uint64
	Timestamp   int64
	ChatMessage *ChatMessage
	Ack         *Ack
	Heartbeat   *Heartbeat
	Error       *Error
}

type ChatMessage struct {
	MessageID  string
	FromUserID string
	ToUserID   string
	Content    string
	SendAt     int64
}

type Ack struct{ MessageID string }

type Heartbeat struct{ ClientTS int64 }

type Error struct {
	Code    string
	Message string
}

func (m *Envelope) GetChatMessage() *ChatMessage {
	if m == nil {
		return nil
	}
	return m.ChatMessage
}
