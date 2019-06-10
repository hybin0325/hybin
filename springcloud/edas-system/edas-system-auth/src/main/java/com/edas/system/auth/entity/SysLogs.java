package com.edas.system.auth.entity;

import javax.persistence.Table;

import com.edas.system.auth.entity.po.BasePo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false )
@NoArgsConstructor
@Table(name="shopwwi_sys_logs")
public class SysLogs extends BasePo<Long> {

	private static final long serialVersionUID = -7809315432127036583L;
	private SysUser user;
	private String module;
	private Boolean flag;
	private String remark;
	private Long userId;
	private String url;
}
