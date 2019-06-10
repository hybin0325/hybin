package com.edas.business.qywechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edas.business.qywechat.exception.WxErrorException;
import com.edas.business.qywechat.service.WxMpService;
import com.edas.business.qywechat.service.WxMpTemplateMsgService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: WxMpServiceImpl.java
 * </p>
 * <p>
 * Description: 公众号Service
 * </p>
 * <p>
 * Date：2019年5月18日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Service
public class WxMpServiceImpl implements WxMpService {

	@Autowired
	private WxMpTemplateMsgService templateMsgService;
	
	/**
	 * 
	 * @Description: 发送模板消息
	 *
	 * @param msg
	 *
	 * @date 2019年5月20日
	 * @author zzw
	 */
	@Override
	public void sendTemplateMsg(String appId, String appSecret, String msg) throws WxErrorException {
		log.debug("----------TemplateMsg-----------：" +msg);			
		String msgId = templateMsgService.sendTemplateMsg(appId, appSecret, msg);	
		log.debug("----------TemplateMsgId-----------：" +msgId);
	}
	
}