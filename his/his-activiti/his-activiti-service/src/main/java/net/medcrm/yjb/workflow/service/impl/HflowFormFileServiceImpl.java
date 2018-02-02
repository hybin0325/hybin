package net.medcrm.yjb.workflow.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lorne.tx.annotation.TxTransaction;

import net.medcrm.yjb.his.fastdfs.ClientGlobal;
import net.medcrm.yjb.his.fastdfs.UploadStream;
import net.medcrm.yjb.his.feign.Attachment;
import net.medcrm.yjb.his.fileutil.Base64Util;
import net.medcrm.yjb.workflow.domain.HflowFormFile;
import net.medcrm.yjb.workflow.domain.HflowfBusinessFormFile;
import net.medcrm.yjb.workflow.feign.client.SearchServiceClient;
import net.medcrm.yjb.workflow.mapper.ActReProcdefMapper;
import net.medcrm.yjb.workflow.mapper.HflowFormFileMapper;
import net.medcrm.yjb.workflow.service.IHflowFormFileService;
import net.medcrm.yjb.workflow.service.IProcessInstanceService;
import net.medcrm.yjb.workflow.util.StringUtils;
import net.medcrm.yjb.workflow.vo.FileCommVO;

@Service
public class HflowFormFileServiceImpl implements IHflowFormFileService {

	@Autowired
	private HflowFormFileMapper formFileMapper;

	@Autowired
	private ActReProcdefMapper actReProcdefMapper;

	@Autowired
	private SearchServiceClient searchServiceClient;

	@Autowired
	private IProcessInstanceService processInstanceService;

	@Value("${upload.url}")
	String uploadUrl;

	@Override
	@TxTransaction
	@Transactional
	public HflowFormFile save(HflowFormFile formFile) throws IOException {
		String returnValue = "";
		String fileType = "";
		String url = Base64Util.getLoadFilePath() + formFile.getUrl();
		fileType = FilenameUtils.getExtension(formFile.getUrl());
		File file = new File(url);
		formFile.setFileSize(Base64Util.getFileSize(file));
		String[] files = UploadStream.uploadFile(file, formFile.getUrl(), file.length());
		// returnValue = uploadUrl +files[1];
		returnValue = ClientGlobal.uploadUrl + files[1];
		formFile.setUrl(files[1]);
		formFile.setFileType(fileType);
		formFile.createPersistentObject();
		formFileMapper.insert(formFile);
		saveSearchService(formFile.getId(), formFile.getFileName(), fileType, returnValue, formFile.getCreateUserId(),
				formFile.getCreateUser());

		HflowFormFile pojo = formFileMapper.selectByPrimaryKey(formFile.getId());
		if (StringUtils.isNull(pojo))
			return pojo;
		if (StringUtils.isNotNull(formFile.getBusinessId()) && StringUtils.isNotNull(formFile.getBusinessKey())) {
			saveBusinessFormFile(pojo.getId(), formFile.getBusinessId(), formFile.getBusinessKey());
		}
		return pojo;
	}
	
	@TxTransaction
	public String saveImg(FileCommVO fileComm) throws IOException {
		String returnValue = "";
		String path = Base64Util.uploadFile(fileComm.getBase64Str());
		String url = Base64Util.getLoadFilePath() + path;
		File file = new File(url);
		String[] files = UploadStream.uploadFile(file, path, file.length());
		// returnValue = uploadUrl +files[1];
		returnValue = ClientGlobal.uploadUrl + files[1];
		return returnValue;
	}

	/**
	 * 
	 * @param fileId
	 * @param businessId
	 * @param actKey
	 */
	@Transactional
	public void saveBusinessFormFile(String fileId, String businessId, String actKey) {
		Map<String, Object> param = new HashMap<>();
		param.put("fileId", fileId);
		param.put("fromId", businessId);
		param.put("fileList", null);
		List<String> list = formFileMapper.selectByBusinessFormFile(param);
		if (StringUtils.isNull(list))
			return;
		HflowfBusinessFormFile bff = new HflowfBusinessFormFile();
		bff.createPersistentObject();
		bff.setFileId(fileId);
		bff.setBusinessKey(actKey);
		bff.setFormId(businessId);
		formFileMapper.insertBusinessFormFile(bff);
	}

	@TxTransaction
	public HflowFormFile update(HflowFormFile formFile) {
		String returnValue = "";
		String fileType = "";
		try {
			String url = Base64Util.getLoadFilePath() + formFile.getUrl();
			fileType = FilenameUtils.getExtension(formFile.getUrl());
			File file = new File(url);
			formFile.setFileSize(Base64Util.getFileSize(file));
			String[] files = UploadStream.uploadFile(file, formFile.getUrl(), file.length());
			// returnValue = uploadUrl + files[1];
			returnValue = ClientGlobal.uploadUrl + files[1];
			formFile.setUrl(files[1]);
			formFile.setFileType(fileType);
			formFileMapper.updateByPrimaryKeySelective(formFile);
			saveSearchService(formFile.getId(), formFile.getFileName(), fileType, returnValue,
					formFile.getCreateUserId(), formFile.getCreateUser());
		} catch (IOException e) {
			e.printStackTrace();
		}
		HflowFormFile pojo = formFileMapper.selectByPrimaryKey(formFile.getId());
		if (StringUtils.isNull(pojo))
			return pojo;
		if (StringUtils.isNotNull(formFile.getBusinessId()) && StringUtils.isNotNull(formFile.getBusinessKey())) {
			saveBusinessFormFile(pojo.getId(), formFile.getBusinessId(), formFile.getBusinessKey());
		}
		return pojo;
	}

	/**
	 * 同步附件啊
	 * 
	 * @param fileId
	 * @param fileName
	 * @param fileType
	 * @param url
	 * @param createUserId
	 * @param createUserName
	 * @return
	 */
	protected String saveSearchService(String fileId, String fileName, String fileType, String url, String createUserId,
			String createUserName) {
		Attachment attachment = new Attachment();
		attachment.setCreateDate(new Date().getTime());
		attachment.setFileType(Attachment.FILETYPE_ACTIVITI + "");
		attachment.setFileName(fileName);
		attachment.setUrl(url);
		attachment.setCreateUserId(createUserId);
		attachment.setCreateUserName(createUserName);
		attachment.setId(fileId);
		try {
			searchServiceClient.create(attachment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public void deleteFile(String fileIds) {
		Map<String, Object> param = new HashMap<>();
		if (fileIds.indexOf(",") != -1) {
			formFileMapper.delete(fileIds);
			param.put("fileId", fileIds);
			param.put("fromId", null);
			param.put("fileList", null);
			List<String> list = formFileMapper.selectByBusinessFormFile(param);
			formFileMapper.deleteBatchBusinessFormFile(list);
		} else {
			List<String> fileList = StringUtils.stringToList(fileIds, ",");
			formFileMapper.deleteBatch(fileList);
			param.put("fileId", null);
			param.put("fromId", null);
			param.put("fileList", fileList);
			List<String> list = formFileMapper.selectByBusinessFormFile(param);
			formFileMapper.deleteBatchBusinessFormFile(list);
		}
	}

	public List<HflowFormFile> findListByForm(String taskId) {
		String businessId = actReProcdefMapper.selectBusinessByTaskId(taskId);
		if (StringUtils.isNotNull(businessId)) {
			List<HflowFormFile> list = formFileMapper.selectListByForm(businessId);
			return list;
		} else {
			Map<String, Object> variables = processInstanceService.getTaskVariables(taskId);
			if (StringUtils.isNotNull(variables) && StringUtils.isNotNull(variables.get("fileIds"))) {
				String fileIds = variables.get("fileIds").toString();
				String[] str = fileIds.split(",");
				List<String> param = Arrays.asList(str);
				List<HflowFormFile> list = formFileMapper.selectByInfo(param);
				return list;
			}
		}
		return null;
	}

	public List<HflowFormFile> findListByFormId(String processInstanceId) {
		List<HflowFormFile> list = formFileMapper.selectListByForm(processInstanceId);
		return list;
	}

	@Override
	public List<HflowFormFile> findListByPrimaryKeys(String fileIds) {
		List<String> list = StringUtils.stringToList(fileIds, ",");
		return formFileMapper.selectListByPrimaryKeys(list);
	}

	public String getFastDbPath() {
		return ClientGlobal.uploadUrl;
	}

	@Transactional
	public void updateBatch(String processInstanceId, String fileIds) {
		if (StringUtils.isNull(fileIds))
			return;
		Map<String, Object> map = new HashMap<>();
		map.put("processInstanceId", processInstanceId);
		map.put("list", StringUtils.str2List(fileIds, ","));
		formFileMapper.updateBatch(map);
	}

	@Override
	public List<HflowFormFile> findListByProcessInstanceId(String processInstanceId) {
		return formFileMapper.selectListByProcessInstanceId(processInstanceId);
	}

}
