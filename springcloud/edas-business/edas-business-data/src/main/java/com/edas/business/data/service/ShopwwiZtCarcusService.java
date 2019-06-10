package com.edas.business.data.service;

import com.edas.business.data.entity.ShopwwiZtCarcus;
import com.edas.edascommon.core.Service;

/**
 * @Description: ShopwwiZtCarcusService
 * @author hjx
 * @date 2019/04/10 14:13
 */
public interface ShopwwiZtCarcusService extends Service<ShopwwiZtCarcus> {
	
	 public void sendMsg(String message);
	 public ShopwwiZtCarcus getDataByLicense(String message);

}
