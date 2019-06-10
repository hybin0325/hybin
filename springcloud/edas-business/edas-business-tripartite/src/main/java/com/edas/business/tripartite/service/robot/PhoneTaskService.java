package com.edas.business.tripartite.service.robot;

import com.alibaba.fastjson.JSONObject;
import com.edas.business.tripartite.entity.robot.CustomerDTO;
import com.edas.business.tripartite.entity.robot.PhoneTask;
import com.edas.business.tripartite.entity.robot.PhoneTaskDTO;
import com.edas.edascommon.core.Service;
import com.edas.edascommon.utils.web.RetResult;

/**
 * <p>
 * Description: 任务service
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface PhoneTaskService extends Service<PhoneTask>{
	
	/**
     * 
     * @Description:创建任务
     *
     * @param task
     * @return null
     *
     * @date 2019年4月29日
     * @author zzw
     */
	public RetResult<Object> savePhoneTask(PhoneTask task);
	
	/**
     * 
     * @Description:启动任务
     *
     * @param id
     * @return Map
     *
     * @date 2019年4月29日
     * @author zzw
     */
	public RetResult<Object> startPhoneTask(Integer id);
	
	/**
     * 
     * @Description:暂停任务
     *
     * @param id
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */
	public RetResult<Object> pausePhoneTask(Integer id);
	
	/**
     * 
     * @Description:停止任务
     *
     * @param id
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */
	public RetResult<Object> stopPhoneTask(Integer id);
	
	/**
     * 
     * @Description:删除任务
     *
     * @param id
     * @return null
     *
     * @date 2019年4月29日
     * @author zzw
     */
	public RetResult<Object> deletePhoneTask(Integer id);
	
	/**
     * 
     * @Description:更新任务
     *
     * @param 
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */
	public String updatePhoneTask(PhoneTaskDTO task);
	
	/**
     * 
     * @Description:导入客户
     *
     * @param 
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */
	public RetResult<Object> importCustomer(CustomerDTO customerVO);
	
	/**
     * 
     * @Description 任务回调
     *
     * @param objetc
     * @return null
     *
     * @date 2019年5月5日
     * @author zzw
     */	
	public void handlerCallBack(JSONObject param);
	
	/**
     * 
     * @Description 百应增加任务
     *
     * @param phoneTask
     *
     * @date 2019年5月9日
     * @author zzw
     */	
	public RetResult<Object> addTaskToBy(PhoneTask phoneTask);
}