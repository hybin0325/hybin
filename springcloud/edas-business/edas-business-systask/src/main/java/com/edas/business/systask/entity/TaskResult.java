package com.edas.business.systask.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: TaskResult.java
 * </p>
 * <p>
 * Description: 任务结果实体
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_taskresult")
@Data
@ToString
public class TaskResult implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    private String clique;

    private String dld;

    /**
     * 任务编号
     */
    private Long taskId;

    /**
     * 车牌号
     */
    private String license;

    /**
     * 车架号
     */
    private byte[] frame;

    private String engineno;

    /**
     * 下次保养日
     */
    private Date nextmaintainday;

    /**
     * 保险到期日
     */
    private Date insuranceday;

    /**
     * 公里数
     */
    private BigDecimal kilometres;

    private byte[] memLevel;

    private Date memPeriod;

    private Date extenPeriod;

    private Date warrantyPeriod;

    private Date buyTime;

    private Date finalTime;

    private String cusId;

    private String cusPhone;

    private String cusName;

    private String cusType;

    private String cusLevel;

    /**
     * 客户公众号的openid
     */
    private String cusOpenid;

    /**
     * 客户小程的form_id
     */
    private String cusFormId;

    private Date createDate;

    private Date firstFollowDate;

    private String followUserid;

    private String followUsername;

    /**
     * 待分配,，待回访，继续跟进，成功，战败
     */
    private String taskState;

    private Date appointDate;

    private Date nextFollowDate;

    private Date updateDate;

    private String updateUserid;

    /**
     * 1、人工任务 2、AI 转人工 3、其他来源方式（手动生成）
     */
    private Integer source;

    /**
     * 人工任务编号、AI通话记录编号、其他编号
     */
    private Integer sourceId;
}
