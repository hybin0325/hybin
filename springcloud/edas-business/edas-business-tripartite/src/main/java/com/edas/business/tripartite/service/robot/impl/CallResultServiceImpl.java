package com.edas.business.tripartite.service.robot.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edas.business.tripartite.entity.robot.CallResult;
import com.edas.business.tripartite.service.robot.CallResultService;
import com.edas.business.tripartite.util.StringUtils;
import com.edas.edascommon.core.AbstractServices;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: 通话结果service
 * </p>
 * <p>
 * Date：2019年5月5日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Service
public class CallResultServiceImpl extends AbstractServices<CallResult> implements CallResultService {
	
	/**
     * 
     * @Description 根据companyId,taskId,CallInstanceId查询
     *
     * @param taskId, callInstanceId
     * @return TaskResult
     *
     * @date 2019年5月5日
     * @author zzw
     */
	@Override
	public CallResult findByCallInstanceId(int companyId, int taskId, long callInstanceId) {
		CallResult callResult = new CallResult();
		callResult.setCompanyId(companyId);
		callResult.setCallJobId(taskId);		
		callResult.setSceneInstanceId(callInstanceId);			
		return selectOne(callResult);			
	}

	@Transactional
	@Override
	public void saveCallResult(CallResult callResult) {
		insert(callResult);	
		
	}

	@Transactional
	@Override
	public void updateCallResult(CallResult callResult) {
		update(callResult);		
		
	}

	@Transactional
	@Override
	public void deleteCallResult(String id) {
		deleteById(id);		
	}
	
	/**
     * 
     * @Description 任务回调
     *
     * @param param
     *
     * @date 2019年5月9日
     * @author zzw
     */	
	@Transactional
	@Override
	public void handlerCallBack(JSONObject param) {
		log.info("请求参数: " + param.toJSONString());		

		CallResult paramResult = StringUtils.stringToBean(JSON.toJSONString(param), CallResult.class);
		
		if(paramResult != null) {
			CallResult example = new CallResult();
			example.setCompanyId(paramResult.getCompanyId());
			example.setSceneInstanceId(paramResult.getSceneInstanceId());
			CallResult dbResult = selectOne(example);
			if(dbResult != null) {
				dbResult.setResultName(paramResult.getResultName());
				dbResult.setResultValue(paramResult.getResultValue());
				update(dbResult);
			}			
		}
	}
}