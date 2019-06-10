package com.edas.business.qywechat.constant;


public class Constants {
	// 发送中
	public static final String PARK_SENDING = "0";
	// 成功
	public static final String PARK_SEND_SUCCESS = "1";
	// 失败
	public static final String PARK_SEND_FAILURE = "2";
	// 超时单位：min
	public static final int PARK_TIMEOUT = 1;
	// 最大重试次数
	public static final int MAX_RETRY_COUNT = 3;
	
	public static final byte DELETE_STATUS = 1; 
	
	/**
	 * 公众号 Topic
	 */
	public static final String WXMP_QUEUE = "wxmp.queue";
	public static final String WXMP_TOPIC = "wxmpExchage";
	public static final String WXMP_RONTINGKEY = "wxmp.queue";
	
	/**
	 * 小程序 Topic
	 */
	public static final String WXMA_QUEUE = "wxma.queue";
	public static final String WXMA_TOPIC = "wxmaExchage";
	public static final String WXMA_RONTINGKEY = "wxma.queue";
	
}