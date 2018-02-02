package net.medcrm.yjb.workflow.feign.client;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.DivisionVO;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.feign.PositionVO;
import net.medcrm.yjb.workflow.config.feign.OAuth2FeignAutoConfiguration;

/**
 * Created by Administrator on 2017/11/20.
 */

@FeignClient(name = "employeeService", url = "${employeeService.ribbon.listOfServers}", configuration = {
		OAuth2FeignAutoConfiguration.class })
public interface EmployeeServiceClient {

	/**
	 * 获取当前登录用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/employee/currentEmp", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<EmployeeVO> currentEmp();

	/**
	 * 根据人员信息查询部门信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/employee/major", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<DivisionVO> getDivisionByUserId(String useId);

	/**
	 * 根据人员信息查询相关部门信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/employee/divisionsById", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<List<DivisionVO>> getDivisionsByUserId(String useId);

	/**
	 * 根据人员信息查询相关角色信息、部门
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/employee/positionsById", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public BaseResp<List<PositionVO>> getpositionsByUserId(@RequestParam(value = "userId") String useId);

	/**
	 * 根据人员信息查询相关角色信息、部门、部门角色组合
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getPositionsDeptByUserId", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public BaseResp<List<String>> getPositionsDeptByUserId(@RequestParam(value = "userId") String useId);

	/**
	 * 根据人员ID查询人员信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getByUserId", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<EmployeeVO> getByUserId(@RequestParam(value = "userId") String useId);

	/**
	 * 得到角色信息
	 * 
	 * @param useId
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getPosition", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<PositionVO> getPosition(String id);

	/**
	 * 根据流程申请人查询部门领导
	 * 
	 * @param useId
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getEmployLeader", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<List<String>> getEmployLeader(@RequestParam(value = "userId") String userId);

	@RequestMapping(value = "/api/employee/getEmpLeaderInfo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<List<EmployeeVO>> getEmpLeaderInfo(@RequestParam(value = "userId") String userId);

	/**
	 * 得到人员信息
	 * 
	 * @param useId
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getEmpInfo", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Map<String, Object> getEmpInfo(@RequestParam(value = "userId") String userId);
	
	/**
	 * id:可能为部门id、角色Id、部门角色关联Id
	 * 
	 * @param useId
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getEmpInfos", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<List<Map<String, Object>>> getEmpInfos(@RequestParam(value = "id") String id);
	
	/**
	 * id:可能为部门id、角色Id、部门角色关联Id
	 * 
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getEmpInfosList", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<List<Map<String, Object>>> getEmpInfosList(@RequestParam(value = "ids") String ids);
	
	
	/**
	 * 得到人员信息
	 * 
	 * @param useId
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getEmpInfoList", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public BaseResp<List<Map<String, Object>>> getEmpInfoList(@RequestParam(value = "userIds") String userIds);
	
	/**
	 * 人名查ID
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getEmpId", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public String getEmpId(@RequestParam(value = "userName") String userName);
	
	/**
	 *部门下所有的人员
	 * Last_update2018年1月29日下午3:04:06
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/api/employee/getDeptUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public List<String> getDeptUser(@RequestParam(value = "userId") String userId);

}
