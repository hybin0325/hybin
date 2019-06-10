package com.edas.business.qywechat.service;

import com.edas.business.qywechat.exception.WxErrorException;

/**
 * <p>
 * File Name: WxMpService.java
 * </p>
 * <p>
 * Description: 公众号Service
 * </p>
 * <p>
 * Date：2019年5月16日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface WxMpService {

	/**
	 * 发送模板消息
	 */
	void sendTemplateMsg(String appId, String appSecret, String msg)  throws WxErrorException;

}