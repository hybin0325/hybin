package com.edas.edasmessage.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.edascommon.constants.Constants;
import com.edas.edasmessage.dao.BrokerMessageLogMapper;
import com.edas.edasmessage.entity.BrokerMessageLog;
import com.edas.edasmessage.service.BrokerMessageLogService;

@Service
public class BrokerMessageLogServiceImpl implements BrokerMessageLogService {

	@Autowired
	private BrokerMessageLogMapper brokerMessageLogMapper;

	@Override
	//@RedisLock(lockPrefix = "brokerMessage", lockKey = "save")
	public void save(BrokerMessageLog brokerMessageLog) {
		// 设置消息状态为0 表示发送中
		brokerMessageLog.setStatus(Constants.PARK_SENDING);
		Date nextRetry = DateUtils.addMinutes(new Date(), Constants.PARK_TIMEOUT);
		brokerMessageLog.setNextRetry(nextRetry);
		brokerMessageLog.setTryCount(0);
		brokerMessageLog.setCreateTime(new Date());
		brokerMessageLogMapper.insert(brokerMessageLog);
	}
	
	@Transactional
	//@RedisLock(lockPrefix = "brokerMessage", lockKey = "update_status")
	public int changeBrokerMessageLogStatus(Long messageId, String status) {
		return brokerMessageLogMapper.changeBrokerMessageLogStatus(messageId,status);
	}
	
	@Transactional
	//@RedisLock(lockPrefix = "brokerMessage", lockKey = "update_nextRetry")
	public int update4ReSend( Long messageId,  Date nextRetry) {
		return brokerMessageLogMapper.update4ReSend(messageId,nextRetry);
	}
	
	
	public List<BrokerMessageLog> query4StatusAndTimeoutMessage(){
		return brokerMessageLogMapper.query4StatusAndTimeoutMessage();
	}
	
	

}
