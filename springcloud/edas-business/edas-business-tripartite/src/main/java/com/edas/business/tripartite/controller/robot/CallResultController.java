package com.edas.business.tripartite.controller.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.tripartite.service.robot.CallResultService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Description: 通话结果controller
 * </p>
 * <p>
 * Date：2019年5月5日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "callResult-apis", description = "通话结果-apis")
@RestController
@RequestMapping("callResult")
public class CallResultController {
	
	@Autowired
    private CallResultService callResultService;
	
	/**
     * 
     * @Description 查询列表
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "获取通话结果列表", notes = "获取通话结果列表")	
    @GetMapping(value = "/list")
    public RetResult<Object> list() throws Exception { 		
        return RetResponse.makeOKRsp(callResultService.selectAll());
    }
	
	/**
     * 
     * @Description: 添加
     *
     * @param CallResult
     * @return RetResult
     *
     * @date 2019年4月29日
     * @author zzw
     */
	/*@ApiOperation(value = "添加通话结果", notes = "添加通话结果")	
	@ApiImplicitParam(name = "callResult", value = "实体callResult", dataType = "CallResult")
	@PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody CallResult callResult) throws Exception {  		
		callResultService.saveCallResult(callResult);
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
	@ApiOperation(value = "删除通话结果", notes = "删除通话结果")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		callResultService.deleteCallResult(id);
		return RetResponse.makeOKRsp();
	}
	
	/**
     * 
     * @Description: 更新
     *
     * @param CallResult
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	/*@ApiOperation(value = "更新通话结果", notes = "更新通话结果")
	@ApiImplicitParam(name = "callResult", value = "实体callResult", dataType = "CallResult")
	@PostMapping(value = "/update")
	public RetResult<Object> update(@RequestBody CallResult callResult){
		callResultService.updateCallResult(callResult); 
		return RetResponse.makeOKRsp();
	}*/
		
	/**
     * 
     * @Description: 查询通话结果
     *
     * @param taskId,callInstanceId
     * @return RetResult
     *
     * @date 2019年5月5日
     * @author zzw
     */
	@ApiOperation(value = "根据条件获取通话结果", notes = "根据公司id,任务id,通话实例id获取通话结果")
	@ApiImplicitParams({		
		@ApiImplicitParam(name = "companyId", value = "公司id", required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "taskId", value = "任务id", required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "callInstanceId", value = "通话实例id", required = true, dataType = "Integer") 
		})	
    @GetMapping(value = "/get")
    public RetResult<Object> get(@RequestParam(value="companyId",required=true) int companyId,
    		@RequestParam(value="taskId",required=true) int taskId,
    		@RequestParam(value="callInstanceId",required=true) long callInstanceId) throws Exception {  
        return RetResponse.makeOKRsp(callResultService.findByCallInstanceId(companyId, taskId, callInstanceId));
    }
	
}