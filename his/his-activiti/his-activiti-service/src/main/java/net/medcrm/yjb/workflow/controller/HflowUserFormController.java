package net.medcrm.yjb.workflow.controller;

import java.util.Date;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.domain.HflowDraftBox;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.IHflowDraftBoxService;
import net.medcrm.yjb.workflow.service.IProcessInstanceService;
import net.medcrm.yjb.workflow.util.ListUtils;
import net.medcrm.yjb.workflow.util.StringUtils;

/**
 * 用户使用自定义表单、流程
 * 
 * @author hybin
 *
 */
@RestController
@RequestMapping(value = "/user/form")
public class HflowUserFormController {

	@Autowired
	private IProcessInstanceService processInstanceService;

	@Autowired
	private IHflowDraftBoxService flowDraftBoxService;

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Autowired
	private RepositoryService repositoryService;

	/**
	 * 读取Task的表单
	 */
	@ApiOperation(value = "流程流行中--加载表单内容来渲染", notes = "表单内容来渲染审批中 form", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "流程实例ID", required = true, dataType = "String")
	@RequestMapping(value = "getForm/task")
	public Object findTaskForm(String taskId) throws Exception {
		if (StringUtils.isNull(taskId))
			return new BaseResp<>(-1, "参数有误", null);
		return new BaseResp<>(processInstanceService.getTaskVariables(taskId));
	}

	/**
	 * 读取启动流程的表单字段
	 */
	@ApiOperation(value = "用户发起流程--表单填写返回数据", notes = "表单填写返回数据，开启流程", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processDefinitionId", value = "流程实例ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "fileIds", value = "附件ID，多个用逗号拼接", required = false, dataType = "String"),
			@ApiImplicitParam(name = "object", value = "表单数据", required = true, dataType = "String") })
	@PostMapping(value = "/startProcess")
	@SuppressWarnings("unchecked")
	public Object submitStartFormAndStartProcessInstance(String processDefinitionId, String fileIds,
			@RequestBody String object) {
		if (StringUtils.isNull(object))
			return new BaseResp<>(-1, "数据为空", null);
		
		Map<String, Object> mapObj = (Map<String, Object>) JSONObject.parse(object);
		Map<String, String> formProperties = ListUtils.map2Map(mapObj);
		
		LoggerUtils.debug(this.getClass(), "start form parameters: {}" + formProperties);
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		if (user == null)
			return new BaseResp<>(-1, "用户没登陆", null);

		formProperties.put("applyUser", user.getFullName());
		formProperties.put("createDate", new Date().getTime()+"");
		//formProperties.put("createDate", DateHandler.date2Str(new Date()));
		mapObj.put("createDate", new Date().getTime());
		processInstanceService.saveProcessInstance(processDefinitionId, formProperties, user, fileIds,mapObj);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "流程草稿--表单填写保存草稿", notes = "表单填写保存草稿", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processDefinitionId", value = "流程实例ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "fileIds", value = "附件ID，多个用逗号拼接", required = false, dataType = "String"),
			@ApiImplicitParam(name = "object", value = "表单数据", required = true, dataType = "String") })
	@PostMapping(value = "/saveDraftBox")
	public Object saveDraftBox(String processDefinitionId, String fileIds, @RequestBody String object) {
		if (StringUtils.isNull(object))
			return new BaseResp<>(-1, "表单数据为空", null);
		
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		if (user == null)
			return new BaseResp<>(-1, "用户没登陆", null);
		HflowDraftBox box = new HflowDraftBox();
		box.setCreateUser(user.getFullName());
		box.setCreateUserId(user.getId());
		box.setFromObject(object);
		box.setProcessDefinitionId(processDefinitionId);
		box.setFileIds(fileIds);
		
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		box.setProcessInstanceName(processDefinition.getName());
		flowDraftBoxService.save(box);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "流程草稿--删除", notes = "删除草稿", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "草稿ID", required = true, dataType = "String")
	@GetMapping(value = "/deleteDraftBox")
	public Object deleteDraftBox(String id) {
		flowDraftBoxService.delete(id);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@SuppressWarnings("unchecked")
	@ApiOperation(value = "流程草稿--提交流程", notes = "流程草稿提交流程", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "草稿ID", required = true, dataType = "String")
	@GetMapping(value = "/submitDraftBox")
	public Object submitDraftBox(String id) {
		HflowDraftBox box = flowDraftBoxService.findById(id);
		if (StringUtils.isNull(box))
			return new BaseResp<>(-1, "参数有误", null);
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		if (StringUtils.isNull(user))
			return new BaseResp<>(-1, "用户没登陆", null);
		
		Map<String, Object> mapObj = (Map<String, Object>) JSONObject.parse(box.getFromObject());
		Map<String, String> formProperties = ListUtils.map2Map(mapObj);
		if (StringUtils.isNull(formProperties))
			return new BaseResp<>(-1, "数据有误", null);
		
		formProperties.put("applyUser", user.getFullName());
		//formProperties.put("createDate", DateHandler.date2Str(box.getCreateDate()));
		formProperties.put("createDate", new Date().getTime() + "");
		try {
			processInstanceService.saveProcessInstance(box.getProcessDefinitionId(), formProperties, user,
				box.getFileIds(),mapObj);
		}catch (Exception e) {
			return new BaseResp<>(-1, "数据有误", null);
		}
		flowDraftBoxService.delete(id);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	@ApiOperation(value = "流程草稿--查询详情", notes = "流程草稿查询详情", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "草稿ID", required = true, dataType = "String")
	@GetMapping(value = "/getDraftBox")
	public Object getDraftBox(String id) {
		HflowDraftBox box = flowDraftBoxService.findById(id);
		if (StringUtils.isNull(box))
			return new BaseResp<>(-1, "参数有误", null);
		return new BaseResp<>(box);
	}

}
