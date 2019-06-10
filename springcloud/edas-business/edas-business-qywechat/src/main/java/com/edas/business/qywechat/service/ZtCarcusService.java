package com.edas.business.qywechat.service;


import com.edas.business.qywechat.entity.ZtCarcus;
import com.edas.edascommon.core.Service;


public interface ZtCarcusService extends Service<ZtCarcus> {
	
	 public void sendMsg(String message);
	 public ZtCarcus getDataByLicense(String message);

}
