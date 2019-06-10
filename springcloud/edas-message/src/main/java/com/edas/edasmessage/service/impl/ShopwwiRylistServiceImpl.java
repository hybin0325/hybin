package com.edas.edasmessage.service.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.edascommon.constants.Constants;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.model.MqMessage;
import com.edas.edasmessage.dao.ShopwwiRylistMapper;
import com.edas.edasmessage.entity.ShopwwiRylist;
import com.edas.edasmessage.rabbitmq.sender.MQCarParkSender;
import com.edas.edasmessage.service.ShopwwiRylistService;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: ShopwwiRylistService接口实现类
 * @author zwx
 * @date 2019/01/25 16:07
 */
@Slf4j
@Service
@Transactional
public class ShopwwiRylistServiceImpl extends AbstractServices<ShopwwiRylist> implements ShopwwiRylistService {

    @Resource
    private ShopwwiRylistMapper shopwwiRylistMapper;
    
    @Resource
    private MQCarParkSender carParkSender;
    
    public void getMsg() {
    	log.info("-------------------------");
    	String messageId = System.currentTimeMillis() + "#" + UUID.randomUUID().toString();
    	MqMessage msg=new MqMessage();
    	msg.setMessageId(messageId);
    	msg.setMessage("这是个消息");
    	try {
    		String exchange=Constants.NL_DATA_MSG_FANOUT;
    		String routingKey="";
			carParkSender.sendDataMsg(exchange,routingKey,msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}