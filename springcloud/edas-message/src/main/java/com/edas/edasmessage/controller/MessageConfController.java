package com.edas.edasmessage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.edas.edasmessage.entity.MessageConf;
import com.edas.edasmessage.service.MessageConfService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
* @ClassName: MessageConfController
* @Description: 密钥配置
* @author nl
* @date 2019年4月15日
*
 */
@Slf4j
@RestController
@RequestMapping("/msg/confkey")
//@Api(value = "/msg/confkey",tags = "密钥配置")
public class MessageConfController {
	
	@Autowired
	private MessageConfService messageConfService;

	@ApiOperation(value = "密钥配置查询", notes = "密钥配置查询")
	@PostMapping(value = "/page")
	public RetResult<Object> findByPage() throws Exception {
		return RetResponse.makeOKRsp(messageConfService.findAll());
	}
	
	@ApiOperation(value = "新增密钥配置", notes = "新增密钥配置")
	@ApiImplicitParam(name = "messageConf", value = "实体messageConf", dataType = "MessageConf")
	@PostMapping(value = "/save")
	public RetResult<Object> save(@RequestBody MessageConf messageConf) throws Exception {
		messageConfService.saveMessageConf(messageConf);
		return RetResponse.makeOKRsp();
	}
	
	
	@ApiOperation(value = "修改密钥配置", notes = "修改密钥配置")
	@ApiImplicitParam(name = "messageConf", value = "实体messageConf", dataType = "MessageConf")
	@PostMapping(value = "/edit")
	public RetResult<Object> edit(@RequestBody MessageConf messageConf) throws Exception {
		messageConfService.updateMessageConf(messageConf);
		return RetResponse.makeOKRsp();
	}
	
	@ApiOperation(value = "密钥配置查询", notes = "密钥配置查询")
	@ApiImplicitParam(name = "messageConf", value = "实体messageConf", dataType = "MessageConf")
	@PostMapping(value = "/list")
	public RetResult<Object> findByList(@RequestBody MessageConf messageConf) throws Exception {
		return RetResponse.makeOKRsp(messageConfService.findByList(messageConf));
	}
	
	
	@ApiOperation(value = "查询密钥配置", notes = "查询密钥配置")
	@ApiImplicitParam(name = "id", value = "id", dataType = "int")
	@PostMapping(value = "/findById")
	public RetResult<Object> findById(@RequestParam(value = "id", required = true) int id ) throws Exception {
		
		return RetResponse.makeOKRsp(messageConfService.getMessageConf(id));
	}
	
	
	@ApiOperation(value = "查询密钥配置", notes = "查询密钥配置")
	@ApiImplicitParam(name = "typeKey", value = "typeKey", dataType = "String")
	@PostMapping(value = "/findByTypeKey")
	public RetResult<Object> findById(@RequestParam(value = "typeKey", required = true) String  typeKey ) throws Exception {
		
		return RetResponse.makeOKRsp(messageConfService.findByType(typeKey));
	}
	
	
	@ApiOperation(value = "删除密钥配置", notes = "删除密钥配置")
	@ApiImplicitParam(name = "id", value = "id", dataType = "int")
	@PostMapping(value = "/delete")
	public RetResult<Object> delete(@RequestParam(value = "id", required = true) int id ) throws Exception {
		messageConfService.deleteMessageConf(id);
		return RetResponse.makeOKRsp();
	}

}
