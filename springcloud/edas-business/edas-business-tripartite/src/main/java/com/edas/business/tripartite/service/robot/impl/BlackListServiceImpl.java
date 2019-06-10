package com.edas.business.tripartite.service.robot.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edas.business.tripartite.dao.robot.BlackListMapper;
import com.edas.business.tripartite.entity.robot.BlackList;
import com.edas.business.tripartite.service.robot.BlackListService;
import com.edas.business.tripartite.util.ByUtils;
import com.edas.business.tripartite.util.StringUtils;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: 黑名单serviceImlp
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
public class BlackListServiceImpl extends AbstractServices<BlackList> implements BlackListService {
	
	private final static String SUCCESSCODE = "200";
	
	@Autowired
	private BlackListMapper blackListMapper;
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@Value("${baiying.baseUrl}")
	private String baseUrl;
	
	@Value("${baiying.appKey}")
	private String appKey;
	
	@Value("${baiying.appSecret}")
	private String appSecret;
	

	@Transactional
	@Override
	public RetResult<Object> saveBlackList(BlackList blackList) {
		RetResult<Object> result = addBlackListToBy(blackList);
		if(result.getCode() == 0) {			
			//insert(blackList);
			blackListMapper.insert(blackList);
		}
		return result;	
	}
	

	@Transactional
	@Override
	public void updateBlackList(BlackList blackList) {
		update(blackList);		
	}

	@Transactional
	@Override
	public void deleteBlackList(String id) {
		deleteById(id);			
	}
	
	/**
     * 
     * @Description 在百应网站增加黑名单
     *
     * @param blackList
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@Override
	public RetResult<Object> addBlackListToBy(BlackList blackList) {
		String url = baseUrl + "/openapi/v1/company/addBlackList";
		log.info("syncRobotUrl: " + url);	
		Map<String, Object> headersMap = ByUtils.getHeaders(appKey, appSecret);		
		String postData = JSON.toJSONString(blackList);		
        long starTime = System.currentTimeMillis();	
		JSONObject json = restTemplateService.getPostForEntity(url, postData, headersMap);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求结果: " + json);
		
		if(SUCCESSCODE.equals(json.get("code").toString())) {				
			Integer blackListId = StringUtils.stringToBean(JSON.toJSONString(json.get("data")), Integer.class);
			blackList.setBlackListId(blackListId);
			return RetResponse.makeOKRsp();
		}else {
			return RetResponse.makeRsp(-1, json.get("resultMsg").toString());
		}
	}
	
}