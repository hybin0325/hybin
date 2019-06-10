package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.Task;
import com.edas.business.systask.service.TaskService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: TaskServiceImpl.java
 * </p>
 * <p>
 * Description: 任务 service impl
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class TaskServiceImpl extends AbstractServices<Task> implements TaskService {
	
	@Transactional
	@Override	
	public void saveTask(Task task) {
		insert(task);		
	}
	
	@Transactional
	@Override
	public void updateTask(Task task) {
		update(task);		
	}
	
	@Override
	public void deleteTask(String id) {
		deleteById(id);		
	}
	
}