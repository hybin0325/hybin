package com.edas.business.byrobot.service.impl;

import org.springframework.stereotype.Service;

import com.edas.business.byrobot.entity.CallLog;
import com.edas.business.byrobot.service.CallLogService;
import com.edas.edascommon.core.AbstractServices;

/**
 * <p>
 * File Name: CallLogServiceImpl.java
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

@Service
public class CallLogServiceImpl extends AbstractServices<CallLog> implements CallLogService {
	
	/**
     * 
     * @Description 根据taskId, CallInstanceId查询
     *
     * @param taskId, callInstanceId
     * @return PhoneLog
     *
     * @date 2019年5月5日
     * @author zzw
     */
	@Override
	public CallLog findByCallInstanceId(int taskId, int callInstanceId) {
		CallLog phoneLog = new CallLog();
		phoneLog.setTaskId(taskId);		
		phoneLog.setSceneInstanceId(Long.valueOf(callInstanceId));			
		return selectOne(phoneLog);			
	}
	
	
}