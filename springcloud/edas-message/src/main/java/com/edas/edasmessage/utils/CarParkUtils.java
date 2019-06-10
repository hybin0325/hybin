package com.edas.edasmessage.utils;

import com.edas.edascommon.utils.DateUtils;
import com.edas.edascommon.utils.LocalDateUtils;
import com.edas.edascommon.utils.SystemClock;
import com.edas.edasmessage.entity.req.CarInParkDataReq;
import com.edas.edasmessage.entity.req.CarOutParkDataReq;

public class CarParkUtils {
	
	private static final int PAGE_NO=1;
	private static final int PAGE_SIZE=20;
	
	public static CarInParkDataReq getCarInParkDataReq() {
		CarInParkDataReq cdata = new CarInParkDataReq();
		cdata.setPage(PAGE_NO);
		cdata.setSize(PAGE_SIZE);
		//Long currentTime = System.currentTimeMillis();
		Long currentTime=SystemClock.millisClock().now();
		cdata.setInTimeStart(LocalDateUtils.getAgoMinutes10(currentTime) / 1000);
		cdata.setInTimeEnd(currentTime / 1000);
		return cdata;
	}

	public static CarOutParkDataReq getCarOutParkDataReq() {
		CarOutParkDataReq data = new CarOutParkDataReq();
		data.setPage(PAGE_NO);
		data.setSize(PAGE_SIZE);
		//Long currentTime = System.currentTimeMillis();
		Long currentTime=SystemClock.millisClock().now();
		data.setOutTimeStart(LocalDateUtils.getAgoMinutes10(currentTime) / 1000);
		data.setOutTimeEnd(currentTime / 1000);
		return data;
	}
}
