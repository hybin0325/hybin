package net.medcrm.yjb.workflow.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import net.medcrm.yjb.workflow.domain.HflowModel;

public interface HflowModelMapper {
	
	int insert(HflowModel record);
	
	HflowModel selectByPrimaryKey(String id);
	
	HflowModel selectByPrimaryCode(String code);
	
	List<HflowModel> selectAllModel(Map<String,String> map);
	
	int updateByPrimaryKeySelective(HflowModel record);
	
	Integer selectMaxSort();

	List<HflowModel> selectByMenu(String menuId);
	
	void updateBatch(Map<String,Object> map);
	
	List<String> selectProcdefIdByMenu(@Param("menuId") String menuId);
	
	List<String> selectProcdefIdByModelId(@Param("modelId") String modelId,@Param("status") Integer status);
}
