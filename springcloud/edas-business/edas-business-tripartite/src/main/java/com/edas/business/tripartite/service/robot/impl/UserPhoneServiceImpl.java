package com.edas.business.tripartite.service.robot.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edas.business.tripartite.entity.robot.UserPhone;
import com.edas.business.tripartite.service.robot.UserPhoneService;
import com.edas.business.tripartite.util.ByUtils;
import com.edas.edascommon.core.AbstractServices;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description: 主叫电话service
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
public class UserPhoneServiceImpl extends AbstractServices<UserPhone> implements UserPhoneService {
	
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
     * @Description: 根据公司id查询电话
     *
     * @param id
     * @return List
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@Override
	public List<UserPhone> findByCompanyId(int id) {		
		UserPhone userPhone = new UserPhone();
		userPhone.setCompanyId(id);						
		return select(userPhone);
	}
	
	/**
     * 
     * @Description 同步主叫电话
     *
     * @param id
     * 
     * @date 2019年5月8日
     * @author zzw
     */
	@Override
	public void syncUserPhone(int id) {
		String url = baseUrl + "/openapi/v1/company/getPhones?companyId=" + id;
		log.info("syncUserPhone: " + url);
	
		Map<String, Object> headersMap = ByUtils.getHeaders(appKey, appSecret);
		
        long starTime = System.currentTimeMillis();	
		JSONObject json = restTemplateService.getGetForEntity(url, null, headersMap);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求数据: " + json);
		
		if(Integer.parseInt(json.get("code").toString())==200) {
			List<UserPhone> result = (List<UserPhone>) JSONArray.parseArray(JSON.toJSONString(json.get("data")), UserPhone.class);
			for(UserPhone phone: result) {				
				insert(phone);				
			}
		}
	}
	
	@Transactional
	@Override
	public void saveUserPhone(UserPhone userPhone) {
		insert(userPhone);		
	}

	@Transactional
	@Override
	public void updateUserPhone(UserPhone userPhone) {
		update(userPhone);
		
	}
	
	@Transactional	
	@Override
	public void deleteUserPhone(String id) {
		deleteById(id);		
	}
		
	

}
