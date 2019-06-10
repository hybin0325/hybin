package com.edas.business.byrobot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edas.business.byrobot.Util.ByUtils;
import com.edas.business.byrobot.Util.ListUtils;
import com.edas.business.byrobot.Util.StringUtils;
import com.edas.business.byrobot.dao.master.CallResultMapper;
import com.edas.business.byrobot.entity.CallDetail;
import com.edas.business.byrobot.entity.CallResult;
import com.edas.business.byrobot.service.CallDetailService;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * File Name: CallDetailServiceImpl.java
 * </p>
 * <p>
 * Description: 通话详情service
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Service
public class CallDetailServiceImpl extends AbstractServices<CallDetail> implements CallDetailService {
	
	private final static String SUCCESSCODE = "200";
	
	@Autowired
	private CallResultMapper callResultMapper;
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@Value("${baiying.baseUrl}")
	private String baseUrl;
	
	@Value("${baiying.appKey}")
	private String appKey;
	
	@Value("${baiying.appSecret}")
	private String appSecret;
	
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
	@Override
	public CallDetail findByCallInstanceId(int companyId, int taskId, long callInstanceId) {
		CallDetail callDetail = new CallDetail();
		callDetail.setCompanyId(companyId);
		callDetail.setCallJobId(taskId);
		callDetail.setCallInstanceId(callInstanceId);			
		return selectOne(callDetail);		
	}

	/**
     * 
     * @Description 通话详情回调
     *
     * @param param
     *
     * @date 2019年5月5日
     * @author zzw
     */	
	//@Transactional
	@Override
	public void handlerCallBack(JSONObject param) {		
		log.info("jsonString: " + param.toJSONString());		

		CallDetail callDetail = StringUtils.stringToBean(JSON.toJSONString(param.getJSONObject("sceneInstance")),
				CallDetail.class);
		List<CallResult> crResult = (List<CallResult>) JSONArray.parseArray(JSON.toJSONString(param.getJSONArray("taskResult")), 
				CallResult.class);
		
		if(callDetail != null) {
			insert(callDetail);
		}		
		
		if(ListUtils.isNotEmpty(crResult)) {
			for(CallResult result : crResult) {
				callResultMapper.insert(result);
			}
		}
				
	}

	@Transactional
	@Override
	public void saveCallDetail(CallDetail callDetail) {
		insert(callDetail);		
	}

	@Transactional
	@Override
	public void updateCallDetail(CallDetail callDetail) {
		update(callDetail);		
	}

	@Transactional
	@Override
	public void deleteCallDetail(String id) {
		deleteById(id);		
	}
	
	/**
     * 
     * @Description 处理未回调的通话
     *
     * @date 2019年5月13日
     * @author zzw
     */
	@Override
	public RetResult<Object> handleUnCallBack(Map<String, Object> parmsMap) {
		String url = baseUrl + "/openapi/v1/callBack/queryUnCallBack?callJobId=566934&companyId=16443&dataType=0&startDate=2019-05-13 10:00:00&endDate=2019-05-13 11:00:00";	
		log.info("handleUnCallBackUrl: " + url);
		
        Map<String, Object> headers = ByUtils.getHeaders(appKey, appSecret);
        long starTime = System.currentTimeMillis();	
		JSONObject json = restTemplateService.getGetForEntity(url, null, headers);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求数据: " + json);

		if(SUCCESSCODE.equals(json.get("code").toString())) {
			
			//这里处理业务
			JSONObject dataJson = JSON.parseObject(JSON.toJSONString(json.get("data")));			
			Integer pageNum = Integer.parseInt(dataJson.get("pageNum").toString());
			Integer pageSize = Integer.parseInt(dataJson.get("pageSize").toString());
			Integer total = Integer.parseInt(dataJson.get("total").toString());
			Integer pages = Integer.parseInt(dataJson.get("pages").toString());						
			List<CallDetail> callDetail = (List<CallDetail>) JSONArray.parseArray(JSON.toJSONString(dataJson.get("list")), CallDetail.class);
			return RetResponse.makeOKRsp();
		}else {
			return RetResponse.makeRsp(-1, json.get("resultMsg").toString());
		}	

	}

}