/**
 * 
 */
package net.medcrm.yjb.workflow.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.form.TaskFormDataImpl;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskInfoQuery;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.his.mybatis.dynamicDataSource.page.PageInfo;
import com.lorne.tx.annotation.TxTransaction;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.ElementVO;
import net.medcrm.yjb.his.feign.HflowProcdefVO;
import net.medcrm.yjb.his.log.LoggerUtils;
import net.medcrm.yjb.his.tool.BeanUtilEx;
import net.medcrm.yjb.workflow.domain.HflowModel;
import net.medcrm.yjb.workflow.domain.HflowProcdef;
import net.medcrm.yjb.workflow.dto.FlowDeployDto;
import net.medcrm.yjb.workflow.feign.client.ElementServiceClient;
import net.medcrm.yjb.workflow.feign.client.PermissionServiceClient;
import net.medcrm.yjb.workflow.mapper.HflowModelMapper;
import net.medcrm.yjb.workflow.mapper.HflowProcdefMapper;
import net.medcrm.yjb.workflow.service.IHflowModelProcdefService;
import net.medcrm.yjb.workflow.service.IHflowProcdefService;
import net.medcrm.yjb.workflow.util.ActivitiUtils;
import net.medcrm.yjb.workflow.util.ProcdefStatus;
import net.medcrm.yjb.workflow.util.ProcdefType;
import net.medcrm.yjb.workflow.util.StatusType;
import net.medcrm.yjb.workflow.util.StringUtils;
import net.medcrm.yjb.workflow.vo.HandleVO;
import net.medcrm.yjb.workflow.vo.HistoryVO;

/**
 * @author Administrator
 *
 */
@Service
public class HflowProcdefServiceImpl implements IHflowProcdefService {
	protected Logger logger = LoggerFactory.getLogger(HflowProcdefServiceImpl.class);

	@Autowired
	private HflowProcdefMapper procdefMapper;

	@Autowired
	private HflowModelMapper modelMapper;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private ElementServiceClient elementServiceClient;

	@Autowired
	private IHflowModelProcdefService modelProcdefService;

	@Autowired
	private PermissionServiceClient permissionServiceClient;

	@Autowired
	private FormService formService;

	@Autowired
	private HistoryService historyService;

	@Override
	@Transactional
	@TxTransaction
	public void save(HflowProcdef record) throws Exception {
		HflowProcdef pojo = procdefMapper.selectByPrimaryKeyType(record.getActKey(), record.getType());
		LoggerUtils.debug(this.getClass(), "-----------------" + pojo);
		if (pojo != null) {
			record.setId(pojo.getId());
			procdefMapper.updateByPrimaryKeySelective(record);
		} else {
			record.setpSort(getSort());
			record.createPersistentObject();
			procdefMapper.insert(record);
			if (record.getType() == ProcdefType.PRCDE.getIndex()) {
				saveElemnts(record);
			}
		}
		modelProcdefService.saveModelProcdef(record.getModelId(), record.getId());
	}

	@Transactional
	@TxTransaction
	public boolean saveElemnts(HflowProcdef record) throws Exception {
		List<ElementVO> list = new ArrayList<>();
		Date date = new Date();
		// 查看操作
		ElementVO vo = new ElementVO();
		vo.setId(UUID.randomUUID().toString());
		vo.setAuth("hflow:procdef:scan");
		vo.setType("100");
		vo.setName("申请");
		vo.setParentId(record.getId());
		vo.setStatus(1);
		vo.setCreatTime(date);
		vo.setDescription("可以发出流程申请；监控：可以在监控列表中查阅流程状态并进行特殊处理");
		list.add(vo);

		// 监控操作
		vo = new ElementVO();
		vo.setId(UUID.randomUUID().toString());
		vo.setAuth("hflow:procdef:controller");
		vo.setType("100");
		vo.setName("监控");
		vo.setParentId(record.getId());
		vo.setStatus(1);
		vo.setCreatTime(date);
		vo.setDescription("监控流程。");
		list.add(vo);

		// 管理操作
		vo = new ElementVO();
		vo.setId(UUID.randomUUID().toString());
		vo.setAuth("hflow:procdef:manager");
		vo.setType("100");
		vo.setName("管理");
		vo.setParentId(record.getId());
		vo.setStatus(1);
		vo.setCreatTime(date);
		vo.setDescription("可以在流程管理列表中设置流程与维护流程的备选人员等。");
		list.add(vo);

		BaseResp baseResp = elementServiceClient.saveOrUpdateAll(list);

		if (baseResp.getCode() != 0 || !"success".equals(baseResp.getMessage())) {
			throw new Exception("服务器内部错误");
		}
		return true;
	}

	@Override
	public void update(HflowProcdef record) {
		record.updatePersistentObject();
		procdefMapper.updateByPrimaryKeySelective(record);

	}

	@Override
	public HflowProcdef findById(String id) {

		return procdefMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<HflowProcdef> findAllProcdef(String type, int pageNum, int pageSize, String modelId,
			String queryValue) {
		// 将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		if (modelId != null && !modelId.equals("")) {
			return procdefMapper.selectAllProcdefByModel(modelId, type, queryValue);
		} else {
			return procdefMapper.selectAllProcdef(type, null, queryValue);
		}

	}

	@Override
	@Transactional
	public void updateChangeSort(String currentId, String changeId) {
		HflowProcdef current = procdefMapper.selectByPrimaryKey(currentId);
		HflowProcdef change = procdefMapper.selectByPrimaryKey(changeId);
		if (current == null) {
			return;
		}
		if (change == null) {
			return;
		}
		Integer tempCurrentSort = current.getpSort();
		Integer tempChangeSort = change.getpSort();
		if (current != null) {
			current.setpSort(tempChangeSort);
			current.updatePersistentObject();
			procdefMapper.updateByPrimaryKeySelective(current);
		}

		if (change != null) {
			change.setpSort(tempCurrentSort);
			change.updatePersistentObject();
			procdefMapper.updateByPrimaryKeySelective(change);
		}
	}

	@Override
	@Transactional
	public int updateDisable(String id, int status) {
		if (id == null || id.equals(""))
			return 0;
		if (id.indexOf(",") != -1) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] a = id.split(",");
			map.put("status", status);
			map.put("updateDate", new Date());
			map.put("ids", a);
			procdefMapper.updateBatch(map);
			return 1;
		}
		HflowProcdef h = procdefMapper.selectByPrimaryKey(id);
		if (h == null)
			return 0;
		HflowProcdef model = new HflowProcdef();
		model.setId(id);
		model.setStatus(status);
		model.updatePersistentObject();
		procdefMapper.updateByPrimaryKeySelective(model);
		return 1;
	}

	@Override
	public List<FlowDeployDto> findAllDeploy(int type, String modelId) {
		// BaseResp<List<SysElementVO>> baseResp =
		// permissionServiceClient.findUserPermissions();
		// List<SysElementVO> listVo = (List<SysElementVO>) baseResp.getData();
		// logger.debug("用户权限集合List<SysElementVO>：", listVo);
		// if (StringUtils.isNotNull(listVo))
		// return new ArrayList<FlowDeployDto>();
		// List<String> vo = new ArrayList<>();
		// for (SysElementVO sysElementVO : listVo) {
		// vo.add(sysElementVO.getParentId());
		// }
		// logger.debug("权限Id集合：", vo);

		List<String> proList = procdefMapper.selectSendFlowId(modelId, type + "", StatusType.TES.getIndex());
		if (StringUtils.isNull(proList))
			return new ArrayList<>();
		logger.debug("流程集合：", proList);

		// List<String> str = ListUtils.getStringsection(vo, proList);

		// logger.debug("交集合：", str);
		List<FlowDeployDto> rest=Lists.newArrayList();
		
		List<FlowDeployDto> list= procdefMapper.selectSendFlow(proList);
		for (FlowDeployDto flowDeployDto : list) {
			getStartEvent(flowDeployDto);
			rest.add(flowDeployDto);
		}
		return rest;
	}
	
    private FlowDeployDto getStartEvent(FlowDeployDto dto) {
    	BpmnModel model = repositoryService.getBpmnModel(dto.getActProcodefId());
		if (model != null) {
			Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
			for (FlowElement e : flowElements) {
				if (e.getClass().toString().endsWith("StartEvent")) {
					dto.setStartEventId(e.getId());
					dto.setStartEventName( e.getName());
					break;
				}
			}
		}
		return dto;
    }

	/**
	 * 查询待办
	 * 
	 * @param type
	 * @param menuId
	 * @param userId
	 */
	public List<HandleVO> getHandleHFlow(int type, String modelId, String userId, PageInfo<HandleVO> page,
			int[] pageParams) {
		List<HandleVO> results = new ArrayList<HandleVO>();

		TaskQuery taskQuery = null;
		if (modelId == null || modelId.equals("")) {
			taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
		} else {
			HflowModel model = modelMapper.selectByPrimaryKey(modelId);
			if (model == null)
				return null;
			List<String> listKey = procdefMapper.selectKeyByModel(model.getId(), type);
			if (listKey == null || listKey.isEmpty() || listKey.size() == 0)
				return null;
			taskQuery = taskService.createTaskQuery().processDefinitionKeyIn(listKey).taskCandidateOrAssigned(userId);
		}
		List<Task> tasks = taskQuery.listPage(pageParams[0], pageParams[1]);
		for (Task task : tasks) {
			HandleVO vo = new HandleVO();
			String processInstanceId = task.getProcessInstanceId();
			ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
					.processInstanceId(processInstanceId).active().singleResult();
			if (processInstance == null) {
				continue;
			}
			String businessKey = processInstance.getBusinessKey();
			if (businessKey != null) {
				Map<String, Object> object = procdefMapper.selectObject(processInstance.getProcessDefinitionKey(),
						businessKey);
				vo.setForm(object);
			} else {
				TaskFormDataImpl taskFormData = (TaskFormDataImpl) formService.getTaskFormData(task.getId());
				taskFormData.setTask(null);
				Map<String, Object> map = new HashMap<>();
				List<FormProperty> listFp = taskFormData.getFormProperties();
				for (FormProperty formProperty : listFp) {
					map.put(formProperty.getId(), formProperty.getValue());
				}
				vo.setForm(map);
			}
			vo.setTask(ActivitiUtils.toConverterTaskVO(task));
			vo.setProcessDefinition(ActivitiUtils
					.toConverterProcessDefinitionVO(getProcessDefinition(processInstance.getProcessDefinitionId())));
			vo.setProcessInstance(ActivitiUtils.toConverterProcessInstanceVO(processInstance, null));

			results.add(vo);
		}
		page.setTotal(taskQuery.count());
		page.setList(results);
		return results;
	}

	protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		return processDefinition;
	}

	@Override
	public List<HflowProcdefVO> findAllList() {

		List<HflowProcdefVO> result = new ArrayList<HflowProcdefVO>();
		List<HflowProcdef> list = procdefMapper.selectAllProcdef(ProcdefType.PRCDE.getIndex() + "",
				StatusType.TES.getIndex() + "", null);
		try {
			for (HflowProcdef hflowProcdef : list) {
				HflowProcdefVO vo = new HflowProcdefVO();
				BeanUtilEx.copyProperties(vo, hflowProcdef);
				result.add(vo);
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Transactional
	public HflowProcdef saveByActModel(Model model, String user, String description) {
		HflowProcdef procdef = new HflowProcdef();
		HflowProcdef query = procdefMapper.selectByPrimaryKeyType(model.getKey(), ProcdefType.MODEL.getIndex());
		if (StringUtils.isNotNull(query)) {
			procdef.setId(query.getId());
			procdef.setpVersion(model.getVersion());
			procdef.setTitleName(model.getName());
			procdef.setDescription(description);
			procdef.setUpdateDate(new Date());
			procdef.setUpdateUser(user);
			procdef.setActModelId(model.getId());
			procdefMapper.updateByPrimaryKeySelective(procdef);
			return procdef;
		}
		procdef.setActKey(model.getKey());
		procdef.setpVersion(model.getVersion());
		procdef.setTitleName(model.getName());
		procdef.setDescription(description);
		procdef.setType(ProcdefType.MODEL.getIndex());
		procdef.setCreateUser(user);
		procdef.setActModelId(model.getId());
		procdef.createPersistentObject();
		procdef.setpSort(getSort());
		procdef.setStatus(StatusType.TES.getIndex());
		procdefMapper.insert(procdef);
		return procdef;

	}

	@Transactional
	public HflowProcdef saveHflowProcdef(Model model, ProcessDefinition processDefinition, String dec)
			throws Exception {
		HflowProcdef procdef = new HflowProcdef();
		HflowProcdef query = procdefMapper.selectByPrimaryKeyType(model.getKey(), ProcdefType.PRCDE.getIndex());
		if (StringUtils.isNotNull(query)) {
			procdef.setId(query.getId());
			procdef.setpVersion(model.getVersion());
			procdef.setTitleName(model.getName());
			procdef.setActProcodefId(procdef.getId());
			procdef.setDescription(dec);
			procdef.setUpdateDate(new Date());
			procdefMapper.updateByPrimaryKeySelective(procdef);
			return procdef;
		}
		procdef.setTitleName(processDefinition.getName());
		procdef.setDescription(dec);
		procdef.setpVersion(processDefinition.getVersion());
		procdef.setStatus(processDefinition.isSuspended() ? ProcdefStatus.TES.getIndex() : ProcdefStatus.NO.getIndex());
		procdef.setActProcodefId(procdef.getId());
		procdef.setType(ProcdefType.PRCDE.getIndex());
		procdef.setActModelId(model.getId());
		procdef.setActKey(processDefinition.getKey());
		procdef.setpSort(getSort());
		procdef.createPersistentObject();
		save(procdef);
		return procdef;
	}

	protected int getSort() {
		if (procdefMapper.selectMaxSort() != null) {
			return procdefMapper.selectMaxSort() + 1;
		} else {
			return 1;
		}
	}

	@Override
	public List<String> getProcdefIdByModelId(String modelId) {
		return modelMapper.selectProcdefIdByModelId(modelId, null);
	}

	@Override
	public HflowProcdef findByPrimaryKeyType(String actKey, Integer type) {
		return procdefMapper.selectByPrimaryKeyType(actKey, type);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<HistoryVO> findHistoryFlow(int type, String modelId, String userId, PageInfo<HistoryVO> page,
			int[] pageParams) {
		List<HistoryVO> result = new ArrayList<>();
		TaskInfoQuery query = historyService.createHistoricTaskInstanceQuery().taskCandidateUser(userId);
		List<HistoricTaskInstance> list = query.listPage(pageParams[0], pageParams[1]);
		// List<HistoricTaskInstance> list=
		// historyService.createHistoricTaskInstanceQuery().taskCandidateUser(userId).listPage(pageParams[0],
		// pageParams[1]);
		for (HistoricTaskInstance historicTaskInstance : list) {
			HistoryVO vo = new HistoryVO();
			vo.setTaskInfo(ActivitiUtils.toConverterTaskInfoVO(historicTaskInstance));
			result.add(vo);
		}
		page.setTotal(query.count());
		page.setList(result);
		return result;
	}

	@Transactional
	public int updateDisableByPro(String proId, int status) {
		if (StringUtils.isNull(proId))
			return 0;
		HflowProcdef h = procdefMapper.selectByPrimaryKeyPro(proId, ProcdefType.PRCDE.getIndex());
		if (StringUtils.isNull(h))
			return 0;
		HflowProcdef model = new HflowProcdef();
		model.setId(h.getId());
		model.setStatus(status);
		model.updatePersistentObject();
		procdefMapper.updateByPrimaryKeySelective(model);
		return 1;
	}

	public HflowProcdef findProcdefInfo(String id) {
		HflowProcdef flowProcdef = procdefMapper.selectByPrimaryKeyPro(id, ProcdefType.PRCDE.getIndex());
		if (StringUtils.isNull(flowProcdef)) {
			return procdefMapper.selectActProcodefInfoByProId(id);
		}
		return procdefMapper.selectByPrimaryKeyPro(id, ProcdefType.PRCDE.getIndex());

	}

}
