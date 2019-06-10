package com.edas.business.systask.service.impl;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edas.business.systask.quartz.QuartzEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: Quartz service
 * </p>
 * <p>
 * Date：2019年6月25日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Service
public class QuartzService {
	
	@Autowired
    private Scheduler scheduler;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String save(QuartzEntity quartz){
		log.info(">>>>>>>>>>>>>>>>>>>>新增任务");
		try {
	        //如果是修改  展示旧的 任务
	        if(quartz.getOldJobGroup()!=null){
	        	JobKey key = new JobKey(quartz.getOldJobName(),quartz.getOldJobGroup());
	        	scheduler.deleteJob(key);
	        }
	        
			Class cls = Class.forName(quartz.getJobClassName());
	        cls.newInstance();
	        //构建job信息
	        JobDetail job = JobBuilder.newJob(cls).withIdentity(quartz.getJobName(),
	        		quartz.getJobGroup())
	        		.withDescription(quartz.getDescription()).build();
	        
	        //任务传入参数
	        job.getJobDataMap().put("sql", "select 1 from dual");
	        
	        // 触发时间点
	        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(quartz.getCronExpression());
	        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger"+quartz.getJobName(), quartz.getJobGroup())
	                .startNow().withSchedule(cronScheduleBuilder).build();		        
	        
	        //交由Scheduler安排触发
	        scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			 e.printStackTrace();			
			 return "fail";
		}
		return "success";
	}
}
