package com.edas.business.byrobot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.byrobot.service.CallRecordService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * File Name: CallRecordController.java
 * </p>
 * <p>
 * Description: 电话录音controller
 * </p>
 * <p>
 * Date：2019年5月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "callRecord-apis", description = "录音文件-apis")
@RestController
@RequestMapping("callRecord")
public class CallRecordController {
	
	@Autowired
    private CallRecordService callRecordService;
	
	/**
     * 
     * @Description: 根据id查询
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年5月6日
     * @author zzw
     */
	@ApiOperation(value = "根据id查询电话录音", notes = "根据id查询电话录音")
	@ApiImplicitParam(name = "id", value = "主键", dataType = "String")
    @GetMapping(value = "/get/{id}")
    public RetResult<Object> get(@PathVariable("id") String id) throws Exception { 		
        return RetResponse.makeOKRsp(callRecordService.selectById(id));
    }
	
	/**
     * 
     * @Description: 查询列表
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年5月6日
     * @author zzw
     */
	@ApiOperation(value = "获取电话录音", notes = "获取电话录音")	
    @GetMapping(value = "/list")
    public RetResult<Object> list() throws Exception { 		
        return RetResponse.makeOKRsp(callRecordService.selectAll());
    }
	
	/**
     * 
     * @Description: 添加电话录音
     *
     * @param callRecord
     * @return RetResult
     *
     * @date 2019年5月6日
     * @author zzw
     */
	/*@ApiOperation(value = "添加电话录音", notes = "添加电话录音")	
	@ApiImplicitParam(name = "callRecord", value = "实体callRecord", dataType = "CallRecord")
	@PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody CallRecord callRecord) throws Exception {  		
		callRecordService.saveCallRecord(callRecord);
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
	@ApiOperation(value = "删除电话录音", notes = "删除电话录音")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		callRecordService.deleteCallRecord(id);
		return RetResponse.makeOKRsp();
	}
	
	/**
     * 
     * @Description: 更新
     *
     * @param callRecord
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	/*@ApiOperation(value = "更新电话录音", notes = "更新电话录音")
	@ApiImplicitParam(name = "callRecord", value = "实体callRecord", dataType = "CallRecord")
	@PostMapping(value = "/update")
	public RetResult<Object> update(@RequestBody CallRecord callRecord){
		callRecordService.updateCallRecord(callRecord); 
		return RetResponse.makeOKRsp();
	}*/

}