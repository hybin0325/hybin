package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


/**
 * <p>
 * File Name: CallLog.java
 * </p>
 * <p>
 * Description: 通话日志
 * </p>
 * <p>
 * Date：2019年5月5日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_calllog")
@Data
@ToString
public class CallLog implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	private Long sceneInstanceLogId;

    private Long sceneInstanceId;

    private Integer robotDefId;

    private Integer decisionId;

    private String speaker;

    private String content;

    private String userMean;

    private String userMeanDetail;

    private Integer aiUnknown;

    private Integer answerStatus;

    private Integer studyStatus;

    private Integer startTime;

    private Integer endTime;

    private Date gmtCreate;

    private Date gmtModified;

    private String correctionContent;

    private String luyinOssUrl;

    private Boolean jobFinished;

    private String sign;

    private String dateTime;

    private Integer companyId;
    
    private Integer taskId;
    
}