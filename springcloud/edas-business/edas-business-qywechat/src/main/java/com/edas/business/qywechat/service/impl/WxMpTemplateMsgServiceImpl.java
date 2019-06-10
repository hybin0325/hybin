package com.edas.business.qywechat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edas.business.qywechat.entity.WxError;
import com.edas.business.qywechat.entity.template.WxMpTemplate;
import com.edas.business.qywechat.entity.template.WxMpTemplateIndustry;
import com.edas.business.qywechat.enums.WxType;
import com.edas.business.qywechat.exception.WxErrorException;
import com.edas.business.qywechat.service.AbstractWxService;
import com.edas.business.qywechat.service.WxMpTemplateMsgService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <p>
 * File Name: WxMpTemplateMsgServiceImpl.java
 * </p>
 * <p>
 * Description: 公众号模板消息实现
 * </p>
 * <p>
 * Date：2019年5月18日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */

@Service
public class WxMpTemplateMsgServiceImpl extends AbstractWxService implements WxMpTemplateMsgService {

	private static final JsonParser JSON_PARSER = new JsonParser();
	
	/**
	   * <pre>
	   * 发送模板消息
	   * 详情请见: http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1433751277&token=&lang=zh_CN
	   * </pre>
	   *
	   * @return 消息Id
	   */
	@Override
	public String sendTemplateMsg(String appId, String appSecret, String templateMessage) throws WxErrorException {
		String url = WXMP_TEMPLATE_MSG_PREFIX + "send";
	    String responseContent = post(appId, appSecret, url, templateMessage, WxType.MP);
	    final JsonObject jsonObject = JSON_PARSER.parse(responseContent).getAsJsonObject();
	    if (jsonObject.get("errcode").getAsInt() == 0) {
	      return jsonObject.get("msgid").getAsString();	      
	    }	    
	    throw new WxErrorException(WxError.fromJson(responseContent, WxType.MP));
	}
	
	@Override
	public boolean setIndustry(WxMpTemplateIndustry wxMpIndustry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WxMpTemplateIndustry getIndustry() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String addTemplate(String shortTemplateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WxMpTemplate> getAllPrivateTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delPrivateTemplate(String templateId) {
		// TODO Auto-generated method stub
		return false;
	}

}