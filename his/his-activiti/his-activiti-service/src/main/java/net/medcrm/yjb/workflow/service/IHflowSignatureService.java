package net.medcrm.yjb.workflow.service;

import java.util.List;
import java.util.Map;

import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.workflow.domain.HflowSignature;

public interface IHflowSignatureService {
	public void save(HflowSignature pojo);
	
	public void saveHflowSignature(String taskId,EmployeeVO entity,String opinion);
	
	List<HflowSignature> findListInfo(String taskId);
	
	void saveOpeion(String userId,String userName,String deptName,String processInstanceId);
}
