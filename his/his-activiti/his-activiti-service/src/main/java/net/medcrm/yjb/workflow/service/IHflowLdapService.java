package net.medcrm.yjb.workflow.service;

import java.util.List;

import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.workflow.vo.UserInfoVO;

/**
 * 审批集合
 * 
 * @author Administrator
 *
 */
public interface IHflowLdapService {

	/**
	 * 根据启动用户查询出其部门领导集合
	 * 
	 * @param employee
	 * @return
	 */
	public List<EmployeeVO> findDeptLeaders(String employee);

	/**
	 * 根据启动用户查询出本部门领导集合
	 * @param employee
	 * @return
	 */
	public List<String> findThisDeptLeaders(String employee);

	/**
	 * 根据启动用户查询运营操作者集合
	 * 
	 * @param employee
	 * @return
	 */
	public List<String> findOperators(String employee);

	/**
	 * 根据启动用户查询总监领导集合
	 * 
	 * @param employee
	 * @return
	 */
	public List<String> findLeaders(String employee);

	/**
	 * 根据启动用户查找财务集合
	 * 
	 * @param employee
	 * @return
	 */
	public List<String> findFinances(String employee);

	/**
	 * 根据启动用户查找出纳集合
	 * 
	 * @param employee
	 * @return
	 */
	public List<String> findCashiers(String employee);
}
