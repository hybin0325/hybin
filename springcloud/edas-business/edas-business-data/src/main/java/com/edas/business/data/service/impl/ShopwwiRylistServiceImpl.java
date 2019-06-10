package com.edas.business.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edas.business.data.dao.master.ShopwwiRylistMapper;
import com.edas.business.data.entity.ShopwwiRylist;
import com.edas.business.data.feign.MessageFeign;
import com.edas.business.data.service.ShopwwiRylistService;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: ShopwwiRylistService接口实现类
 * @author zwx
 * @date 2019/01/25 16:07
 */
@Slf4j
@Service
public class ShopwwiRylistServiceImpl extends AbstractServices<ShopwwiRylist> implements ShopwwiRylistService {

	@Resource
	private ShopwwiRylistMapper shopwwiRylistMapper;

	@Resource
	private MessageFeign messageFeign;

	public void sendMsg(String message) {
		try {
			log.info("这边的的消息 : " + message);
			MQDataMsg dataMsg=new MQDataMsg(); 
			dataMsg.setMessage(message);
			RetResult<String> result = messageFeign.senderMsg(dataMsg);
			log.info(result.getData());
		} catch (Exception e) {
			log.info("有错：" + e.getMessage());
		}
	}
}