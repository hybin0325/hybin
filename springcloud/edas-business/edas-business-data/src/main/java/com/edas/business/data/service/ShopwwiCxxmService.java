package com.edas.business.data.service;

import java.util.List;

import com.edas.business.data.entity.ShopwwiCxxm;
import com.edas.edascommon.core.Service;


/**
 * @Description: ShopwwiCxxmService
 * @author hjx
 * @date 2019/04/10 15:40
 */
public interface ShopwwiCxxmService extends Service<ShopwwiCxxm> {
	
	 public void sendMsg(String message);
	 public List<ShopwwiCxxm> getDataByTbname(String tbname);

}
