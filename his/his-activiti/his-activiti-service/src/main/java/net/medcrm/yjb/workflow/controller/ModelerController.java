package net.medcrm.yjb.workflow.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.his.mybatis.dynamicDataSource.page.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.fileutil.Base64Util;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.IActReModelService;
import net.medcrm.yjb.workflow.service.IActReProcdefService;
import net.medcrm.yjb.workflow.util.BaseResponse;
import net.medcrm.yjb.workflow.util.PageUtil;
import net.medcrm.yjb.workflow.vo.FileUtilVO;
import net.medcrm.yjb.workflow.vo.ModelVO;

/**
 * 模型管理
 */
@RestController
@RequestMapping("/models")
public class ModelerController implements ModelDataJsonConstants {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	RepositoryService repositoryService;

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Autowired
	private IActReProcdefService actReProcdefService;
	
	@Autowired
	private  IActReModelService actReModelService;

	/**
	 * 新建一个空模型
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@ApiOperation(value = "流程设计器--新建一个空模型", notes = "", httpMethod = "POST")
	@PostMapping("/newModel")
	public Object newModel() throws UnsupportedEncodingException {
		// 初始化一个空模型
		Model model = repositoryService.newModel();
		// 设置一些默认信息
		String name = "new-process";
		String description = "";
		int revision = 1;
		String key = "process";

		ObjectNode modelNode = objectMapper.createObjectNode();
		modelNode.put(ModelDataJsonConstants.MODEL_NAME, name);
		modelNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
		modelNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);

		model.setName(name);
		model.setKey(key);
		model.setMetaInfo(modelNode.toString());

		repositoryService.saveModel(model);
		String id = model.getId();

		// 完善ModelEditorSource
		ObjectNode editorNode = objectMapper.createObjectNode();
		editorNode.put("id", "canvas");
		editorNode.put("resourceId", "canvas");
		ObjectNode stencilSetNode = objectMapper.createObjectNode();
		stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
		editorNode.put("stencilset", stencilSetNode);
		repositoryService.addModelEditorSource(id, editorNode.toString().getBytes("utf-8"));
		return new BaseResp<>(id);
	}

	/**
	 * 创建模型
	 */
	@ApiOperation(value = "自定义创建流程", notes = "自定义创建流程", httpMethod = "POST")
	@ApiImplicitParam(name = "modelVO", value = "标题名称", required = true, dataType = "ModelVO")
	@PostMapping(value = "/create")
	public Object create(@RequestBody ModelVO modelVO) {
		int revision = 1;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ObjectNode editorNode = objectMapper.createObjectNode();
			editorNode.put("id", "canvas");
			editorNode.put("resourceId", "canvas");
			ObjectNode stencilSetNode = objectMapper.createObjectNode();
			stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
			editorNode.put("stencilset", stencilSetNode);
			Model modelData = repositoryService.newModel();

			ObjectNode modelObjectNode = objectMapper.createObjectNode();
			modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, modelVO.getName());
			modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, revision);
			String description = StringUtils.defaultString(modelVO.getDescription());
			modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
			modelData.setMetaInfo(modelObjectNode.toString());
			modelData.setName(modelVO.getName());
			modelData.setKey(StringUtils.defaultString(modelVO.getKey()));
			modelData.setCategory(modelVO.getTypeId());
			
			repositoryService.saveModel(modelData);
			repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
			
			return new BaseResp<>(modelData.getId());
		} catch (Exception e) {
			logger.error("创建模型失败：", e);
		}
		return new BaseResp<>(ResultStatus.FAIL);
	}

	@ApiOperation(value = "自定义创建流程--保存流程发布流程", notes = "保存流程发布流程", httpMethod = "PUT")
	@ApiImplicitParams({ @ApiImplicitParam(name = "modelId", value = "自定义流程模板Id", required = true, dataType = "String"),
			@ApiImplicitParam(name = "name", value = "name标题名称", required = true, dataType = "String"),
			@ApiImplicitParam(name = "description", value = "description说明", required = false, dataType = "String"),
			@ApiImplicitParam(name = "json_xml", value = "流程文件json_xml", required = false, dataType = "String"),
			@ApiImplicitParam(name = "svg_xml", value = "流程文件svg_xml", required = false, dataType = "String") })
	@PutMapping(value = "/model/save")
	public void saveModel(String modelId, String name, String description, String json_xml,
			String svg_xml) {
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		try {
			Model model = repositoryService.getModel(modelId);
			ObjectNode modelJson = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
			modelJson.put(MODEL_NAME, name);
			modelJson.put(MODEL_DESCRIPTION, description);
			model.setMetaInfo(modelJson.toString());
			model.setName(name);
			actReModelService.saveModelDeployment(model, json_xml, svg_xml,user,description);
		} catch (Exception e) {
			logger.error("Error saving model", e);
			throw new ActivitiException("Error saving model", e);
		}
	}

	/**
	 * 发布模型为流程定义
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "流程设计器--发布模型为流程定义", notes = "发布模型为流程定义", httpMethod = "GET")
	@ApiImplicitParam(name = "modelId", value = "流和模板ID", required = true, dataType = "String")
	@GetMapping("/deployment")
	public Object deploy(String modelId) throws Exception {

		// 获取模型
		Model modelData = repositoryService.getModel(modelId);
		byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());

		if (bytes == null) {
			return new BaseResp<>(ResultStatus.FAIL);
		}

		JsonNode modelNode = new ObjectMapper().readTree(bytes);

		BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
		if (model.getProcesses().size() == 0) {
			// 数据模型不符要求，请至少设计一条主线流程
			return new BaseResp<>(ResultStatus.FAIL);
		}
		byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);

		// 发布流程
		String processName = modelData.getName() + ".bpmn20.xml";
		Deployment deployment = repositoryService.createDeployment().name(modelData.getName())
				.addString(processName, new String(bpmnBytes, "UTF-8")).deploy();
		modelData.setDeploymentId(deployment.getId());
		repositoryService.saveModel(modelData);

		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "流程设计器--查询模型信息", notes = "modelId", httpMethod = "GET")
	@GetMapping("/getModel")
	public Object getOne(String id) {
		Model model = repositoryService.createModelQuery().modelId(id).singleResult();
		return BaseResponse.buildResult().setObjData(model);
	}

	/**
	 * 获取所有模型
	 */

	@ApiOperation(value = "流程设计器--获取所有模型", notes = "page当前页|rowSize页码", httpMethod = "GET")
	@GetMapping("/getList")
	public Object getList() {
		List<Model> list = repositoryService.createModelQuery().list();
		return new BaseResp<List<Model>>(list);
	}

	/**
	 * 删除模型
	 */
	@ApiOperation(value = "流程设计器--删除模型", notes = "id流程", httpMethod = "GET")
	@GetMapping("/deleteOne")
	public Object deleteOne(String id) {
		repositoryService.deleteModel(id);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "导出流程model对象为指定类型", notes = "导出model对象为指定类型", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "modelId", value = "modelId流程model对象ID", required = true, dataType = "String"),
			@ApiImplicitParam(name = "type", value = "导出文件类型(bpmn\\json)", required = true, dataType = "String") })
	@GetMapping(value = "export/{modelId}/{type}")
	public void export(@PathVariable("modelId") String modelId, @PathVariable("type") String type,
			HttpServletResponse response) {
		try {
			Model modelData = repositoryService.getModel(modelId);
			BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
			byte[] modelEditorSource = repositoryService.getModelEditorSource(modelData.getId());

			JsonNode editorNode = new ObjectMapper().readTree(modelEditorSource);
			BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);

			// 处理异常
			if (bpmnModel.getMainProcess() == null) {
				response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
				response.getOutputStream().println("no main process, can't export for type: " + type);
				response.flushBuffer();
				return;
			}

			String filename = "";
			byte[] exportBytes = null;
			String mainProcessId = bpmnModel.getMainProcess().getId();
			if (type.equals("bpmn")) {
				BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
				exportBytes = xmlConverter.convertToXML(bpmnModel);
				filename = mainProcessId + ".bpmn20.xml";
			} else if (type.equals("json")) {
				exportBytes = modelEditorSource;
				filename = mainProcessId + ".json";
			}

			ByteArrayInputStream in = new ByteArrayInputStream(exportBytes);
			IOUtils.copy(in, response.getOutputStream());
			response.setHeader("Content-Disposition", "attachment; filename=" + filename);
			response.flushBuffer();
		} catch (Exception e) {
			logger.error("导出model的xml文件失败：modelId={}, type={}", modelId, type, e);
		}
	}

	@ApiOperation(value = "流程上传", notes = "文件加密成base64位", httpMethod = "POST")
	@ApiImplicitParam(name = "fileUtil", value = "文件上传类", required = true, dataType = "FileUtilVO")
	@PostMapping(value = "/uploadPoster")
	public Object uploadPoster(@RequestBody FileUtilVO fileUtil) {
		// 当前登陆用户
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		String path = Base64Util.generateFile(fileUtil.getBase64Str(), user.getAccountId());
		LoggerUtils.debug(this.getClass(), "文件路径-------------------:" + path);
		if (path != null && !"".equals(path)) {
			try {
				actReProcdefService.updateDeployZIP(path, fileUtil.getFileName(), user.getFullName(),fileUtil.getModelId());
			} catch (Exception e) {
				e.printStackTrace();
				LoggerUtils.debug(this.getClass(), "文件上传出错-------------------:" + e.getMessage());
				return new BaseResp<String>(ResultStatus.error_file_upload);
			}
			return new BaseResp<>(ResultStatus.SUCCESS);
		}
		return new BaseResp<String>(ResultStatus.error_file_upload);
	}

	
	/**
	 * 流程定义列表
	 *
	 * @return
	 */
	@ApiOperation(value = "流程定义列表", notes = "流程定义列表", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer") })
	@GetMapping(value = "/process-list")
	public Object processList(@RequestParam(value = "pageSize", defaultValue = "1000", required = false) int pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) int pageNum) {

		/*
		 * 保存两个对象，一个是ProcessDefinition（流程定义），一个是Deployment（流程部署）
		 */
		List<Object[]> objects = new ArrayList<Object[]>();
		PageInfo<Object[]> page = new PageInfo<>();
		int[] pageParams = PageUtil.init(page, pageNum, pageSize);
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery()
				.orderByDeploymentId().desc();
		List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(pageParams[0], pageParams[1]);
		for (ProcessDefinition processDefinition : processDefinitionList) {
			String deploymentId = processDefinition.getDeploymentId();
			Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
			objects.add(new Object[] { processDefinition, deployment });
		}
		page.setTotal(processDefinitionQuery.count());
		page.setList(objects);
		return new BaseResp<PageInfo<Object[]>>(page);
	}

	@ApiOperation(value = "查看流程图片、xml文件源码", notes = "读取资源，通过部署ID", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processDefinitionId", value = "流程定义id", required = false, dataType = "String"),
			@ApiImplicitParam(name = "resourceType", value = "资源类型xml、image", required = false, dataType = "String") })
	@GetMapping(value = "/resource/read")
	public void loadByDeployment( String processDefinitionId,
			String resourceType, HttpServletResponse response) throws Exception {

		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		String resourceName = "";
		if (resourceType.equals("image")) {
			resourceName = processDefinition.getDiagramResourceName();
		} else if (resourceType.equals("xml")) {
			resourceName = processDefinition.getResourceName();
		}
		InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
				resourceName);
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}
	
	@ApiOperation(value = "查看流程图片、xml文件源码", notes = "读取资源，通过部署ID", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "processDefinitionId", value = "流程定义id", required = false, dataType = "String"),
			@ApiImplicitParam(name = "resourceType", value = "资源类型xml、image", required = false, dataType = "String") })
	@GetMapping(value = "/resource/read/getFileBase64")
	public Object getFileBase64( String processDefinitionId,String resourceType) {

		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		String resourceName = "";
		if (resourceType.equals("image")) {
			resourceName = processDefinition.getDiagramResourceName();
		} else if (resourceType.equals("xml")) {
			resourceName = processDefinition.getResourceName();
		}
		InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
				resourceName);
		return new BaseResp<>(Base64Util.ioToBase64(resourceAsStream));
	}

}
