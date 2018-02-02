package net.medcrm.yjb.workflow.service;

import java.util.List;

/**
 * 用户组关系
 * @author Administrator
 *
 */
public interface IdentityMembershipService {

	/**
	 * 获取指定的用户所在的组ID列表
	 */
	public List<String> findGroupIdsByUser(String userId);

	/**
	 * 获取指定组的成员用户ID列表
	 */
	public List<String> findUserIdsByGroup(String groupId);
}
