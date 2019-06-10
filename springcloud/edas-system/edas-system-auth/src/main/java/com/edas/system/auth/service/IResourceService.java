package com.edas.system.auth.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.edas.edascommon.core.Service;
import com.edas.system.auth.entity.Resource;
import com.edas.system.auth.entity.Role;

public interface IResourceService extends Service<Resource> {
	/**
	 * 返回所有的资源定义内容，resources表中
	 *
	 * @return
	 */
	Set<Resource> findAll();

	/**
	 * 根据角色code查询到角色把对应的资源定义
	 *
	 * @param roleCodes
	 * @return
	 */
	Set<Resource> queryByRoleCodes(String[] roleCodes);

	void saveResource(Resource resource);

	void updateResource(Resource resource);

	void deleteResource(Long id);

	List<Resource> findByParents();

	List<Resource> findByByRoleId(Long roleId);

	public Set<Role> findByByRole(Long resourceId);
	
	List<Resource> selectBylist(Map<String, Object> params,int pageNo,int pageSize);
}
