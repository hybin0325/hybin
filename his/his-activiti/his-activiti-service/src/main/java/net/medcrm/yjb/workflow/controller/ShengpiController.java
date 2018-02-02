package net.medcrm.yjb.workflow.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.workflow.service.IHflowCommService;

@RestController
@RequestMapping(value = "/test/shengpi")
public class ShengpiController {

	@Autowired
	private IHflowCommService flowCommService;

	@Autowired
	private RepositoryService repositoryService;

	@Autowired
	private ProcessEngine processEngine;

	@GetMapping("/getStart")
	public Object getBanLi(String processDefinitionKey) {
		try {
			// 流程定义的key
			//String processDefinitionKey = "test-email";
			ProcessInstance pi = processEngine.getRuntimeService()// 与正在执行的流程实例和执行对象相关的Service
					.startProcessInstanceByKey(processDefinitionKey);// 使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动
			System.out.println(pi.getId());
			return new BaseResp<>(pi.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseResp<>(ResultStatus.FAIL);
	}

	@GetMapping("/getElements")
	public Object getElements(String processDefinitionId) {
		List<Map<String, Object>> list = new ArrayList<>();
		BpmnModel model = repositoryService.getBpmnModel(processDefinitionId);

		if (model != null) {
			Collection<FlowElement> flowElements = model.getMainProcess().getFlowElements();
			for (FlowElement e : flowElements) {
				System.out.println("flowelement id:" + e.getId() + "  name:" + e.getName() + "   class:"
						+ e.getClass().toString());
				if (e.getClass().toString().endsWith("UserTask")) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", e.getId());
					map.put("name", e.getName());
					// map.put("class", e.getClass().toString());
					list.add(map);
				}
			}
			return new BaseResp<>(list);
		}
		return new BaseResp<>(ResultStatus.FAIL);
	}
}
