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
 * File Name: AiPhone.java
 * </p>
 * <p>
 * Description: ai电话关联实体
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_aiphone")
@Data
@ToString
public class AiPhone implements Serializable{
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
    private Long id;
	
	/**
     * AI渠道
     */
    private Integer aichannel;

    /**
     * 启动客户转交
     */
    private Integer isChangeCus;

    /**
     * 客户转交完成
     */
    private Integer isChangeOver;

}