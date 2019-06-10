package com.edas.business.tripartite.service.robot;

import java.util.List;

import com.edas.business.tripartite.entity.robot.Customer;
import com.edas.edascommon.core.Service;


/**
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
public interface CustomerService extends Service<Customer>{
	
	/**
     * 
     * @Description 保存
     * @param call
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void saveCustomer(Customer customer); 
	
	/**
     * 
     * @Description 更新
     * @param call
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void updateCustomer(Customer customer);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void deleteCustomer(String id);
	
	/**
     * 
     * @Description 根据公司id查询
     * @param id
     *
     * @date 2019年5月22日
     * @author zzw
     */
	public List<Customer> findByCompanyId(int companyId);
}