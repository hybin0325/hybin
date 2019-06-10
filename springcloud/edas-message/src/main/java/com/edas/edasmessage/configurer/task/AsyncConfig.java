package com.edas.edasmessage.configurer.task;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableAsync
@Configuration
public class AsyncConfig implements AsyncConfigurer {
	@Bean
	@Override
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
		threadPool.setCorePoolSize(1);
		threadPool.setMaxPoolSize(1);
		threadPool.setWaitForTasksToCompleteOnShutdown(true);
		threadPool.setAwaitTerminationSeconds(60 * 15);
		threadPool.setThreadNamePrefix("MyAsync-");
		threadPool.initialize();
		return threadPool;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new AsyncExceptionHandler();
	}

	/**
	 * 自定义异常处理类
	 * 
	 * @author hry
	 *
	 */
	class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
		@Override
		public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
			log.info("Exception message - " + throwable.getMessage());
			log.info("Method name - " + method.getName());
			for (Object param : obj) {
				log.info("Parameter value - " + param);
			}
		}

	}

}
