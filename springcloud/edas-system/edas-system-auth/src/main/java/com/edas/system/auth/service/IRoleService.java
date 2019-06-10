package com.edas.system.auth.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.edas.system.auth.entity.Role;
import com.edas.system.auth.entity.dto.RoleDto;

public interface IRoleService {

	Set<Role> queryUserRolesByUserId(long userId);

	void saveRole(RoleDto roleDto);

	void deleteRole(Long id);

	List<Role> findAll(Map<String, Object> params, int pageNo, int pageSize);

	List<Role> listByUserId(Long userId);

	Role selectById(Long id);

	List<Role> findByList();

	void saveRole2(RoleDto roleDto);

	void updateRole(RoleDto roleDto);

}
