package com.edas.business.tripartite.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edas.edascommon.utils.web.RetResult;

@FeignClient(value ="edas-data")
public interface ZtConfigkeyFeign {
	/**
	 * 查询
	 */
	@PostMapping("/ztconfigkey/findByType")
	public RetResult<Object> findByType(@RequestParam(value = "type") String  type ) ;
}
