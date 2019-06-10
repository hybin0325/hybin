package com.edas.business.data.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edas.business.data.dao.master.ShopwwiCxxmMapper;
import com.edas.business.data.entity.ShopwwiCxxm;
import com.edas.business.data.feign.MessageFeign;
import com.edas.business.data.service.ShopwwiCxxmService;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: ShopwwiCxxmServiceImpl接口实现类
 * @author hjx
 * @date 2019/04/10 15:40
 */
@Slf4j
@Service
public class ShopwwiCxxmServiceImpl extends AbstractServices<ShopwwiCxxm> implements ShopwwiCxxmService {

	@Resource
	private ShopwwiCxxmMapper shopwwiCxxmMapper;

	@Resource
	private MessageFeign messageFeign;

	public List<ShopwwiCxxm> getDataByTbname(String  tbname){

		ShopwwiCxxm shopwwiCxxms = new ShopwwiCxxm();
		shopwwiCxxms.setTbname(tbname);
		List<ShopwwiCxxm> shopwwiCxxm= shopwwiCxxmMapper.findCxxmBytbname(shopwwiCxxms);

		return shopwwiCxxm;
	};

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