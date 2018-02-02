package net.medcrm.yjb.workflow.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import net.medcrm.yjb.workflow.domain.HflowDraftBox;

public interface HflowDraftBoxMapper {
	int insert(HflowDraftBox record);

	int deleteByPrimaryKey(String id);

	int insertSelective(HflowDraftBox record);

	List<HflowDraftBox> selectAll(@Param("userId") String userId,@Param("queryValue") String queryValue);
	
	HflowDraftBox selectByPrimaryKey(String id);
}