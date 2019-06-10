package com.edas.business.dingtalk.service;


import com.edas.business.dingtalk.entity.ZtCarcus;
import com.edas.edascommon.core.Service;


public interface ZtCarcusService extends Service<ZtCarcus> {
	
	 public void sendMsg(String message);
	 public ZtCarcus getDataByLicense(String message);

}
