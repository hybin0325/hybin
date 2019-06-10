package com.edas.business.byrobot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: PhoneTask.java
 * </p>
 * <p>
 * Description: 任务实体
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_task")
@Data
@ToString
public class PhoneTask implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
    private Integer id;
	
	@ApiModelProperty(notes = "公司id", example = "66", required = true)
    private Integer companyId;
    
	@ApiModelProperty(notes = "任务名称", example = "测试", required = true)
    private String taskName;
    
    private Integer taskId;
    
    /**
     * 任务类型, 1-定时,2-手动
     */
    @ApiModelProperty(notes = "任务类型,1-定时,2-手动", example = "1", required = true)
    private Integer taskType;
    
    @ApiModelProperty(notes = "开始日期", example = "2019-05-07", required = true)
    private String startDate;
    
    @ApiModelProperty(notes = "任务开始时间", example = "09:50", required = true)
    private String workingStartTime;
    
    @ApiModelProperty(notes = "任务结束时间", example = "20:00", required = true)
    private String workingEndTime;
    
    @ApiModelProperty(notes = "午休开始时间", example = "12:00", required = true)
    private String breakStartTime;
    
    @ApiModelProperty(notes = "午休结束时间", example = "13:30", required = true)
    private String breakEndTime;
    
    /**
     *主叫电话号码id列表，详见获取公司的主叫电话列表(getPhones)接口 
     */
    private Integer callPhones;
    
    @ApiModelProperty(notes = "话术场景id", example = "133", required = true)
    private Integer sceneDefId;
    
    @ApiModelProperty(notes = "话术id", example = "35", required = true)
    private Integer robotDefId;
    
    @ApiModelProperty(notes = "场景录音id", example = "33", required = true)
    private Integer sceneRecordId;
    
    /**
     * 主叫号码类型，0-sim卡,1-固话（默认）, 2-无主叫
     */
    @ApiModelProperty(notes = "主叫号码类型", example = "2", required = true)
    private Integer callType;
    
    @ApiModelProperty(notes = "坐席数", example = "1", required = true)
    private Integer concurrencyQuota;
    
    @ApiModelProperty(notes = "备注", example = "33", required = true)
    private String remark;
    
    @ApiModelProperty(notes = "重播标志", example = "false", required = true)
    private Boolean repeatCall;
        
    //private Integer phoneStatus;
    
    //private Integer times;
    
    //private Integer intervalTime;
    
    private Boolean defaultIntentionRule;
    
    /**
     * 任务状态, 0:未开始,1:进行中,2:已完成,3:调度中,4:手动暂停,5:自动暂停,6:已终止,7:排队中,8:AI到期,9:账户欠费,10：短信欠费
     */
    private Integer status;
    
    /**
     * 创建任务时需要传主叫号码id
     */
    @Transient
    List<Integer> userPhoneIds;
    
    /**
     * 创建任务时重播规则
     */
    @Transient
    List<CallRule> repeatCallRule;
    
    @Transient
    private Integer callJobId;
    
    @Transient
    private String jobName;
   
}