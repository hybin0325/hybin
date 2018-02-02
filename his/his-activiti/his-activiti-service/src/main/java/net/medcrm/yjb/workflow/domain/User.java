package net.medcrm.yjb.workflow.domain;

public class User {
	private String userName;
	private String accountNane;
	private String userId;
	
	private String department;//部门
	
	private String department_id;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAccountNane() {
		return accountNane;
	}
	public void setAccountNane(String accountNane) {
		this.accountNane = accountNane;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	
}
