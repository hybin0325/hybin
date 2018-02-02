package net.medcrm.yjb.workflow.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import net.medcrm.yjb.workflow.domain.HflowProcdef;
import net.medcrm.yjb.workflow.dto.FlowDeployDto;

public interface HflowProcdefMapper {

	int insert(HflowProcdef record);

	HflowProcdef selectByPrimaryKey(String id);

	List<HflowProcdef> selectAllProcdef(@Param("type") String type, @Param("status") String status,
			@Param("queryValue") String queryValue);

	List<HflowProcdef> selectAllProcdefByModel( @Param("modelId") String modelId,@Param("type") String type,
			@Param("queryValue") String queryValue);

	int updateByPrimaryKeySelective(HflowProcdef record);

	Integer selectMaxSort();

	List<FlowDeployDto> selectAllDeploy(Map<String, Object> map);

	List<String> selectHFlowByMenu(int type, String menuId);

	List<String> selectHFlowKeyByMenu(String menuId, int type);

	List<String> selectProcdefIdByModel(String modelId, int type);

	List<String> selectKeyByModel(@Param("modelId") String modelId, @Param("type") Integer type);

	Map<String, Object> selectObject(@Param("tableName") String tableName, @Param("id") String id);

	void updateBatch(Map<String, Object> map);

	FlowDeployDto selectActReProcdefById(String id);

	List<String> selectAllkey();

	List<String> selectAllKeyByParam(@Param("modelId") String modelId, @Param("type") String type,
			@Param("status") Integer status);

	List<FlowDeployDto> selectSendFlow(List<String> list);

	List<String> selectSendFlowId(@Param("modelId") String modelId, @Param("type") String type,
			@Param("status") Integer status);

	HflowProcdef selectByPrimaryKeyType(@Param("key") String key, @Param("type") Integer type);

	HflowProcdef selectByPrimaryKeyPro(@Param("proId") String proId, @Param("type") Integer type);

	HflowProcdef selectActProcodefInfoByProId(String proId);
	
}
