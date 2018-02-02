package net.medcrm.yjb.workflow.util;

/**
 * @author 原饼
 * @version 创建时间2018年1月29日上午10:52:11 办理类别
 **/
public enum HandleType {
	MYAPPLY("myApply", "我的申请"),
	MYDEPTAPPLY("myDeptApply", "本部门的申请"),
	MYHANDLE("myHandle","我的办理"),
	MYDEPTHANDLE("myDeptHandle", "本部门的办理"),
	MYDEPTLEADERHANDLE("myDeptLeaderHandle", "本部门领导的办理");

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private HandleType(String id, String name) {
		this.id = id;
		this.name = name;
	}

}
