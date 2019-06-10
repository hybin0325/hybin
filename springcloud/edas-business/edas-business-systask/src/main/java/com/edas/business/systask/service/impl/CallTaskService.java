package com.edas.business.systask.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.edas.business.systask.entity.Task;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: CallTaskService.java
 * </p>
 * <p>
 * Description: 任务执行
 * </p>
 * <p>
 * Date：2019年5月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Service
public class CallTaskService {
	
	/**
	 * <pre>
	 * 处理客户
	 * </pre>
	 * 
	 * @param task
	 */
	@Async("taskExecutor")
	public void handleCustomer(Task task) {
		log.info("start handleCustomer");
		try {
			System.out.println("当前运行的线程名称：" + Thread.currentThread().getName());
			handleTask(null);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("end handleCustomer");
	}
	
	/**
	 * <pre>
	 * 处理任务
	 * </pre>
	 * 
	 * @param task
	 */
	@Async("taskExecutor")
	public void handleTask(Task task) {
		log.info("start handleTask");
		try {
			System.out.println("当前运行的线程名称：" + Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		log.info("end handleTask");
	}
}