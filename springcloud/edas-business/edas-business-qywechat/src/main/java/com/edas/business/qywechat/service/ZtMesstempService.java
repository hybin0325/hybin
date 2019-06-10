package com.edas.business.qywechat.service;

import com.edas.business.qywechat.entity.ZtMesstemp;
import com.edas.edascommon.core.Service;

/**
 * @Description: ZtMesstempService
 * @author zwx
 * @date 2019/01/25 16:07
 */
public interface ZtMesstempService extends Service<ZtMesstemp> {
	
	 public void sendMsg(String message);
	 public ZtMesstemp getDataById(Integer id);

}
