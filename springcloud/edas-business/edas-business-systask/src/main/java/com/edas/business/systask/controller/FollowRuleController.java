package com.edas.business.systask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.systask.entity.FollowRule;
import com.edas.business.systask.service.FollowRuleService;
import com.edas.edascommon.model.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * File Name: FollowRuleController.java
 * </p>
 * <p>
 * Description: 跟进规则controller
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "followRule-apis", description = "跟进规则-apis")
@RestController
@RequestMapping("followRule")
public class FollowRuleController {

	@Autowired
    private FollowRuleService followRuleService;
	
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
	@ApiOperation(value = "获取列表", notes = "获取列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "page",  required = true),
		@ApiImplicitParam(name = "size", value = "size",  required = true)
	})
    @GetMapping(value = "/list")
    public Object list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {   
		PageHelper.startPage(page, size);
		PageInfo<FollowRule> pageInfo = new PageInfo<FollowRule>(followRuleService.selectAll());
		return Result.success(pageInfo);        
    }
	
	/**
     * 
     * @Description: 新增
     *
     * @param followRule
     * @return Object
     *
     * @date 2019年5月28日
     * @author zzw
     */
	@ApiOperation(value = "新增", notes = "新增")
	@ApiImplicitParam(name = "followRule", value = "实体followRule")
    @PostMapping(value = "/save")
    public Object save(@RequestBody FollowRule followRule) throws Exception {
		followRuleService.saveFollowRule(followRule);
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
	@ApiImplicitParam(name = "id", value = "id", required = true)
	@PostMapping(value = "/delete/{id}")
	public Object delete(@PathVariable("id") String id){
		followRuleService.deleteFollowRule(id);
		return Result.success();
	}
	
	/**
     * 
     * @Description: 更新
     *
     * @param followRule
     * @return Object
     *
     * @date 2019年5月28日
     * @author zzw
     */
	@ApiOperation(value = "更新", notes = "更新")
	@ApiImplicitParam(name = "followRule", value = "实体followRule")
	@PostMapping(value = "/update")
	public Object update(@RequestBody FollowRule followRule){
		followRuleService.updateFollowRule(followRule); 
		return Result.success();
	}
}
