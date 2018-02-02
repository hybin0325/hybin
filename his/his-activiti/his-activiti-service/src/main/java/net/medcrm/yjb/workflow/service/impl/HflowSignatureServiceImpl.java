package net.medcrm.yjb.workflow.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.medcrm.yjb.his.dateutil.DateHandler;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.workflow.domain.HflowSignature;
import net.medcrm.yjb.workflow.mapper.HflowSignatureMapper;
import net.medcrm.yjb.workflow.service.IHflowCommService;
import net.medcrm.yjb.workflow.service.IHflowSignatureService;
import net.medcrm.yjb.workflow.util.StringUtils;

@Service
public class HflowSignatureServiceImpl implements IHflowSignatureService {
	@Autowired
	private TaskService taskService;

	@Autowired
	private HflowSignatureMapper flowSignatureMapper;
	
	@Autowired
	private IHflowCommService flowCommService;

	@Transactional
	@Override
	public void save(HflowSignature pojo) {
		pojo.createPersistentObject();
		flowSignatureMapper.insert(pojo);
	}

	@Transactional
	public void saveHflowSignature(String taskId, EmployeeVO entity, String opinion) {
		// 获取流程实例Id信息
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();


		HflowSignature pojo = new HflowSignature();
		pojo.setProcessInstanceId(task.getProcessInstanceId());
		pojo.setTaskDefKey(task.getTaskDefinitionKey());
		pojo.setTaskDefName(task.getName());
		pojo.setHandler(entity.getFullName());
		pojo.setHandlerId(entity.getId());
		pojo.setHandlerDeptName(entity.getMajorName());
		pojo.setOpinion(opinion);
		
		pojo.createPersistentObject();
		HflowSignature hs = flowSignatureMapper.selectHflowSignatureInfo(task.getProcessInstanceId());
		if (StringUtils.isNotNull(hs)) {
			pojo.setSendDate(hs.getCreateDate());
			pojo.setSender(hs.getHandler());
			pojo.setSenderDeptName(hs.getHandlerDeptName());
			//String b = DateHandler.dateToStr2(task.getCreateTime(), "yyyy-MM-dd");
			//String t = DateHandler.dateToStr2(new Date(), "yyyy-MM-dd");
			String c = DateHandler.getDaysBetween(task.getCreateTime(), new Date());
			pojo.setUseDate(c);
		}
		flowSignatureMapper.insert(pojo);
	}

	public List<HflowSignature> findListInfo(String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		if(StringUtils.isNull(task))
			return null;
		List<HflowSignature> list = flowSignatureMapper.selectListInfo(task.getProcessInstanceId());
		return list;
	}
	
	@Transactional
	public void saveOpeion(String userId,String userName,String deptName,String processInstanceId) {
		Map<String, Object> startEventInfo = flowCommService.getStartEventInfo(processInstanceId);
		HflowSignature pojo = new HflowSignature();
		pojo.setProcessInstanceId(processInstanceId);
		pojo.setTaskDefKey(startEventInfo.get("id").toString());
		pojo.setTaskDefName(startEventInfo.get("name").toString());
		pojo.setHandler(userName);
		pojo.setHandlerId(userId);
		pojo.setHandlerDeptName(deptName);
		pojo.createPersistentObject();
		flowSignatureMapper.insert(pojo);
	}

}
