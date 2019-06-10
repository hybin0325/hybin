package com.edas.business.tripartite.service.distribution.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.tripartite.entity.distribution.Order;
import com.edas.business.tripartite.service.distribution.OrderService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * Description: 订单serviceImlp
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Service
public class OrderServiceImpl extends AbstractServices<Order> implements OrderService{
	
	@Transactional
	@Override
	public void saveEntity(Order entity) {		
		insert(entity);	
	}
	
	@Transactional
	@Override
	public void updateEntity(Order entity) {
		update(entity);	
		
	}
	
	@Transactional
	@Override
	public void deleteEntity(String id) {		
		deleteById(id);	
	}

}
