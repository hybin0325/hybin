package com.edas.business.data.feign;

import com.edas.edascommon.utils.web.RetResult;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageFeignFallbackFactory implements FallbackFactory<MessageFeign> {

	@Override
	public MessageFeign create(Throwable cause) {
		log.info("fallback; reason was: {}", cause.getMessage());
		return id ->{
			return new RetResult();
		};
	}

}
