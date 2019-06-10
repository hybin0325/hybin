package com.edas.edascommon.constants;

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

	public static final String CARINPARK_QUEUE = "carInPark.queue";

	
	
	/**
	 * 创建Fanout交换器
	 */
	public static final String NL_DATA_MSG_FANOUT = "nlDataMsg";
	public static final String DINGTALK_DATA_QUEUE = "dingtalkdData.queue";
	public static final String WECHAT_DATA_QUEUE = "wechatData.queue";
	
	
	/**
	 * 创建Topic交换器
	 */
	public static final String NL_CAR_PARK_MSG_TOPIC = "nlCarParkMsg";
	public static final String NL_CAR_PARK_MSG_QUEUE = "nlCarParkMsg.queue";
	public static final String NL_CAR_PARK_MSG_RONTINGKEY = "car.park";
	
	
	/**
	 * 创建Topic交换器
	 */
	public static final String NL_CAR_PARK_DATA_MSG_TOPIC = "nlCarParkDataMsg";
	public static final String NL_CAR_PARK_DATA_DINGTALK_MSG_QUEUE = "nlCarParkDingtalkdDataMsg.queue";
	public static final String NL_CAR_PARK_DATA_WECHAT_MSG_QUEUE = "nlCarParkWechatDataMsg.queue";
	public static final String NL_CAR_PARK_DATA_WECHAT_MSG_RONTINGKEY = "carpark.wechat";
	public static final String NL_CAR_PARK_DATA_DINGTALK_MSG_RONTINGKEY = "carpark.dingtalk";
	
	
	public static final byte DELETE_STATUS = 1; 
	
	public static final String CAR_IN_PARK = "carInPark"; 
	
	public static final String CAR_OUT_PARK = "carOutPark"; 
	

}
