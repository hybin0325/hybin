package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.RuleTemplate;
import com.edas.business.systask.service.RuleTemplateService;
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
public class RuleTemplateServiceImpl extends AbstractServices<RuleTemplate> implements RuleTemplateService{
	
	@Transactional
	@Override
	public void saveRuleTemplate(RuleTemplate template) {
		insert(template);			
	}
	
	@Transactional
	@Override
	public void updateRuleTemplate(RuleTemplate template) {
		update(template);		
	}

	@Override
	public void deleteRuleTemplate(String id) {
		deleteById(id);		
	}
		
}