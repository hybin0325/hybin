package com.edas.edasmessage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edascommon.utils.DateUtils;
import com.edas.edascommon.utils.EncodeUtils;
import com.edas.edascommon.utils.Md5Utils;
import com.edas.edascommon.utils.UrlUtils;
import com.edas.edasmessage.entity.CarParkLog;
import com.edas.edasmessage.entity.User;
import com.edas.edasmessage.entity.req.CarInParkDataReq;
import com.edas.edasmessage.entity.req.CarOutParkDataReq;
import com.edas.edasmessage.service.CarParkLogService;
import com.edas.edasmessage.service.DeliyunService;
import com.edas.edasmessage.utils.StringUtils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DeliyunServiceImpl implements DeliyunService {

	@Value("${deliyun.url}")
	private String deliyunUrl;

	@Value("${deliyun.url.findParkInLog}")
	private String deliyunUrlFindParkInLog;

	@Value("${deliyun.url.findParkOutLog}")
	private String deliyunUrlFindParkOutLog;

	@Value("${deliyun.accessKeyID}")
	private String accessKeyID;

	@Value("${deliyun.version}")
	private String version;

	@Value("${deliyun.commKey}")
	private String commKey;

	@Value("${deliyun.timestamp}")
	private String timestamp;

	@Value("${deliyun.accessKeySecret}")
	private String accessKeySecret;

	@Autowired
	private RestTemplateService restTemplate;

	@Autowired
	private CarParkLogService carParkLogService;

	/**
	 * 车进场
	 */
	@SneakyThrows
	public void findParkInLog(CarInParkDataReq dataReq,SnowflakeIdWorker idWorker) {

		log.info(JSON.toJSONString(dataReq));
		String dataUtf = EncodeUtils.encodeUrl(JSON.toJSONString(dataReq));
		log.info("dataUtf: " + JSON.toJSONString(dataUtf));

		Map<String, String> map = new HashMap<>();
		map.put("accessKeyID", accessKeyID);
		map.put("timestamp", DateUtils.dateToLong("2019-04-3 09:20") + "");
		map.put("commKey", commKey);
		map.put("version", version);
		map.put("data", dataUtf);
		map.put("accessKeySecret", accessKeySecret);
		// String sign = Md5Utils.getSignToken(map);

		String sign = getSign(dataUtf);
		log.info("sign: " + sign);

		map.remove("data");
		map.remove("accessKeySecret");
		map.put("sign", sign);
		String url = UrlUtils.getRqstUrl(deliyunUrl, deliyunUrlFindParkInLog, map);
		log.info("url: " + url);

		List<CarParkLog> list = restTemplate.getPostForEntity(url, "data=" + dataUtf, CarParkLog.class);
		carParkLogService.saveCarParkLos(list,idWorker);
	}

	/**
	 * 车出场
	 */
	@SneakyThrows
	public void findParkOutLog(CarOutParkDataReq data,SnowflakeIdWorker idWorker) {

		log.info("data: " + JSON.toJSONString(data));
		String dataUtf = EncodeUtils.encodeUrl(JSON.toJSONString(data));
		log.info("dataUtf: " + JSON.toJSONString(dataUtf));

		Map<String, String> map = new HashMap<>();
		map.put("accessKeyID", accessKeyID);
		map.put("timestamp", DateUtils.dateToLong("2019-04-3 09:20") + "");
		map.put("commKey", commKey);
		map.put("version", version);
		map.put("data", dataUtf);
		map.put("accessKeySecret", accessKeySecret);
		log.info("map:  " + map);
		// String sign = Md5Utils.getSignToken(map);

		String sign = getSign(dataUtf);
		log.info("sign: " + sign);
		map.remove("data");
		map.remove("accessKeySecret");
		map.put("sign", sign);
		String url = UrlUtils.getRqstUrl(deliyunUrl, deliyunUrlFindParkOutLog, map);
		log.info("url: " + url);

		List<CarParkLog> list = restTemplate.getPostForEntity(url, "data=" + dataUtf, CarParkLog.class);
		carParkLogService.saveCarParkLos(list,idWorker);

	}
	
	public void findParkOutLog(CarOutParkDataReq data, String key,SnowflakeIdWorker idWorker) {

		log.info("data: " + JSON.toJSONString(data));
		String dataUtf = EncodeUtils.encodeUrl(JSON.toJSONString(data));
		log.info("dataUtf: " + JSON.toJSONString(dataUtf));
		
		if (org.apache.commons.lang3.StringUtils.isBlank(key)) {
			key = commKey;
		}

		String url = UrlUtils.getRqstUrl(deliyunUrl, deliyunUrlFindParkOutLog,  getMap(dataUtf, key));
		log.info("url: " + url);

		List<CarParkLog> list = restTemplate.getPostForEntity(url, "data=" + dataUtf, CarParkLog.class);
		carParkLogService.saveCarParkLos(list,idWorker);
	}
	
	public void findParkInLog(CarInParkDataReq dataReq, String key) {
		log.info(JSON.toJSONString(dataReq));
		String dataUtf = EncodeUtils.encodeUrl(JSON.toJSONString(dataReq));
		log.info("dataUtf: " + JSON.toJSONString(dataUtf));
		
		if (org.apache.commons.lang3.StringUtils.isBlank(key)) {
			key = commKey;
		}

		String url = UrlUtils.getRqstUrl(deliyunUrl, deliyunUrlFindParkInLog, getMap(dataUtf, key));
		log.info("url: " + url);

		List<CarParkLog> list = restTemplate.getPostForEntity(url, "data=" + dataUtf, CarParkLog.class);
		carParkLogService.saveCarParkLos(list,key );
	}
	
	public void findParkInLog(CarInParkDataReq dataReq, String key,SnowflakeIdWorker idWorkers) {
		log.info(JSON.toJSONString(dataReq));
		String dataUtf = EncodeUtils.encodeUrl(JSON.toJSONString(dataReq));
		log.info("dataUtf: " + JSON.toJSONString(dataUtf));
		if (org.apache.commons.lang3.StringUtils.isBlank(key)) {
			key = commKey;
		}
		String url = UrlUtils.getRqstUrl(deliyunUrl, deliyunUrlFindParkInLog, getMap(dataUtf, key));
		log.info("url: " + url);
		List<CarParkLog> list = restTemplate.getPostForEntity(url, "data=" + dataUtf, CarParkLog.class);
		carParkLogService.saveCarParkLos(list,key ,idWorkers);
	}
	

	/**
	 * 加密码签名
	 * 
	 * @param dataUtf
	 * @param timestamp
	 * @return
	 */
	private String getSign(String dataUtf) {
		StringBuilder signData = new StringBuilder();
		signData.append("accessKeyID=").append(accessKeyID);
		signData.append("&commKey=").append(commKey);
		signData.append("&data=").append(dataUtf);
		signData.append("&timestamp=").append(timestamp);
		signData.append("&version=").append(version);
		signData.append("&accessKeySecret=").append(accessKeySecret);
		return Md5Utils.getMD5Value(signData.toString()).toLowerCase();
	}

	/**
	 * 
	 * @Title: getMap 
	 * @Description: 数据封装 
	 * @param dataUtf 
	 * @param key 
	 * @param timestamp
	 * @return Map<String,String> 
	 */
	private Map<String, String> getMap(String dataUtf, String key) {
		Map<String, String> map = new HashMap<>();
		map.put("accessKeyID", accessKeyID);
		map.put("timestamp", DateUtils.dateToLong("2019-04-3 09:20") + "");
		map.put("commKey", key);
		map.put("version", version);
		// map.put("data", dataUtf);
		// map.put("accessKeySecret", accessKeySecret);
		log.info("map:  " + map);
		// String sign = Md5Utils.getSignToken(map);
		String sign = getSign(dataUtf);
		log.info("sign: " + sign);
		// map.remove("data");
		// map.remove("accessKeySecret");
		map.put("sign", sign);
		return map;
	}

	@SneakyThrows
	@Override
	public User getUserInfos() {
		User user = new User();
		user.setId(45);
		user.setUsername("tty");

		String url = "http://127.0.0.1:18081/user/getUsers";
		User rsp = restTemplate.methodPost(url, StringUtils.beanToMap(user), User.class);
		log.info("rsp: " + rsp);
		// RespResult<User> r = restTemplate.postForObject(url, user, RespResult.class);
		// log.info("RespResult: " + r);
		// Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		// String vbillCardProfitBeanStr = gson.toJson(r.getData());
		// User users = gson.fromJson(vbillCardProfitBeanStr, User.class);

		return restTemplate.getUser(url, StringUtils.beanToMap(user));
	}

	
}
