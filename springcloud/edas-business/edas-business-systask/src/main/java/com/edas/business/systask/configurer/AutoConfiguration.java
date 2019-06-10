package com.edas.business.systask.configurer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edas.system.common.exception.OpenExceptionHandler;
import com.edas.system.common.utils.SpringContextHolder;

import lombok.extern.slf4j.Slf4j;

/**
 * 默认配置类
 *
 */
@Slf4j
@Configuration
public class AutoConfiguration {

	/**
	 * Spring上下文工具配置
	 *
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(SpringContextHolder.class)
	public SpringContextHolder springContextHolder() {
		SpringContextHolder holder = new SpringContextHolder();
		log.info("bean [{}]", holder);
		return holder;
	}

	/**
	 * 统一异常处理配置
	 *
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(OpenExceptionHandler.class)
	public OpenExceptionHandler exceptionHandler() {
		OpenExceptionHandler exceptionHandler = new OpenExceptionHandler();
		log.info("bean [{}]", exceptionHandler);
		return exceptionHandler;
	}

	
}
