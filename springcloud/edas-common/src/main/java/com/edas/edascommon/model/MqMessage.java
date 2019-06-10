package com.edas.edascommon.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class MqMessage implements Serializable {
	private String messageId;

	private String message;
}
