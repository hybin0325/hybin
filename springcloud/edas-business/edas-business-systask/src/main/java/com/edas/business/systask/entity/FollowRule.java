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
 * File Name: FollowRule.java
 * </p>
 * <p>
 * Description: 跟进规则实体
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_followrule")
@Data
@ToString
public class FollowRule implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
    private Long id;

	/**
     * 任务编号
     */
    private Long taskId;

    /**
     * 规则名称
     */
    private String ruleName;

    /**
     * 项次
     */
    private Short item;

    /**
     * 中文描述
     */
    private String remark;

    /**
     * 对应逻辑（默认逻辑）
     */
    private String logic;

    /**
     * 启动否
     */
    private Short status;

}