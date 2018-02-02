package net.medcrm.yjb.workflow.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.ProcessEngineImpl;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.ProcessDiagramGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.fileutil.Base64Util;
import net.medcrm.yjb.workflow.service.impl.WorkflowTraceService;
import net.medcrm.yjb.workflow.util.WorkflowUtils;

/**
 * 流程管理控制器
 *
 * @author HenryYan
 */
@RestController
@RequestMapping(value = "/actWorkflow")
public class WorkFlowController {
	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	ProcessEngineConfiguration processEngineConfiguration;

	@Autowired
	private WorkflowTraceService traceService;

	@Autowired
	protected HistoryService historyService;

	protected static Map<String, ProcessDefinition> PROCESS_DEFINITION_CACHE = new HashMap<String, ProcessDefinition>();

	/**
	 * 读取资源，通过流程ID
	 *
	 * @param resourceType
	 *            资源类型(xml|image)
	 * @param processInstanceId
	 *            流程实例ID
	 * @param response
	 * @throws Exception
	 */
	@ApiOperation(value = "流程运行中--查看流程图片", notes = "读取资源，通过部署ID", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processInstanceId", value = "流程定义id", required = true, dataType = "String"),
			@ApiImplicitParam(name = "resourceType", value = "资源类型xml、image", required = true, dataType = "String") })
	@GetMapping(value = "/resource/process/instance")
	public void loadByProcessInstance(String processInstanceId, String resourceType, HttpServletResponse response)
			throws Exception {
		InputStream resourceAsStream = null;
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processInstance.getProcessDefinitionId()).singleResult();

		String resourceName = "";
		if (resourceType.equals("image")) {
			resourceName = processDefinition.getDiagramResourceName();
		} else if (resourceType.equals("xml")) {
			resourceName = processDefinition.getResourceName();
		}
		resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	@ApiOperation(value = "查看流程图片、xml文件源码", notes = "读取资源，通过部署ID", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processInstanceId", value = "流程定义id", required = false, dataType = "String"),
			@ApiImplicitParam(name = "resourceType", value = "资源类型xml、image", required = false, dataType = "String") })
	@GetMapping(value = "/resource/read/getFileBase64")
	public Object getFileBase64(String processInstanceId, String resourceType) {

		InputStream resourceAsStream = null;
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processInstance.getProcessDefinitionId()).singleResult();

		String resourceName = "";
		if (resourceType.equals("image")) {
			resourceName = processDefinition.getDiagramResourceName();
		} else if (resourceType.equals("xml")) {
			resourceName = processDefinition.getResourceName();
		}
		resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
		return new BaseResp<>(Base64Util.ioToBase64(resourceAsStream));
	}

	/**
	 * 输出跟踪流程信息
	 *
	 * @param processInstanceId
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "流程运行中--输出跟踪流程信息", notes = "输出跟踪流程信息", httpMethod = "GET")
	@ApiImplicitParam(name = "processInstanceId", value = "流程定义id", required = true, dataType = "String")
	@GetMapping(value = "/process/trace")
	public Object traceProcess(String processInstanceId) throws Exception {
		List<Map<String, Object>> activityInfos = traceService.traceProcess(processInstanceId);
		return new BaseResp<>(activityInfos);
	}

	/**
	 * 读取带跟踪的图片
	 */
	@ApiOperation(value = "流程运行中--读取带跟踪的图片", notes = "读取带跟踪的图片", httpMethod = "GET")
	@ApiImplicitParam(name = "executionId", value = "流程执行ID", required = true, dataType = "String")
	@GetMapping(value = "/process/trace/auto")
	public void readResource(String executionId, HttpServletResponse response) throws Exception {
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(executionId)
				.singleResult();
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
		List<String> activeActivityIds = runtimeService.getActiveActivityIds(executionId);
		// 不使用spring请使用下面的两行代码
		ProcessEngineImpl defaultProcessEngine = (ProcessEngineImpl) ProcessEngines.getDefaultProcessEngine();
		Context.setProcessEngineConfiguration(defaultProcessEngine.getProcessEngineConfiguration());

		// 使用spring注入引擎请使用下面的这行代码
		// processEngineConfiguration = processEngine.getProcessEngineConfiguration();
		// Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl)
		// processEngineConfiguration);

		ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIds,
				new ArrayList<String>(), "宋体", "宋体", "宋体", null, 1.0d);
		// 输出资源内容到相应对象
		byte[] b = new byte[1024];
		int len;
		while ((len = imageStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
		// test(imageStream, response);
	}

	

	@ApiOperation(value = "流程运行中--读取带跟踪的图片", notes = "读取带跟踪的图片返回base64", httpMethod = "GET")
	@ApiImplicitParam(name = "executionId", value = "流程执行ID", required = false, dataType = "String")
	@GetMapping(value = "/process/trace/auto/getFileBase64")
	public Object getFileTraceBase64(String executionId) {
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(executionId)
				.singleResult();
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
		List<String> activeActivityIds = runtimeService.getActiveActivityIds(executionId);
		
		ProcessEngineImpl defaultProcessEngine = (ProcessEngineImpl) ProcessEngines.getDefaultProcessEngine();
		Context.setProcessEngineConfiguration(defaultProcessEngine.getProcessEngineConfiguration());

		ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIds,
				new ArrayList<String>(), "宋体", "宋体", "宋体", null, 1.0d);

		return new BaseResp<>(Base64Util.ioToBase64(imageStream));
	}

	/**
	 * 导出图片文件到硬盘
	 *
	 * @return
	 */
	@GetMapping(value = "export/diagrams")
	@ApiImplicitParam(name = "exportDir", value = "目录", required = true, dataType = "String")
	public Object exportDiagrams(String exportDir) throws IOException {
		List<String> files = new ArrayList<String>();
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();

		for (ProcessDefinition processDefinition : list) {
			files.add(WorkflowUtils.exportDiagramToFile(repositoryService, processDefinition, exportDir));
		}
		return new BaseResp<>(files);
	}

}
