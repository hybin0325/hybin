package net.medcrm.yjb.workflow.service;

import java.util.List;
import java.util.Map;

import net.medcrm.yjb.workflow.domain.HflowModel;

public interface IHflowModelService {

	void save(HflowModel record);
	
	void update(HflowModel record);
	
	HflowModel findById(String id);
	
	List<HflowModel> findAllModel(String queryValue,int pageNum, int pageSize);
	
	/**
	 * 向下排序
	 * @param currentId
	 * @param currentSort
	 * @param downId
	 * @param downSort
	 */
	void  updateDownChangeSort(String currentId,int currentSort,String downId,int downSort);
	
	/**
	 * 向上排序
	 * @param currentId
	 * @param currentSort
	 * @param upId
	 * @param upSort
	 */
	void  updateUpChangeSort(String currentId,int currentSort,String upId,int upSort);
	
	/**
	 * 向上、向下排序
	 * @param currentId
	 * @param currentSort
	 * @param changeId
	 * @param changeSort
	 */
	String updateChangeSort(String currentId,String changeId);
	
	/**
	 * 停用
	 * @param id
	 * @param status
	 */
	int updateDisableModel(String id ,int status);
	
	/**
	 * 内容
	 * @param Model
	 * @param procde
	 */
	void saveModelContent(String Model,String[] procde);
	
	
	int getByCode(String code);
	
	boolean isExistCode(String code);


}
