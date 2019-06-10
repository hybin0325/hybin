package com.edas.business.byrobot.service;

import com.edas.business.byrobot.entity.CallLog;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: CallLogService.java
 * </p>
 * <p>
 * Description: 通话日志service
 * </p>
 * <p>
 * Date：2019年5月5日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface CallLogService extends Service<CallLog>{
	
	/**
     * 
     * @Description 根据taskId, CallInstanceId查询详情
     *
     * @param taskId, callInstanceId
     * @return PhoneLog
     *
     * @date 2019年5月5日
     * @author zzw
     */
	public CallLog findByCallInstanceId(int taskId, int callInstanceId);
}