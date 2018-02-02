package net.medcrm.yjb.his.omp.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.omp.domain.Employee;
import net.medcrm.yjb.his.omp.domain.EmployeeRelation;
import net.medcrm.yjb.his.omp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Justin on 2017/10/29.
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @ApiOperation(value="新增或者编辑人员",notes="根据参数中是否传入id，判断新增或编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employee",value = "人员基本信息",required = true,dataType = "Employee")
    })
    @PostMapping("/employee")
    public BaseResp insertOrUpdate(@RequestBody Employee employee){
        return new BaseResp(employeeService.insertOrUpdate(employee));
    }


    @ApiOperation(value="批量停用人员",notes="根据listId，批量停用人员")
    @ApiImplicitParam(name="listId",value="id直接用','隔开",required=true,paramType="query",dataType="String")
    @PostMapping("/delete")
    public BaseResp deleteByIds(@RequestParam("listId") String listId){
        return new BaseResp(employeeService.deleteByIds(listId));
    }

    @ApiOperation(value="根据id或者accountId查看人员信息",notes="根据人员id或accountId查看基本信息和组织关系")
    @ApiImplicitParam(name="id",value="id",required=true,paramType="query",dataType="String")
    @GetMapping("/select")
    public BaseResp<Employee> selectById(@RequestParam("id")String id){
        return new BaseResp<Employee>(employeeService.selectById(id));
    }

    @ApiOperation(value="查看人员或人员停用列表",notes="传入id，则查询指定人员列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "指定divisionId,可不传",required = false,dataType = "String"),
            @ApiImplicitParam(name="status",value="状态，启用或停用,0/1,0为启用",required=true,dataType="int")
    })

    @GetMapping(value = "/list")
    public BaseResp<List<Employee>> selectEmployList(@RequestParam("id") String id,@RequestParam("status") int status){
        if(null!=id&&!"".equals(id)){
            return new BaseResp<List<Employee>>(employeeService.selectEmployList(id,status));
        }
       return new BaseResp<List<Employee>>(employeeService.selectAll(status));
    }
}
