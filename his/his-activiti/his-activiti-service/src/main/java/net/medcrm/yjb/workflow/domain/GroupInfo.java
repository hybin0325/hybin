package net.medcrm.yjb.workflow.domain;

/**
 * 部门信息
 * @author Administrator
 *
 */
public class GroupInfo {
	private  String id;
    private  String code;
    private  String groupName;
    private  String mark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
    
    
}
