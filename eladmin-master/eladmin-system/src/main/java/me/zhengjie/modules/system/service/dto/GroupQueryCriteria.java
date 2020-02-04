package me.zhengjie.modules.system.service.dto;

import me.zhengjie.annotation.Query;

public class GroupQueryCriteria {
	
	@Query(type = Query.Type.INNER_LIKE)
	private String groupName;

}
