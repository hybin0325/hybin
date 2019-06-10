package com.edas.edasmessage.entity.req;

import java.io.Serializable;

import lombok.Data;

@Data
public class CarOutParkDataReq implements Serializable {
	/**
	 * 计费类型ID（详见计费类型说明）
	 */
	private Integer cardTypeId;

	/**
	 * 车牌号码
	 */
	private String plateNum;

	/**
	 * 注册号/卡号
	 */
	private String cardNo;
	/**
	 * 入场开始时间（时间戳）
	 */
	private Long inTimeStart;
	/**
	 * 入场结束时间（时间戳）
	 */
	private Long inTimeEnd;

	/**
	 * 出场开始时间（时间戳）
	 */
	private Long outTimeStart;

	/**
	 * 出场结束时间（时间戳）
	 */
	private Long outTimeEnd;

	/**
	 * 值班员UID
	 */
	private Long auid;
	/**
	 * 值班员姓名
	 */
	private String realName;

	/**
	 * 出场设备ID
	 */
	private Long controlId;
	private int page;
	private int size;

}
