package net.medcrm.yjb.workflow.service;

import net.medcrm.yjb.workflow.domain.UserInfo;

public interface IUserDetailService {
	/**
	 * 根据用户名获取用户详细信息
	 */
	UserInfo findUserDetails(String userId) throws Exception;
}
