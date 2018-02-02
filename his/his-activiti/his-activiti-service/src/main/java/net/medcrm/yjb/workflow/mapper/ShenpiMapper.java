package net.medcrm.yjb.workflow.mapper;

import net.medcrm.yjb.workflow.domain.Shenpi;

public interface ShenpiMapper {
	int insert(Shenpi record);
	Shenpi selectByPrimaryKey(String id);
}
