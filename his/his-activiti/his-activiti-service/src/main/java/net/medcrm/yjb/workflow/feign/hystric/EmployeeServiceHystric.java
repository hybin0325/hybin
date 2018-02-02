package net.medcrm.yjb.workflow.feign.hystric;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.DivisionVO;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.feign.PositionVO;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/20.
 */
@Component
public class EmployeeServiceHystric implements EmployeeServiceClient{
    @Override
    public BaseResp<EmployeeVO> currentEmp() {
        System.out.println("进入熔断-> currentEmp");
        return null;
    }

	@Override
	public BaseResp<DivisionVO> getDivisionByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<List<DivisionVO>> getDivisionsByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<List<PositionVO>> getpositionsByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<EmployeeVO> getByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<PositionVO> getPosition(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<List<String>> getEmployLeader(String userId) {
		return null;
	}

	@Override
	public BaseResp<List<String>> getPositionsDeptByUserId(String useId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<List<EmployeeVO>> getEmpLeaderInfo(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<List<Map<String, Object>>> getEmpInfos(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getEmpInfo(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<List<Map<String, Object>>> getEmpInfosList(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseResp<List<Map<String, Object>>> getEmpInfoList(String userIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmpId(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getDeptUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
