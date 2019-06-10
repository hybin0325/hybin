package com.edas.business.tripartite.service.distribution.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.tripartite.entity.distribution.User;
import com.edas.business.tripartite.service.distribution.UserService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * Description: 用户serviceImlp
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class UserServiceImpl extends AbstractServices<User> implements UserService{
	
	@Transactional
	@Override
	public void saveEntity(User entity) {		
		insert(entity);	
	}
	
	@Transactional
	@Override
	public void updateEntity(User entity) {
		update(entity);	
		
	}
	
	@Transactional
	@Override
	public void deleteEntity(String id) {		
		deleteById(id);	
	}

}