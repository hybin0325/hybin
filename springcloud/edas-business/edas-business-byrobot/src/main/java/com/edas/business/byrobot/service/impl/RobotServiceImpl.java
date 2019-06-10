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
import com.edas.business.byrobot.dao.master.RobotMapper;
import com.edas.business.byrobot.entity.Robot;
import com.edas.business.byrobot.entity.SceneRecords;
import com.edas.business.byrobot.service.RobotService;
import com.edas.edascommon.core.AbstractServices;

import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * File Name: RobotServiceImpl.java
 * </p>
 * <p>
 * Description: 话术service
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
public class RobotServiceImpl extends AbstractServices<Robot> implements RobotService {
	
	@Autowired
	private RobotMapper robotMapper;
	
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
     * @Description: 根据公司id查询话术
     *
     * @param id
     * @return robot
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@Override
	public List<Robot> findByCompanyId(int id) {		
		Robot robot = new Robot();
		robot.setCompanyId(id);				
		return robotMapper.select(robot);
	}
	
	/**
     * 
     * @Description 同步话术
     *
     * @param id
     * 
     * @date 2019年5月8日
     * @author zzw
     */
	@Override
	public void syncRobot(int id) {
		String url = baseUrl + "/openapi/v1/company/getRobots?companyId=" + id;
		log.info("syncRobotUrl: " + url);
	
		Map<String, Object> headersMap = ByUtils.getHeaders(appKey, appSecret);
		
        long starTime = System.currentTimeMillis();	
		JSONObject json = restTemplateService.getGetForEntity(url, null, headersMap);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求数据: " + json);
		
		if(Integer.parseInt(json.get("code").toString())==200) {
			List<Robot> result = (List<Robot>) JSONArray.parseArray(JSON.toJSONString(json.get("data")), Robot.class);
			for(Robot robot: result) {													
				List<SceneRecords> sceneRecords = robot.getSceneRecords();
				if(ListUtils.isNotEmpty(sceneRecords)) {
					robot.setSceneRecordId(sceneRecords.get(0).getSceneRecordId());
					robot.setSceneRecordName(sceneRecords.get(0).getSceneRecordName());																			
				}
				insert(robot);
			}
		}
		
	}

	@Transactional
	@Override
	public void saveRobot(Robot robot) {
		insert(robot);		
	}

	@Transactional
	@Override
	public void updateRobot(Robot robot) {
		update(robot);		
	}

	@Transactional
	@Override
	public void deleteRobot(String id) {
		deleteById(id);		
	}

}