package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.TaskPararm;
import com.edas.business.systask.service.TaskPararmService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: TaskPararmServiceImpl.java
 * </p>
 * <p>
 * Description: 任务参数impl
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class TaskPararmServiceImpl extends AbstractServices<TaskPararm> implements TaskPararmService{
	
	@Transactional
	@Override
	public void savePararm(TaskPararm pararm) {
		insert(pararm);
		
	}
	
	@Transactional
	@Override
	public void updatePararm(TaskPararm pararm) {
		update(pararm);
		
	}

	@Override
	public void deletePararm(String id) {
		deleteById(id);
	}
			
}