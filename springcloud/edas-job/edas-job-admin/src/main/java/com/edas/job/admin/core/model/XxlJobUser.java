package com.edas.job.admin.core.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.util.StringUtils;

import com.edas.job.admin.core.dto.RolesDTO;

import lombok.Data;

/**
 * @author xuxueli 2019-05-04 16:43:12
 */
@Data
public class XxlJobUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1867550366472142366L;
	private int id;
	private String username; // 账号
	private String password; // 密码
	private int role; // 角色：0-普通用户、1-管理员
	private String permission; // 权限：执行器ID列表，多个逗号分割
	private List<Long> roleIds;
	private List<RolesDTO> setRole;
	private String name;

	
	// plugin
	public boolean validPermission(int jobGroup) {
		if (this.role == 1) {
			return true;
		} else {
			if (StringUtils.hasText(this.permission)) {
				for (String permissionItem : this.permission.split(",")) {
					if (String.valueOf(jobGroup).equals(permissionItem)) {
						return true;
					}
				}
			}
			return false;
		}

	}


}
