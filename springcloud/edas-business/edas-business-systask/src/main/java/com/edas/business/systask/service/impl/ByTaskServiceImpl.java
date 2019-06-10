package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.ByTask;
import com.edas.business.systask.service.ByTaskService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: ByTaskServiceImpl.java
 * </p>
 * <p>
 * Description: 百应电话关联表impl
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class ByTaskServiceImpl extends AbstractServices<ByTask> implements ByTaskService{
	
	@Transactional
	@Override
	public void saveByTask(ByTask byTask) {
		insert(byTask);
		
	}
	
	@Transactional
	@Override
	public void updateByTask(ByTask byTask) {
		update(byTask);
		
	}

	@Override
	public void deleteByTask(String id) {
		deleteById(id);		
	}	

}