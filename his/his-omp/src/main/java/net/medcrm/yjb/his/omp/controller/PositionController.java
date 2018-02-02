package net.medcrm.yjb.his.omp.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import net.medcrm.yjb.his.omp.domain.Position;
import net.medcrm.yjb.his.omp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Justin on 2017/10/26.
 */
@RestController
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    PositionService positionService;


    @ApiImplicitParam(name="divisionRePositions",value="集合",required=true,dataType="List")
    @PostMapping("/update")
    public BaseResp updatePosiEmploy(List<DivisionRePosition> divisionRePositions){
        return new BaseResp(positionService.updatePosiEmploy(divisionRePositions));
    }

    @ApiOperation(value="删除机构、部门或工作组中的角色人员",notes="删除机构、部门或工作组中的角色人员")
    @ApiImplicitParam(name="divisionRePosition",value="divisionRePosition",required=true,dataType="DivisionRePosition")
    @PostMapping("/delete")
    public BaseResp deletePosiEmploy(DivisionRePosition divisionRePosition){
        return new BaseResp(positionService.deletePosiEmploy(divisionRePosition));
    }

    @ApiOperation(value="根据type和exclusive获取角色列表",notes="获取公有角色或者独有角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type",value = "角色类型，1/2/3",required = true,dataType = "int"),
            @ApiImplicitParam(name = "exclusive",value = "是否独有,0/1,0为公有",required = true,dataType = "int")
    })
    @GetMapping("/positions")
    public BaseResp<List<Position>> selectByType(@RequestParam("type") int type,@RequestParam("exclusive") int exclusive){
        return new BaseResp<List<Position>>(positionService.selectByType(type,exclusive));
    }
}
