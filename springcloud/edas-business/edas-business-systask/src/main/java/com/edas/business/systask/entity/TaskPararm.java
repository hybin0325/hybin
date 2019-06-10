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
 * File Name: TaskPararm.java
 * </p>
 * <p>
 * Description: 任务实体
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_taskpararm")
@Data
@ToString
public class TaskPararm implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    /**
     * 任务编号
     */
    private Long taskId;

    /**
     * eg: 当前ibu
     */
    private String paramDec;

    /**
     * eg: [dld]  执行sql 时，替换成ibu编号
     */
    private String paramName;

    /**
     * eg : GS
     */
    private String paramValue;

    /**
     * eg : [dld] 属于系统变量，直接替换成当前执行的ibu编号
     */
    private Integer isSystem;
}
