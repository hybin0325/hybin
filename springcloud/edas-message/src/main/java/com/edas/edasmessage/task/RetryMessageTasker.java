package com.edas.edasmessage.task;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edas.edascommon.constants.Constants;
import com.edas.edascommon.model.MqMessage;
import com.edas.edasmessage.entity.BrokerMessageLog;
import com.edas.edasmessage.rabbitmq.sender.MQCarParkSender;
import com.edas.edasmessage.service.BrokerMessageLogService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author shallowan
 */
@Component
@Slf4j
//@EnableScheduling
public class RetryMessageTasker {
	@Autowired
	private MQCarParkSender rabbitOrderSender;

	@Autowired
	private BrokerMessageLogService brokerMessageLogService;

	//@Scheduled(initialDelay = 5000, fixedDelay = 10000)
	public void reSend() {
		// 拉去status=0并且超时next_retry时间的message
		List<BrokerMessageLog> brokerMessageLogs = brokerMessageLogService.query4StatusAndTimeoutMessage();
		brokerMessageLogs.forEach(messageLog -> {
			if (messageLog.getTryCount() >= Constants.MAX_RETRY_COUNT) {
				// 消息投递失败
				brokerMessageLogService.changeBrokerMessageLogStatus(messageLog.getMessageId(),
						Constants.PARK_SEND_FAILURE);
			} else {
				// 重发
				Date nextRetry = DateUtils.addMinutes(new Date(), Constants.PARK_TIMEOUT);
				brokerMessageLogService.update4ReSend(messageLog.getMessageId(), nextRetry);
				try {
					MqMessage msg = new MqMessage();
					msg.setMessage(messageLog.getMessage());
					msg.setMessageId(messageLog.getMessageId()+"");
					rabbitOrderSender.sendDataMsg(messageLog.getExchange(),messageLog.getRoutingKey(),msg);
				} catch (Exception e) {
					log.error("异常处理==>{}", e);
				}
			}
		});
	}
}
