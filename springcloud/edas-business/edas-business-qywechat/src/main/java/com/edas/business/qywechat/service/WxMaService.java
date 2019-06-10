package com.edas.business.qywechat.service;

import com.edas.business.qywechat.exception.WxErrorException;

/**
 * <p>
 * File Name: WxMpService.java
 * </p>
 * <p>
 * Description: 小程序Service
 * </p>
 * <p>
 * Date：2019年5月21日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface WxMaService {
	
	public void sendTemplateMsg(String appId, String appSecret, String templateMessage) throws WxErrorException;
	
}
