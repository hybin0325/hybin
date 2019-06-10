package com.edas.business.systask.quartz;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * Description job实体类方便参数的传递
 * </p>
 * <p>
 * Date：2019年6月5日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Data
@ToString
public class QuartzEntity implements Serializable{
	
	private String jobName;// 任务名称
	private String jobGroup;// 任务分组
	private String description;// 任务描述
	private String jobClassName;// 执行类
	private String cronExpression;// 执行时间
	private String triggerName;// 执行时间
	private String triggerState;// 任务状态

	private String oldJobName;// 任务名称 用于修改
	private String oldJobGroup;// 任务分组 用于修改

	public QuartzEntity() {
		super();
	}

	public QuartzEntity(String jobName, String jobGroup, String description, String jobClassName, String cronExpression,
			String triggerName) {
		super();
		this.jobName = jobName;
		this.jobGroup = jobGroup;
		this.description = description;
		this.jobClassName = jobClassName;
		this.cronExpression = cronExpression;
		this.triggerName = triggerName;

	}
}