package com.edas.business.tripartite.controller.distribution;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.tripartite.entity.distribution.City;
import com.edas.business.tripartite.service.distribution.CityService;
import com.edas.edascommon.model.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Description: 市controller
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "city-apis", description = "市-apis")
@RestController
@RequestMapping("city")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	/**
     * 
     * @Description: 查询
     *
     */
	@ApiOperation(value = "获取列表", notes = "获取列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "第几页",  required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "size", value = "分页数",  required = true, dataType = "Integer")
	})
    @GetMapping(value = "/list")
    public Object list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {	
		PageHelper.startPage(page, size);		
		PageInfo<City> pageInfo = new PageInfo<City>(cityService.selectAll());		
        return Result.success(pageInfo);
    }
	
	/**
     * 
     * @Description: 添加
     *
     */
	@ApiOperation(value = "添加", notes = "添加")	
	@ApiImplicitParam(name = "city", value = "实体", dataType = "City",required = true)
	@PostMapping(value = "/save")
    public Object save(@RequestBody @Valid City city) throws Exception {  				
		cityService.saveEntity(city);
		return Result.success();
    }
	
	/**
     * 业务逻辑没有删除和更新，先注释
     * @Description: 删除 
     *
     * @param id
     */
	@ApiOperation(value = "删除黑名单", notes = "删除黑名单")
	@ApiImplicitParam(name = "id", value = "主键id", required = true, dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public Object delete(@PathVariable("id") String id){
		cityService.deleteEntity(id);
		return Result.success();
	}
	
	/**
     * 
     * @Description: 更新
     *
     */
	@ApiOperation(value = "更新", notes = "更新")
	@PostMapping(value = "/update")
	@ApiImplicitParam(name = "city", value = "实体", required = true, dataType = "City")
	public Object update(@RequestBody City city){
		cityService.updateEntity(city); 
		return Result.success();
	}
}
