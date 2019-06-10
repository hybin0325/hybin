package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
 * File Name: Customer.java
 * </p>
 * <p>
 * Description: 任务客户表
 * </p>
 * <p>
 * Date：2019年5月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_customer")
@Data
@ToString
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	
	private Integer companyId;
	
	private Integer taskId;
	
	//通话记录id
    private Long callInstanceId;
    
	//姓名
    @ApiModelProperty(notes = "姓名", example = "测试人员", required = true)
    private String name;

    //手机号
    @ApiModelProperty(notes = "手机号", example = "18699999999", required = true)
    private String phone;
    
    /**
     * 任务名称
     */
    private String jobName;

    private Integer status;

    private Integer finishStatus;    

    private String trackResult;

    //客户额外信息，如果话术中包含变量，则需要在properties中加上此字段，map的key和话术中的变量保持一致
    @Transient
    private Map<String, String> properties = new HashMap<>();
}