package net.medcrm.yjb.workflow.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.domain.Consultation;
import net.medcrm.yjb.workflow.domain.HflowFormFile;
import net.medcrm.yjb.workflow.domain.HflowSignature;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.IConsultationService;
import net.medcrm.yjb.workflow.service.IHflowFormFileService;
import net.medcrm.yjb.workflow.service.IHflowHandleService;
import net.medcrm.yjb.workflow.service.IHflowLdapService;
import net.medcrm.yjb.workflow.service.IHflowSignatureService;
import net.medcrm.yjb.workflow.util.StringUtils;

/**
 * 会诊
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/consultation")
public class ConsultationController {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IConsultationService consultationService;

	@Resource(name = "identityService")
	private org.activiti.engine.IdentityService identityService;

	@Resource(name = "runtimeService")
	private RuntimeService runtimeService;

	@Resource(name = "historyService")
	private HistoryService historyService;

	@Resource(name = "taskService")
	private TaskService taskService;

	@Resource(name = "managementService")
	private ManagementService managementService;

	@Resource // (name="formService")
	private FormService formService;

	@Resource(name = "repositoryService")
	private RepositoryService repositoryService;

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Autowired
	private IHflowFormFileService hflowFormFileService;

	@Autowired
	private IHflowLdapService hflowLdapService;

	@Autowired
	private IHflowSignatureService flowSignatureService;
	
	@Autowired
	private IHflowHandleService flowHandleService;
	

	@ApiOperation(value = "当前用户会诊流程任务列表", notes = "根据每页数pageSize,当前页码pageNum查询当前用户会诊流程任务列表", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer") })
	@PostMapping("/list")
	public Object getList(@RequestParam(value = "rowSize", defaultValue = "1000", required = false) Integer rowSize,
			@RequestParam(value = "page", defaultValue = "1", required = false) Integer page) {
		List<Consultation> list = consultationService.findAllConsultation(page, rowSize);
		return new BaseResp<List<Consultation>>(list);
	}

	/**
	 * 新增申请信息流程开始
	 * 
	 * @param consultation
	 * @return
	 */
	@ApiOperation(value = "新增会诊申请信息流程开始", notes = "根据consultation对象创建会诊,会诊详细实体consultation", httpMethod = "POST")
	@ApiImplicitParam(name = "consultation", value = "会诊详细实体consultation", required = true, dataType = "consultation")
	@PostMapping("/save")
	public Object save(@RequestBody Consultation consultation) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		try {
			consultation.setApplyUser(user.getFullName());
			consultation.setApplyUserId(user.getId());
			consultation.setApplyDepartmentId(user.getMajor());
			consultation.setApplyDepartment(user.getMajorName());
			Map<String, Object> variables = new HashMap<String, Object>();
			ProcessInstance processInstance = consultationService.startWorkflow(consultation, variables);
			System.out.println("流程已启动，流程ID：" + processInstance.getId());
		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				return new BaseResp<>(ResultStatus.error_start_workflow);
			} else {
				logger.error("启动请假流程失败：", e);
				return new BaseResp<>(ResultStatus.FAIL);
			}
		} catch (Exception e) {
			logger.error("启动请假流程失败：", e);
			return new BaseResp<>(ResultStatus.FAIL);
		}
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "新增会诊申请信息加入草稿", notes = "根据consultation对象创建会诊", httpMethod = "POST")
	@ApiImplicitParam(name = "consultation", value = "会诊详细实体consultation", required = true, dataType = "consultation")
	@PostMapping("/saveDrafts")
	public Object saveDrafts(Consultation consultation, @RequestParam(value = "fileBase64") String fileBase64,
			@RequestParam(value = "content") String content, @RequestParam(value = "fileName") String fileName) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();

		consultation.setApplyUser(user.getFullName());
		consultation.setApplyUserId(user.getAccountId());
		consultationService.addConsultation(consultation, fileBase64, content, fileName);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	/**
	 * 根据流程定义的key查询运行中的流程实例
	 * 
	 * @param processDefinitionKey
	 *            //流程定义key
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "根据流程定义的key查询运行中的流程实例", notes = "运行中的流程实例", httpMethod = "GET")
	@ApiImplicitParam(name = "processDefinitionKey", value = "流程定义的key", required = true, dataType = "String")
	@GetMapping(value = "/process/running/list")
	public Object findRunningProcessInstaces( String processDefinitionKey) {

		List<Consultation> runningProcessInstaces = consultationService
				.findRunningProcessInstaces(processDefinitionKey);

		return new BaseResp<List<Consultation>>(runningProcessInstaces);
	}

	/**
	 * 查询已结束的流程实例
	 * 
	 * @param processDefinitionKey
	 * @return
	 */
	@ApiOperation(value = "查询已结束的流程实例", notes = "查询已结束的流程实例", httpMethod = "GET")
	@ApiImplicitParam(name = "processDefinitionKey", value = "流程定义的key", required = true, dataType = "String")
	@GetMapping(value = "/process/finished/list")
	public Object findFinishedProcessInstaces( String processDefinitionKey) {

		List<Consultation> finishedProcessInstaces = consultationService
				.findFinishedProcessInstaces(processDefinitionKey);
		return new BaseResp<List<Consultation>>(finishedProcessInstaces);
	}

	/**
	 * 根据任务Id完成任务 驳回
	 * 
	 * @param userid
	 * @return
	 */
	@ApiOperation(value = "审批人办理完成任务", notes = "审批人办理完成任务", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "taskId", value = "流程运行ID", required = true, dataType = "String"),
		@ApiImplicitParam(name = "opinion", value = "扩展审批意见", required = false, dataType = "String"),
		@ApiImplicitParam(name = "nextHandleUser", value = "下个节点办理人", required = false, dataType = "String")		
	})
	@PostMapping(value = "/task/complete")
	public Object completeTask(String taskId,
			@RequestParam(value = "opinion", defaultValue = "", required = false) String opinion,
			@RequestParam(value = "nextHandleUser", defaultValue = "", required = false) String nextHandleUser,
			@RequestBody String variables) {
		if(StringUtils.isNull(taskId))
			return new BaseResp<>(-1,"参数有误",null);
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();

		Map<String, Object> formProperties = JSON.parseObject(variables);
		LoggerUtils.debug(this.getClass(), "start form parameters: {}" + formProperties);
		
		flowHandleService.updateClaim(taskId, nextHandleUser, opinion, formProperties, user);

		return new BaseResp<String>(ResultStatus.SUCCESS);

	}
	
	//@ApiImplicitParam(name = "variable", value = "自定义json,opinion:扩展审批意见", required = true, dataType = "String")

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "得到会诊详细信息", notes = "根据会诊id查找", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "会诊id", required = true, dataType = "String")
	@GetMapping(value = "/detail/consultation")
	public Object getLeaveById(String id) {
		Consultation consultation = consultationService.findById(id);
		return new BaseResp<Consultation>(consultation);
	}

	

	/* 2017-01-22增加在springmvc中如果表单属性的类型是日期型时，从页面绑定字符串数据会出错 */
	// SimpleDateFormat日期格式与页面日期格式要一致！ 对应的controller中增加属性编辑器
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/**
	 * 获取实体
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "会诊流程--查看会诊详细信息", notes = "根据流程id查找", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "流程id", required = true, dataType = "String")
	@GetMapping(value = "/detail/getConsultation")
	public Object getConsultationById(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if (StringUtils.isNull(task))
			return new BaseResp<>(ResultStatus.SUCCESS);

		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		if (StringUtils.isNull(processInstance))
			return new BaseResp<>(ResultStatus.SUCCESS);

		String businessKey = processInstance.getBusinessKey();
		Consultation consultation = consultationService.findById(businessKey);
		if (StringUtils.isNull(consultation))
			return new BaseResp<>(ResultStatus.SUCCESS);
		Map<String, Object> map = new HashMap<>();
		map.put("form", consultation);
		
		List<HflowFormFile> list = hflowFormFileService.findListByProcessInstanceId(task.getProcessInstanceId());
		String path1 = "http://" + hflowFormFileService.getFastDbPath();
		List<HflowFormFile> fileList = new ArrayList<>();
		for (HflowFormFile hflowFormFile : list) {
			hflowFormFile.setUrl(path1 + hflowFormFile.getUrl());
			fileList.add(hflowFormFile);
		}
		map.put("fileList", fileList);
		return new BaseResp<>(map);
	}

	@ApiOperation(value = "会诊流程--选择本部人领导", notes = "根据申请人选本部门领导", httpMethod = "GET")
	@GetMapping(value = "/getDeptLeader")
	public Object getDeptLeader(String taskId) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		List<String> list = hflowLdapService.findThisDeptLeaders(user.getId());
		return new BaseResp<>(list);
	}

	@ApiOperation(value = "会诊流程--查询流程处理情况", notes = "查询流程处理情况", httpMethod = "GET")
	@ApiImplicitParam(name = "taskId", value = "流程id", required = true, dataType = "String")
	@GetMapping(value = "/getHflowSignature")
	public Object getHflowSignature(String taskId) {
		List<HflowSignature> list = flowSignatureService.findListInfo(taskId);
		return new BaseResp<>(list);
	}

}
