package protocol

import (
	"bytes"
	"encoding/binary"
	"errors"

	"github.com/hybin/im-go/internal/protocol/pb"
)

func Marshal(msg *pb.Envelope) ([]byte, error) {
	if msg.ChatMessage == nil {
		return nil, errors.New("only chat_message payload supported in demo")
	}
	chat := marshalChat(msg.ChatMessage)
	var out bytes.Buffer
	writeVarintField(&out, 1, msg.Seq)
	writeVarintField(&out, 2, uint64(msg.Timestamp))
	writeBytesField(&out, 11, chat)
	return out.Bytes(), nil
}

func Unmarshal(data []byte) (*pb.Envelope, error) {
	env := &pb.Envelope{}
	for len(data) > 0 {
		num, wt, n := readTag(data)
		if n <= 0 {
			return nil, errors.New("invalid tag")
		}
		data = data[n:]
		switch {
		case num == 1 && wt == 0:
			v, m := binary.Uvarint(data)
			env.Seq = v
			data = data[m:]
		case num == 2 && wt == 0:
			v, m := binary.Uvarint(data)
			env.Timestamp = int64(v)
			data = data[m:]
		case num == 11 && wt == 2:
			ln, m := binary.Uvarint(data)
			start := m
			end := start + int(ln)
			env.ChatMessage = unmarshalChat(data[start:end])
			data = data[end:]
		default:
			next, err := skip(data, wt)
			if err != nil {
				return nil, err
			}
			data = data[next:]
		}
	}
	return env, nil
}

func marshalChat(c *pb.ChatMessage) []byte {
	var out bytes.Buffer
	writeStringField(&out, 1, c.MessageID)
	writeStringField(&out, 2, c.FromUserID)
	writeStringField(&out, 3, c.ToUserID)
	writeStringField(&out, 4, c.Content)
	writeVarintField(&out, 5, uint64(c.SendAt))
	return out.Bytes()
}

func unmarshalChat(data []byte) *pb.ChatMessage {
	c := &pb.ChatMessage{}
	for len(data) > 0 {
		num, wt, n := readTag(data)
		data = data[n:]
		switch {
		case wt == 2:
			ln, m := binary.Uvarint(data)
			val := string(data[m : m+int(ln)])
			switch num {
			case 1:
				c.MessageID = val
			case 2:
				c.FromUserID = val
			case 3:
				c.ToUserID = val
			case 4:
				c.Content = val
			}
			data = data[m+int(ln):]
		case wt == 0 && num == 5:
			v, m := binary.Uvarint(data)
			c.SendAt = int64(v)
			data = data[m:]
		default:
			next, _ := skip(data, wt)
			data = data[next:]
		}
	}
	return c
}

func writeTag(out *bytes.Buffer, num int, wt int) {
	writeUvarint(out, uint64(uint64(num)<<3|uint64(wt)))
}
func writeVarintField(out *bytes.Buffer, num int, val uint64) {
	writeTag(out, num, 0)
	writeUvarint(out, val)
}
func writeStringField(out *bytes.Buffer, num int, val string) { writeBytesField(out, num, []byte(val)) }
func writeBytesField(out *bytes.Buffer, num int, val []byte) {
	writeTag(out, num, 2)
	writeUvarint(out, uint64(len(val)))
	out.Write(val)
}
func writeUvarint(out *bytes.Buffer, val uint64) {
	var buf [10]byte
	n := binary.PutUvarint(buf[:], val)
	out.Write(buf[:n])
}
func readTag(b []byte) (num int, wt int, n int) {
	v, n := binary.Uvarint(b)
	return int(v >> 3), int(v & 0x7), n
}
func skip(data []byte, wt int) (int, error) {
	switch wt {
	case 0:
		_, n := binary.Uvarint(data)
		return n, nil
	case 2:
		ln, n := binary.Uvarint(data)
		return n + int(ln), nil
	default:
		return 0, errors.New("unsupported wire type")
	}
}
