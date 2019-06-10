package com.edas.edasmessage.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edas.edascommon.constants.Constants;

/**
 * MQ 配置类
 * 
 * @author nl
 *
 */
@Configuration
public class MQTopicConfig {

	@Bean
	public Queue nlCarParkMsgQ() {
		return new Queue(Constants.NL_CAR_PARK_MSG_QUEUE, true);
	}

	@Bean
	public TopicExchange carParkExchange() {
		return new TopicExchange(Constants.NL_CAR_PARK_MSG_TOPIC);
	}

	@Bean
	public Binding carInParkDirectBinding() {
		return BindingBuilder.bind(nlCarParkMsgQ()).to(carParkExchange()).with(Constants.NL_CAR_PARK_MSG_RONTINGKEY);
	}

	@Bean
	public Queue nlCarParkDingtalkdDataMsg() {
		return new Queue(Constants.NL_CAR_PARK_DATA_DINGTALK_MSG_QUEUE, true);
	}

	@Bean
	public Queue nlCarParkWechatDataMsg() {
		return new Queue(Constants.NL_CAR_PARK_DATA_WECHAT_MSG_QUEUE, true);
	}

	@Bean
	public TopicExchange nlCarParkDataMsg() {
		return new TopicExchange(Constants.NL_CAR_PARK_DATA_MSG_TOPIC);
	}

	@Bean
	public Binding carInParkDirectBinding2() {
		return BindingBuilder.bind(nlCarParkWechatDataMsg()).to(nlCarParkDataMsg())
				.with(Constants.NL_CAR_PARK_DATA_WECHAT_MSG_RONTINGKEY);
	}

	@Bean
	public Binding carInParkDirectBinding3() {
		return BindingBuilder.bind(nlCarParkDingtalkdDataMsg()).to(nlCarParkDataMsg())
				.with(Constants.NL_CAR_PARK_DATA_DINGTALK_MSG_RONTINGKEY);
	}

}
