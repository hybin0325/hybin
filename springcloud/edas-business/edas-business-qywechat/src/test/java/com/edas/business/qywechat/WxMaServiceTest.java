package com.edas.business.qywechat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edas.business.qywechat.entity.template.WxMaTemplateData;
import com.edas.business.qywechat.entity.template.WxMaTemplateMessage;
import com.edas.business.qywechat.service.WxMaService;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EdasBusinessQywechatApplication.class)
public class WxMaServiceTest {

	@Autowired
	private WxMaService wxMaService;

	@Test
	public void sendWxMpMsgMqTest() throws Exception {
		
	}
	
	
	@Test
	public void sendTemplateMsgTest() throws Exception {

		WxMaTemplateMessage templateMessage = WxMaTemplateMessage.builder()
			      .toUser("oj5Hl5UKBnJaCHu0vjmBGWadfQ_Y")
			      .templateId("yk5oFqV-bG-CM1ftMM7FYUzq9yX0x4-FuwDar1WFIYQ")
			      .formId("6789ee943fa448e683e7ca2527e90a7b")
			      //.page("index")
			      .data(Lists.newArrayList(
			        new WxMaTemplateData("keyword1", "张先生"),			        
			        new WxMaTemplateData("keyword2", "车辆保养套餐"),
			        new WxMaTemplateData("keyword3", "2019年6月2号 17:30"),
			        new WxMaTemplateData("keyword4", "奔驰白云店")
			    	))			      
			      .emphasisKeyword("keyword1.DATA")
			      .build();
		
		String appId = "wxc6cc24bb5fd2c3e9";
		String appSecret = "cc65731d36b0b2938bfd5b63f86be98a";
		log.info("-------------------data-----------"+templateMessage.toJson());
		wxMaService.sendTemplateMsg(appId,appSecret,templateMessage.toJson());
		
	}
	
}