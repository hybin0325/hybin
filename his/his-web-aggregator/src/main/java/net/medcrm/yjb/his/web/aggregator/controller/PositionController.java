package net.medcrm.yjb.his.web.aggregator.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.web.aggregator.configure.ResponseModel;
import net.medcrm.yjb.his.web.aggregator.configure.Result;
import net.medcrm.yjb.his.web.aggregator.configure.ResultCode;
import net.medcrm.yjb.his.web.aggregator.dto.DivisionRePosition;
import net.medcrm.yjb.his.web.aggregator.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Justin on 2017/10/31.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/position")
public class PositionController {
    @Autowired
    PositionService positionService;


    @ApiOperation(value="删除角色内的人员",notes="根据divisionId，positionId，employeeId")
    @ApiImplicitParam(name="map",value="map",required=true,paramType="body",dataType="Map")
    @PostMapping(value = "/delete")
    public Object deletePosiEmploy(DivisionRePosition divisionRePosition){
        return new ResponseModel(ResultCode.SUCCESS,positionService.deletePosiEmploy(divisionRePosition));
    }
}
