package com.edas.business.systask.service;

import com.edas.business.systask.entity.Task;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: TaskService.java
 * </p>
 * <p>
 * Description: 任务service
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface TaskService extends Service<Task>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void saveTask(Task task);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updateTask(Task task);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deleteTask(String id);
	

}