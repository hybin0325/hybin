package com.edas.edasusers.configurer;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
	@Override
	public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
		// 参数传入一个size为10的线程池
		scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(6));
		
	}

	//@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newScheduledThreadPool(6);
	}
}
