package net.medcrm.yjb.his.web.aggregator.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.web.aggregator.configure.ResponseModel;
import net.medcrm.yjb.his.web.aggregator.configure.ResultCode;
import net.medcrm.yjb.his.web.aggregator.dto.Division;
import net.medcrm.yjb.his.web.aggregator.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/division")
public class DivisionController {

    @Autowired DivisionService divisionService;

    @ApiOperation(value="根据id获取机构、部门或工作组的基本信息",notes="根据id获取机构、部门或工作组的基本信息")
    @ApiImplicitParam(name="id",value="id",required=true,paramType="query",dataType="String")
    @GetMapping( value="/select")
    public Object selectById(@RequestParam("id") String id){
        return new BaseResp<Division>(ResultStatus.SUCCESS,divisionService.selectBasicById(id));
    }

    @ApiOperation(value="获取机构列表",notes="获取所有机构列表")
    @GetMapping( value="/legalentitys")
    public Object selectAll(){
        return new BaseResp<List<Division>>(divisionService.selectAll());
    }

    @ApiOperation(value="获取机构、部门或工作组已停用列表",notes="根据diviType，获取已停用列表")
    @GetMapping( value="/suspend")
    public Object selectsuspendAll(@RequestParam("diviType") int diviType){
        BaseResp resp = new BaseResp();
        resp.setData(divisionService.selectSuspendAll(diviType));
        return resp;
    }

    @ApiOperation(value="新增或编辑机构、部门和工作组",notes="通过传入的diviType区分")
    @ApiImplicitParam(name="division",value="Division",required=true,dataType="Division")
    @PostMapping( value="/division")
    public Object insertOrUpdate(@RequestBody Division division){
        try{
            divisionService.insertOrUpdate(division);
            return new BaseResp<String>( ResultStatus.SUCCESS);
        }catch (Exception e){
            return new BaseResp<String>( ResultStatus.FAIL);
        }


    }


    @ApiOperation(value="根据id对机构、部门或工作组进行批量逻辑删除",notes="id之间用','隔开,含有子机构的不能被直接删除")
    @ApiImplicitParam(name="listId",value="id",required=true,paramType="query",dataType="String")
    @PostMapping( value = "/delete")
    public Object deleteByListId(@RequestParam("listId")String listId){
        return new ResponseModel(ResultCode.SUCCESS,divisionService.deleteByListId(listId));
    }

    @ApiOperation(value="根据divisionId查询角色列表",notes="根据divisionId查询角色列表")
    @ApiImplicitParam(name="id",value="id",required=true,paramType="query",dataType="String")
    @GetMapping( value = "/positions")
    public Object selectPositionsById(@RequestParam("id")String id){
        return new ResponseModel(ResultCode.SUCCESS,divisionService.selectPositionsById(id));
    }
}
