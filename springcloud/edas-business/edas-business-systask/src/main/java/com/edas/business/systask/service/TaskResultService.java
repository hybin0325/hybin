package com.edas.business.systask.service;

import com.edas.business.systask.entity.TaskResult;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: TaskResultService.java
 * </p>
 * <p>
 * Description: 任务结果service
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface TaskResultService extends Service<TaskResult>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void saveTaskResult(TaskResult result);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updateTaskResult(TaskResult result);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deleteTaskResult(String id);
	
}