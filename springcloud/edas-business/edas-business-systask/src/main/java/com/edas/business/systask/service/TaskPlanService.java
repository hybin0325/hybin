package com.edas.business.systask.service;

import com.edas.business.systask.entity.TaskPlan;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: TaskPlanService.java
 * </p>
 * <p>
 * Description: 任务计划service
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface TaskPlanService extends Service<TaskPlan>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void savePlan(TaskPlan plan);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updatePlan(TaskPlan plan);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deletePlan(String id);
	
}