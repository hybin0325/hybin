package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.ToString;


/**
 * <p>
 * File Name: PhoneTaskDTO.java
 * </p>
 * <p>
 * Description: 任务更新时用到，创建和更新的参数不一样，暂时用这个走更新
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */

@SuppressWarnings("serial")
@Data
@ToString
public class PhoneTaskDTO implements Serializable{

    private Integer id;
	
    private Integer companyId;
    
    private Integer taskId;
    
    private String taskName;
        
    /**
     * 创建任务时需要传主叫号码id
     */
    private String  userPhoneIds;
    
    /**
     * 任务类型, 1-定时,2-手动
     */
    private Integer taskType;
    
    /**
     * 主叫号码类型，0-sim卡,1-固话（默认）, 2-无主叫
     */
    private Integer callType;
    
    private Integer concurrencyQuota;
    
    private String startDate;
    
    private String workingStartTime;
    
    private String workingEndTime;
    
    private String breakStartTime;
    
    private String breakEndTime;
    
    private Integer sceneDefId;
    
    private Integer robotDefId;
    
    private Integer sceneRecordId;
    
    private String remark;
    
    private Boolean repeatCall;
    
    private Boolean defaultIntentionRule;
    
    private Integer status;
    
    /**
     * 创建任务时重播规则
     */
    List<CallRule> repeatCallRule;

   
}