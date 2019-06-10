package com.edas.business.tripartite.service.distribution.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.tripartite.entity.distribution.Province;
import com.edas.business.tripartite.service.distribution.ProvinceService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * Description: 省serviceImlp
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class ProvinceServiceImpl extends AbstractServices<Province> implements ProvinceService{
	
	@Transactional
	@Override
	public void saveEntity(Province entity) {		
		insert(entity);	
	}
	
	@Transactional
	@Override
	public void updateEntity(Province entity) {
		update(entity);	
		
	}
	
	@Transactional
	@Override
	public void deleteEntity(String id) {		
		deleteById(id);	
	}

}