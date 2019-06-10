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
 * File Name: CallResult.java
 * </p>
 * <p>
 * Description: 通话结果
 * </p>
 * <p>
 * Date：2019年5月5日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_callresult")
@Data
@ToString
public class CallResult implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private Integer sceneInstanceResultId;

    private Integer companyId;

    private Long sceneInstanceId;

    private String resultName;

    private String resultValue;

    private String resultDesc;

    private String analyzeType;

    private Date gmtCreate;

    private Date gmtModified;

    private String artificialResultValue;

    private Integer artificialChanged;

    private String extra;

    private String resultValueAlias;

    private String resultValueNew;
    
    private Integer callJobId; 
}