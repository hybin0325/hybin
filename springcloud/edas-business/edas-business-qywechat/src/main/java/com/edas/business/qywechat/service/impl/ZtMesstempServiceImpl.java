package com.edas.business.qywechat.service.impl;


import com.edas.business.qywechat.dao.master.ZtMesstempMapper;
import com.edas.business.qywechat.entity.ZtMesstemp;
import com.edas.business.qywechat.service.ZtMesstempService;
import com.edas.edascommon.core.AbstractServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: ZtMesstempServiceImpl接口实现类
 * @author hjx
 * @date 2019/04/10 14:57
 */
@Slf4j
@Service
public class ZtMesstempServiceImpl extends AbstractServices<ZtMesstemp> implements ZtMesstempService{

	@Resource
	private ZtMesstempMapper ZtMesstempMapper;



	public void sendMsg(String message) {

	}

	public ZtMesstemp getDataById(Integer id){
		ZtMesstemp ZtMesstemp = selectBy("id",id);
		System.out.println("这里是消息模板");
		return  ZtMesstemp;
	}
}