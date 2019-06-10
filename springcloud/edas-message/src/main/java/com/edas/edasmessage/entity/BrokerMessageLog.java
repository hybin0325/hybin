package com.edas.edasmessage.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.edas.edascommon.gen.SnowflakeId;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 消息推送记录表
 * 
 * @author nl
 *
 */
@Table(name = "shopwwi_broker_message_log")
@Data
public class BrokerMessageLog {

	/**
	 * 消息唯一ID
	 */
	@Id
	private Long messageId;

	/**
	 * 消息内容
	 */
	private String message;

	/**
	 * 重复次数
	 */
	private Integer tryCount;

	/**
	 * 消息投递状态 0 投递中 1 投递成功 2 投递失败
	 */
	private String status;

	/**
	 * 下一次重试时间 或 超时时间
	 */
	private Date nextRetry;
	
	/**
	 * 路由key
	 */
	private String routingKey;
	
	/**
	 * 交换机
	 */
	private String exchange;

	private Date createTime;

	private Date updateTime;

}
