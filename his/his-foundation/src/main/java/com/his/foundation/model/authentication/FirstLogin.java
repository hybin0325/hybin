/**
 * 
 */
package com.his.foundation.model.authentication;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 用户第一次登陆
 * @author Administrator
 *
 */
public class FirstLogin extends PersistentObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1207063182141283838L;
	
	private String accountName ;//登陆帐号
	private String  host ;//登陆时使用的客户端主机
	private Long  loginAt ;//登陆时间.自1970年1月1日0时起的毫秒数
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Long getLoginAt() {
		return loginAt;
	}
	public void setLoginAt(Long loginAt) {
		this.loginAt = loginAt;
	}
}
