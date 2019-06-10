package com.edas.business.tripartite.controller.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.tripartite.entity.robot.CallRule;
import com.edas.business.tripartite.service.robot.CallRuleService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * Description: 重拨规则controller
 * </p>
 * <p>
 * Date：2019年5月7日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "callRule-apis", description = "重拨规则-apis")
@RestController
@RequestMapping("callRule")
public class CallRuleController {
	
	@Autowired
    private CallRuleService callRuleService;
	
	/**
     * 
     * @Description: 查询重拨规则
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年5月7日
     * @author zzw
     */
	@ApiOperation(value = "获取重拨规则列表", notes = "获取重拨规则列表")
    @GetMapping(value = "/list")
    public RetResult<Object> list() throws Exception {       	   
        return RetResponse.makeOKRsp(callRuleService.selectAll());
    }
	
	/**
     * 
     * @Description: 添加
     *
     * @param callRule
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "添加重拨规则", notes = "添加重拨规则")	
	@ApiImplicitParam(name = "callRule", value = "实体callRule", dataType = "CallRule")
	@PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody CallRule callRule) throws Exception {  		
		callRuleService.saveCallRule(callRule);
        return RetResponse.makeOKRsp();
    }
	
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
	@ApiOperation(value = "删除重拨规则", notes = "删除重拨规则")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		callRuleService.deleteCallRule(id);
		return RetResponse.makeOKRsp();
	}
	
	/**
     * 
     * @Description: 更新
     *
     * @param callRule
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "更新重拨规则", notes = "更新重拨规则")
	@ApiImplicitParam(name = "callRule", value = "实体callRule", dataType = "CallRule")
	@PostMapping(value = "/update")
	public RetResult<Object> update(@RequestBody CallRule callRule){
		callRuleService.updateCallRule(callRule); 
		return RetResponse.makeOKRsp();
	}
	
}