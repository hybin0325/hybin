package net.medcrm.yjb.his.omp.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.omp.domain.Division;
import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import net.medcrm.yjb.his.omp.service.DivisionRePositionService;
import net.medcrm.yjb.his.omp.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/division")
public class DivisionController {

    @Autowired
    DivisionService divisionService;
    @Autowired
    DivisionRePositionService divisionRePositionService;


    @ApiOperation(value="根据id获取机构、部门或工作组的基本信息",notes="根据id获取机构、部门或工作组的基本信息")
    @ApiImplicitParam(name="id",value="id",required=true,paramType="query",dataType="String")
    @GetMapping("/select")
    public BaseResp<Division> selectBasicById(@RequestParam("id") String id){
        return new BaseResp<Division>(divisionService.selectBasicById(id));
    }

    @ApiOperation(value="根据divisionId查询角色列表",notes="根据divisionId查询角色列表")
    @ApiImplicitParam(name="id",value="id",required=true,paramType="query",dataType="String")
    @GetMapping("/positions")
    public BaseResp<List<DivisionRePosition>> selectPositionsById(String id){
        return new BaseResp<List<DivisionRePosition>>(divisionRePositionService.selectPositionsById(id));
    }

    @ApiOperation(value="获取机构列表",notes="获取所有机构列表")
    @GetMapping("/legalentitys")
    public BaseResp<List<Division>> selectAll(){
        return new BaseResp<List<Division>>(divisionService.selectAll());
    }

    @ApiOperation(value="获取某个机构下的部门、工作组列表(或已停用列表),以及人员信息",notes="根据show决定是否展示人员，Y/N,Y则展示,status=1为停用，0为正常")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "机构id",required = true,dataType = "String"),
            @ApiImplicitParam(name = "show",value = "Y/N",required = true,dataType = "String"),
            @ApiImplicitParam(name = "status",value = "状态0/1",required = true,dataType = "int"),

    })
    @GetMapping("/list")
    public BaseResp<List<Division>> selectDivisionChildById(@RequestParam("id") String id,@RequestParam("show") String show,@RequestParam("status")int status){
        return new BaseResp<List<Division>>(divisionService.selectDivisionChildById(id,show,status));
    }

    @ApiOperation(value="获取机构、部门或工作组已停用列表",notes="根据diviType，获取已停用列表")
    @GetMapping("/suspend")
    public BaseResp<List<Division>> selectSuspendAll(@RequestParam("diviType") int diviType){
        return new BaseResp<>(divisionService.selectSuspendAll(diviType));
    }



    @ApiOperation(value="新增或编辑机构、部门和工作组",notes="通过传入的diviType区分")
    @ApiImplicitParam(name="division",value="Division",required=true,dataType="Division")
    @PostMapping("/division")
    public BaseResp insertOrUpdate(Division division){
        return new BaseResp(divisionService.insertOrUpdate(division));
    }

    @ApiOperation(value="根据id对机构、部门或工作组进行批量逻辑删除",notes="id之间用','隔开,含有子机构的不能被直接删除")
    @ApiImplicitParam(name="listId",value="id",required=true,paramType="query",dataType="String")
    @PostMapping("/delete")
    public BaseResp deleteByListId(@RequestParam("listId") String listId){
        return new BaseResp(divisionService.deleteByListId(listId));
    }

}
