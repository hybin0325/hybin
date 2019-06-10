package com.edas.business.systask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.systask.entity.AiPhone;
import com.edas.business.systask.service.AiPhoneService;
import com.edas.edascommon.model.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * File Name: AiPhoneController.java
 * </p>
 * <p>
 * Description: ai电话controller
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "aiPhone-apis", description = "ai电话-apis")
@RestController
@RequestMapping("aiPhone")
public class AiPhoneController {

	@Autowired
    private AiPhoneService aiPhoneService;
	
	/**
     * 
     * @Description: 查询
     *
     * @param page,size
     * @return Object
     *
     * @date 2019年5月28日
     * @author zzw
     */
	@ApiOperation(value = "获取ai电话列表", notes = "获取ai电话列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "page",  required = true),
		@ApiImplicitParam(name = "size", value = "size",  required = true)
	})
    @GetMapping(value = "/list")
    public Object list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {   
		PageHelper.startPage(page, size);
		PageInfo<AiPhone> pageInfo = new PageInfo<AiPhone>(aiPhoneService.selectAll());
		return Result.success(pageInfo);        
    }
	
	/**
     * 
     * @Description: 新增
     *
     * @param aiPhone
     * @return Object
     *
     * @date 2019年5月28日
     * @author zzw
     */
	@ApiOperation(value = "新增ai电话", notes = "新增ai电话")
	@ApiImplicitParam(name = "aiPhone", value = "实体AiPhone")
    @PostMapping(value = "/save")
    public Object save(@RequestBody AiPhone aiPhone) throws Exception {
		aiPhoneService.saveAiPhone(aiPhone);
        return Result.success();
    }
	
	/**
     * 
     * @Description: 删除
     *
     * @param id
     * @return Object
     *
     * @date 2019年5月28日
     * @author zzw
     */
	@ApiOperation(value = "删除", notes = "删除")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public Object delete(@PathVariable("id") String id){
		aiPhoneService.deleteAiPhone(id);
		return Result.success();
	}
	
	/**
     * 
     * @Description: 更新
     *
     * @param AiPhone
     * @return Object
     *
     * @date 2019年5月28日
     * @author zzw
     */
	@ApiOperation(value = "更新", notes = "更新")
	@ApiImplicitParam(name = "aiPhone", value = "实体AiPhone")
	@PostMapping(value = "/update")
	public Object update(@RequestBody AiPhone aiPhone){
		aiPhoneService.updateAiPhone(aiPhone); 
		return Result.success();
	}
}
