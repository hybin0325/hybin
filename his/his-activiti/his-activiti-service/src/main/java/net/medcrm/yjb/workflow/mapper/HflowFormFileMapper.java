package net.medcrm.yjb.workflow.mapper;

import java.util.List;
import java.util.Map;

import net.medcrm.yjb.workflow.domain.HflowFormFile;
import net.medcrm.yjb.workflow.domain.HflowfBusinessFormFile;

/**
 * 表单附件
 * 
 * @author Administrator
 *
 */
public interface HflowFormFileMapper {

	int insert(HflowFormFile record);

	HflowFormFile selectByPrimaryKey(String id);

	int insertBusinessFormFile(HflowfBusinessFormFile record);

	void delete(String id);

	void deleteBusinessFormFile(String id);

	List<String> selectByBusinessFormFile(Map<String, Object> map);

	void deleteBatchBusinessFormFile(List<String> list);

	void deleteBatch(List<String> list);

	List<HflowFormFile> selectListByForm(String formId);

	int updateByPrimaryKeySelective(HflowFormFile record);

	List<HflowFormFile> selectListByPrimaryKeys(List<String> list);

	List<HflowFormFile> selectByInfo(List<String> list);

	void updateBatch(Map<String, Object> map);

	List<HflowFormFile> selectListByProcessInstanceId(String processInstanceId);
}
