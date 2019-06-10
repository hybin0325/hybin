package com.edas.job.executor.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.edas.edascommon.model.Result;


//@FeignClient(value = "edas-message",  fallbackFactory = MsgFeignFallbackFactory.class)
@FeignClient(name = "edas-message", url = "http://14.152.78.200:13012/api-msg")
//@FeignClient(name = "edas-message", url = "http://192.168.4.164:16088")
public interface MsgFeign {
	@PostMapping(value = "/api/getTest") 
	public Result test();
	
	@PostMapping(value = "/api/carParkInLogs")
	public Result getCarParkInLogs();
	
	@PostMapping(value = "/api/carParkOutLogs") 
	public Result getCarParkOutLogs();
}
