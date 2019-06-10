package com.edas.business.systask.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: TaskPlan.java
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
@Table(name = "shopwwi_zt_taskplan")
@Data
@ToString
public class TaskPlan implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    private Long taskId;

    /**
     * 1、重复执行 2、执行一次
     */
    private Integer planType;

    /**
     * 执行一次时间时间
     */
    private Date oneTime;

    /**
     * 每天 每周 每月
            
     */
    private Integer executionFrequency;

    /**
     * 周期为每天时，执行间隔xxx天执行
            周期为周时，执行间隔xxx周的星期几 ， 值为：1|3    代表：间隔1周，每周的星期三执行
            周期为月时，执行间隔 xxx 月的第几天，值为：1|3    代表：间隔1月，每月的第3天执行
            
     */
    private String frequencyInterval;

    /**
     * 执行一次时间  值为： 1|01:10:20  代表：每天执行一次，运行时间是：01:10:20
            执行间隔          
            值为： 2|3|1|08:00:00|18:00:00 代表：执行间隔：3 秒钟执行一次，从08:00:00 开始，到 18:00:00 结束
            值为： 2|3|2|08:00:00|18:00:00 代表：执行间隔：3 分钟执行一次，从08:00:00 开始，到 18:00:00 结束
            值为： 2|3|3|08:00:00|18:00:00 代表：执行间隔：3 小时执行一次，从08:00:00 开始，到 18:00:00 结束
     */
    private String dayFrequency;

    /**
     * 有结束时间       无结束时间
            eg:  值为： 1|2000:01:01|2019:05-16   代表：从2000-01-01 开始，到2019-05016 结束
            eg:  值为： 2|2000:01:01   代表：从2000-01-01 开始，无结束
     */
    private String duration;
}
