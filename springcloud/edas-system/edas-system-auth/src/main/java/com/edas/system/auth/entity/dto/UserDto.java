package com.edas.system.auth.entity.dto;

import java.util.List;

import com.edas.system.auth.entity.SysUser;


public class UserDto extends SysUser {

	private static final long serialVersionUID = -184009306207076712L;

	private List<Long> roleIds;

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	

}
