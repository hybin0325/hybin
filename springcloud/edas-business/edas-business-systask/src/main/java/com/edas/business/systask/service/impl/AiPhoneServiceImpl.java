package com.edas.business.systask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.systask.entity.AiPhone;
import com.edas.business.systask.service.AiPhoneService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: AiPhoneServiceImpl.java
 * </p>
 * <p>
 * Description: ai电话关联 impl
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class AiPhoneServiceImpl extends AbstractServices<AiPhone> implements AiPhoneService{
	
	@Transactional
	@Override
	public void saveAiPhone(AiPhone phone) {
		insert(phone);		
	}
	
	@Transactional
	@Override
	public void updateAiPhone(AiPhone phone) {
		update(phone);			
	}

	@Override
	public void deleteAiPhone(String id) {
		deleteById(id);		
	}

}