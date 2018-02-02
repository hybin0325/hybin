package net.medcrm.yjb.workflow.mapper;

import java.util.List;
import java.util.Map;

import net.medcrm.yjb.workflow.vo.ActReProcdefVO;
import net.medcrm.yjb.workflow.vo.FinishedFlowVO;
import net.medcrm.yjb.workflow.vo.HandleInfoVO;
import net.medcrm.yjb.workflow.vo.IdentitylinkVO;
import net.medcrm.yjb.workflow.vo.MonitorVO;

public interface ActReProcdefMapper {
	List<ActReProcdefVO> findByKeysMap(List<String> list);	
	
	Integer findTasByProc(String proId);
	
	List<HandleInfoVO> findHandleFlowsList(Map<String,Object> map);
	
	List<HandleInfoVO> findHistoricFlowsList(Map<String,Object> map);
	
	String selectBusinessByTaskId(String taskId);
	
	List<IdentitylinkVO> selectActHiIdentitylinkList(String taskId);

	List<IdentitylinkVO> selectActRuIdentitylinkList(String taskId);

	void insertActRuIdentitylink(IdentitylinkVO vo);

	void insertActHiIdentitylink(IdentitylinkVO vo);

	void deleteBatchActRuIdentitylink(List<String> list);

	void deleteBatchActHiIdentitylink(List<String> list);
	
	String selectNewActHiTaskinst(String processInstanceId);
	
	List<Map<String,Object>> selectStartActRuTaskInfo(String userId);
	
	List<FinishedFlowVO> selectEndFlowsList(Map<String,Object> map);
	
	List<String> selectHandlerInfo(String handler);
	
	List<String> selectHandlerInfoByList(List<String> list);
	
	List<HandleInfoVO> selectRunningFlowsList(Map<String,Object> map);
	
	List<MonitorVO> findMonitorFlowsList(Map<String,Object> map);
}
