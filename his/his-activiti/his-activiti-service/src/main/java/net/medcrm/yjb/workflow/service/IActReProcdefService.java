package net.medcrm.yjb.workflow.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import net.medcrm.yjb.workflow.vo.ActReProcdefVO;
import net.medcrm.yjb.workflow.vo.FinishedFlowVO;
import net.medcrm.yjb.workflow.vo.HandleInfoVO;
import net.medcrm.yjb.workflow.vo.MonitorVO;
import net.medcrm.yjb.workflow.vo.QuereyParameterVO;

public interface IActReProcdefService {
	/**
	 * 查询
	 * 
	 * @param list
	 * @return
	 */
	List<ActReProcdefVO> findActReProcdefList(String modelId, int pageNum, int pageSize);

	/**
	 * 上传布署
	 * 
	 * @param filePath
	 * @param newFileName
	 * @param user
	 * @return
	 */
	void updateDeployZIP(String filePath, String newFileName, String user, String modelId) throws Exception;

	/**
	 * 转model
	 * 
	 * @param processDefinition
	 * @param user
	 * @return
	 * @throws Exception
	 */
	String updateConvertToModel(ProcessDefinition processDefinition, String user, String modelId) throws Exception;

	/**
	 * 查看流程实例是否被 使用
	 * 
	 * @param proId
	 * @return
	 */
	Integer findTasByProc(String proId);

	/**
	 * 布署
	 * 
	 * @param modelData
	 * @param user
	 * @param dec
	 * @return
	 */
	String saveDeploy(Model modelData, String user, String dec);

	void updateState(String actProcodefId, String state);

	PageInfo<HandleInfoVO> getHandleHFlow(String applyUser, String start, String end, String queryValue, String modelId,
			String userId, int pageNum, int pageSize);

	PageInfo<HandleInfoVO> getHistoryFlow(String modelId, String userId, int pageNum, int pageSize);

	PageInfo<FinishedFlowVO> finished(String applyUser, String start, String end, String queryValue, String modelId,
			String handler, int pageNum, int pageSize);

	PageInfo<HandleInfoVO> findRunningFlows(String applyUser, String start, String end, String queryValue,
			String modelId, List<String> handler, int pageNum, int pageSize);

	PageInfo<HandleInfoVO> findRunningFlows(String applyUser, Map<String, Object> queryUser,
			QuereyParameterVO quereyPara);

	PageInfo<FinishedFlowVO> finished(String applyUser, Map<String, Object> queryUser, QuereyParameterVO quereyPara);

	PageInfo<MonitorVO> findFlowMonitor(String applyUser, String queryValue, String modelId, int pageNum, int pageSize);
}
