package com.edas.edasmessage.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edas.edascommon.constants.Constants;
import com.edas.edascommon.model.MqMessage;
import com.edas.edasmessage.service.BrokerMessageLogService;

import lombok.extern.slf4j.Slf4j;

/**
 * 车辆进场
 * 
 * @author nl
 *
 */
@Service
@Slf4j
public class MQCarParkSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private BrokerMessageLogService brokerMessageLogService;

	final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
		@Override
		public void confirm(CorrelationData correlationData, boolean ack, String cause) {
			log.info("correlationData" + correlationData);
			
			if (ack) {
				log.info("投递成功");
				// 如果confirm返回成功，则进行更新
				Long messageId =Long.parseLong(correlationData.getId());
				brokerMessageLogService.changeBrokerMessageLogStatus(messageId, Constants.PARK_SEND_SUCCESS);
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
	public void sendDataMsg(String exchange, String routingKey, MqMessage message) throws Exception {
		log.info("message  " + message);
		rabbitTemplate.setConfirmCallback(confirmCallback);
		CorrelationData correlationData = new CorrelationData(message.getMessageId());
		rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
	}

}
