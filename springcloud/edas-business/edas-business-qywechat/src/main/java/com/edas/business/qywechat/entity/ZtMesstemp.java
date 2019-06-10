package com.edas.business.qywechat.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "shopwwi_zt_messtemp")
public class ZtMesstemp {
	@Id
	private Integer id;

	/**
	 * 模板编号
	 */
	private String temNum;

	/**
	 * 模板类型(在sysset里面设置模板分类：门禁通知/人脸识别/订单推送)
	 */
	private String temType;

	/**
	 * 模板名称(进场提醒/违章提醒)
	 */
	private String temName;

	/**
	 * 推送渠道(钉钉/企业微信/公众号/小程序/短信)
	 */
	private String pushChan;

	/**
	 * 渠道模板(文本消息/链接消息/语音消息)
	 */
	private String chanTemp;

	/**
	 * 模板数据源(中台车辆客户汇总档/自定义sql)
	 */
	private String tempDataSou;

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
	private Date addDate;

	/**
	 * 修改时间
	 */
	private Date updDate;

	/**
	 * 是否该消息模板，1是启用 0是不启用
	 */
	private Byte status;

	/**
	 * 消息内容(参数列表即:车辆客户汇总档的列 举个例子:保险模板: {客户姓名} 车主,您好! 您的爱车{车牌} 将在 {距离保险到期天数}天后,)
	 */
	private String messCon;

	/**
     * 启用该渠道类型必须的条件json格式
     */
    private String typeMessage;

	/**
	 * 新增字段 跳转url 2019-05-31
	 */
	private String tiaozhuanUrl;

}
