package com.edas.business.systask.service;

import com.edas.business.systask.entity.ByTask;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: ByTaskService.java
 * </p>
 * <p>
 * Description: 百应任务关联表service
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface ByTaskService extends Service<ByTask>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void saveByTask(ByTask byTask);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updateByTask(ByTask byTask);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deleteByTask(String id);
	
}