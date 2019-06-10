package com.edas.business.systask.quartz;

import org.springframework.boot.autoconfigure.quartz.SchedulerFactoryBeanCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * <p>
 * Description quartz调度三大核心元素Scheduler(任务调度器)
 * </p>
 * <p>
 * Date：2019年6月5日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Configuration
public class SchedulerConfig implements SchedulerFactoryBeanCustomizer{
	
	@Override
	public void customize(SchedulerFactoryBean schedulerFactoryBean) {
		 	schedulerFactoryBean.setStartupDelay(2);
	        schedulerFactoryBean.setAutoStartup(true);
	        schedulerFactoryBean.setOverwriteExistingJobs(true);
	}	

}