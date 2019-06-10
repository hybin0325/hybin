package com.edas.business.tripartite.service.robot;

import com.edas.business.tripartite.entity.robot.CallLog;
import com.edas.edascommon.core.Service;

/**
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