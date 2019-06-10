package com.edas.system.auth.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edas.edascommon.core.AbstractServices;
import com.edas.system.auth.dao.ResourceMapper;
import com.edas.system.auth.dao.RoleMapper;
import com.edas.system.auth.entity.Resource;
import com.edas.system.auth.entity.Role;
import com.edas.system.auth.entity.SysUser;
import com.edas.system.auth.service.IResourceService;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResourceServiceImpl extends AbstractServices<Resource> implements IResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<Resource> findAll() {
    	log.info("findAll{}----------------------");
        return resourceMapper.findAll();
    }

    @Override
    public Set<Resource> queryByRoleCodes(String[] roleCodes) {
        return resourceMapper.queryByRoleCodes(roleCodes);
    }

	@Override
	public void saveResource(Resource resource) {
		resourceMapper.insert(resource);
	}

	@Override
	public void updateResource(Resource resource) {
		resourceMapper.updateByPrimaryKeySelective(resource);
	}

	@Override
	public void deleteResource(Long id) {
		resourceMapper.deleteRolePermission(id);
		resourceMapper.deleteByPrimaryKey(id);
		resourceMapper.deleteByParentId(id);

		log.debug("删除菜单id:{}", id);
	}

	@Override
	public List<Resource> findByParents() {
		return resourceMapper.selectByParents();
	}

	@Override
	public List<Resource> findByByRoleId(Long roleId) {
		return resourceMapper.selectByRoleId(roleId);
	}
	
	public Set<Role> findByByRole(Long resourceId) {
		return roleMapper.selectByResourceId(resourceId);
	}

	@Override
	public List<Resource> selectBylist(Map<String, Object> params, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<Resource> list=resourceMapper.selectlist(params);
		return list;
	}
    
  
}
