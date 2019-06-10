package com.edas.business.byrobot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.byrobot.entity.Company;
import com.edas.business.byrobot.service.CompanyService;
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
 * File Name: CompanyController.java
 * </p>
 * <p>
 * Description: 公司controller
 * </p>
 * <p>
 * Date：2019年4月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Api(tags = "company-apis", description = "公司-apis")
@RestController
@RequestMapping("company")
public class CompanyController {

	@Autowired
    private CompanyService companyService;
	
	/**
     * 
     * @Description: 查询
     *
     * @param null
     * @return RetResult
     *
     * @date 2019年4月28日上午11:52:58
     * @author zzw
     */
	@ApiOperation(value = "获取公司列表", notes = "获取公司列表")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "page", value = "page",  required = true, dataType = "Integer"),
		@ApiImplicitParam(name = "size", value = "size",  required = true, dataType = "Integer")
	})
    @GetMapping(value = "/list")
    public RetResult<Object> list(@RequestParam(value="page",required = true) int page, 
    		@RequestParam(value="size",required = true) int size) throws Exception {   
		PageHelper.startPage(page, size);
		List<Company> list = companyService.selectAll();
		PageInfo<Company> pageInfo = new PageInfo<Company>(list);
        return RetResponse.makeOKRsp(pageInfo);
    }
	
	/**
     * 
     * @Description: 增加公司
     *
     * @param company
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "增加公司", notes = "增加公司")
	@ApiImplicitParam(name = "company", value = "实体company", dataType = "Company")
    @PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody Company company) throws Exception {
		companyService.saveCompany(company);
        return RetResponse.makeOKRsp();
    }
	
	/**
     * 
     * @Description: 删除公司
     *
     * @param id
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "删除公司", notes = "删除公司")
	@ApiImplicitParam(name = "id", value = "id", dataType = "String")
	@PostMapping(value = "/delete/{id}")
	public RetResult<Object> delete(@PathVariable("id") String id){
		companyService.deleteCompany(id);
		return RetResponse.makeOKRsp();
	}
	
	/**
     * 
     * @Description: 更新公司
     *
     * @param company
     * @return RetResult
     *
     * @date 2019年5月8日
     * @author zzw
     */
	@ApiOperation(value = "更新公司", notes = "更新公司")
	@ApiImplicitParam(name = "company", value = "实体company", dataType = "Company")
	@PostMapping(value = "/update")
	public RetResult<Object> update(@RequestBody Company company){
		companyService.updateCompany(company); 
		return RetResponse.makeOKRsp();
	}
}
