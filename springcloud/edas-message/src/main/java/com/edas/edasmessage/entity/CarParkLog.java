package com.edas.edasmessage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.edas.edascommon.gen.SnowflakeId;
import com.edas.edascommon.gen.UUIdGenId;

import lombok.Data;
import lombok.ToString;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 车辆进出车场记录
 * 
 * @author nl
 *
 */
@Data
@ToString
@Table(name = "shopwwi_car_park_log")
public class CarParkLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6695655207892327991L;

	@Id
	@Column(name = "id")
	@KeySql(genId = SnowflakeId.class)
	// @KeySql(genId = UUIdGenId.class)
	private Long id;

	/**
	 * 记录唯一标识
	 */
	private String iden;
	/**
	 * 车牌号
	 */
	private String plateNum;

	/**
	 * 入场通道ID
	 */
	private Long channelId;

	/**
	 * 入场通道名称
	 */
	private String cname;

	/**
	 * 入场摄像机ID
	 */
	private Long controlId;

	/**
	 * 入场设备名称
	 */
	private String dname;

	/**
	 * 值班员ID
	 */
	private Long auid;

	/**
	 * 值班员姓名
	 */
	private String realName;

	/**
	 * 车辆ID(临时车可能没有值)
	 */
	private Long cardId;

	/**
	 * 车辆类型ID
	 */
	private Long carTypeId;

	/**
	 * 车辆类型名称
	 */
	private String carType;

	/**
	 * 计费类型ID
	 */
	private Integer cardTypeId;

	/**
	 * 计费类型名称
	 */
	private String cardType;

	/**
	 * 入场时间戳(单位：秒)
	 */
	private Date inTime;

	/**
	 * 保存图片
	 */
	private String picPlateNum;

	/**
	 * 注册号/卡号
	 */
	private String cardNo;

	/**
	 * 出场时间戳(单位：秒)
	 */
	private Date outTime;

	/**
	 * 收费终端ID
	 */
	private Long cpcId;

	/**
	 * 出场收费终端名称
	 */
	private String cpcName;

	/**
	 * 收费终端IP
	 */
	private String cpcIp;

	/**
	 * 通行方式
	 */
	private Integer state;

	/**
	 * 保存日期
	 */
	private Date createDate;
	/**
	 * 20 入场通道名称
	 */
	private String channelName;
	/**
	 * 计费类型ID（详见计费类型说明）
	 */

	/**
	 * 100 入场图片URL 地址
	 */
	private String inPhoto;

	private String outPhoto;

	/**
	 * 所属门店
	 */
	private String dld;

	/**
	 * 所属集团
	 */
	private String clique;

}
