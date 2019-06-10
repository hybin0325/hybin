package com.edas.business.dingtalk.configurer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class ConsumerConfig {

	@Bean("customContainerFactory")
	public SimpleRabbitListenerContainerFactory containerFactory(
			SimpleRabbitListenerContainerFactoryConfigurer configurer,ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		ExecutorService service = Executors.newFixedThreadPool(600);
		factory.setTaskExecutor(service);
		factory.setConcurrentConsumers(500);
		factory.setPrefetchCount(5);
		configurer.configure(factory, connectionFactory);
		return factory;
	}
}
