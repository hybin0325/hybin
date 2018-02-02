package net.medcrm.yjb.workflow.service;

import java.io.IOException;
import java.util.List;

import net.medcrm.yjb.workflow.domain.HflowFormFile;
import net.medcrm.yjb.workflow.vo.FileCommVO;

public interface IHflowFormFileService {

	HflowFormFile save(HflowFormFile formFile)throws IOException;

	void deleteFile(String fileIds);

	HflowFormFile update(HflowFormFile formFile);

	List<HflowFormFile> findListByForm(String taskId);
	
	List<HflowFormFile> findListByPrimaryKeys(String fileIds);
	
	void saveBusinessFormFile(String fileId,String businessId ,String actKey);

	String getFastDbPath();
	
	List<HflowFormFile> findListByFormId(String formId);
	
	void updateBatch(String processInstanceId,String fileIds) ;
	
	
	List<HflowFormFile> findListByProcessInstanceId(String processInstanceId);
	
	/**
	 * 保存图片
	 * @param formFile
	 * @return
	 * @throws IOException
	 */
	public String saveImg(FileCommVO fileComm) throws IOException ;

}
