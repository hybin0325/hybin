package com.edas.business.qywechat.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: WxMaMsgSender.java
 * </p>
 * <p>
 * Description: 发送mq消息
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
public class WxMaMsgSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			log.info("correlationData" + correlationData);
			
			if (ack) {
				log.info("投递成功");
							
			} else {
				// 失败则进行具体的后续操作：重试或者补偿等手段
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
	public void sendDataMsg(String appId, String mess, String exchage, String queue) throws Exception {								
		WxMqMsg message = new WxMqMsg();
		message.setAppId(appId);		
		message.setMessage(mess);		
		rabbitTemplate.setConfirmCallback(confirmCallback);
		CorrelationData correlationData = new CorrelationData(message.getAppId());
		rabbitTemplate.convertAndSend(exchage, queue, message, correlationData);
	}

}