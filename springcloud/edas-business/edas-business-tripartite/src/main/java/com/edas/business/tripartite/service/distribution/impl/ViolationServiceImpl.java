package com.edas.business.tripartite.service.distribution.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.tripartite.entity.distribution.Violation;
import com.edas.business.tripartite.service.distribution.ViolationService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * Description: 违章serviceImlp
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class ViolationServiceImpl extends AbstractServices<Violation> implements ViolationService{
	
	@Transactional
	@Override
	public void saveEntity(Violation entity) {		
		insert(entity);	
	}
	
	@Transactional
	@Override
	public void updateEntity(Violation entity) {
		update(entity);	
		
	}
	
	@Transactional
	@Override
	public void deleteEntity(String id) {		
		deleteById(id);	
	}

}