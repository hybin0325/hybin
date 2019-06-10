package com.edas.business.tripartite.controller.robot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.tripartite.entity.robot.UserPhone;
import com.edas.business.tripartite.service.robot.UserPhoneService;
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
 * Description: 主叫电话controller
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "userPhone-apis", description = "主叫电话-apis")
@RestController
@RequestMapping("userPhone")
public class UserPhoneController {
	
	@Autowired
    private UserPhoneService userPhoneService;
	
	/**
     * 
     * @Description: 根据公司id查询主叫电话
     *
     * @param companyId
     * @return list
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@ApiOperation(value = "根据公司id查询主叫电话", notes = "根据公司id查询主叫电话")
	@ApiImplicitParam(name = "companyId", value = "公司id", required = true, dataType = "Integer")
    @GetMapping(value = "/get")
    public RetResult<Object> get(@RequestParam(value="companyId",required = true) int companyId) throws Exception {  
        return RetResponse.makeOKRsp(userPhoneService.findByCompanyId(companyId));
    }
	
	/**
     * 
     * @Description 查询主叫电话
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年5月6日
     * @author zzw
     */
	@ApiOperation(value = "获取主叫电话列表", notes = "获取主叫电话列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "page",  required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "size", value = "size",  required = true, dataType = "Integer")
	})
    @GetMapping(value = "/list")
    public RetResult<Object> list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {
		PageHelper.startPage(page, size);
		List<UserPhone> list = userPhoneService.selectAll();
		PageInfo<UserPhone> pageInfo = new PageInfo<UserPhone>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
	
	/**
     * 
     * @Description: 添加
     *
     * @param CallDetail
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "添加主叫电话", notes = "添加主叫电话")	
	@ApiImplicitParam(name = "userPhone", value = "实体userPhone", dataType = "UserPhone")
	@PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody UserPhone userPhone) throws Exception {  		
		userPhoneService.saveUserPhone(userPhone);
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
	@ApiOperation(value = "删除主叫电话", notes = "删除主叫电话")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		userPhoneService.deleteUserPhone(id);
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
	@ApiOperation(value = "更新主叫电话", notes = "更新主叫电话")
	@ApiImplicitParam(name = "userPhone", value = "实体userPhone", dataType = "UserPhone")
	@PostMapping(value = "/update")
	public RetResult<Object> update(@RequestBody UserPhone userPhone){
		userPhoneService.updateUserPhone(userPhone); 
		return RetResponse.makeOKRsp();
	}
	
}