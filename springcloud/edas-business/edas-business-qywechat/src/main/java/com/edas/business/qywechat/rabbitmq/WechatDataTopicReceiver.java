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

import com.edas.business.qywechat.service.ZtWechatcorpidService;
import com.edas.edascommon.constants.Constants;
import com.edas.edascommon.model.MqMessage;
import com.edas.edascommon.utils.StringUtils;
import com.rabbitmq.client.Channel;

import lombok.extern.slf4j.Slf4j;

/**
 * 只接收微信
 * 
 * @author nl
 *
 */
@Slf4j
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = Constants.NL_CAR_PARK_DATA_WECHAT_MSG_QUEUE, durable = "true"), exchange = @Exchange(name = Constants.NL_CAR_PARK_DATA_MSG_TOPIC, durable = "true", type = "topic"), key = "carpark.dingtalk"))
public class WechatDataTopicReceiver {

	@Autowired
	private ZtWechatcorpidService ztWechatcorpidService;

	@RabbitHandler
	public void onWechatDataMessage(@Payload MqMessage msg, @Headers Map<String, Object> headers, Channel channel)
			throws IOException {
		// 消费者操作
		log.info("---------微信收到消息，开始消费---------");
		try {
			log.info(msg.getMessageId());
			log.info(msg.getMessage());
			String messageId = msg.getMessageId();
			if (StringUtils.isNotBlank(messageId)) {
				ztWechatcorpidService.snderWechat(msg.getMessage());
			}

			Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

			boolean multiple = false;

			// ACK,确认一条消息已经被消费
			channel.basicAck(deliveryTag, multiple);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}

}
