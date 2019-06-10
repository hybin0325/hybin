package com.edas.business.qywechat.service;


import com.edas.business.qywechat.entity.Cxxm;
import com.edas.edascommon.core.Service;

import java.util.List;


/**
 * @Description: ShopwwiCxxmService
 * @author hjx
 * @date 2019/04/10 15:40
 */
public interface CxxmService extends Service<Cxxm> {
	
	 public void sendMsg(String message);
	 public List<Cxxm> getDataByTbname(String tbname);

}
