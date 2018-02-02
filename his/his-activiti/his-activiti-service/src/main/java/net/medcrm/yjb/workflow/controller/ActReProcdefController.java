package net.medcrm.yjb.workflow.controller;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.service.IActReProcdefService;
import net.medcrm.yjb.workflow.service.IHflowProcdefLogsService;
import net.medcrm.yjb.workflow.util.StringUtils;
import net.medcrm.yjb.workflow.vo.ActReProcdefVO;

/**
 * 流程管理
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/actReProcdef")
public class ActReProcdefController {
	@Autowired
	private IActReProcdefService actReProcdefService;

	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private EmployeeServiceClient employeeServiceClient;
	
	@Autowired
	private IHflowProcdefLogsService procdefLogsService;

	@ApiOperation(value = "分页查询流程列表", notes = "根据每页数rowSize,当前页码pageNum查询流程信息表status:1可用、2停用", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "modelId", value = "模块IDmodelId", required = false, dataType = "String") })
	@PostMapping("/getActReProcdefList")
	public Object getList(@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "modelId", required = false) String modelId) {
		List<ActReProcdefVO> list = actReProcdefService.findActReProcdefList(modelId, pageNum, pageSize);
		PageInfo<ActReProcdefVO> pageInfo = new PageInfo<ActReProcdefVO>(list);
		return new BaseResp<PageInfo<ActReProcdefVO>>(pageInfo);
	}

	/**
	 * 挂起、激活流程实例 ，改成启用和停用
	 */
	@ApiOperation(value = "流程实例---停用、启用", notes = "根据流程实例ID、停用和启用status:1可用、2停用", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "state", value = "标识码active启用，suspend停用", required = true, dataType = "String"),
			@ApiImplicitParam(name = "actProcodefId", value = "流程实例ID", required = true, dataType = "String") })
	@PostMapping(value = "/processdefinition/update")
	public Object updateState(String state, String actProcodefId) {
		if (StringUtils.isNull(state)) {
			return new BaseResp<>(-1, "标识码state不能为空,请写active启用、suspend停用", null);
		}
		if (StringUtils.isNull(actProcodefId)) {
			return new BaseResp<>(-1, "流程实例ID不能为空", null);
		}
		actReProcdefService.updateState(actProcodefId,state);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	/**
	 * 修改流程
	 */
	@ApiOperation(value = "流程实例---编辑流程实例", notes = "编辑流程实例", httpMethod = "GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "actProcodefId", value = "流程实例ID", required = true, dataType = "String"),
		@ApiImplicitParam(name = "modelId", value = "模块ID", required = true, dataType = "String")
	})
	@GetMapping(value = "/toEdit")
	public Object edit(String actProcodefId,String modelId) {
		if (StringUtils.isNull(actProcodefId)) {
			return new BaseResp<>(-1, "流程实例ID不能为空", null);
		}
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(actProcodefId).singleResult();
		if(processDefinition==null)
			return new BaseResp<>(ResultStatus.FAIL);
		
		Model model= repositoryService.createModelQuery().deploymentId(processDefinition.getDeploymentId()).singleResult();
		Integer num= actReProcdefService.findTasByProc(actProcodefId);
		if(num==0 && model!=null)
			return new BaseResp<>(model.getId());
		BaseResp<EmployeeVO> baseEmployee = employeeServiceClient.currentEmp();
		EmployeeVO user = (EmployeeVO) baseEmployee.getData();
		try {
			String actModelId= actReProcdefService.updateConvertToModel(processDefinition, user.getFullName(),modelId);
			return new BaseResp<>(actModelId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BaseResp<>(ResultStatus.FAIL);
	}
	
	@ApiOperation(value = "向下向下排序", notes = "根据选中的行的currentId,并根据上行或下行changeId进行排序", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "currentId", value = "当前选中currentId", required = true, dataType = "String"),
			@ApiImplicitParam(name = "changeId", value = "向上或向下排序changeId", required = true, dataType = "String") })
	@PostMapping("/changeSort")
	public Object getChangeSort(String currentId,String changeId) {
		if (StringUtils.isNull(currentId)) {
			return new BaseResp<>(-1, "当前选中currentId不能为空", null);
		}
		if (StringUtils.isNull(currentId)) {
			return new BaseResp<>(-1, "向上或向下排序changeId不能为空", null);
		}
		String str= procdefLogsService.updateChangeSort(currentId, changeId);
		if(StringUtils.isNotNull(str))
			return new BaseResp<>(-1, str, null);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
}
