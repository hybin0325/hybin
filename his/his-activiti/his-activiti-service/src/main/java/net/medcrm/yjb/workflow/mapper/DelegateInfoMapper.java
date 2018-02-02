package net.medcrm.yjb.workflow.mapper;

import java.util.List;
import java.util.Map;

import net.medcrm.yjb.workflow.domain.DelegateInfo;

public interface DelegateInfoMapper {

	int insert(DelegateInfo record);
	
	List<DelegateInfo> selectAll(Map<String,Object> map);
	
	DelegateInfo selectByPrimaryKey(String id);
	
	int delete(String id);
	
}
