package com.edas.edasmessage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.edas.edascommon.core.BaseCrudMapper;
import com.edas.edasmessage.entity.BrokerMessageLog;

public interface BrokerMessageLogMapper extends BaseCrudMapper<BrokerMessageLog>{
	
	
	/**
	 * 修改
	 * @param messageId
	 * @param status
	 * @return
	 */
	@Update("update shopwwi_broker_message_log set status=#{status} where message_id=#{messageId}")
	public int changeBrokerMessageLogStatus(@Param("messageId") Long messageId, @Param("status") String status);
	
	 /**
     * 查询消息状态为0（发送中）且已经超时的消息集合
     *
     * @return
     */
    List<BrokerMessageLog> query4StatusAndTimeoutMessage();

    /**
     * 重新发送统计count发送次数 +1
     *
     * @param messageId
     * @param nextRetry
     */
    int update4ReSend(@Param("messageId") Long messageId, @Param("nextRetry") Date nextRetry);
	
}
