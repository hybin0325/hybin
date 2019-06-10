package com.edas.edasmessage.task;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edas.edascommon.utils.DateUtils;
import com.edas.edasmessage.entity.MessageConf;
import com.edas.edasmessage.entity.req.CarInParkDataReq;
import com.edas.edasmessage.service.DeliyunService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadCarPark {
	@Autowired
	private DeliyunService deliyunService;
	
	
}
