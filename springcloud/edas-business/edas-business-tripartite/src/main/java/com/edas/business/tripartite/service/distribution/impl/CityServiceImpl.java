package com.edas.business.tripartite.service.distribution.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.tripartite.entity.distribution.City;
import com.edas.business.tripartite.service.distribution.CityService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * Description: 市serviceImlp
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class CityServiceImpl extends AbstractServices<City> implements CityService{
	
	@Transactional
	@Override
	public void saveEntity(City entity) {
		insert(entity);		
	}
	
	@Transactional
	@Override
	public void updateEntity(City entity) {		
		update(entity);	
	}
	
	@Transactional
	@Override
	public void deleteEntity(String id) {		
		deleteById(id);			
	}

}
