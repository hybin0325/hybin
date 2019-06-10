package com.edas.business.systask.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: RuleTemplate.java
 * </p>
 * <p>
 * Description: 跟进规则模板实体
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ruletemplate")
@Data
@ToString
public class RuleTemplate implements Serializable{
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
    private Long id;

	/**
     * eg:  
            1、 任务跟进6次后，还不成功，归档入待分配
            2、任务预期5天不跟进，归档入待分配 
     */
    private String remark;

    /**
     * 对应逻辑（默认逻辑）
     */
    private String logic;

    /**
     * 定时服务否
     */
    private Integer isService;

}