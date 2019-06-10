package com.edas.edasusers.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edas.edascommon.utils.web.RetResult;
import com.edas.edasusers.entity.CarParkReq;


//@FeignClient(value = "edas-message",  fallbackFactory = MsgFeignFallbackFactory.class)
@FeignClient(name = "edas-message", url = "http://14.152.78.200:13012/api-msg")
public interface MsgFeign {
	@PostMapping(value = "/api/addCarInPark")
	public RetResult<String> addCarInPark(@RequestBody CarParkReq req);
}
