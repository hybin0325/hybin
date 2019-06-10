package com.edas.business.qywechat.entity.req;

import lombok.Data;

@Data
public class WeChatUrlData {
	/**
	 * 企业Id
	 */
	private String corpid;
	/**
	 * secret管理组的凭证密钥
	 */
	private String corpsecret;
	/**
	 * 获取ToKen的请求
	 */
	private String Get_Token_Url;
	/**
	 * 发送消息的请求
	 */
	private String SendMessage_Url;
	
	private String Upload_Url;
}
