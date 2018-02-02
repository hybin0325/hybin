package net.medcrm.yjb.workflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.IHflowLdapService;
import net.medcrm.yjb.workflow.util.StringUtils;
import net.medcrm.yjb.workflow.vo.UserInfoVO;

@Service(value="hflowLdapService")
public class HflowLdapServiceImpl implements IHflowLdapService {

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Override
	public List<EmployeeVO> findDeptLeaders(String employee) {
		BaseResp<List<EmployeeVO>> base = employeeServiceClient.getEmpLeaderInfo(employee);
		return (List<EmployeeVO>) base.getData();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findThisDeptLeaders(String employee) {
		LoggerUtils.debug(this.getClass(), "-----------------------------"+employee);
		BaseResp<List<String>> base = employeeServiceClient.getEmployLeader(employee);
		return (List<String>) base.getData();
	}

	@Override
	public List<String> findOperators(String employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findLeaders(String employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findFinances(String employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> findCashiers(String employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
