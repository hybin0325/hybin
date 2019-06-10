package com.edas.business.byrobot.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;


/**
 * <p>
 * File Name: SceneRecords.java
 * </p>
 * <p>
 * Description: 场景记录
 * </p>
 * <p>
 * Date：2019年5月8日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */

@SuppressWarnings("serial")
@Data
@ToString
public class SceneRecords implements Serializable{

	private Integer sceneRecordId;
    
    private String sceneRecordName;
    
}