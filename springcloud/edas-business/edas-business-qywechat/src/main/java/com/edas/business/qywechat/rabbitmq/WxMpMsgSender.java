package com.edas.business.qywechat.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edas.business.qywechat.entity.template.WxMpTemplateData;
import com.edas.business.qywechat.entity.template.WxMpTemplateMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: WxMpMsgSender.java
 * </p>
 * <p>
 * Description: 公众号测试生产消息
 * </p>
 * <p>
 * Date：2019年5月21日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Component
@Slf4j
public class WxMpMsgSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			log.info("correlationData" + correlationData);			
			if (ack) {
				log.info("投递成功");							
			} else {				
				log.error("异常处理");
			}
		}
	};

	/**
	 * 业务数据处理后发到队列
	 * 
	 * @param message
	 * @throws Exception
	 */
	public void sendDataMsg() throws Exception {
				
		WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder().toUser("oOjLv52pGGifRN-d9fT4APqQgOVo")
				.templateId("WP7O0xxkOOlgksHvVWn-i-iIEFVZ8C4eCfQHz0G0FYk").url(" ").build();

		templateMessage.addData(new WxMpTemplateData("first", "恭喜你购买成功", "#173177"))
				.addData(new WxMpTemplateData("product", "空客A380", "#173177"))
				.addData(new WxMpTemplateData("amount", "9936899999元", "#173177"))
				.addData(new WxMpTemplateData("time", "2019年5月22日", "#173177"))
				.addData(new WxMpTemplateData("remark", "欢迎再次购买！", "#173177"));
		
		WxMpTemplateMessage mess = WxMpTemplateMessage.builder()
				.toUser("olNLIv9be4w_opX0HioFfklhw060")
				.templateId("r1bSqVyIPeXMuutLyruYrJSc3_hFM6E-gEOeiSAxzs0")
				.url("")
				.build();

		mess.addData(new WxMpTemplateData("productType", "消费项目"))
				.addData(new WxMpTemplateData("name", "大保健"))				
				.addData(new WxMpTemplateData("time", "2019年5月22日 20:15"))
				.addData(new WxMpTemplateData("remark", "欢迎再次消费！"));
		
		WxMqMsg message = new WxMqMsg();
		message.setAppId("wxc6cc24bb5fd2c3e9");
		message.setAppSecret("cc65731d36b0b2938bfd5b63f86be98a");
		message.setMessage(mess.toJson());
		
		log.info("message  " + message);
		rabbitTemplate.setConfirmCallback(confirmCallback);
		CorrelationData correlationData = new CorrelationData(message.getAppId());
		rabbitTemplate.convertAndSend("wxmpExchage", "wxmp.queue", message, correlationData);
	}

}