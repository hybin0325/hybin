package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.TaskCustomer;
import com.edas.business.systask.service.TaskCustomerService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: TaskCustomerServiceImpl.java
 * </p>
 * <p>
 * Description: 客户impl
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class TaskCustomerServiceImpl extends AbstractServices<TaskCustomer> implements TaskCustomerService{
	
	@Transactional
	@Override
	public void saveCustomer(TaskCustomer customer) {
		insert(customer);		
	}
	
	@Transactional
	@Override
	public void updateCustomer(TaskCustomer customer) {
		update(customer);
	}

	@Override
	public void deleteCustomer(String id) {
		deleteById(id);		
	}
		
}