package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: CallRule.java
 * </p>
 * <p>
 * Description: 重拨规则实体
 * </p>
 * <p>
 * Date：2019年5月7日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_callrule")
@Data
@ToString
public class CallRule implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	/**
	 * 通话状态
	 */
	@ApiModelProperty(notes = "通话状态", example = "1", required = true)
	private Integer phoneStatus;
	
	/**
	 * 重拨次数
	 */
	@ApiModelProperty(notes = "重拨次数", example = "3", required = true)
    private Integer times;
    
    /**
     * 间隔时间 单位分钟
     */
	@ApiModelProperty(notes = "间隔时间", example = "2", required = true)
    @Column(name = "interval_time")
    private Integer interval;
    
    @ApiModelProperty(notes = "任务id", example = "666", required = true)
    private Integer taskId;
    
    @ApiModelProperty(notes = "公司id", example = "123", required = true)
    private Integer companyId;
    
}