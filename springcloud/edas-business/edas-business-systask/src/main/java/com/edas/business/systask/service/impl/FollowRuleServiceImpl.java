package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.FollowRule;
import com.edas.business.systask.service.FollowRuleService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: FollowRuleServiceImpl.java
 * </p>
 * <p>
 * Description: 跟进规则impl
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class FollowRuleServiceImpl extends AbstractServices<FollowRule> implements FollowRuleService{
	
	@Transactional
	@Override
	public void saveFollowRule(FollowRule rule) {
		insert(rule);		
	}
	
	@Transactional
	@Override
	public void updateFollowRule(FollowRule rule) {
		update(rule);		
	}

	@Override
	public void deleteFollowRule(String id) {
		deleteById(id);		
	}
	
}