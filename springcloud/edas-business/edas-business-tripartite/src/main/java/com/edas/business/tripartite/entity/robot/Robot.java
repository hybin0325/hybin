package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;


/**
 * <p>
 * File Name: Robot.java
 * </p>
 * <p>
 * Description: 话术实体
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_robot")
@Data
@ToString
public class Robot implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
    private Integer id;
	
	@ApiModelProperty(notes = "公司id", example = "669", required = true)
    private Integer companyId;
    
	@ApiModelProperty(notes = "话术机器人Id", example = "39", required = true)
    private Integer robotDefId;
    
	@ApiModelProperty(notes = "话术机器人名称", example = "测试", required = true)
    private String robotName;
    
	@ApiModelProperty(notes = "话术场景Id", example = "34", required = true)
    private Integer sceneDefId;
    
	@ApiModelProperty(notes = "话术场景录音id", example = "19", required = true)
    private Integer sceneRecordId;
    
	@ApiModelProperty(notes = "话术场景录音名称", example = "保险通用")
    private String sceneRecordName;
    
	@ApiModelProperty(notes = "一级行业名", example = "汽车", required = true)
    private String industryOneName;
    
	@ApiModelProperty(notes = "二级行业名", example = "保险", required = true)
    private String industryTwoName;
    
	@ApiModelProperty(notes = "创建时间", example = "2019-05-17 15:51:27")
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date gmtModify;
    
	@ApiModelProperty(hidden = true)
    @Transient
    private List<SceneRecords> sceneRecords;
 
}