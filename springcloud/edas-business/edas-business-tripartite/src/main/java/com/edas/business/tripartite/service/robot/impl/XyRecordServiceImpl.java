package com.edas.business.tripartite.service.robot.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.edas.business.tripartite.dao.robot.CallRecordMapper;
import com.edas.business.tripartite.entity.robot.CallRecord;
import com.edas.business.tripartite.entity.robot.XyRecord;
import com.edas.business.tripartite.service.robot.XyRecordService;
import com.edas.edascommon.configurer.FastDFSClient;
import com.edas.edascommon.core.AbstractServices;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: 先锋通话记录serviceimpl
 * </p>
 * <p>
 * Date：2019年5月14日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Service
public class XyRecordServiceImpl extends AbstractServices<XyRecord> implements XyRecordService {
    
	@Autowired
    private CallRecordMapper callRecordMapper;
	
	/**
     * 
     * @Description 更新
     * @param record
     *
     * @date 2019年5月14日
     * @author zzw
     */
	@Transactional
	@Override
	public void updateXyRecord(XyRecord record) {
		update(record);		
	}
	
	/**
     * 
     * @Description 保存
     * @param record
     *
     * @date 2019年5月14日
     * @author zzw
     */
	@Transactional
	@Override
	public void saveXyRecord(XyRecord record) {
		insert(record);		
	}
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月14日
     * @author zzw
     */
	@Transactional
	@Override
	public void deleteXyRecord(String id) {
		deleteById(id);		
	}
	
	/**
     * 
     * @Description 回调
     *
     * @param param
     *
     * @date 2019年5月14日
     * @author zzw
     */	
	@Override
	public synchronized void handleCallBack(XyRecord xyRecord, MultipartFile file) {
		if(xyRecord != null) {
			XyRecord exampl = new XyRecord();
			exampl.setFileName(xyRecord.getFileName());
			XyRecord dbRecord = selectOne(exampl);
			if(dbRecord != null) {				
				dbRecord.setCaller(xyRecord.getCaller());
				dbRecord.setDuration(xyRecord.getDuration());
				dbRecord.setDeviceId(xyRecord.getDeviceId());
				dbRecord.setDate(xyRecord.getDate());	
				update(dbRecord);
			}else {
				insert(xyRecord);
			}
		}else {
			try {
				// 获取文件名
		        String fileName = file.getOriginalFilename();	        		        		        
		        //byte[] soundFile = file.getBytes();
		        //String base64Encode = ByUtils.base64Encode(soundFile);
		        String path = FastDFSClient.uploadFile(file);
				String url= FastDFSClient.getResAccessUrl(path);
				CallRecord record = new CallRecord();			
				//record.setSoundFile(base64Encode);
				record.setFileName(fileName);
				record.setClique("GS");
				record.setCreateTime(new Date());
				record.setCreateUser("XFYX");
				record.setPath(url);
				callRecordMapper.insert(record);
				
				XyRecord exampl = new XyRecord();
				exampl.setFileName(fileName);
				XyRecord dbRecord = selectOne(exampl);
				if(dbRecord != null) {				
					dbRecord.setRecordId(record.getId());
					update(dbRecord);
				}else {
					XyRecord newRecord = new XyRecord();
					newRecord.setRecordId(record.getId());
					newRecord.setFileName(fileName);				
					insert(newRecord);
				}
								
			} catch (Exception e) {    
				e.printStackTrace();    
				log.error(e.toString(), e);								    
			}
		}
			
	}	
}