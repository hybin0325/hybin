package com.edas.business.tripartite.service.robot;

import com.alibaba.fastjson.JSONObject;
import com.edas.business.tripartite.entity.robot.CallResult;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * Description: 任务结果service
 * </p>
 * <p>
 * Date：2019年5月5日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface CallResultService extends Service<CallResult>{
	
	/**
     * 
     * @Description 根据taskId, CallInstanceId查询
     *
     * @param companyId, taskId, callInstanceId
     * @return TaskResult
     *
     * @date 2019年5月5日
     * @author zzw
     */	
	public CallResult findByCallInstanceId(int companyId, int taskId, long callInstanceId);
	
	/**
     * 
     * @Description 保存
     * @param callResult
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void saveCallResult(CallResult callResult);
	
	/**
     * 
     * @Description 更新
     * @param callResult
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void updateCallResult(CallResult callResult);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void deleteCallResult(String id);
	
	/**
     * 
     * @Description 任务回调
     *
     * @param param
     * @return null
     *
     * @date 2019年5月9日
     * @author zzw
     */	
	public void handlerCallBack(JSONObject param);
}