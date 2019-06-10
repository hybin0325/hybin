package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: UserPhone.java
 * </p>
 * <p>
 * Description: 主叫电话实体
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Table(name = "shopwwi_zt_ai_baiying_phone")
@Data
@ToString
public class UserPhone implements Serializable{

	private static final long serialVersionUID = 6212444520142802071L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
    private Integer id;
	
	@ApiModelProperty(notes = "公司id", example = "66", required = true)
    private Integer companyId;
    
    /**
     * 主叫号码Id
     */
	@ApiModelProperty(notes = "主叫号码id", example = "632", required = true)
    private Integer userPhoneId;
    
    /**
     * 主叫号码
     */
	@ApiModelProperty(notes = "主叫号码", example = "02088967832", required = true)
    private String phone;
    
	@ApiModelProperty(notes = "账号", example = "test", required = true)
    private String account;
    
	@ApiModelProperty(notes = "名称", example = "测试", required = true)
    private String phoneName;
    
    /**
     * 主叫号码类型：手机(0, "手机"),阿里云固话(1, "阿里云固话"),无主叫固话(2, "无主叫固话"),sip线路(6,"sip线路")
     */
	@ApiModelProperty(notes = "主叫号码类型", example = "2")
    private Integer phoneType;
    
    private Boolean available;
    
    /**
     * 总坐席
     */
    @ApiModelProperty(notes = "总坐席", example = "88")
    private Integer totalConcurrencyQuota;
    
    /**
     * 可用坐席
     */
    @ApiModelProperty(notes = "可用坐席", example = "22")
    private Integer usedConcurrencyQuota;
    
    @ApiModelProperty(notes = "计费周期", example = "5")
    private Integer billPeriod;
    
    @ApiModelProperty(notes = "可用开始时间", example = "2019-05-11 15:51:27", required = true)
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date validityBegin;
    
    @ApiModelProperty(notes = "可用结束时间", example = "2019-05-17 15:51:27", required = true)
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date validityEnd;
    
    @ApiModelProperty(notes = "应用场景", example = "2")
    private Integer sceneType;
    
    @ApiModelProperty(notes = "余额", example = "100.5")
    private BigDecimal lineAmount;
     
    private Integer billMode;
    
    private Integer rateType;
    
    private Integer weightType;
    
}