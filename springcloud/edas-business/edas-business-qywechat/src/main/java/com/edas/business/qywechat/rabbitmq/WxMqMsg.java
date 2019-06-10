package com.edas.business.qywechat.rabbitmq;

import java.io.Serializable;

import lombok.Data;

/**
 * <p>
 * File Name: WxMqMsg.java
 * </p>
 * <p>
 * Description: 微信MQ消息
 * </p>
 * <p>
 * Date：2019年5月21日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Data
public class WxMqMsg implements Serializable{
	
	private String appId;
	private String appSecret;
	private String message;
}