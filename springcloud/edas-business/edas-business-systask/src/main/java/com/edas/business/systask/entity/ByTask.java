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
 * File Name: ByTask.java
 * </p>
 * <p>
 * Description: 百应任务关联实体
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_bytask")
@Data
@ToString
public class ByTask implements Serializable{
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
    private Long id;
	
	/**
     * 任务编号
     */
    private Long taskId;

    private Long bytaskId;

}