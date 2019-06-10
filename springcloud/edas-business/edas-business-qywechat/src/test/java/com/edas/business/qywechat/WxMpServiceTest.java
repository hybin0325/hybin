package com.edas.business.qywechat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edas.business.qywechat.entity.template.WxMpTemplateData;
import com.edas.business.qywechat.entity.template.WxMpTemplateMessage;
import com.edas.business.qywechat.rabbitmq.WxMpMsgSender;
import com.edas.business.qywechat.service.WxMpService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EdasBusinessQywechatApplication.class)
public class WxMpServiceTest {

	@Autowired
	private WxMpMsgSender wxMpMsgSender;

	@Autowired
	private WxMpService wxMpService;

	@Test
	public void sendWxMpMsgMqTest() throws Exception {
		wxMpMsgSender.sendDataMsg();
	}
	
	
	@Test
	public void sendTemplateMsgTest() throws Exception {

		/*WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser("oOjLv52pGGifRN-d9fT4APqQgOVo")
				.templateId("WP7O0xxkOOlgksHvVWn-i-iIEFVZ8C4eCfQHz0G0FYk").url(" ").build();

		templateMessage.addData(new WxMpTemplateData("first", "恭喜你购买成功", "#173177"))
				.addData(new WxMpTemplateData("product", "波音783", "#173177"))
				.addData(new WxMpTemplateData("amount", "136899999元", "#173177"))
				.addData(new WxMpTemplateData("time", "2014年9月22日", "#173177"))
				.addData(new WxMpTemplateData("remark", "欢迎再次购买！", "#173177"));*/
		
		WxMpTemplateMessage mess = WxMpTemplateMessage.builder()
				.toUser("olNLIv9be4w_opX0HioFfklhw060")
				.templateId("r1bSqVyIPeXMuutLyruYrJSc3_hFM6E-gEOeiSAxzs0")
				.url("")
				.build();

		mess.addData(new WxMpTemplateData("productType", "消费项目"))
				.addData(new WxMpTemplateData("name", "大保健"))				
				.addData(new WxMpTemplateData("time", "2019年5月22日 20:15"))
				.addData(new WxMpTemplateData("remark", "欢迎再次消费！"));
		
		String appId = "wxc6cc24bb5fd2c3e9";
		String appSecret = "cc65731d36b0b2938bfd5b63f86be98a";
		
		wxMpService.sendTemplateMsg(appId, appSecret, mess.toJson());
		
	}
	
}