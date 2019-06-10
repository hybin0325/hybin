package com.edas.job.executor.service.jobhandler;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edas.job.core.biz.model.ReturnT;
import com.edas.job.core.handler.IJobHandler;
import com.edas.job.core.handler.annotation.JobHandler;
import com.edas.job.core.log.XxlJobLogger;
import com.edas.job.executor.fegin.MsgFeign;

@JobHandler(value = "msgJobHandler")
@Component
public class MsgJobHandler extends IJobHandler {
	@Autowired
	private MsgFeign msgFeign;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		System.out.println("测试发消息");
		XxlJobLogger.log("测试发消息");
		msgFeign.test();
		for (int i = 0; i < 5; i++) {
			XxlJobLogger.log("beat at:" + i);
			TimeUnit.SECONDS.sleep(2);
		}
		return SUCCESS;
	}
}
