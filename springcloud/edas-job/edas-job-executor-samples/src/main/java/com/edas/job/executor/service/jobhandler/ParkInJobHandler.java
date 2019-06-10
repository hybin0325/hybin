package com.edas.job.executor.service.jobhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edas.job.core.biz.model.ReturnT;
import com.edas.job.core.handler.IJobHandler;
import com.edas.job.core.handler.annotation.JobHandler;
import com.edas.job.core.log.XxlJobLogger;
import com.edas.job.executor.fegin.MsgFeign;

@JobHandler(value = "parkInJobHandler")
@Component
public class ParkInJobHandler extends IJobHandler {
	@Autowired
	private MsgFeign msgFeign;

	@Override
	public ReturnT<String> execute(String param) throws Exception {
		System.out.println("车入场发消息");
		XxlJobLogger.log("车入场发消息");
		msgFeign.getCarParkInLogs();
		return SUCCESS;
	}
}
