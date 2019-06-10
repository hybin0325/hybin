package com.edas.edasmessage.service;

import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edasmessage.entity.User;
import com.edas.edasmessage.entity.req.CarInParkDataReq;
import com.edas.edasmessage.entity.req.CarOutParkDataReq;

public interface DeliyunService {
	
	/**
	 * 车进场
	 */
	public void findParkInLog(CarInParkDataReq dataReq,SnowflakeIdWorker idWorker);
	
	/**
	 * 车进场
	 */
	public void findParkInLog(CarInParkDataReq dataReq,String key);
	
	/**
	 * 车进场
	 */
	public void findParkInLog(CarInParkDataReq dataReq,String key,SnowflakeIdWorker idWorker);
	
	/**
	 * 车出场
	 */
	public void findParkOutLog( CarOutParkDataReq data,SnowflakeIdWorker idWorker );
	
	public void findParkOutLog(CarOutParkDataReq data,  String key,SnowflakeIdWorker idWorker);
	
	public User getUserInfos();
	
	

}
