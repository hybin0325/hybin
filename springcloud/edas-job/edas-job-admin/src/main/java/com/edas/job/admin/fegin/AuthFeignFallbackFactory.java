package com.edas.job.admin.fegin;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthFeignFallbackFactory implements FallbackFactory<AuthFeign> {
	
	
	@Override
    public AuthFeign create(Throwable throwable) {
		log.info("fallback; reason was: {}", throwable.getMessage());
		return null;
		
    }

}
