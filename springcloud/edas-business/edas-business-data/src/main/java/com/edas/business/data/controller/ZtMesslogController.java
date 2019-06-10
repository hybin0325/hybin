package com.edas.business.data.controller;

import com.edas.business.data.entity.ZtMesssendlog;
import com.edas.business.data.service.ZtMesssendlogService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/ztmesslog")
public class ZtMesslogController {

    @Autowired
    ZtMesssendlogService ztMesssendlogService;

    @ApiOperation(value = "发送记录查询", notes = "发送记录查询")
    @ApiImplicitParam(name = "conf", value = "实体conf", dataType = "ZtMesssendlog")
    @PostMapping(value = "/list")
    public RetResult<Object> findByList(@RequestBody ZtMesssendlog conf) throws Exception {

        return RetResponse.makeOKRsp(ztMesssendlogService.findByList(conf));
    }


}
