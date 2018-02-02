package net.medcrm.yjb.workflow.mapper;

import net.medcrm.yjb.workflow.domain.Leave;

public interface LeaveMapper {

	int insert(Leave record);

	

	Leave selectByPrimaryKey(String id);

}
