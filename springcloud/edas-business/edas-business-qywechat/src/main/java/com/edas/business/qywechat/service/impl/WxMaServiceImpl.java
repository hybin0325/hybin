package com.edas.business.qywechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edas.business.qywechat.exception.WxErrorException;
import com.edas.business.qywechat.service.WxMaService;
import com.edas.business.qywechat.service.WxMaTemplateService;

/**
 * <p>
 * File Name: WxMaServiceImpl.java
 * </p>
 * <p>
 * Description: 小程序serviceImpl
 * </p>
 * <p>
 * Date：2019年5月21日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */

@Service
public class WxMaServiceImpl implements WxMaService{
	
	@Autowired
	private WxMaTemplateService wxMaTemplateService;
	
	@Override
	public void sendTemplateMsg(String appId, String appSecret, String templateMessage) throws WxErrorException {
		
		wxMaTemplateService.sendTemplateMsg(appId,appSecret, templateMessage);		
		
	}

}