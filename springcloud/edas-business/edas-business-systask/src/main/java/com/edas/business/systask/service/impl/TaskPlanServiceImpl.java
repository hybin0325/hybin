package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.TaskPlan;
import com.edas.business.systask.service.TaskPlanService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: TaskPlanServiceImpl.java
 * </p>
 * <p>
 * Description: 任务计划impl
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class TaskPlanServiceImpl extends AbstractServices<TaskPlan> implements TaskPlanService{
	
	@Transactional
	@Override
	public void savePlan(TaskPlan plan) {
		insert(plan);		
	}
	
	@Transactional
	@Override
	public void updatePlan(TaskPlan plan) {
		update(plan);		
	}

	@Override
	public void deletePlan(String id) {
		deleteById(id);		
	}
		
}