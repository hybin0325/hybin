package net.medcrm.yjb.workflow.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.TransitionImpl;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @Title: SpecialTaskService.java
 * @Description: 自由跳转流程的处理类
 * @date 2017年2月4日 下午5:34:49
 * @version V1.0
 */
@Service("specialTaskService")
public class SpecialTaskService {
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;

	private Object clone(final Object value) throws IOException, ClassNotFoundException {
		// 字节数组输出流，暂存到内存中
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		// 序列化
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(value);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		// 反序列化
		return ois.readObject();
	}

	/**
	 * 通过指定目标节点，实现任务的跳转
	 * 
	 * @param taskId
	 *            任务ID
	 * @param destNodeIds
	 *            跳至的目标节点ID
	 * @param vars
	 *            流程变量
	 */
	public void completeTask(String taskId, String[] destNodeIds) {
		TaskEntity task = (TaskEntity) taskService.createTaskQuery().taskId(taskId).singleResult();
		String curNodeId = task.getTaskDefinitionKey();
		String actDefId = task.getProcessDefinitionId();
		Map activityMap = prepare(actDefId, curNodeId, destNodeIds);
		try {
			taskService.complete(taskId);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			// 恢复
			restore(activityMap);
		}
	}

	/**
	 * 将节点之后的节点删除然后指向新的节点。
	 * 
	 * @param actDefId
	 *            流程定义ID
	 * @param nodeId
	 *            流程节点ID
	 * @param aryDestination
	 *            需要跳转的节点
	 * @return Map 返回节点和需要恢复节点的集合。
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private Map prepare(String actDefId, String nodeId, String[] aryDestination) {
		Map map = new HashMap();
		// 修改流程定义
		ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) repositoryService
				.getProcessDefinition(actDefId);
		ActivityImpl curAct = processDefinition.findActivity(nodeId);
		List outTrans = curAct.getOutgoingTransitions();
		try {
			List cloneOutTrans = (List) clone(outTrans);
			map.put("outTrans", cloneOutTrans);
		} catch (Exception ex) {
		}
		curAct.getOutgoingTransitions().clear();
		if (aryDestination != null && aryDestination.length > 0) {
			for (String dest : aryDestination) {
				// 创建一个连接
				ActivityImpl destAct = processDefinition.findActivity(dest);
				TransitionImpl transitionImpl = curAct.createOutgoingTransition();
				transitionImpl.setDestination(destAct);
			}
		}
		map.put("activity", curAct);
		return map;
	}

	/**
	 * 将临时节点清除掉，加回原来的节点。
	 * 
	 * @param map
	 *            void
	 */
	@SuppressWarnings("unchecked")
	private void restore(Map map) {
		ActivityImpl curAct = (ActivityImpl) map.get("activity");
		List outTrans = (List) map.get("outTrans");
		curAct.getOutgoingTransitions().clear();
		curAct.getOutgoingTransitions().addAll(outTrans);
		for (Iterator it = outTrans.iterator(); it.hasNext();) {
			// 回复删除的INCOMING
			PvmTransition transition = (PvmTransition) it.next();
			PvmActivity activity = transition.getDestination();
			List incomes = (List) map.get("Income_" + activity.getId());
			activity.getIncomingTransitions().clear();
			activity.getIncomingTransitions().addAll(incomes);
		}
	}

	/**
	 * 转他人处理
	 * 
	 * @param taskId
	 * @param userId
	 */
	public void mytaskChangeOther(String taskId, String userId) {
		taskService.setAssignee(taskId, userId);
	}

	/**
	 * 委派
	 * 
	 * @param taskId
	 * @param userId
	 */
	public void weipai(String taskId, String userId) {
		taskService.delegateTask(taskId, userId);
	}

	/**
	 * 查询委派任务： 根据字段owner查询 正在运行的委派任务：
	 * 
	 * @param userId
	 */
	public List<Task> ListmytaskChangeOtherList1(String userId) {
		List<Task> list = taskService.createTaskQuery().taskOwner(userId).orderByTaskCreateTime().desc().list();
		return list;
	}
}
