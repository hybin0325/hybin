package net.medcrm.yjb.workflow.mapper;

import java.util.List;
import java.util.Map;

import net.medcrm.yjb.workflow.domain.OnlineForm;

public interface OnlineFormMapper {
	int insert(OnlineForm record);
	
	OnlineForm selectByPrimaryKey(String id);
	
	List<OnlineForm> selectAll(Map<String,String> map);
	
	int update(OnlineForm record);
	
	int design(OnlineForm record);
	
	int delete(String id);
}
