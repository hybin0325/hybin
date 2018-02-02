package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;

public class HistoryVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7484433297374165476L;

	private TaskInfoVO taskInfo;

	public TaskInfoVO getTaskInfo() {
		return taskInfo;
	}

	public void setTaskInfo(TaskInfoVO taskInfo) {
		this.taskInfo = taskInfo;
	}

}
