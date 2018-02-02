package net.medcrm.yjb.workflow.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.form.TaskFormDataImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.his.mybatis.dynamicDataSource.page.PageInfo;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.dateutil.DateHandler;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.his.myenum.StatusType;
import net.medcrm.yjb.workflow.domain.Consultation;
import net.medcrm.yjb.workflow.domain.HflowCustomRealTemplate;
import net.medcrm.yjb.workflow.domain.HflowCustomTable;
import net.medcrm.yjb.workflow.domain.HflowModel;
import net.medcrm.yjb.workflow.domain.HflowProcdef;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.mapper.ActReProcdefMapper;
import net.medcrm.yjb.workflow.mapper.ConsultationMapper;
import net.medcrm.yjb.workflow.mapper.HflowCustomRealTemplateMapper;
import net.medcrm.yjb.workflow.mapper.HflowCustomTableMapper;
import net.medcrm.yjb.workflow.mapper.HflowModelMapper;
import net.medcrm.yjb.workflow.mapper.HflowProcdefMapper;
import net.medcrm.yjb.workflow.service.HflowCustomRealTemplateService;
import net.medcrm.yjb.workflow.service.IActReProcdefService;
import net.medcrm.yjb.workflow.service.IHflowModelProcdefService;
import net.medcrm.yjb.workflow.service.IHflowProcdefLogsService;
import net.medcrm.yjb.workflow.service.IHflowProcdefService;
import net.medcrm.yjb.workflow.util.ActivitiUtils;
import net.medcrm.yjb.workflow.util.ProcdefType;
import net.medcrm.yjb.workflow.util.StringUtils;
import net.medcrm.yjb.workflow.vo.ActReProcdefVO;
import net.medcrm.yjb.workflow.vo.FinishedFlowVO;
import net.medcrm.yjb.workflow.vo.HandleInfoVO;
import net.medcrm.yjb.workflow.vo.MonitorVO;
import net.medcrm.yjb.workflow.vo.QuereyParameterVO;

@Service
public class ActReProcdefServiceImpl implements IActReProcdefService {
	private static Logger logger = LoggerFactory.getLogger(ActReProcdefServiceImpl.class);
	@Autowired
	private ActReProcdefMapper actReProcdefMapper;

	@Autowired
	private HflowProcdefMapper procdefMapper;

	@Autowired
	private HflowCustomRealTemplateMapper hflowCustomRealTemplateMapper;

	@Autowired
	RepositoryService repositoryService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private IHflowProcdefService procdefService;

	@Autowired
	private IHflowProcdefLogsService procdefLogsService;

	@Autowired
	private IHflowModelProcdefService modelProcdefService;

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Autowired
	private HflowModelMapper modelMapper;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private FormService formService;

	@Autowired
	private ProcessEngine processEngine;

	@Autowired
	private ConsultationMapper consultationMapper;

	@Autowired
	private TaskService taskService;

	@Override
	public List<ActReProcdefVO> findActReProcdefList(String modelId, int pageNum, int pageSize) {
		List<String> keyList = procdefMapper.selectAllKeyByParam(modelId, ProcdefType.PRCDE.getIndex() + "", null);
		PageHelper.startPage(pageNum, pageSize);
		return actReProcdefMapper.findByKeysMap(keyList);
	}

	@Override
	@Transactional
	public void updateDeployZIP(String filePath, String newFileName, String user, String modelId) throws Exception {
		File f = new File(filePath);
		InputStream inputStream = new FileInputStream(f);

		// 部署流程定义文件
		Deployment deployment = null;
		String extension = FilenameUtils.getExtension(filePath);
		if (extension.equals("zip") || extension.equals("bar")) {
			ZipInputStream zipInputStream = new ZipInputStream(inputStream);
			deployment = repositoryService.createDeployment().addZipInputStream(zipInputStream).name(newFileName)
					.deploy();
		} else {
			deployment = repositoryService.createDeployment().addInputStream(filePath, inputStream).deploy();
		}
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId())
				.latestVersion().list();
		if (net.medcrm.yjb.workflow.util.StringUtils.isNull(list)) {
			return;
		}
		ProcessDefinition processDefinition = list.get(0);
		procdefLogsService.save(processDefinition.getId(), user);

		HflowProcdef procdef = ActivitiUtils.toConverterHflowProcdef(processDefinition);
		procdef.setType(ProcdefType.PRCDE.getIndex());
		procdef.setCreateUser(user);
		procdef.setModelId(modelId);
		procdefService.save(procdef);
		updateConvertToModel(processDefinition, user, modelId);
	}

	@Transactional
	public String updateConvertToModel(ProcessDefinition processDefinition, String user, String modelId)
			throws Exception {
		InputStream bpmnStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
				processDefinition.getResourceName());
		XMLInputFactory xif = XMLInputFactory.newInstance();
		InputStreamReader in = new InputStreamReader(bpmnStream, "UTF-8");
		XMLStreamReader xtr = xif.createXMLStreamReader(in);
		BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);

		BpmnJsonConverter converter = new BpmnJsonConverter();
		com.fasterxml.jackson.databind.node.ObjectNode modelNode = converter.convertToJson(bpmnModel);
		Model modelData = repositoryService.newModel();
		modelData.setKey(processDefinition.getKey());
		modelData.setName(processDefinition.getName());
		// 分类
		modelData.setCategory(modelId);
		modelData.setVersion(processDefinition.getVersion());
		modelData.setDeploymentId(processDefinition.getDeploymentId());

		ObjectNode modelObjectNode = new ObjectMapper().createObjectNode();
		modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, processDefinition.getName());
		modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, processDefinition.getVersion());
		modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, processDefinition.getDescription());
		modelData.setMetaInfo(modelObjectNode.toString());

		repositoryService.saveModel(modelData);
		repositoryService.addModelEditorSource(modelData.getId(), modelNode.toString().getBytes("utf-8"));
		procdefService.saveByActModel(modelData, user, processDefinition.getDescription());
		return modelData.getId();
	}

	@Override
	public Integer findTasByProc(String proId) {
		return actReProcdefMapper.findTasByProc(proId);
	}

	/**
	 * 流程布署
	 * 
	 * @param actModelId
	 * @return
	 */
	@Transactional
	public String saveDeploy(Model modelData, String user, String dec) {
		try {
			ObjectNode modelNode = (ObjectNode) new ObjectMapper()
					.readTree(repositoryService.getModelEditorSource(modelData.getId()));
			byte[] bpmnBytes = null;
			BpmnModel modelm = new BpmnJsonConverter().convertToBpmnModel(modelNode);
			bpmnBytes = new BpmnXMLConverter().convertToXML(modelm);

			String processName = modelData.getName() + ".bpmn20.xml";
			Deployment deployment = repositoryService.createDeployment().name(modelData.getName())
					.addString(processName, new String(bpmnBytes)).deploy();

			ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
					.deploymentId(deployment.getId()).latestVersion().singleResult();

			procdefLogsService.save(processDefinition.getId(), user);
			HflowProcdef procdef = procdefService.saveHflowProcdef(modelData, processDefinition, dec);
			if (StringUtils.isNotNull(procdef)) {
				modelProcdefService.saveModelProcdef(modelData.getCategory(), procdef.getId());
			}

			return deployment.getId();
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		return null;
	}

	@Override
	public void updateState(String actProcodefId, String state) {
		if (state.equals("active")) {
			logger.debug("message", "已启用ID为[" + actProcodefId + "]的流程定义。");
			repositoryService.activateProcessDefinitionById(actProcodefId, true, null);
			procdefService.updateDisableByPro(actProcodefId, StatusType.TES.getIndex());
		} else if (state.equals("suspend")) {
			repositoryService.suspendProcessDefinitionById(actProcodefId, true, null);
			procdefService.updateDisableByPro(actProcodefId, StatusType.NO.getIndex());
			logger.debug("message", "已停用ID为[" + actProcodefId + "]的流程定义。");

		}
	}

	/**
	 * 查询待办
	 * 
	 * @param type
	 * @param menuId
	 * @param userId
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<HandleInfoVO> getHandleHFlow(String applyUser, String start, String end, String queryValue,
			String modelId, String userId, int pageNum, int pageSize) {

		BaseResp<List<String>> elist = employeeServiceClient.getPositionsDeptByUserId(userId);
		List<String> bGroupList = (List<String>) elist.getData();

		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("groupList", bGroupList);
		filter.put("userId", userId);
		filter.put("queryValue", queryValue);
		filter.put("type", "candidate");
		filter.put("start", start);
		filter.put("end", end);
		List<String> listKey = getProcessDefinitionKey(modelId);
		if (StringUtils.isNull(listKey)) {
			filter.put("keyList", null);
		} else {
			filter.put("keyList", listKey);
		}
		PageHelper.startPage(pageNum, pageSize);
		List<HandleInfoVO> list = actReProcdefMapper.findHandleFlowsList(filter);
		PageInfo<HandleInfoVO> pageInfo = new PageInfo<HandleInfoVO>(list);

		List<HandleInfoVO> taslList = new ArrayList<>();
		for (HandleInfoVO handleInfoVO : list) {
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(handleInfoVO.getProcessInstanceId()).active().singleResult();
			if (processInstance == null) {
				continue;
			}
			handleInfoVO.setToDate(DateHandler.getDaysBetween2(handleInfoVO.getCreateTime(), new Date()));
			getStartEvent(handleInfoVO);
			String businessKey = processInstance.getBusinessKey();
			if (StringUtils.isNotNull(businessKey)) {
				Consultation object = consultationMapper.selectByPrimaryKey(businessKey);
				handleInfoVO.setForm(object);
			} else {
				Map<String, Object> variables = processEngine.getTaskService().getVariables(handleInfoVO.getTaskId());
				handleInfoVO.setForm(variables);
			}
			taslList.add(handleInfoVO);
		}
		pageInfo.setList(taslList);
		return pageInfo;
	}

	/**
	 * 经办
	 * 
	 * @param type
	 * @param modelId
	 * @param userId
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<HandleInfoVO> getHistoryFlow(String modelId, String userId, int pageNum, int pageSize) {
		BaseResp<List<String>> elist = employeeServiceClient.getPositionsDeptByUserId(userId);
		List<String> bGroupList = (List<String>) elist.getData();
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("groupList", bGroupList);
		filter.put("userId", userId);
		filter.put("type", "candidate");
		List<String> listKey = getProcessDefinitionKey(modelId);
		if (StringUtils.isNull(listKey)) {
			filter.put("keyList", null);
		} else {
			filter.put("keyList", listKey);
		}
		PageHelper.startPage(pageNum, pageSize);
		List<HandleInfoVO> list = actReProcdefMapper.findHistoricFlowsList(filter);
		PageInfo<HandleInfoVO> pageInfo = new PageInfo<HandleInfoVO>(list);

		List<HandleInfoVO> taslList = new ArrayList<>();
		for (HandleInfoVO handleInfoVO : list) {
			Map<String, Object> map = getHistoryVariable(handleInfoVO.getProcessInstanceId());
			handleInfoVO.setForm(map);
			taslList.add(handleInfoVO);
		}
		pageInfo.setList(taslList);
		return pageInfo;
	}

	/**
	 * 得到业务key
	 */
	public Object getBusiness(String processInstanceId, String taskId) {
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).active().singleResult();
		String businessKey = processInstance.getBusinessKey();
		if (businessKey != null) {
			Map<String, Object> object = procdefMapper.selectObject(processInstance.getProcessDefinitionKey(),
					businessKey);
			return object;
		} else {
			TaskFormDataImpl taskFormData = (TaskFormDataImpl) formService.getTaskFormData(taskId);
			taskFormData.setTask(null);
			Map<String, Object> map = new HashMap<>();
			List<FormProperty> listFp = taskFormData.getFormProperties();
			for (FormProperty formProperty : listFp) {
				map.put(formProperty.getId(), formProperty.getValue());
			}
			return map;
		}
	}

	/**
	 * 完成流程
	 * 
	 * @param handler
	 *            办理人
	 * @param queryValue
	 *            包含申请人
	 * @return
	 */
	public PageInfo<FinishedFlowVO> finished(String applyUser, String start, String end, String queryValue,
			String modelId, String handler, int pageNum, int pageSize) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("applyUser", applyUser);
		filter.put("queryValue", queryValue);
		filter.put("start", start);
		filter.put("end", end);
		List<String> listKey = getProcessDefinitionKey(modelId);
		if (StringUtils.isNull(listKey)) {
			filter.put("keyList", null);
		} else {
			filter.put("keyList", listKey);
		}

		// 办理人
		List<String> proInstList = actReProcdefMapper.selectHandlerInfo(handler);
		if (StringUtils.isNull(proInstList)) {
			filter.put("proInstList", null);
		} else {
			filter.put("proInstList", proInstList);
		}
		LoggerUtils.debug(this.getClass(), "filter-----------------------" + filter);
		PageHelper.startPage(pageNum, pageSize);
		List<FinishedFlowVO> list = actReProcdefMapper.selectEndFlowsList(filter);
		PageInfo<FinishedFlowVO> pageInfo = new PageInfo<FinishedFlowVO>(list);

		List<FinishedFlowVO> rest = Lists.newArrayList();
		for (FinishedFlowVO finishedFlowVO : list) {
			finishedFlowVO.setForm(getHistoryVariable(finishedFlowVO.getProcessInstanceId()));
			finishedFlowVO.setToDate(
					DateHandler.getDaysBetween2(finishedFlowVO.getStartDate(), finishedFlowVO.getStartDate()));
			rest.add(finishedFlowVO);
		}
		pageInfo.setList(rest);
		return pageInfo;
	}

	/**
	 * 经手流程
	 * 
	 * @param applyUser
	 * @param start
	 * @param end
	 * @param queryValue
	 * @param modelId
	 * @param handler
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<HandleInfoVO> findRunningFlows(String applyUser, String start, String end, String queryValue,
			String modelId, List<String> handler, int pageNum, int pageSize) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("applyUser", applyUser);
		filter.put("queryValue", queryValue);
		List<String> listKey = getProcessDefinitionKey(modelId);
		filter.put("keyList", listKey);

		filter.put("handlerList", handler);
		filter.put("start", start);
		filter.put("end", end);
		LoggerUtils.debug(this.getClass(), "filter-----------------------" + filter);

		PageHelper.startPage(pageNum, pageSize);
		List<HandleInfoVO> list = actReProcdefMapper.selectRunningFlowsList(filter);
		PageInfo<HandleInfoVO> pageInfo = new PageInfo<HandleInfoVO>(list);

		List<HandleInfoVO> rest = Lists.newArrayList();
		for (HandleInfoVO handleInfoVO : list) {
			Task task = taskService.createTaskQuery().processInstanceId(handleInfoVO.getProcessInstanceId())
					.singleResult();
			if (StringUtils.isNotNull(task)) {
				handleInfoVO.setTaskId(task.getId());
				handleInfoVO.setTaskName(task.getName());
				handleInfoVO.setExecutionId(task.getExecutionId());
				handleInfoVO.setAssignee(task.getAssignee());
				handleInfoVO.setOwner(task.getOwner());
				Map<String, Object> variables = taskService.getVariables(handleInfoVO.getTaskId());
				handleInfoVO.setForm(variables);
				handleInfoVO.setTaskDefinitionKey(task.getTaskDefinitionKey());
				// Long start=DateHandler.str2Date(long1)
				handleInfoVO.setToDate(DateHandler.getDaysBetween2(handleInfoVO.getCreateTime(), new Date()));
				rest.add(handleInfoVO);
			}
		}
		pageInfo.setList(rest);
		return pageInfo;
	}

	/**
	 * 流程监控
	 * 
	 * @return
	 */
	public PageInfo<MonitorVO> findFlowMonitor(String applyUser, String queryValue, String modelId, int pageNum,
			int pageSize) {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("applyUser", applyUser);
		filter.put("queryValue", queryValue);
		List<String> listKey = getProcessDefinitionKey(modelId);
		if (StringUtils.isNull(listKey)) {
			filter.put("keyList", null);
		} else {
			filter.put("keyList", listKey);
		}
		PageHelper.startPage(pageNum, pageSize);
		List<MonitorVO> list = actReProcdefMapper.findMonitorFlowsList(filter);
		PageInfo<MonitorVO> pageInfo = new PageInfo<MonitorVO>(list);
		List<MonitorVO> rest = Lists.newArrayList();
		for (MonitorVO monitorVO : list) {
			List<Task> taskList = taskService.createTaskQuery().processInstanceId(monitorVO.getProcessInstanceId())
					.active().list();
			if (StringUtils.isNull(taskList)) {
				monitorVO.setTaskName("已结束");
			} else {
				Task task = taskList.get(0);
				monitorVO.setTaskId(task.getId());
				monitorVO.setTaskName(task.getName());
				monitorVO.setHandler(task.getAssignee());
				HflowCustomRealTemplate listCT = hflowCustomRealTemplateMapper.selectByFlowIdAndNodeId(monitorVO.getProcessInstanceId(),task.getTaskDefinitionKey());
				if (StringUtils.isNotNull(listCT)) {
					monitorVO.setFormName(listCT.getName());
					monitorVO.setFormVersion(listCT.getVersion());
				}
			}
			Map<String, Object> variable = getHistoryVariable(monitorVO.getProcessInstanceId());
			LoggerUtils.debug(this.getClass(), "variable------------ " + variable);
			if (StringUtils.isNotNull(variable) && StringUtils.isNotNull(variable.get("applyUser")))
				monitorVO.setStartUserName(variable.get("applyUser").toString());
			rest.add(monitorVO);
		}
		pageInfo.setList(rest);
		return pageInfo;
	}

	/**
	 * 得到历史变量
	 * 
	 * @param ProcessInstanceId
	 * @return
	 */
	private Map<String, Object> getHistoryVariable(String processInstanceId) {
		List<HistoricVariableInstance> hlist = processEngine.getHistoryService().createHistoricVariableInstanceQuery()
				.processInstanceId(processInstanceId).list();
		Map<String, Object> map = new HashMap<>();
		if (StringUtils.isNotNull(hlist)) {
			for (HistoricVariableInstance hvi : hlist) {
				map.put(hvi.getVariableName(), hvi.getValue());
			}
		}
		return map;
	}

	private List<String> getProcessDefinitionKey(String modelId) {
		List<String> listKey = Lists.newArrayList();
		if (StringUtils.isNull(modelId)) {
			return listKey;
		} else {
			HflowModel model = modelMapper.selectByPrimaryKey(modelId);
			if (model == null)
				return listKey;
			listKey = procdefMapper.selectKeyByModel(model.getId(), ProcdefType.PRCDE.getIndex());
			return listKey;
		}
	}

	private HandleInfoVO getStartEvent(HandleInfoVO dto) {
		BpmnModel model = repositoryService.getBpmnModel(dto.getProcessDefinitionId());
		if (model != null) {
			Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
			for (FlowElement e : flowElements) {
				if (e.getClass().toString().endsWith("StartEvent")) {
					dto.setStartEventId(e.getId());
					dto.setStartEventName(e.getName());
					break;
				}
			}
		}
		return dto;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<HandleInfoVO> findRunningFlows(String applyUser, Map<String, Object> queryUser,
			QuereyParameterVO quereyPara) {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.isNotNull(applyUser)) {
			List<String> list=Lists.newArrayList();
			list.add(applyUser);
		    if(StringUtils.isNotNull(queryUser.get("applyUser"))) {
		    	list.addAll((List<String>)queryUser.get("applyUser"));
		    }
			filter.put("applyUserList", list);
		}	
		filter.put("queryValue", quereyPara.getQueryValue());
		List<String> listKey = getProcessDefinitionKey(quereyPara.getModelId());
		filter.put("keyList", listKey);
		filter.put("handlerList", queryUser.get("handleUser"));
		filter.put("start", quereyPara.getStartDate());
		filter.put("end", quereyPara.getEndDate());
		LoggerUtils.debug(this.getClass(), "filter-----------------------" + filter);

		PageHelper.startPage(quereyPara.getPageNum(), quereyPara.getPageSize());
		List<HandleInfoVO> list = actReProcdefMapper.selectRunningFlowsList(filter);
		PageInfo<HandleInfoVO> pageInfo = new PageInfo<HandleInfoVO>(list);

		List<HandleInfoVO> rest = Lists.newArrayList();
		for (HandleInfoVO handleInfoVO : list) {
			Task task = taskService.createTaskQuery().processInstanceId(handleInfoVO.getProcessInstanceId())
					.singleResult();
			if (StringUtils.isNotNull(task)) {
				handleInfoVO.setTaskId(task.getId());
				handleInfoVO.setTaskName(task.getName());
				handleInfoVO.setExecutionId(task.getExecutionId());
				handleInfoVO.setAssignee(task.getAssignee());
				handleInfoVO.setOwner(task.getOwner());
				Map<String, Object> variables = taskService.getVariables(handleInfoVO.getTaskId());
				handleInfoVO.setForm(variables);
				handleInfoVO.setTaskDefinitionKey(task.getTaskDefinitionKey());
				handleInfoVO.setToDate(DateHandler.getDaysBetween2(handleInfoVO.getCreateTime(), new Date()));
				rest.add(handleInfoVO);
			}
		}
		pageInfo.setList(rest);
		return pageInfo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<FinishedFlowVO> finished(String applyUser, Map<String, Object> queryUser,
			QuereyParameterVO quereyPara) {
		Map<String, Object> filter = new HashMap<String, Object>();
		if(StringUtils.isNotNull(applyUser)) {
			List<String> list=Lists.newArrayList();
			list.add(applyUser);
		    if(StringUtils.isNotNull(queryUser.get("applyUser"))) {
		    	list.addAll((List<String>)queryUser.get("applyUser"));
		    }
			filter.put("applyUserList", list);
		}	
		filter.put("queryValue", quereyPara.getQueryValue());
		filter.put("start", quereyPara.getStartDate());
		filter.put("end", quereyPara.getEndDate());
		List<String> listKey = getProcessDefinitionKey(quereyPara.getModelId());
		filter.put("keyList", listKey);
		// 办理人
		if(StringUtils.isNotNull(queryUser.get("handleUser"))) {
			List<String> proInstList = actReProcdefMapper.selectHandlerInfoByList((List<String>)queryUser.get("handleUser"));
			filter.put("proInstList", proInstList);
		}else {
			filter.put("proInstList", null);
		}
		LoggerUtils.debug(this.getClass(), "filter-----------------------" + filter);
		PageHelper.startPage(quereyPara.getPageNum(), quereyPara.getPageSize());
		List<FinishedFlowVO> list = actReProcdefMapper.selectEndFlowsList(filter);
		PageInfo<FinishedFlowVO> pageInfo = new PageInfo<FinishedFlowVO>(list);

		List<FinishedFlowVO> rest = Lists.newArrayList();
		for (FinishedFlowVO finishedFlowVO : list) {
			finishedFlowVO.setForm(getHistoryVariable(finishedFlowVO.getProcessInstanceId()));
			finishedFlowVO.setToDate(
					DateHandler.getDaysBetween2(finishedFlowVO.getStartDate(), finishedFlowVO.getStartDate()));
			rest.add(finishedFlowVO);
		}
		pageInfo.setList(rest);
		return pageInfo;
	}
	
	

}
