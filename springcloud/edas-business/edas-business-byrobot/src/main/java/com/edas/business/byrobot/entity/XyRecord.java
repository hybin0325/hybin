package com.edas.business.byrobot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.ToString;


/**
 * <p>
 * File Name: XyRecord.java
 * </p>
 * <p>
 * Description: 先锋音讯电话记录
 * </p>
 * <p>
 * Date：2019年5月14日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ly_xfyx")
@Data
@ToString
public class XyRecord implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	/**
     * YU1只有一线 所以永远是1
     */
    private Integer line;

    private Long deviceId;

    private Date date;

    private String caller;

    private Integer duration;

    private Long recordId;
    
    private String fileName;
    
    @Transient
    private Integer event_type;
    
}