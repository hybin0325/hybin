package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: Company.java
 * </p>
 * <p>
 * Description: 公司实体
 * </p>
 * <p>
 * Date：2019年4月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_company")
@Data
@ToString
public class Company implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "主键", dataType="Integer")
    private Integer id;
	
	@ApiModelProperty(notes = "公司id", example = "66", required = true, dataType="Integer")
    private Integer companyId;
    
	@ApiModelProperty(notes = "公司名称", example = "南菱", required = true, dataType="String")
    private String companyName;
    
}