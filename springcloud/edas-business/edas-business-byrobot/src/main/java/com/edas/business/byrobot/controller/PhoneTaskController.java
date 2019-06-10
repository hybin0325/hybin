package com.edas.business.byrobot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.byrobot.entity.CustomerDTO;
import com.edas.business.byrobot.entity.PhoneTask;
import com.edas.business.byrobot.entity.PhoneTaskDTO;
import com.edas.business.byrobot.service.PhoneTaskService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * <p>
 * File Name: PhoneTaskController.java
 * </p>
 * <p>
 * Description: 任务controller
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "callTask-apis", description = "任务-apis")
@RestController
@RequestMapping("phoneTask")
public class PhoneTaskController {
	
	@Autowired
    private PhoneTaskService phoneTaskService;
	
	/**
     * 
     * @Description 查询列表
     *
     * @param page,size
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "获取任务列表", notes = "获取任务列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "page",  required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "size", value = "size",  required = true, dataType = "Integer")
	})
    @GetMapping(value = "/list")
    public RetResult<Object> list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {
		PageHelper.startPage(page, size);
		List<PhoneTask> list = phoneTaskService.selectAll();
		PageInfo<PhoneTask> pageInfo = new PageInfo<PhoneTask>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
	
	
	/**
     * 
     * @Description: 创建任务
     *
     * @param PhoneTask
     * @return RetResult
     *
     * @date 2019年4月30日
     * @author zzw
     */
	@ApiOperation(value = "创建任务", notes = "创建任务")	
	@ApiImplicitParam(name = "phoneTask", value = "实体PhoneTask", required = true, dataType = "PhoneTask")
	@PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody PhoneTask phoneTask) throws Exception {  
		//创建任务参数
		//phoneTask.setCompanyId(16443);
		/*phoneTask.setTaskName("测试test05");
		phoneTask.setTaskType(2);
		List<Integer> userPhoneIds = new ArrayList<>();
		userPhoneIds.add(49232);
		phoneTask.setUserPhoneIds(userPhoneIds);
		phoneTask.setCallType(2);
		phoneTask.setConcurrencyQuota(1);
		phoneTask.setStartDate("2019-06-07");
		phoneTask.setWorkingStartTime("09:50");
		phoneTask.setWorkingEndTime("19:20");        
		phoneTask.setRobotDefId(72913);
		phoneTask.setSceneDefId(72925);
		phoneTask.setSceneRecordId(72921);
		phoneTask.setRemark("测试test05");*/
		
		//设置重拨规则 默认参数 fasle 
		//phoneTask.setRepeatCall(false);
		/*CallRule rule = new CallRule();
		rule.setPhoneStatus(10);
		rule.setInterval(5);
		rule.setTimes(2);
		phoneTask.setRepeatCallRule(Arrays.asList(rule));*/

		return phoneTaskService.savePhoneTask(phoneTask);        
    }
	
	/**
     * 
     * @Description: 启动任务
     *
     * @param phoneTask
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */
	@ApiOperation(value = "启动任务", notes = "启动任务")
	@ApiImplicitParam(name = "taskId", value = "任务id", required = true, dataType = "Integer")   
	@PostMapping(value = "/start/{taskId}")
    public RetResult<Object> startTask(@PathVariable("taskId") Integer taskId) throws Exception {  		
		return phoneTaskService.startPhoneTask(taskId);
    }
	
	/**
     * 
     * @Description: 暂停任务
     *
     * @param phoneTask
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */
	@ApiOperation(value = "暂停任务", notes = "暂停任务")
	@ApiImplicitParam(name = "taskId", value = "任务id", required = true, dataType = "Integer")   
	@PostMapping(value = "/pause/{taskId}")
    public RetResult<Object> pauseTask(@PathVariable("taskId") Integer taskId) throws Exception {  		
        return phoneTaskService.pausePhoneTask(taskId);
    }
	
	/**
     * 
     * @Description: 停止任务
     *
     * @param phoneTask
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */
	@ApiOperation(value = "停止任务", notes = "停止任务")
	@ApiImplicitParam(name = "taskId", value = "任务id", required = true, dataType = "Integer")   
	@PostMapping(value = "/stop/{taskId}")
    public RetResult<Object> stopTask(@PathVariable("taskId") Integer taskId) throws Exception {  		
        return phoneTaskService.stopPhoneTask(taskId);
    }
	
	/**
     * 
     * @Description: 删除任务
     *
     * @param phoneTask
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */	
	@ApiOperation(value = "删除任务", notes = "删除任务")
	@ApiImplicitParam(name = "taskid", value = "任务id", required = true, dataType = "Integer")
	@PostMapping(value = "/delete/{taskId}")
    public RetResult<Object> deleteTask(@PathVariable("taskid") Integer taskid) throws Exception {  		
        return phoneTaskService.deletePhoneTask(taskid);
    }
	
	/**
     * 
     * @Description: 更新任务
     *
     * @param phoneTask
     * @return null
     *
     * @date 2019年4月30日
     * @author zzw
     */
	@ApiOperation(value = "更新任务", notes = "更新任务")
	@ApiImplicitParam(name = "phoneTask", value = "实体phoneTask", required = true, dataType = "PhoneTask")   
	@PostMapping(value = "/update")
    public RetResult<Object> updateTask(@RequestBody PhoneTaskDTO task) throws Exception {  				
		String result = phoneTaskService.updatePhoneTask(task);	
		if(result != null) {
			return RetResponse.makeErrRsp(result);
		}
        return RetResponse.makeOKRsp();
    }
	
	/**
     * 
     * @Description: 导入客户
     *
     * @param CustomerVO
     * @return null
     *
     * @date 2019年5月10日
     * @author zzw
     */
	@ApiOperation(value = "导入客户", notes = "导入客户")
	@ApiImplicitParam(name = "CustomerDTO", value = "实体", required = true, dataType = "CustomerDTO")   
	@PostMapping(value = "/importCustomer")
    public RetResult<Object> importCustomer(@RequestBody CustomerDTO CustomerDTO) throws Exception {  				
        return phoneTaskService.importCustomer(CustomerDTO);
    }
		
}