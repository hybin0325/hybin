package com.edas.business.byrobot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;
import lombok.ToString;


/**
 * <p>
 * File Name: CallRecord.java
 * </p>
 * <p>
 * Description: 电话录音
 * </p>
 * <p>
 * Date：2019年5月8日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_ai_baiying_callrecord")
@Data
@ToString
public class CallRecord implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String clique;
    
    private String createUser;
    
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    
    private String path;
    
    private String fileName;
}