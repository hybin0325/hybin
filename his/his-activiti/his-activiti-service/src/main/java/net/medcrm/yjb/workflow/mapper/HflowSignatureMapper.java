package net.medcrm.yjb.workflow.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.medcrm.yjb.workflow.domain.HflowSignature;

public interface HflowSignatureMapper {

	int insert(HflowSignature record);

	HflowSignature selectByPrimaryKey(String id);
	
	List<HflowSignature> selectListByProcessInstanceId(String processInstanceId);
	
	HflowSignature selectHflowSignatureInfo(@Param("processInstanceId") String processInstanceId);
	
	List<HflowSignature> selectListInfo(@Param("processInstanceId") String processInstanceId);

}
