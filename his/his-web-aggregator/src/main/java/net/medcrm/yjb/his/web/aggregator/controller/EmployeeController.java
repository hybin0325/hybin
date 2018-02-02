package net.medcrm.yjb.his.web.aggregator.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.web.aggregator.configure.ResponseModel;
import net.medcrm.yjb.his.web.aggregator.configure.ResultCode;
import net.medcrm.yjb.his.web.aggregator.dto.Employee;
import net.medcrm.yjb.his.web.aggregator.dto.EmployeeRelation;
import net.medcrm.yjb.his.web.aggregator.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Justin on 2017/10/29.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @ApiOperation(value="新增或者编辑人员",notes="根据参数中是否传入id，判断新增或编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employee",value = "人员基本信息",required = true,dataType = "Employee")
    })
    @PostMapping( value = "/employee")
    public Object insert(@RequestBody Employee employee){
        return new ResponseModel(ResultCode.SUCCESS,employeeService.insertOrUpdate(employee));
    }



    @ApiOperation(value="批量停用人员",notes="根据listId，批量停用人员")
    @ApiImplicitParam(name="listId",value="id直接用','隔开",required=true,paramType="query",dataType="String")
    @PostMapping(value = "/delete")
    public Object deleteByIds( String listId){
        return new ResponseModel(ResultCode.SUCCESS,employeeService.deleteByIds(listId));
    }

    @ApiOperation(value="查看人员信息",notes="根据人员id，查看基本信息和组织关系")
    @ApiImplicitParam(name="id",value="id",required=true,paramType="query",dataType="String")
    @GetMapping(value = "/select")
    public Object selectById(String id){
        return new ResponseModel(ResultCode.SUCCESS,employeeService.selectById(id));
    }

    @ApiOperation(value="查看指定部门的人员列表",notes="根据divisionId，查询人员列表")
    @ApiImplicitParam(name="id",value="id",required=true,paramType="query",dataType="String")
    @GetMapping(value = "/list")
    public Object selectEmployList(@RequestParam("id") String id){
        return new ResponseModel(ResultCode.SUCCESS,employeeService.selectEmployList(id));
    }
}
