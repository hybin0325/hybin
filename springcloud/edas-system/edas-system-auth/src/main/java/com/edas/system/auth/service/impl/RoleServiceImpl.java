package com.edas.system.auth.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.edas.system.auth.dao.RoleMapper;
import com.edas.system.auth.entity.Role;
import com.edas.system.auth.entity.dto.RoleDto;
import com.edas.system.auth.service.IRoleService;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<Role> queryUserRolesByUserId(long userId) {
        return roleMapper.queryByUserId(userId);
    }
    
    @Override
	@Transactional
	public void saveRole(RoleDto roleDto) {
		Role role = roleDto;
		List<Long> resourceIds = roleDto.getResourceIds();
		if(resourceIds!=null&& resourceIds.size()>0) {
			resourceIds.remove(0L);
		}
		if (role.getId() != null) {// 修改
			updateRole(role, resourceIds);
		} else {// 新增
			saveRole(role, resourceIds);
		}
	}
    
    @Transactional
    public void saveRole2(RoleDto roleDto) {
    	Role role = roleDto;
		Role r = roleMapper.getByCode(role.getCode());
		if (r != null) {
			throw new IllegalArgumentException(role.getName() + "已存在");
		}

		roleMapper.insert(role);
		if (!CollectionUtils.isEmpty(roleDto.getResourceIds())) {
			roleMapper.saveRoleResources(role.getId(), roleDto.getResourceIds());
		}
		log.debug("新增角色{}", role.getName());
	}

    @Transactional
	public void updateRole(RoleDto roleDto) {
    	Role role = roleDto;
		Role r = roleMapper.getByCode(role.getCode());
		if (r != null && r.getId() != role.getId()) {
			throw new IllegalArgumentException(role.getName() + "已存在");
		}

		roleMapper.updateByPrimaryKeySelective(role);

		roleMapper.deleteRolePermission(role.getId());
		if (!CollectionUtils.isEmpty(roleDto.getResourceIds())) {
			roleMapper.saveRoleResources(role.getId(), roleDto.getResourceIds());
		}
		log.debug("修改角色{}", role.getName());
	}

	private void saveRole(Role role, List<Long> resourceIds) {
		Role r = roleMapper.getByCode(role.getCode());
		if (r != null) {
			throw new IllegalArgumentException(role.getName() + "已存在");
		}

		roleMapper.insert(role);
		if (!CollectionUtils.isEmpty(resourceIds)) {
			roleMapper.saveRoleResources(role.getId(), resourceIds);
		}
		log.debug("新增角色{}", role.getName());
	}

	private void updateRole(Role role, List<Long> resourceIds) {
		Role r = roleMapper.getByCode(role.getCode());
		if (r != null && r.getId() != role.getId()) {
			throw new IllegalArgumentException(role.getName() + "已存在");
		}

		roleMapper.updateByPrimaryKeySelective(role);

		roleMapper.deleteRolePermission(role.getId());
		if (!CollectionUtils.isEmpty(resourceIds)) {
			roleMapper.saveRoleResources(role.getId(), resourceIds);
		}
		log.debug("修改角色{}", role.getName());
	}

	@Override
	@Transactional
	public void deleteRole(Long id) {
		roleMapper.deleteRolePermission(id);
		roleMapper.deleteRoleUser(id);
		roleMapper.deleteByPrimaryKey(id);

		log.debug("删除角色id:{}", id);
	}

	@Override
	public List<Role> findAll(Map<String, Object> params,int pageNo,int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Role> list= roleMapper.selectlist(params);
		return list;
	}

	@Override
	public List<Role> listByUserId(Long userId) {
		return roleMapper.listByUserId(userId);
	}

	@Override
	public Role selectById(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> findByList() {
		return roleMapper.selectAll();
	}
	

}
