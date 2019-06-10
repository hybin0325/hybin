package com.edas.business.dingtalk.rabbitmq;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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

import com.edas.business.dingtalk.service.impl.ShopwwiZtDingdingcorpidService;
import com.edas.edascommon.constants.Constants;
import com.edas.edascommon.model.MqMessage;
import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = Constants.NL_CAR_PARK_DATA_DINGTALK_MSG_QUEUE, durable = "true"), 
exchange = @Exchange(name = Constants.NL_CAR_PARK_DATA_MSG_TOPIC, durable = "true", type = "topic"), key = "carpark.wechat"))
public class DingtalkTopicDataReceiver {
	@Autowired
	private ShopwwiZtDingdingcorpidService dingtalkService;

	@RabbitHandler
	public void onDingtalkDataMessage(@Payload MqMessage msg, @Headers Map<String, Object> headers, Channel channel)
			throws IOException {

		log.info("---------钉钉收到消息，开始消费---------");
		try {
			log.info(msg.getMessageId());
			log.info(msg.getMessage());
			String messageId = msg.getMessageId();
			if (StringUtils.isNotBlank(messageId)) {
				dingtalkService.snderDingTalk(msg.getMessage());
			}
			Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
			boolean multiple = false;
			// ACK,确认一条消息已经被消费
			channel.basicAck(deliveryTag, multiple);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

}
