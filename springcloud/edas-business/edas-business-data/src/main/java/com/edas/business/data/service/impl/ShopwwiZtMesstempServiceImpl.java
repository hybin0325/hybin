package com.edas.business.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edas.business.data.dao.master.ShopwwiZtMesstempMapper;
import com.edas.business.data.entity.ShopwwiZtMesstemp;
import com.edas.business.data.feign.MessageFeign;
import com.edas.business.data.service.ShopwwiZtMesstempService;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: ShopwwiZtMesstempServiceImpl接口实现类
 * @author hjx
 * @date 2019/04/10 14:57
 */
@Slf4j
@Service
public class ShopwwiZtMesstempServiceImpl extends AbstractServices<ShopwwiZtMesstemp> implements ShopwwiZtMesstempService {

	@Resource
	private ShopwwiZtMesstempMapper shopwwiZtMesstempMapper;

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

	public ShopwwiZtMesstemp getDataById(Integer id){
//		ShopwwiZtMesstemp shopwwiZtMesstemp = selectBy("id",id);
		ShopwwiZtMesstemp shopwwiZtMesstemp = selectBy("id",id);
		System.out.println("这里是消息模板");
		return  shopwwiZtMesstemp;
	}
}