package com.his.foundation.model.authentication;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 账号表
 * 
 * @author hybin
 *
 */
public class Account extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8175811504125636160L;
	
	private String name;// 账号名称,需要验证唯一性
	private String loginUserName;// 帐号,工号,手机号码,不能重复,保持唯一
	private String encryptedLoginUserPassword;// 加salt后的加密的密码.md5(md5($password)+$salt)
	private String disabled;// “Y”,"N".不允许用户登陆
	private String forceUserToChangePasswordUponFirstLogin;// “Y”,"N".是否强制用户第一次登陆后修改密码
	private Long passwordExpiresAt;// 密码过期时间.自1970年1月1日0时起的毫秒数
	private String saltId;// 引用SALT对象id
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoginUserName() {
		return loginUserName;
	}
	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}
	public String getEncryptedLoginUserPassword() {
		return encryptedLoginUserPassword;
	}
	public void setEncryptedLoginUserPassword(String encryptedLoginUserPassword) {
		this.encryptedLoginUserPassword = encryptedLoginUserPassword;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getForceUserToChangePasswordUponFirstLogin() {
		return forceUserToChangePasswordUponFirstLogin;
	}
	public void setForceUserToChangePasswordUponFirstLogin(String forceUserToChangePasswordUponFirstLogin) {
		this.forceUserToChangePasswordUponFirstLogin = forceUserToChangePasswordUponFirstLogin;
	}
	public Long getPasswordExpiresAt() {
		return passwordExpiresAt;
	}
	public void setPasswordExpiresAt(Long passwordExpiresAt) {
		this.passwordExpiresAt = passwordExpiresAt;
	}
	public String getSaltId() {
		return saltId;
	}
	public void setSaltId(String saltId) {
		this.saltId = saltId;
	}
}
