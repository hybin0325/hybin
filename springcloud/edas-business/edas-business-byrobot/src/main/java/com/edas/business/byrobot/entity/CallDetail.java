package com.edas.business.byrobot.entity;

import java.io.Serializable;
import java.util.Date;
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
 * File Name: CallDetail.java
 * </p>
 * <p>
 * Description: 通话详情
 * </p>
 * <p>
 * Date：2019年4月30日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_calldetail")
@Data
@ToString
public class CallDetail implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
    private Long id;

	/**
	 * 任务id
	 */
	@ApiModelProperty(notes = "任务id", example = "6321", required = true)
	private Integer callJobId;
	
	@ApiModelProperty(notes = "公司id", example = "66", required = true)
    private Integer companyId;

	@ApiModelProperty(notes = "客户姓名", example = "测试人员", required = true)
    private String customerName;

	@ApiModelProperty(notes = "手机", example = "18699999999", required = true)
    private String customerTelephone;
    
	@ApiModelProperty(notes = "客户id", example = "123", required = true)
    private Integer customerId;
    
    /**
     * Json
            //客户额外信息，如果话术中包含变量，则需要在properties中加上对应字段，map的key和话术中的变量保持一致。如果话术没有变量，则不要properties
     */
    private String properties;

    /**
     * 1：是 0：否（默认1）
            （默认强制转移） 有多个子账号（团队成员）情况下，客户【a】被子账号A跟进，此时通过api向子账号B创建的任务中导入客户【a】 会因为跟进人不是子账号B导致失败，如果forceTransferCustomer设置为1，则会强制将客户【a】导入到子账号B 创建的任务中，并且将客户【a】分配给子账号B
     */
    private Integer forceTransferCustomer;

    private Long callInstanceId;

    private Integer sceneDefId;

    /**
     *  0:未开始,1:进行中,2:已完成,3:调度中,4:手动暂停,5:自动暂停,6:已终止,7:排队中,8:AI到期,9:账户欠费,10：短信欠费   
     */
    private Integer status;

    /**
     * 0:已接, 1:拒接, 2:无法接通, 3:主叫号码不可用, 4:空号, 5:关机, 6:占线, 7:停机, 8:未接, 9:主叫欠费,10:呼损,11:黑名单
     */
    private Integer finishStatus;

    private Integer duration;

    private Integer chatRound;

    private String startTime;

    /**
     * 2017-10-25 11:17:06
     */
    private String endTime;

    private String callerPhone;

    private Integer callIndex;

    /**
     * （包含用户录音和Ai语音）
     */
    private String luyinOssUrl;

    private String userLuyinOssUrl;

    /**
     *  0: 免费试用 1: 任务 2: 用户单独拨打
     */
    private Integer callType;

    /**
     * 0: 未读 1: 已读
     */
    private Integer readStatus;

    private Integer robotDefId;

    private Integer sceneRecordId;
    
    private Integer secondaryCallTimes;
    
    private Date secondaryCallTime;
    
    /**
     *  0: AI 1: 用户
     */
    private Integer hangUp;
    
    /**
     * 主叫用户id
     */
    private Integer callUserId;
    
    private String handlePerson;
    
    private String jobName;
    
    private String industry;
    
    private String trackResult;
    
    private String bugType;
    
    private Integer cost;
    
    private Integer csStaffId;
    
    private Date gmtCreate;
    
    private Date gmtModified;
        
    private Integer callbacked;
    
    @Transient
    private List<CallResult> taskResult;
    
    @Transient
    private Date callerTime;
}