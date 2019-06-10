package com.edas.business.qywechat.feign;

import com.edas.business.qywechat.entity.ZtMesssendlog;
import com.edas.edascommon.utils.web.RetResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value ="edas-business-data")
public interface ZtMesslogFeign {

	/**
	 * 查询
	 */
	@PostMapping("/ztmesslog/list")
	public RetResult<Object> findByList(@RequestBody ZtMesssendlog conf);

}
