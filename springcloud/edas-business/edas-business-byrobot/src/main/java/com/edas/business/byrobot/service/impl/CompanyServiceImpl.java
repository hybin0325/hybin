package com.edas.business.byrobot.service.impl;

import java.util.HashMap;
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
import com.edas.business.byrobot.Util.StringUtils;
import com.edas.business.byrobot.entity.Company;
import com.edas.business.byrobot.service.CompanyService;
import com.edas.edascommon.core.AbstractServices;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: CompanyServiceImpl.java
 * </p>
 * <p>
 * Description: 公司service
 * </p>
 * <p>
 * Date：2019年4月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Service
public class CompanyServiceImpl extends AbstractServices<Company> implements CompanyService {
	
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
	public void updateCompany(Company company) {
		update(company);		
	}
	
	@Transactional
	@Override
	public void saveCompany(Company company) {
		insert(company);		
	}

	@Transactional
	@Override
	public void deleteCompany(String id) {
		deleteById(id);		
	}
	
	/**
     * 
     * @Description 同步公司
     *
     *
     * @date 2019年5月7日
     * @author zzw
     */
	@Override
	public void syncCompany() {
		
		String url = baseUrl + "/openapi/v1/company/getCompanys";
		log.info("syncCompanyUrl: " + url);
		
        Map<String, Object> headers = ByUtils.getHeaders(appKey, appSecret);
        long starTime = System.currentTimeMillis();	
		JSONObject json = restTemplateService.getGetForEntity(url, null, headers);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求数据: " + json);
		if(Integer.parseInt(json.get("code").toString())==200) {
			List<Company> companys = (List<Company>) JSONArray.parseArray(JSON.toJSONString(json.get("data")), Company.class);
			for(Company com: companys) {				
				insert(com);				
			}
		}
	}
	
	/**
     * 
     * @Description 获取公司坐席
     * @param id
     * @return Map
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@Override
	public Map<String, Object> getCompanySeat(int id) {
		String url = baseUrl + "/openapi/v1/company/seat/statistics?companyId=" + id;
		log.info("syncRobotUrl: " + url);
	
		Map<String, Object> headers = ByUtils.getHeaders(appKey, appSecret);
		
        long starTime = System.currentTimeMillis();	
		JSONObject json = restTemplateService.getGetForEntity(url, null, headers);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求数据: " + json);
		
		Map<String, Object> result = new HashMap<>();		
		if(Integer.parseInt(json.get("code").toString())==200) {			
			JSONObject obj = JSON.parseObject(json.get("data").toString());
			Integer companyAllCallSeat = StringUtils.stringToBean(JSON.toJSONString(obj.get("companyAllCallSeat")), Integer.class);
			Integer companyUsingCallSeat = StringUtils.stringToBean(JSON.toJSONString(obj.get("companyUsingCallSeat")), Integer.class);
			result.put("companyAllCallSeat", companyAllCallSeat);
			result.put("companyUsingCallSeat", companyUsingCallSeat);
		}
		return result;
	}
	
}
