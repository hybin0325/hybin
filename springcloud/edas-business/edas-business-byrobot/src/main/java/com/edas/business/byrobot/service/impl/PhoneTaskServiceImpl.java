package com.edas.business.byrobot.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edas.business.byrobot.Util.ByUtils;
import com.edas.business.byrobot.Util.StringUtils;
import com.edas.business.byrobot.dao.master.CustomerMapper;
import com.edas.business.byrobot.dao.master.PhoneTaskMapper;
import com.edas.business.byrobot.entity.Customer;
import com.edas.business.byrobot.entity.CustomerResult;
import com.edas.business.byrobot.entity.CustomerDTO;
import com.edas.business.byrobot.entity.PhoneTask;
import com.edas.business.byrobot.entity.PhoneTaskDTO;
import com.edas.business.byrobot.service.PhoneTaskService;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.exception.BaseException;
import com.edas.edascommon.exception.SystemErrorType;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: PhoneTaskServiceImpl.java
 * </p>
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
@Slf4j
@Service
public class PhoneTaskServiceImpl extends AbstractServices<PhoneTask> implements PhoneTaskService {
	private final static String SUCCESSCODE = "200";
	
	@Autowired
	private PhoneTaskMapper phoneTaskMapper;
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Value("${baiying.baseUrl}")
	private String baseUrl;
	
	@Value("${baiying.appKey}")
	private String appKey;
	
	@Value("${baiying.appSecret}")
	private String appSecret;
	
	/**
     * 
     * @Description:创建任务
     *
     * @param task
     * @return RetResult
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@Transactional
	@Override
	public RetResult<Object> savePhoneTask(PhoneTask task) {
		return addTaskToBy(task);	
	}
	
	
	/**
     * 
     * @Description 百应增加任务
     *
     * @param phoneTask
     *
     * @date 2019年5月9日
     * @author zzw
     */	
	@Override
	public RetResult<Object> addTaskToBy(PhoneTask phoneTask) {
		String url = baseUrl + "/openapi/v1/task/createTask";
		log.info("addPhoneTaskToBy: " + url);			
		Map<String, Object> headersMap = ByUtils.getHeaders(appKey, appSecret);		
		String postData = JSON.toJSONString(phoneTask);		
		log.info("-----------postData---------: " + postData);		
        long starTime = System.currentTimeMillis();	
		JSONObject json = restTemplateService.getPostForEntity(url, postData, headersMap);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求结果: " + json);				
		if(SUCCESSCODE.equals(json.get("code").toString())) {
			Integer taskId = StringUtils.stringToBean(JSON.toJSONString(json.get("data")), Integer.class);
			//任务状态, 0:未开始,1:进行中,2:已完成,3:调度中,4:手动暂停,5:自动暂停,6:已终止,7:排队中,8:AI到期,9:账户欠费,10：短信欠费
			phoneTask.setStatus(0);
			phoneTask.setTaskId(taskId);
			insert(phoneTask);
			return RetResponse.makeRsp(0, taskId+"");
		}else {
			return RetResponse.makeRsp(-1, json.get("resultMsg").toString());
		}		
	}
	
	
	/**
     * 
     * @Description:启动任务
     *
     * @param taskId
     * @return null
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@Override
	public RetResult<Object> startPhoneTask(Integer taskId) {							
		return handleTask("start", taskId);			
	}

	/**
     * 
     * @Description:根据taskid校验数据库是否存在
     *
     * @param taskId
     * @return PhoneTask
     *
     * @date 2019年5月11日
     * @author zzw
     */
	private PhoneTask checkTask(Integer taskId) {
		PhoneTask task = new PhoneTask();
		task.setTaskId(taskId);
		PhoneTask dbTask = selectOne(task);
		if(dbTask == null) {			
			throw new BaseException(SystemErrorType.ARGUMENT_NOT_VALID);
		}
		return dbTask;
	}
	
	/**
     * 
     * @Description:处理任务
     *
     * @param operation，id
     * @return Map
     *
     * @date 2019年5月11日
     * @author zzw
     */
	private RetResult<Object> handleTask(String operation, Integer id) {		
		PhoneTask dbTask = checkTask(id);

		String url = baseUrl + "/openapi/v1/task/" + operation;
		log.info("HandleTaskUrl: " + url);	
		
		Map<String, Object> headersMap = ByUtils.getHeaders(appKey, appSecret);
		
		JSONObject jsonData = new JSONObject();
		jsonData.put("taskId", id);
		String postData = JSON.toJSONString(jsonData);		
		log.info("-----------postData---------: " + postData);		
        long starTime = System.currentTimeMillis();	
		JSONObject jsonResult = restTemplateService.getPostForEntity(url, postData, headersMap);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求结果: " + jsonResult);
		
		if(SUCCESSCODE.equals(jsonResult.get("code").toString())) {			
			//操作成功修改状态 
			//任务状态, 0:未开始,1:进行中,2:已完成,3:调度中,4:手动暂停,5:自动暂停,6:已终止,7:排队中,8:AI到期,9:账户欠费,10：短信欠费
			if("delete".equals(operation)) {								
				deleteById(id+"");				
			}else {
				if("start".equals(operation)) {
					dbTask.setStatus(1);
				}
				if("pause".equals(operation)) {
					dbTask.setStatus(4);
				}
				if("stop".equals(operation)) {
					dbTask.setStatus(6);
				}							
				update(dbTask);
			}						
			return RetResponse.makeRsp(0, jsonResult.get("resultMsg").toString());
		}else {
			return RetResponse.makeRsp(-1, jsonResult.get("resultMsg").toString());
		}		
	}
	
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
	@Override
	public RetResult<Object> pausePhoneTask(Integer taskId) {		
		return handleTask("pause", taskId);			
	}
	
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
	@Override
	public RetResult<Object> stopPhoneTask(Integer taskId) {		
		return handleTask("stop", taskId);	
	}
	
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
	@Transactional
	@Override
	public RetResult<Object> deletePhoneTask(Integer taskId) {		
		return handleTask("delete", taskId);			
	}
	
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
	//@Transactional
	@Override
	public String updatePhoneTask(PhoneTaskDTO task) {
		checkTask(task.getTaskId());
		String url = baseUrl + "/openapi/v1/task/update";
		log.info("updateTaskUrl: " + url);	
		
		Map<String, Object> headersMap = ByUtils.getHeaders(appKey, appSecret);
		
		//参数实例 {"companyId":"16443","taskId":"564242","taskName":"test测试04","taskType":"2",
		//"userPhoneIds":"49232","callType":"2","concurrencyQuota":"2"}
		//task.setCompanyId(16443);		
		//task.setTaskId(1);		
		//task.setTaskName("test测试04");		
		//可选		
		/*task.setTaskType(2);        
		task.setStartDate("2019-06-07");		
		task.setWorkingStartTime("09:50");
		task.setWorkingEndTime("19:20");*/        		
		/*breakStartClose
		breakStartTime
		breakEndTime*/       
        //可选 设置重拨规则 默认参数 fasle 
        /*task.setRepeatCall(false);
        CallRule rule = new CallRule();
        rule.setPhoneStatus(10);
        rule.setInterval(5);
        rule.setTimes(2);
        task.setRepeatCallRule(Arrays.asList(rule));*/        
		//可选，测试只有一个电话 不用改
		//List<Integer> userPhoneIds = new ArrayList<>();
        //userPhoneIds.add(49232);
        //task.setUserPhoneIds(userPhoneIds);		
		//可选，测试只有一个坐席 不用改
		//task.setConcurrencyQuota(1);		
		//主叫号码类型，0-sim卡,1-固话（默认）, 2-无主叫 测试只有一个无主叫电话，也不用改
		//task.setCallType(2);
						
		String postData = JSON.toJSONString(task);		
		log.info("-----------postData---------: " + postData);		
        long starTime = System.currentTimeMillis();	
		JSONObject jsonResult = restTemplateService.getPostForEntity(url, postData, headersMap);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求结果: " + jsonResult);
		
		if(!SUCCESSCODE.equals(jsonResult.get("code").toString())) {		
			return jsonResult.get("resultMsg").toString();
		}
		
		//这里有修改本地数据库的逻辑
		//phoneTaskMapper.updateByPrimaryKeySelective(task);
		return null;
	}
	
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
	@Override
	public RetResult<Object> importCustomer(CustomerDTO customerVO) {
		/*customerVO.setCompanyId(16443);
		customerVO.setTaskId(564187);
		customerVO.setForceTransferCustomer(1);
		
		List<Customer> customerInfoList = new ArrayList<>();
        //客户信息
        for(int i=0;i<=2;i++){
        	Customer customer = new Customer();
        	customer.setName("孙悟空");
        	customer.setPhone("18676899120");
            customerInfoList.add(customer);
        }
        customerVO.setCustomerInfoList(customerInfoList);*/
		
		String url = baseUrl + "/openapi/v2/task/importTaskCustomer";
		log.info("importCustomer: " + url);	
		
		String postData = JSON.toJSONString(customerVO);		
		log.info("-----------postData---------: " + postData);
		
		Map<String, Object> headersMap = ByUtils.getHeaders(appKey, appSecret);
        long starTime = System.currentTimeMillis();	
		JSONObject json = restTemplateService.getPostForEntity(url, postData, headersMap);
		long endTime = System.currentTimeMillis();
		long cost = endTime-starTime;
		log.info("请求耗时: " + cost + " 请求结果: " + json);
				
		if(SUCCESSCODE.equals(json.get("code").toString())) {
			Integer companyId = customerVO.getCompanyId();
			Integer taskId = customerVO.getTaskId();
			List<Customer> customerInfoList = customerVO.getCustomerInfoList();
			for(Customer customer : customerInfoList) {
				customer.setCompanyId(companyId);
				customer.setTaskId(taskId);
				customerMapper.insert(customer);
			}
			
			CustomerResult customerResult = StringUtils.stringToBean(JSON.toJSONString(json.get("data")), CustomerResult.class);					
			return RetResponse.makeRsp(0, customerResult.getMsg());
		}else {		
			return RetResponse.makeRsp(-1, json.get("resultMsg").toString());
		}	
	}

	/**
     * 
     * @Description 任务回调
     *	任务运行中动态状态变更回调，包含如下状态：手动暂停，自动暂停 ，线路欠费 ，短信欠费 ，任务完成 需另外开通和配置
     * @param param
     *
     * @date 2019年5月5日
     * @author zzw
     */	
	@Transactional
	@Override
	public void handlerCallBack(JSONObject param) {
		log.info("jsonString: " + param.toJSONString());
		
		PhoneTask task = StringUtils.stringToBean(JSON.toJSONString(param),PhoneTask.class);
		
		phoneTaskMapper.changeTaskStatus(task.getCompanyId(), task.getCallJobId(), task.getStatus());
		
	}	
}