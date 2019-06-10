package com.edas.business.byrobot.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.edas.business.byrobot.entity.CallDetail;
import com.edas.edascommon.core.Service;
import com.edas.edascommon.utils.web.RetResult;


/**
 * <p>
 * File Name: CallDetailService.java
 * </p>
 * <p>
 * Description: 通话详情service
 * </p>
 * <p>
 * Date：2019年4月30日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface CallDetailService extends Service<CallDetail>{
	
	/**
     * 
     * @Description 根据taskId, CallInstanceId查询详情
     *
     * @param taskId, callInstanceId
     * @return PhoneDetails
     *
     * @date 2019年4月29日
     * @author zzw
     */
	public CallDetail findByCallInstanceId(int companyId, int taskId, long callInstanceId);
	
	/**
     * 
     * @Description 通话详情回调
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
     * @Description 保存
     * @param BlackList
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void saveCallDetail(CallDetail callDetail);
	
	/**
     * 
     * @Description 更新
     * @param BlackList
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void updateCallDetail(CallDetail callDetail);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void deleteCallDetail(String id);
	
	/**
     * 
     * @Description 处理未回调的通话
     *
     * @date 2019年5月13日
     * @author zzw
     */
	public RetResult<Object> handleUnCallBack(Map<String, Object> parmsMap);
}