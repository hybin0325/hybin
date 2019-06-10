package com.edas.business.dingtalk.service;

import com.edas.business.dingtalk.entity.ZtMesstemp;
import com.edas.edascommon.core.Service;

/**
 * @Description: ShopwwiZtMesstempService接口
 * @author zwx
 * @date 2019/01/25 16:07
 */
public interface ZtMesstempService extends Service<ZtMesstemp> {
	
	 public void sendMsg(String message);
	 public ZtMesstemp getDataById(Integer id);

}
