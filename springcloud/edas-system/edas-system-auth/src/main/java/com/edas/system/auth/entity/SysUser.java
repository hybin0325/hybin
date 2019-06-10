package com.edas.system.auth.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Table;

import com.edas.system.auth.entity.po.BasePo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Table(name = "shopwwi_sys_users")
public class SysUser extends BasePo<Long> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1800717324188350431L;
	private String name;
	private String mobile;
	private String username;
	private String password;

	@Column(name="headimg_url")
	private String headimgUrl;
	private String email;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Integer sex;
	private Integer status;
	
	private Set<Role> setRole;
	
	public interface Status {
		int DISABLED = 0;
		int VALID = 1;
		int LOCKED = 2;
	}

}