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

import com.edas.business.tripartite.entity.robot.Customer;
import com.edas.business.tripartite.service.robot.CustomerService;
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
 * File Name: CustomerController.java
 * </p>
 * <p>
 * Description: 任务客户controller
 * </p>
 * <p>
 * Date：2019年5月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "customer-apis", description = "客户-apis")
@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;
	
	/**
     * 
     * @Description: 根据公司id查询
     *
     * @param companyId
     * @return RetResult
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@ApiOperation(value = "根据公司id查询", notes = "根据公司id查询")
	@ApiImplicitParam(name = "companyId", value = "公司id", required = true, dataType = "Integer")
    @GetMapping(value = "/get")
    public RetResult<Object> get(@RequestParam(value="companyId", required = true) int companyId) throws Exception {  
        return RetResponse.makeOKRsp(customerService.findByCompanyId(companyId));
    }
	
	/**
     * 
     * @Description 查询任务客户
     *
     * @return RetResult
     *
     * @date 2019年5月6日
     * @author zzw
     */
	@ApiOperation(value = "获取任务客户列表", notes = "获取任务客户列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "page",  required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "size", value = "size",  required = true, dataType = "Integer")
	})
    @GetMapping(value = "/list")
    public RetResult<Object> list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {
		PageHelper.startPage(page, size);
		List<Customer> list = customerService.selectAll();
		PageInfo<Customer> pageInfo = new PageInfo<Customer>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
	
	/**
     * 
     * @Description: 添加
     *
     * @param customer
     * @return RetResult
     *
     * @date 2019年4月29日
     * @author zzw
     */
	@ApiOperation(value = "添加任务客户", notes = "添加任务客户")	
	@ApiImplicitParam(name = "customer", value = "实体customer", dataType = "Customer")
	@PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody Customer customer) throws Exception {  		
		customerService.saveCustomer(customer);
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
	@ApiOperation(value = "删除任务客户", notes = "删除任务客户")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		customerService.deleteCustomer(id);
		return RetResponse.makeOKRsp();
	}
	
	/**
     * 
     * @Description: 更新
     *
     * @param customer
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "更新任务客户", notes = "更新任务客户")
	@ApiImplicitParam(name = "customer", value = "实体customer", dataType = "Customer")
	@PostMapping(value = "/update")
	public RetResult<Object> update(@RequestBody Customer customer){
		customerService.updateCustomer(customer); 
		return RetResponse.makeOKRsp();
	}
	
}