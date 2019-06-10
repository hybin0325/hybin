package com.edas.business.byrobot.service;

import org.springframework.web.multipart.MultipartFile;

import com.edas.business.byrobot.entity.CallRecord;
import com.edas.edascommon.core.Service;
import com.edas.edascommon.utils.web.RetResult;

/**
 * <p>
 * File Name: CallRecordService.java
 * </p>
 * <p>
 * Description: 电话录音service
 * </p>
 * <p>
 * Date：2019年5月8日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface CallRecordService extends Service<CallRecord>{
	
	/**
     * 
     * @Description 保存
     * @param phoneRecord
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void saveCallRecord(CallRecord callRecord);
	
	/**
     * 
     * @Description 更新
     * @param phoneRecord
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void updateCallRecord(CallRecord callRecord);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void deleteCallRecord(String id);
	
	/**
     * 
     * @Description 上传
     * @param file
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public RetResult<Object> uploadRecord(MultipartFile file);
	
	/**
     * 
     * @Description 下载
     * @param fileName
     *
     * @date 2019年5月14日
     * @author zzw
     */	
	public CallRecord downLoadRecord(String fileName);
	
}