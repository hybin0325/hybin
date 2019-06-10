package com.edas.business.systask.service;

import com.edas.business.systask.entity.TaskCustomer;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: TaskCustomerService.java
 * </p>
 * <p>
 * Description: 客户service
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface TaskCustomerService extends Service<TaskCustomer>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void saveCustomer(TaskCustomer customer);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updateCustomer(TaskCustomer customer);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deleteCustomer(String id);
	
}