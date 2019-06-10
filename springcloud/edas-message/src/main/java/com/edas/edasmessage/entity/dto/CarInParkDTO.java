package com.edas.edasmessage.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

/**
 * 车辆入场记录数
 * 
 * @author nl
 *
 */

@Data
@ToString
public class CarInParkDTO implements Serializable{

	/**
	 * 记录唯一标识
	 */
	@Size(min=0, max=36) 
	private String iden;

	/**
	 * 车牌号 20
	 */
	@Size(min=0, max=20) 
	private String plateNum;

	/**
	 * 注册号/卡号 20
	 */
	@Size(min=0, max=20) 
	private String cardNo;

	/**
	 * 车辆ID
	 */
	private Long cardId;

	/**
	 * 车辆分组ID
	 */
	private Long cardGroupId;

	/**
	 * 分组名称 30
	 */
	@Size(min=0, max=30) 
	private String gname;

	/**
	 * 入场时间戳
	 */
	private Long inTime;

	/**
	 * 入场摄像机ID
	 */
	private Long controlId;

	/**
	 * 入场设备名称 60
	 */
	@Size(min=0, max=60) 
	private String dname;

	/**
	 * 计费类型ID
	 */
	private int cardTypeId;

	/**
	 * 计费类型名称 20
	 */
	@Size(min=0, max=20) 
	private String cardType;

	/**
	 * 车辆类型ID
	 */
	private Long carTypeId;

	/**
	 * 车辆类型名称 20
	 */
	@Size(min=0, max=20) 
	private String carType;

	/**
	 * 收费终端ID
	 */
	private Long cpcId;

	/**
	 * 收费终端名称 60
	 */
	@Size(min=0, max=60) 
	private String cpcName;

	/**
	 * 收费终端IP 20
	 */
	@Size(min=0, max=20) 
	private String cpcIp;

	/**
	 * 入场通道ID
	 */
	private Long channelId;

	/**
	 * 入场通道名称 30
	 */
	@Size(min=0, max=30) 
	private String cname;

	/**
	 * 值班员ID
	 */
	private Long auid;

	/**
	 * 值班员姓名 30
	 */
	@Size(min=0, max=30) 
	private String realName;

	/**
	 * 通行方式
	 */
	private int state;

}
