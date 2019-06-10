package com.edas.business.byrobot.service;

import org.springframework.web.multipart.MultipartFile;

import com.edas.business.byrobot.entity.XyRecord;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: XyRecordService.java
 * </p>
 * <p>
 * Description: 先锋通话记录service
 * </p>
 * <p>
 * Date：2019年5月14日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface XyRecordService extends Service<XyRecord>{
	
	
	/**
     * 
     * @Description 保存
     * @param record
     *
     * @date 2019年5月14日
     * @author zzw
     */
	public void saveXyRecord(XyRecord record);
	
	/**
     * 
     * @Description 更新
     * @param record
     *
     * @date 2019年5月14日
     * @author zzw
     */
	public void updateXyRecord(XyRecord record);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月14日
     * @author zzw
     */
	public void deleteXyRecord(String id);
	
	/**
     * 
     * @Description 回调
     *
     * @param param
     *
     * @date 2019年5月14日
     * @author zzw
     */	
	public void handleCallBack(XyRecord record, MultipartFile file);
}