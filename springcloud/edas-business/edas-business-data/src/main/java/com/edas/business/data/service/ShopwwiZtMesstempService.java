package com.edas.business.data.service;

import com.edas.business.data.entity.ShopwwiZtMesstemp;
import com.edas.edascommon.core.Service;

/**
 * @Description: ShopwwiZtMesstempService接口
 * @author zwx
 * @date 2019/01/25 16:07
 */
public interface ShopwwiZtMesstempService extends Service<ShopwwiZtMesstemp> {
	
	 public void sendMsg(String message);
	 public ShopwwiZtMesstemp getDataById(Integer id);

}
