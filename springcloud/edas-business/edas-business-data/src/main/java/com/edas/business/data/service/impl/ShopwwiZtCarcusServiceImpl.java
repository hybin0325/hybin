package com.edas.business.data.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edas.business.data.dao.master.ShopwwiZtCarcusMapper;
import com.edas.business.data.entity.ShopwwiZtCarcus;
import com.edas.business.data.feign.MessageFeign;
import com.edas.business.data.service.ShopwwiZtCarcusService;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.utils.web.RetResult;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: ShopwwiZtCarcusService接口实现类
 * @author hjx
 * @date 2019/04/10 14:15
 */
@Slf4j
@Service
public class ShopwwiZtCarcusServiceImpl extends AbstractServices<ShopwwiZtCarcus> implements ShopwwiZtCarcusService {

	@Resource
	private ShopwwiZtCarcusMapper shopwwiZtcarcusMapper;

	@Resource
	private MessageFeign messageFeign;

	public ShopwwiZtCarcus getDataByLicense(String license){

		ShopwwiZtCarcus qse = new ShopwwiZtCarcus();
		qse.setLicense(license);
		log.info("车牌"+qse.getLicense());
		ShopwwiZtCarcus shopwwiZtCarcus = shopwwiZtcarcusMapper.findZtCarcusBylicense(qse);
//		ShopwwiZtCarcus shopwwiZtCarcus = shopwwiZtcarcusMapper.selectOne(qse);
//		ShopwwiZtCarcus shopwwiZtCarcus = selectBy("id",17806);
		log.info("车牌"+shopwwiZtCarcus.getLicense());
		if(shopwwiZtCarcus == null || shopwwiZtCarcus.equals(null)){
			log.info("车牌"+license+"找不到车辆信息");
		}
		return shopwwiZtCarcus;
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