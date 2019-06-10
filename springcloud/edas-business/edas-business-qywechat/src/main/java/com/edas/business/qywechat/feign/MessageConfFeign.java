package com.edas.business.qywechat.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edas.business.qywechat.entity.req.MessageConfDTO;
import com.edas.edascommon.utils.web.RetResult;

@FeignClient(value ="edas-message")
public interface MessageConfFeign {

	 @PostMapping("/msg/confkey/save")
	 public RetResult<Object> saveMessageConf(@RequestBody  MessageConfDTO messageConf);
	 
	 @PostMapping("/msg/confkey/edit")
	 public RetResult<String> updateMessageConf(@RequestBody  MessageConfDTO messageConf);
	 
	 @PostMapping("/msg/confkey/delete")
	 public RetResult<String> deleteMessageConf(@RequestBody  MessageConfDTO messageConf);
	 
	 @PostMapping("/msg/confkey/list")
	 public RetResult<List<MessageConfDTO>> findListMessageConf(@RequestBody  MessageConfDTO messageConf);
}
