package com.edas.business.qywechat.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * shopwwi_zt_messsendlog
 * 
 * @author
 */
@Table(name = "shopwwi_zt_messsendlog")
@Data
@ToString
public class ZtMesssendlog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * 消息内容
	 */
	private String messCont;

	/**
	 * 消息接收人
	 */
	private String messRec;

	/**
	 * 消息发送时间
	 */
	private LocalDateTime  messDeliTime;
	private LocalDateTime  readDate;

	/**
	 * 推送渠道(钉钉/企业微信/公众号/小程序/短信)
	 */
	private String pushChan;

	/**
	 * 渠道模板(文本消息/链接消息/语音消息)
	 */
	private String chanTemp;

	/**
	 * 门禁通知/人脸识别/订单推送
	 */
	private String messClass;

	/**
	 * 消息标题(进场提醒/违章提醒)
	 */
	private String temName;

	/**
	 * 模板数据源(中台车辆客户汇总档/自定义sql)
	 */
	private String tempDataSou;

	/**
	 * 消息来源系统(钉钉/企业微信/E管家/小程序)
	 */
	private String messSour;


	/**
	 * 来源系统模块(售后/保险/会员/人事)
	 */
	private String messModel;

	/**
	 * 车牌号（非必填:，member_id 与车牌号，不同时为空）
	 */
	private String license;
	/**
	 * 车架号（非必填:中台处理赋值）
	 */
	private String frame;


	/**
	 * 客户编号（非必填，member_id 与车牌号，不同时为空； 抓 微信openId，小程序 from_id）
	 */
	private String cusNum;


	/**
	 * 会员等级（非必填:,中台处理赋值，记录客户进场时的客户等级）
	 */
	private String memLevel;



	/**
	 * 添加人id
	 */
	private String userid;

	/**
	 * 添加人
	 */
	private String username;

	/**
	 * 修改人id
	 */
	private String useridUp;

	/**
	 * 修改人
	 */
	private String usernameUp;

	/**
	 * 所属门店
	 */
	private String dld;

	/**
	 * 所属dld
	 */
	private String clique;

	/**
	 * 添加时间
	 */
	private LocalDateTime addDate;

	/**
	 * 修改时间
	 */
	private LocalDateTime updDate;

	/**
	 * 状态：0有效，1无效
	 */
	private Byte isRead;




}