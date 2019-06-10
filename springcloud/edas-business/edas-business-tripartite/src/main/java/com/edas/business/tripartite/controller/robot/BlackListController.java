package com.edas.business.tripartite.controller.robot;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.tripartite.entity.robot.BlackList;
import com.edas.business.tripartite.service.robot.BlackListService;
import com.edas.edascommon.model.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Description: 黑名单controller
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "blackList-apis", description = "黑名单-apis")
@RestController
@RequestMapping("blackList")
public class BlackListController {
	
	@Autowired
    private BlackListService blackListService;
	
	/**
     * 
     * @Description: 根据公司id查询黑名单列表
     * @param id
     * @return RetResult
     *
     */
	@ApiOperation(value = "根据公司id查询黑名单列表", notes = "根据公司id查询黑名单列表")
	@ApiImplicitParam(name = "companyId", value = "公司id",  required = true, dataType = "Integer")
    @GetMapping(value = "/get")
    public Object findByCompanyId(@RequestParam(value="companyId",required = true) int companyId) throws Exception { 
		BlackList blackList = new BlackList();
		blackList.setCompanyId(companyId);	
        return Result.success(blackListService.select(blackList));
        
    }
	
	/**
     * 
     * @Description: 查询
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "获取黑名单列表", notes = "获取黑名单列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "第几页",  required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "size", value = "分页数",  required = true, dataType = "Integer")
	})
    @GetMapping(value = "/list")
    public Object list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {	
		PageHelper.startPage(page, size);		
		PageInfo<BlackList> pageInfo = new PageInfo<>(blackListService.selectAll());
        return Result.success(pageInfo);
        
    }
	
	/**
     * 
     * @Description: 添加
     *
     * @param blackList
     * @return RetResult
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@ApiOperation(value = "添加黑名单", notes = "添加黑名单")	
	@ApiImplicitParam(
			name = "blackList", 
			value = "实体blackList", 			
			dataType = "BlackList",
			required = true
			)
	@PostMapping(value = "/save")
    public Object save(@RequestBody @Valid BlackList blackList) throws Exception {  				
        return blackListService.saveBlackList(blackList);
    }
	
	/**
     * 业务逻辑没有删除和更新，先注释
     * @Description: 删除 
     *
     * @param id
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	/*@ApiOperation(value = "删除黑名单", notes = "删除黑名单")
	@ApiImplicitParam(name = "id", value = "主键id", required = true, dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		blackListService.deleteBlackList(id);
		return RetResponse.makeOKRsp();
	}*/
	
	/**
     * 
     * @Description: 更新
     *
     * @param BlackList
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	/*@ApiOperation(value = "更新黑名单", notes = "更新黑名单")
	@PostMapping(value = "/update")
	@ApiImplicitParam(name = "blackList", value = "实体blackList", required = true, dataType = "BlackList")
	public RetResult<Object> update(@RequestBody BlackList blackList){
		blackListService.updateBlackList(blackList); 
		return RetResponse.makeOKRsp();
	}*/
}