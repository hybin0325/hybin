package com.edas.edasmessage.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edas.edascommon.constants.Constants;

@Configuration
public class MQFanoutConfig {
	@Bean
	public Queue dingtalkdData() {
		return new Queue(Constants.DINGTALK_DATA_QUEUE, true);
	}

	@Bean
	public Queue wechatData() {
		return new Queue(Constants.WECHAT_DATA_QUEUE, true);
	}

	// 创建Fanout交换器
	@Bean
	public FanoutExchange nlDataMsgFanoutExchange() {
		return new FanoutExchange(Constants.NL_DATA_MSG_FANOUT);
	}

	@Bean
	Binding bindingExchangeWechatData() {
		return BindingBuilder.bind(wechatData()).to(nlDataMsgFanoutExchange());
	}

	// 将对列绑定到Fanout交换器
	@Bean
	Binding bindingExchangeDingtalkdData() {
		return BindingBuilder.bind(dingtalkdData()).to(nlDataMsgFanoutExchange());
	}
}
