package com.edas.business.tripartite.service.robot.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.edas.business.tripartite.entity.robot.CallRecord;
import com.edas.business.tripartite.service.robot.CallRecordService;
import com.edas.edascommon.configurer.FastDFSClient;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * Description: 电话录音serviceimpl
 * </p>
 * <p>
 * Date：2019年5月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Service
public class CallRecordServiceImpl extends AbstractServices<CallRecord> implements CallRecordService {
	
	/**
     * 
     * @Description 保存录音
     *
     * @param phoneRecord
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@Transactional
	@Override
	public void saveCallRecord(CallRecord callRecord) {
		insert(callRecord);	
		
	}

	@Transactional
	@Override
	public void updateCallRecord(CallRecord callRecord) {
		update(callRecord);	
		
	}

	@Transactional
	@Override
	public void deleteCallRecord(String id) {
		deleteById(id);	
		
	}
	
	/**
     * 
     * @Description 上传
     * @param file
     *
     * @date 2019年5月14日
     * @author zzw
     */
	@Override
	public RetResult<Object> uploadRecord(MultipartFile file) {

		try {
			
			String path = FastDFSClient.uploadFile(file);
			String url= FastDFSClient.getResAccessUrl(path);
								
	        /*String fileName = file.getOriginalFilename();	        	        
	        if(fileName.contains("\\")) {
	        	fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
	        }
	        log.info("上传的文件名为：" + fileName);
	        byte[] soundFile = file.getBytes();
	        String base64Encode = ByUtils.base64Encode(soundFile);
			CallRecord record = new CallRecord();			
			record.setSoundFile(base64Encode);
			record.setClique("GS");
			record.setCreateTime(new Date());
			record.setFileName(fileName);
			insert(record);*/
			
			CallRecord record = new CallRecord();						
			record.setClique("GS");
			record.setCreateTime(new Date());
			record.setPath(url);
			insert(record);
			Map<String,Object> result = new HashMap<>();
			result.put("url", url);			
			result.put("id", record.getId());
			return RetResponse.makeOKRsp(result);  
		} catch (Exception e) {    
			e.printStackTrace();    
			log.error(e.toString(), e);			
			return RetResponse.makeErrRsp("上传失败," + e.getMessage());			    
		}		 	
	}
	
	/**
     * 
     * @Description 下载
     * @param fileName
     *
     * @date 2019年5月14日
     * @author zzw
     */	
	@Override
	public CallRecord downLoadRecord(String fileName) {
		CallRecord record = new CallRecord();
		//record.setFileName(fileName);
		CallRecord dbRecord = selectOne(record);
		if(dbRecord != null) {			
			return dbRecord; 
		}
		return null;
	}
	
}