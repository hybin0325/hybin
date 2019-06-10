package com.edas.business.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.data.entity.ZtConfigkey;
import com.edas.business.data.service.ZtConfigkeyService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ztconfigkey")
public class ZtConfigkeyController {
	
	@Autowired
	private ZtConfigkeyService ztConfigkeyService;

	
	
	@ApiOperation(value = "新增密钥配置", notes = "新增密钥配置")
	@ApiImplicitParam(name = "messageConf", value = "实体messageConf", dataType = "ZtConfigkey")
	@PostMapping(value = "/save")
	public RetResult<Object> save(@RequestBody ZtConfigkey conf) throws Exception {
		ztConfigkeyService.saveZtConfigkey(conf);
		return RetResponse.makeOKRsp();
	}
	
	
	@ApiOperation(value = "修改密钥配置", notes = "修改密钥配置")
	@ApiImplicitParam(name = "conf", value = "实体conf", dataType = "ZtConfigkey")
	@PostMapping(value = "/edit")
	public RetResult<Object> edit(@RequestBody ZtConfigkey messageConf) throws Exception {
		ztConfigkeyService.updateZtConfigkey(messageConf);
		return RetResponse.makeOKRsp();
	}
	
	@ApiOperation(value = "密钥配置查询", notes = "密钥配置查询")
	@ApiImplicitParam(name = "conf", value = "实体conf", dataType = "ZtConfigkey")
	@PostMapping(value = "/list")
	public RetResult<Object> findByList(@RequestBody ZtConfigkey conf) throws Exception {
		return RetResponse.makeOKRsp(ztConfigkeyService.findByList(conf));
	}
	
	
	@ApiOperation(value = "查询密钥配置", notes = "查询密钥配置")
	@ApiImplicitParam(name = "id", value = "id", dataType = "int")
	@PostMapping(value = "/findById")
	public RetResult<Object> findById(@RequestParam(value = "id", required = true) int id ) throws Exception {
		
		return RetResponse.makeOKRsp(ztConfigkeyService.getZtConfigkey(id));
	}
	
	
	@ApiOperation(value = "查询密钥配置", notes = "查询密钥配置")
	@ApiImplicitParam(name = "type", value = "type", dataType = "String")
	@PostMapping(value = "/findByType")
	public RetResult<Object> findByType(@RequestParam(value = "type", required = true) String  type ) throws Exception {
		return RetResponse.makeOKRsp(ztConfigkeyService.findByType(type));
	}
	
	@ApiOperation(value = "删除密钥配置", notes = "删除密钥配置")
	@ApiImplicitParam(name = "id", value = "id", dataType = "int")
	@PostMapping(value = "/delete")
	public RetResult<Object> delete(@RequestParam(value = "id", required = true) int id ) throws Exception {
		ztConfigkeyService.deleteZtConfigkey(id);
		return RetResponse.makeOKRsp();
	}


}
