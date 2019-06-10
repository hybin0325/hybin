package com.edas.edasmessage.entity.req;

import java.io.Serializable;

import lombok.Data;

@Data
public class CarInParkDataReq implements Serializable {
	/**
	 * 车牌号码
	 */
	private String plateNum;

	/**
	 * 计费类型ID（详见计费类型说明）
	 */
	private Long cardTypeId;

	/**
	 * 车类型ID（详见车类型说明）
	 */
	private Long carTypeId;

	/**
	 * 入场开始时间（时间戳）
	 */
	private Long inTimeStart;

	/**
	 * 入场结束时间（时间戳）
	 */
	private Long inTimeEnd;

	/**
	 * 
	 */
	private int page;

	private int size;

}
