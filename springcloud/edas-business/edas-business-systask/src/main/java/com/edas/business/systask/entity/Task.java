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
 * File Name: Task.java
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
@Table(name = "shopwwi_zt_task")
@Data
@ToString
public class Task implements Serializable{
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)		
    private Long id;

    /**
     * 集团(公司)
     */
    private String clique;

    /**
     * ibu编号
     */
    private String dld;

    /**
     * 1、任务跟进类 2、到期提醒类
     */
    private Integer taskType;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 售后、保险、会员、二手车、人事、俱乐部、代办、电子名片
     */
    private Integer appType;

    /**
     * eg: 保险：续保跟进任务产生、保险到期日提醒、续保优惠活动提醒
     */
    private Integer appBusinessType;

    /**
     * 1、智能AI（活动通知）  2、人工跟进  3、智能AI + 人工（筛选意向客户，再人工跟进）
     */
    private Integer mode;

    /**
     * 1、 客户经理制  
            2、随机分配 
            3、人工分配 跟进人为空
            4、导入excel(提供模板：手机号、业务人员工号
            
     */
    private Integer customerDistribution;

    /**
     * 1、sql 逻辑（字段对应的设置） 2、excel 导入
     */
    private Integer custormerSource;

    /**
     * 客户取数逻辑
     */
    private String cusSql;
    
    private Integer state;

    /**
     * 计划开始时间
     */
    private Date startTime;

    /**
     * 计划终止时间
     */
    private Date stopTime;

    /**
     * 下次运行时间
     */
    private Date nextRunTime;

    /**
     * 最后运行时间
     */
    private Date lastRunTime;

    /**
     * 执行状态：成功，失败，执行中
     */
    private String runState;

    /**
     * 失败时，记录失败原因
     */
    private String runErrorLog;

    /**
     * 同一集团下，同个逻辑对不同的分公司有效。 
            这样可以避免相同的逻辑重复写
            
            eg:  南菱集团下： GS01, GV01 ,GX01
     */
    private String runRange;

    private String insertTable;

}