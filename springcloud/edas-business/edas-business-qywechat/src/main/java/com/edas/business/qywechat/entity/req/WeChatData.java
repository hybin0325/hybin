package com.edas.business.qywechat.entity.req;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信消息发送实体类
 * 
 * @author zhangmingliang
 */
@Data
public class WeChatData<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3279562265881975666L;
	// 发送微信消息的URLString
	// sendMsgUrl="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";
	/**
	 * 成员账号
	 */
	private String touser;
	private String content;
	private String title;
	private String url;
	private String description;
	private String btntxt;
	private T markdown;
	private T file;
	private T voice;
	private T video;
	private T news;
	/**
	 * 消息类型
	 */
	private String msgtype;
	/**
	 * 企业应用的agentID
	 */
	private int agentid;
	/**
	 * 实际接收Map类型数据
	 */
	private T text;

	/**
	 * 实际接收Map类型数据 卡片
	 */
	private T textcard;

	private T image;

}