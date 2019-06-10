package com.edas.edasmessage.entity.rsp;

import java.io.Serializable;

import lombok.Data;

@Data
public class CarOutParkDataRsp implements Serializable {
	/**
	 * 36 记录唯一标识（详见请求返回参数iden 说明）
	 */
	private String iden;
	/**
	 * 20 车牌号码
	 */
	private String plateNum;

	/**
	 * 20 注册号/卡号
	 */
	private String cardNo;
	/**
	 * 出口通道Id
	 */
	private Long channelId;
	/**
	 * 20 出口通道名称
	 */
	private String channelName;
	/**
	 * 20 入场时间（yyyy-MM-dd HH:MM:SS）
	 */
	private String inTime;
	/**
	 * 20 出场时间（yyyy-MM-dd HH:MM:SS）
	 */
	private String outTime;
	/**
	 * 计费类型ID（详见计费类型说明）
	 */
	private Long cardTypeId;
	/**
	 *  计费类型名称20
	 */
	private String cardType ;
	/**
	 * 出场设备ID
	 */
	private Long controlId;

	/**
	 * 车类型ID（详见车类型说明）
	 */
	private Long carTypeId;

	/**
	 * 车辆类型名称 20
	 */
	private String carType;

	/**
	 * 值班员UID
	 */
	private Long auid;

	/**
	 * 值班员姓名30
	 */
	private String realName;

	/**
	 * 通行方式（详见通行方式说明）
	 */
	private int state;
	/**
	 * 出场照片URL地址 100
	 */
	private String outPhoto;

}
