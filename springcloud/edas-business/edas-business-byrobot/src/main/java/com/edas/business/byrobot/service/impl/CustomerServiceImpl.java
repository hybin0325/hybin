package com.edas.business.byrobot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.business.byrobot.entity.Customer;
import com.edas.business.byrobot.service.CustomerService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: CustomerServiceImpl.java
 * </p>
 * <p>
 * Description: 客户service
 * </p>
 * <p>
 * Date：2019年5月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */

@Service
public class CustomerServiceImpl extends AbstractServices<Customer> implements CustomerService {
	
	/**
     * 
     * @Description: 保存
     *
     * @param customer
     *
     * @date 2019年5月6日
     * @author zzw
     */
	@Transactional
	@Override
	public void saveCustomer(Customer customer) {		
		insert(customer);
	}
	
	/**
     * 
     * @Description 更新
     * @param customer
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@Transactional
	@Override
	public void updateCustomer(Customer customer) {
		update(customer);
		
	}
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@Transactional
	@Override
	public void deleteCustomer(String id) {
		deleteById(id);		
	}

	@Override
	public List<Customer> findByCompanyId(int companyId) {
		Customer record = new Customer();
		record.setCompanyId(companyId);
		return select(record);
	}
	
}