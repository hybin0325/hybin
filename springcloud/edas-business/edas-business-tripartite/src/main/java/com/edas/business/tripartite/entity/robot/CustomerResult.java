package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: CustomerResult.java
 * </p>
 * <p>
 * Description: 客户信息返回结果
 * </p>
 * <p>
 * Date：2019年5月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Data
@ToString
public class CustomerResult implements Serializable {
	
	private String msg;
	
	private int successNum;
    
    private int repeatNum;
    
    private int placeFailNum;
    
}