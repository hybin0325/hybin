package com.edas.business.qywechat.service.impl;


import com.edas.business.qywechat.dao.master.ZtCarcusMapper;
import com.edas.business.qywechat.entity.ZtCarcus;
import com.edas.business.qywechat.service.ZtCarcusService;
import com.edas.edascommon.core.AbstractServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: ZtCarcusService接口实现类
 * @author hjx
 * @date 2019/04/10 14:15
 */
@Slf4j
@Service
public class ZtCarcusServiceImpl extends AbstractServices<ZtCarcus> implements ZtCarcusService {

	@Resource
	private ZtCarcusMapper ZtCarcusMapper;


	public ZtCarcus getDataByLicense(String license){

		ZtCarcus qse = new ZtCarcus();
		qse.setLicense(license);
		log.info("车牌1"+qse.getLicense());
		ZtCarcus ZtCarcus = ZtCarcusMapper.findZtCarcusBylicense(qse);
//		ZtCarcus ZtCarcus = ZtCarcusMapper.selectOne(qse);
//		ZtCarcus ZtCarcus = selectBy("id",17806);
		log.info("车牌2"+ZtCarcus);
		if(ZtCarcus == null || ZtCarcus.equals(null)){
			log.info("车牌"+license+"找不到车辆信息");
		}
		return ZtCarcus;
	};

	public void sendMsg(String message) {

	}
}