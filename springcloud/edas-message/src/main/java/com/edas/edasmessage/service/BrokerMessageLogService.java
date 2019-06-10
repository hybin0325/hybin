package com.edas.edasmessage.service;

import java.util.Date;
import java.util.List;

import com.edas.edasmessage.entity.BrokerMessageLog;

public interface BrokerMessageLogService {
	
	public void save(BrokerMessageLog log);
	
	public int changeBrokerMessageLogStatus(Long messageId, String status);
	
	public int update4ReSend( Long messageId,  Date nextRetry);
	
	public List<BrokerMessageLog> query4StatusAndTimeoutMessage();

}
