package net.medcrm.yjb.workflow.controller;

import java.util.List;

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
import net.medcrm.yjb.workflow.domain.HflowModel;
import net.medcrm.yjb.workflow.service.IHflowModelService;
import net.medcrm.yjb.workflow.util.StringUtils;

/**
 * 自定义模块
 * 
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/flowmodel")
public class HflowModelController {

	@Autowired
	private IHflowModelService modelService;
	

	@ApiOperation(value = "新增模块信息", notes = "根据HflowModel对象创建模块信息", httpMethod = "POST")
	@ApiImplicitParam(name = "model", value = "会诊详细实体HflowModel", required = false, dataType = "HflowModel")
	@PostMapping("/save")
	public Object saveModel(@RequestBody HflowModel model) {
		if (modelService.isExistCode(model.getmCode()))
			return new BaseResp<>(ResultStatus.code_exist);
		modelService.save(model);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "校验Code是否存在", notes = "校验Code是否存在", httpMethod = "GET")
	@ApiImplicitParam(name = "code", value = "模块code", required = true, dataType = "String")
	@GetMapping("/getCodeExist")
	public Object getCodeExist(String code) {
		if (StringUtils.isNull(code)) {
			return new BaseResp<>(-1, "code不能为空", null);
		}
		return new BaseResp<>(modelService.getByCode(code));
	}

	@ApiOperation(value = "修改模块信息", notes = "根据HflowModel对象创建模块信息", httpMethod = "POST")
	@ApiImplicitParam(name = "model", value = "会诊详细实体HflowModel", required = false, dataType = "HflowModel")
	@PostMapping("/update")
	public Object udpateModel(HflowModel model) {
		modelService.update(model);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "查询模块信息", notes = "根据ID查询模块信息", httpMethod = "GET")
	@ApiImplicitParam(name = "id", value = "模块ID", required = true, dataType = "String")
	@GetMapping("/getModel")
	public Object getById(String id) {
		if (id == null || id.equals("")) {
			return new BaseResp<>(-1, "模块Id不能为空", null);
		}
		HflowModel model = modelService.findById(id);
		return new BaseResp<HflowModel>(model);
	}

	@ApiOperation(value = "分页查询模块列表信息", notes = "根据每页数rowSize,当前页码pageNum查询模块信息", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageSize", value = "每页数pageSize", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "pageNum", value = "当前页码pageNum", required = false, dataType = "Integer"),
			@ApiImplicitParam(name = "queryValue", value = "查询关键内容queryValue", required = false, dataType = "String") })
	@PostMapping("/getModelList")
	public Object getList(@RequestParam(value = "pageSize", defaultValue = "1000", required = false) Integer pageSize,
			@RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
			@RequestParam(value = "queryValue", required = false) String queryValue) {
		List<HflowModel> list = modelService.findAllModel(queryValue, pageNum, pageSize);
		PageInfo<HflowModel> pageInfo = new PageInfo<HflowModel>(list);
		return new BaseResp<PageInfo<HflowModel>>(pageInfo);
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
		String str= modelService.updateChangeSort(currentId, changeId);
		if(StringUtils.isNotNull(str))
			return new BaseResp<>(-1, str, null);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}

	@ApiOperation(value = "停用模块信息,多个用逗号拼接", notes = "当前选中id", httpMethod = "POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id", value = "当前选中id", required = true, dataType = "String"),
		@ApiImplicitParam(name = "status", value = "status状态码", required = true, dataType = "Integer")
	})
	@PostMapping("/disableModel")
	public Object disableModel(String id,Integer status) {
		if (id == null || id.equals("")) {
			return new BaseResp<>(-1, "模块Id不能为空", null);
		}
		if (status == null) {
			return new BaseResp<>(-1, "status状态码不能为空", null);
		}
		int result = modelService.updateDisableModel(id, status);
		if (result == 1)
			return new BaseResp<>(ResultStatus.SUCCESS);
		return new BaseResp<>(ResultStatus.FAIL);
	}

	@ApiOperation(value = "模块绑定内容", notes = "模块ID选中的内容", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "modelId", value = "当前模块modelId", required = true, dataType = "String"),
			@ApiImplicitParam(name = "contentsId", value = "内容IDcontentsId", required = true, dataType = "String[]") })
	@GetMapping("/saveModelConts")
	public Object saveModelConts(String modelId, String[] contentsId) {
		if (modelId == null || modelId.equals("")) {
			return new BaseResp<>(-1, "模块Id不能为空", null);
		}
		modelService.saveModelContent(modelId, contentsId);
		return new BaseResp<>(ResultStatus.SUCCESS);
	}
	
}
