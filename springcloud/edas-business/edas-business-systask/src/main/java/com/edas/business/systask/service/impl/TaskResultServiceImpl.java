package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.TaskResult;
import com.edas.business.systask.service.TaskResultService;
import com.edas.edascommon.core.AbstractServices;


/**
 * <p>
 * File Name: FollowRuleServiceImpl.java
 * </p>
 * <p>
 * Description: 跟进规则模板impl
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class TaskResultServiceImpl extends AbstractServices<TaskResult> implements TaskResultService{
	
	@Transactional
	@Override
	public void saveTaskResult(TaskResult result) {
		insert(result);
		
	}
	
	@Transactional
	@Override
	public void updateTaskResult(TaskResult result) {
		update(result);
		
	}

	@Override
	public void deleteTaskResult(String id) {
		deleteById(id);
		
	}	
		
}