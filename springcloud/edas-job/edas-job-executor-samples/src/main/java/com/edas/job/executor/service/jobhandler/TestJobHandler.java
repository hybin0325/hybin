package com.edas.job.executor.service.jobhandler;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.edas.job.core.biz.model.ReturnT;
import com.edas.job.core.handler.IJobHandler;
import com.edas.job.core.handler.annotation.JobHandler;
import com.edas.job.core.log.XxlJobLogger;



@JobHandler(value = "testJobHandler")
@Component
public class TestJobHandler extends IJobHandler {
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		System.out.println("老嬷嬷来了");
		XxlJobLogger.log("老嬷嬷来了");

		for (int i = 0; i < 5; i++) {
			XxlJobLogger.log("beat at:" + i);
			TimeUnit.SECONDS.sleep(2);
		}
		return SUCCESS;
	}
}
