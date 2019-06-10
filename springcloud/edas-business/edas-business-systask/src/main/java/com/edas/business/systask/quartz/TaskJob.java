package com.edas.business.systask.quartz;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TaskJob extends QuartzJobBean{

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		log.info(">>>>>>>>>>>>>>>>>>>>计划任务开始执行>>>>>>>>>>>>>>>>>>>>"+Thread.currentThread().getName());
		
		JobDataMap dataMap = context.getJobDetail().getJobDataMap();
		//获取参数
		String param = dataMap.getString("sql");
		log.info("任务执行参数: "+param);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		log.info(">>>>>>>>>>>>>>>>>>>>计划任务结束>>>>>>>>>>>>>>>>>>>>");
		
	}

}