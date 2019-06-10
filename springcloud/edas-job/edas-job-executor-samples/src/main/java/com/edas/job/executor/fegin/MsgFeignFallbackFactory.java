package com.edas.job.executor.fegin;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MsgFeignFallbackFactory implements FallbackFactory<MsgFeign> {
	
	
	@Override
    public MsgFeign create(Throwable throwable) {
		log.info("fallback; reason was: {}", throwable.getMessage());
		return null;
		
    }

}
