package com.edas.business.data.service;

import com.edas.business.data.entity.ShopwwiRylist;
import com.edas.edascommon.core.Service;

/**
 * @Description: ShopwwiRylistService接口
 * @author zwx
 * @date 2019/01/25 16:07
 */
public interface ShopwwiRylistService extends Service<ShopwwiRylist> {
	
	 public void sendMsg(String message);

}
