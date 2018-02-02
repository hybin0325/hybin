package net.medcrm.yjb.workflow.mapper;

import org.apache.ibatis.annotations.Param;

import net.medcrm.yjb.workflow.domain.HflowModelProcdef;

public interface HflowModelProcdefMapper {
	int insert(HflowModelProcdef record);
	
	HflowModelProcdef selectProcdefByModelId(@Param("modelId") String modelId,@Param("proId") String proId);
}
