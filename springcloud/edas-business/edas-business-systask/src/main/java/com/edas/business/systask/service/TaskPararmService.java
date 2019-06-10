package com.edas.business.systask.service;

import com.edas.business.systask.entity.TaskPararm;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: TaskPararmService.java
 * </p>
 * <p>
 * Description: 任务参数service
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface TaskPararmService extends Service<TaskPararm>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void savePararm(TaskPararm pararm);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updatePararm(TaskPararm pararm);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deletePararm(String id);
	
}