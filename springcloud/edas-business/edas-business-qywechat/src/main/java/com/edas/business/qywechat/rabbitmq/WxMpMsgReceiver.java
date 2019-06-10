package com.edas.business.qywechat.rabbitmq;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.edas.business.qywechat.constant.Constants;
import com.edas.business.qywechat.service.WxMpService;
import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: WxMpDataReceiver.java
 * </p>
 * <p>
 * Description: 公众号消费消息
 * </p>
 * <p>
 * Date：2019年5月20日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(name = Constants.WXMP_QUEUE, durable = "true"),
exchange = @Exchange(name = Constants.WXMP_TOPIC, durable = "true", type = "topic"), 
key = Constants.WXMP_RONTINGKEY))
public class WxMpMsgReceiver {
	
	@Autowired
	private WxMpService wxMpService;
	
	@RabbitHandler 
	public void onWxMpMsg(@Payload WxMqMsg msg, @Headers Map<String, Object> headers, Channel channel)
			throws IOException {
		// 消费者操作
		log.info("---------微信公众号收到消息，开始消费---------"+msg.getMessage());
		try {
			
			String appId = msg.getAppId();
			String appSecret = msg.getAppSecret();						
			wxMpService.sendTemplateMsg(appId, appSecret, msg.getMessage());
			
			Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
			boolean multiple = false;
			channel.basicAck(deliveryTag, multiple);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}