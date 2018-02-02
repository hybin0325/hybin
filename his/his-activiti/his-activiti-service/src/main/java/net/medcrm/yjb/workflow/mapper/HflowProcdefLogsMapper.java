package net.medcrm.yjb.workflow.mapper;

import net.medcrm.yjb.workflow.domain.HflowModel;
import net.medcrm.yjb.workflow.domain.HflowProcdefLogs;

public interface HflowProcdefLogsMapper {
	
	int insert(HflowProcdefLogs record);
	
	Integer selectMaxSort();
	
	int updateByPrimaryKeySelective(HflowProcdefLogs record);
	
	HflowProcdefLogs selectByPrimaryKey(String id);
	
	HflowProcdefLogs selectByPrimaryProId(String proId);
	
}
