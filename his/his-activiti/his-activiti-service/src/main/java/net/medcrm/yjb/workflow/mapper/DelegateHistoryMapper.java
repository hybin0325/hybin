package net.medcrm.yjb.workflow.mapper;

import net.medcrm.yjb.workflow.domain.DelegateHistory;

public interface DelegateHistoryMapper {

	int insert(DelegateHistory record);
	
	int updateByPrimaryKeySelective(DelegateHistory record);

}
