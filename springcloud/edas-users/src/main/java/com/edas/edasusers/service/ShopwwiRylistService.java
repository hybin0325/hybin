package com.edas.edasusers.service;

import com.edas.edascommon.core.Service;
import com.edas.edasusers.entity.ShopwwiRylist;

/**
 * @Description: ShopwwiRylistService接口
 * @author zwx
 * @date 2019/01/25 16:07
 */
public interface ShopwwiRylistService extends Service<ShopwwiRylist> {
	 public ShopwwiRylist findById(int id);

}
