package com.edas.business.tripartite.controller.robot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.tripartite.entity.robot.CallDetail;
import com.edas.business.tripartite.service.robot.CallDetailService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Description: 通话详情controller
 * </p>
 * <p>
 * Date：2019年4月30日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "callDetail-apis", description = "通话详情-apis")
@RestController
@RequestMapping("callDetail")
public class CallDetailController {
	
	@Autowired
    private CallDetailService callDetailsService;
	

	/**
     * 
     * @Description 查询通话详情
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年5月6日
     * @author zzw
     */
	@ApiOperation(value = "获取通话详情列表", notes = "获取通话详情列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "page",  required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "size", value = "size",  required = true, dataType = "Integer")
	})
    @GetMapping(value = "/list")
    public RetResult<Object> list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception { 
		PageHelper.startPage(page, size);
		List<CallDetail> list = callDetailsService.selectAll();
		PageInfo<CallDetail> pageInfo = new PageInfo<CallDetail>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
	
	/**
     * 
     * @Description: 添加
     *
     * @param CallDetail
     * @return RetResult
     *
     */
	/*@ApiOperation(value = "添加通话详情", notes = "添加通话详情")	
	@ApiImplicitParam(name = "callDetail", value = "实体callDetail", dataType = "CallDetail")
	@PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody CallDetail callDetail) throws Exception {  		
		callDetailsService.saveCallDetail(callDetail);
        return RetResponse.makeOKRsp();
    }*/
	
	/**
     * 
     * @Description: 删除
     *
     * @param id
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "删除通话详情", notes = "删除通话详情")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		callDetailsService.deleteCallDetail(id);
		return RetResponse.makeOKRsp();
	}
	
	/**
     * 
     * @Description: 更新
     *
     * @param callDetail
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	/*@ApiOperation(value = "更新通话详情", notes = "更新通话详情")
	@PostMapping(value = "/update")
	@ApiImplicitParam(name = "callDetail", value = "实体callDetail", dataType = "CallDetail")
	public RetResult<Object> update(@RequestBody CallDetail callDetail){
		callDetailsService.updateCallDetail(callDetail); 
		return RetResponse.makeOKRsp();
	}*/
	
	
	/**
     * 
     * @Description: 查询通话详情
     *
     * @param id
     * @return RetResult
     *
     * @date 2019年4月30日
     * @author zzw
     */
	@ApiOperation(value = "获取通话详情", notes = "获取通话详情")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "cmopanyId", value = "公司id", required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "taskId", value = "任务id", required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "callInstanceId", value = "任务实例id", required = true, dataType = "Integer") 
		})	
    @GetMapping(value = "/get")
    public RetResult<Object> get(@RequestParam(value="taskId",required=true) int taskId,
    		@RequestParam(value="cmopanyId",required=true) int cmopanyId,
    		@RequestParam(value="callInstanceId",required=true) long callInstanceId) throws Exception {  
        return RetResponse.makeOKRsp(callDetailsService.findByCallInstanceId(cmopanyId, taskId, callInstanceId));
    }
	
}