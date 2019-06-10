package com.edas.business.qywechat.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edas.business.qywechat.entity.template.WxMaTemplateAddResult;
import com.edas.business.qywechat.entity.template.WxMaTemplateLibraryGetResult;
import com.edas.business.qywechat.entity.template.WxMaTemplateLibraryListResult;
import com.edas.business.qywechat.entity.template.WxMaTemplateListResult;
import com.edas.business.qywechat.enums.WxType;
import com.edas.business.qywechat.exception.WxErrorException;
import com.edas.business.qywechat.service.AbstractWxService;
import com.edas.business.qywechat.service.WxMaTemplateService;

/**
 * <p>
 * File Name: WxMaTemplateServiceImpl.java
 * </p>
 * <p>
 * Description: 小程序 模板消息ServiceImpl
 * </p>
 * <p>
 * Date：2019年5月21日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */

@Service
public class WxMaTemplateServiceImpl extends AbstractWxService implements WxMaTemplateService{
	
	//private static final JsonParser JSON_PARSER = new JsonParser();
	
	/**
	   * <pre>
	   * 发送模板消息
	   * </pre>
	   *
	   */
	@Override
	public void sendTemplateMsg(String appId, String appSecret, String templateMessage) throws WxErrorException {		
		post(appId, appSecret, WXMA_TEMPLATE_SEND_URL, templateMessage, WxType.MiniApp);	   	    	    
	}
	
	
	@Override
	public WxMaTemplateLibraryListResult findTemplateLibraryList(int offset, int count) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMaTemplateLibraryGetResult findTemplateLibraryKeywordList(String id) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMaTemplateAddResult addTemplate(String id, List<Integer> keywordIdList) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WxMaTemplateListResult findTemplateList(int offset, int count) throws WxErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delTemplate(String templateId) throws WxErrorException {
		// TODO Auto-generated method stub
		return false;
	}

}