package com.edas.business.data.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.utils.web.RetResult;


@FeignClient(value ="edas-message",fallbackFactory = MessageFeignFallbackFactory.class)
public interface MessageFeign {
	
	/**
	 * 封装后的数据发送到队列 
	 * @param message 
	 * @return
	 */
	 @PostMapping("/api/senderMsg")
	 public RetResult<String> senderMsg(@RequestBody MQDataMsg message);

}
