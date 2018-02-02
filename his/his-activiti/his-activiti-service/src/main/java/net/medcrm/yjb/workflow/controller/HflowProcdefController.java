package net.medcrm.yjb.workflow.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.feign.HflowProcdefVO;
import net.medcrm.yjb.his.fileutil.Base64Util;
import net.medcrm.yjb.workflow.domain.HflowProcdef;
import net.medcrm.yjb.workflow.service.IHflowCommService;
import net.medcrm.yjb.workflow.service.IHflowProcdefService;
import net.medcrm.yjb.workflow.util.StringUtils;
/**
 * 模块内容
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/procdef")
public class HflowProcdefController {
	@Autowired
	private IHflowProcdefService procdefService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private IHflowCommService flowCommService;

	@ApiOperation(value = "新增模块内容查询表", notes = "根据HflowProcdef对象创建模块信息", httpMethod = "POST")
	@ApiImplicitParam(name = "pojo", value = "会诊详细实体HflowProcdef", required = false, dataType = "HflowModel")
	@PostMapping("/save")
	public Object savePojo(@RequestBody  HflowProcdef pojo) throws  Exception {
		procdefService.save(pojo);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	
	@ApiOperation(value = "分页查询模块内容列表信息", notes = "根据每页数pageSize,当前页码pageNum查询模块信息", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "queryValue", value = "查询关键内容queryValue", required = false, dataType = "String"),
			@ApiImplicitParam(name = "type", value = "type类型:0流程模板 1流程 2表单 3报表 4查询表 默认为1", required = false, dataType = "String"),
			@ApiImplicitParam(name = "modelId", value = "模块modelId", required = false, dataType = "String")})
	@PostMapping("/getPageList")
	public Object getList(@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "queryValue", required = false) String queryValue,
			@RequestParam(value = "type", defaultValue = "1", required = false) String type,
			@RequestParam(value = "modelId", required = false) String modelId) {
		List<HflowProcdef> list = procdefService.findAllProcdef(type,pageNum,pageSize,modelId,queryValue);
		PageInfo<HflowProcdef> pageInfo=new PageInfo<HflowProcdef>(list);
		
		return new BaseResp<PageInfo<HflowProcdef>>(pageInfo);
	}
	
	@ApiOperation(value = "流程管理--流程详细信息", notes = "流程详细信息", httpMethod = "GET")
	@ApiImplicitParam(name = "actProcodefId", value = "流程Id", required = true, dataType = "String")
	@GetMapping("/getProcdefInfo")
	public Object findProcdefInfo(String actProcodefId) {
		if(StringUtils.isNull(actProcodefId))
			return new BaseResp<>(-1,"参数有误",null);
		return new BaseResp<>(procdefService.findProcdefInfo(actProcodefId));
	}
	
	
	@ApiOperation(value = "停用模块内容", notes = "当前选中id", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "当前选中id", required = true, dataType = "String"),
		@ApiImplicitParam(name = "status", value = "status状态码", required = true, dataType = "Integer")
	})
	@PostMapping("/disable")
	public Object disableProcdef(String id,Integer status) {
		if (id == null || id.equals("")) {
			return new BaseResp<>(-1, "Id不能为空", null);
		}
		if (status == null) {
			return new BaseResp<>(-1, "status状态码不能为空", null);
		}
		int result= procdefService.updateDisable(id, status);
		if(result==1)
			return new BaseResp<>(ResultStatus.SUCCESS);
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
		procdefService.updateChangeSort(currentId,  changeId);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	
	@ApiOperation(value = "修改模块内容信息", notes = "根据HflowProcdef对象修改信息", httpMethod = "POST")
	@ApiImplicitParam(name = "procdef", value = "详细实体HflowProcdef", required = false, dataType = "HflowProcdef")
	@PostMapping("/update")
	public Object udpateModel(HflowProcdef procdef) {
		procdefService.update(procdef);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
	 /**
     * 读取资源，通过部署ID
     *
     * @param processDefinitionId 流程定义
     * @param resourceType        资源类型(xml|image)
     * @throws Exception
     */
	@ApiOperation(value = "读取流程图片image,xml文件", notes = "读取流程图片 xml文件", httpMethod = "GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "actProcodefId", value = "布署好的流程actProcodefId", required = true, dataType = "String"),
		@ApiImplicitParam(name = "resourceType", value = "类型xml|image resourceType", required = true, dataType = "String") })
    @GetMapping(value = "/resource/read")
    public void loadByDeployment(String actProcodefId, 
    		String resourceType,HttpServletResponse response) throws Exception {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(actProcodefId).singleResult();
        String resourceName = "";
        if (resourceType.equals("image")) {
            resourceName = processDefinition.getDiagramResourceName();
        } else if (resourceType.equals("xml")) {
            resourceName = processDefinition.getResourceName();
        }
        InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }
	
	@ApiOperation(value = "查看流程图片、xml文件源码返回Base位", notes = "读取流程图片 xml文件", httpMethod = "GET")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "actProcodefId", value = "布署好的流程actProcodefId", required = true, dataType = "String"),
		@ApiImplicitParam(name = "resourceType", value = "类型xml|image resourceType", required = true, dataType = "String") })
	@GetMapping(value = "/resource/read/getFileBase64")
	public Object getFileBase64( String actProcodefId,String resourceType) {
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
				.processDefinitionId(actProcodefId).singleResult();
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
	
	
	@ApiOperation(value = "查询流程所有的审批节点上人员信息", notes = "审批节点上人员信息", httpMethod = "GET")
	@ApiImplicitParam(name = "processDefinitionId", value = "流程实例ID", required = true, dataType = "String")
	@GetMapping("/elements/getUserTaskInfo")
	public Object getUserTaskInfo(String processDefinitionId) {
		return new BaseResp<>(flowCommService.getTaskDefinition(processDefinitionId));
	}
	
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/getAllList")
	public Object findAllList() {
		List<HflowProcdefVO> list = procdefService.findAllList();
		return new BaseResp<List<HflowProcdefVO>>(list);
	}
	
	
	

}
