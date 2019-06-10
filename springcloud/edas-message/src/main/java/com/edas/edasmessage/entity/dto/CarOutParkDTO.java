package com.edas.edasmessage.entity.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.Data;
import lombok.ToString;

/**
 * 车辆出场记录
 * 
 * @author nl
 *
 */

@Data
@ToString
public class CarOutParkDTO implements Serializable{

	/**
	 *记录唯一标识 36
	 */
	@Size(min=0, max=36) 
	private String iden;
	
	/**
	 * 车牌号码 20
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
	 * 车辆分组名称 30
	 */
	@Size(min=0, max=30) 
	private String gname;
	
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
	 * 车类型 20
	 */
	@Size(min=0, max=20) 
	private String carType;
	
	/**
	 * 入场时间戳
	 */
	private Long inTime;
	
	/**
	 * 出场时间戳
	 */
	private Long outTime;
	
	/**
	 * 入场控制器ID
	 */
	private Long controlId;
	
	/**
	 * 出场设备名称 60
	 */
	@Size(min=0, max=60) 
	private String dname;
	
	/**
	 * 收费终端ID
	 */
	private Long cpcId;
	
	/**
	 * 出场收费终端名称 60
	 */
	@Size(min=0, max=60) 
	private String cpcName;
	
	/**
	 * 收费终端IP 20
	 */
	@Size(min=0, max=20) 
	private String cpcIp;
	 
	/**
	 * 通道ID
	 */
	private Long channelId;
	
	/**
	 * 出场通道名称 30
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
	 * String 200
	 */
	@Size(min=0, max=200) 
	private String remark;
	
	/**
	 * 通行方式
	 */
	private int state;
	

}
