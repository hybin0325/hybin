package net.medcrm.yjb.workflow.mapper;

import org.apache.ibatis.annotations.Param;

public interface ActHiTaskinstMapper {
	
	String selectActHiTaskinst(@Param("procInstId") String procInstId,@Param("actKey") String actKey);

}
