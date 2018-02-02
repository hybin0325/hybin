package net.medcrm.yjb.his.web.aggregator.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.web.aggregator.configure.ResponseModel;
import net.medcrm.yjb.his.web.aggregator.configure.ResultCode;
import net.medcrm.yjb.his.web.aggregator.service.Division2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Justin on 2017/10/27.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/division2")
public class Division2Controller {
    @Autowired
    Division2Service division2Service;


}
