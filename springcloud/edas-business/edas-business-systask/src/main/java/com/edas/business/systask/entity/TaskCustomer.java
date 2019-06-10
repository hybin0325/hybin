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
 * File Name: TaskCustomer.java
 * </p>
 * <p>
 * Description: 任务客户实体
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_taskcustomer")
@Data
@ToString
public class TaskCustomer implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;

    /**
     * 任务编号
     */
    private Long taskId;

    /**
     * 客户手机
     */
    private String customerPhone;

    /**
     * 业务员
     */
    private String userId;

    /**
     * 1、sql 逻辑（字段对应的设置） 2、excel 导入
     */
    private Integer custormerSource;
}
