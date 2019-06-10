package com.edas.business.byrobot.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.byrobot.entity.CallRule;
import com.edas.business.byrobot.service.CallRuleService;
import com.edas.edascommon.core.AbstractServices;


/**
 * <p>
 * File Name: CallRuleServiceImpl.java
 * </p>
 * <p>
 * Description: 重拨规则service
 * </p>
 * <p>
 * Date：2019年5月7日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */

@Service
public class CallRuleServiceImpl extends AbstractServices<CallRule> implements CallRuleService {

	@Transactional
	@Override
	public void saveCallRule(CallRule callRule) {
		insert(callRule);
		
	}

	@Transactional
	@Override
	public void updateCallRule(CallRule callRule) {
		update(callRule);
		
	}

	@Transactional
	@Override
	public void deleteCallRule(String id) {
		deleteById(id);		
		
	}
	

}