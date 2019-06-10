package com.edas.system.auth.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.edas.system.auth.entity.Resource;
import com.edas.system.auth.entity.Role;
import com.edas.system.auth.entity.SysUser;
import com.edas.system.auth.entity.dto.UserDto;
import com.edas.system.common.model.Resources;
import com.edas.system.common.model.Roles;

public interface IUserService {

    @Cacheable(value = "sysUser",key="#username")
    SysUser getByUsername(String username);
    
    List<Resource> selectByUserId(Long userId);
    
    @CacheEvict(value = "sysUser", allEntries = true)
    SysUser saveUser(UserDto userDto);

    @CacheEvict(value = "sysUser", allEntries = true)
    SysUser updateUser(UserDto userDto);

    SysUser getUser(String username);

    @CacheEvict(value = "sysUser", allEntries = true)
	void changePassword(String username, String oldPassword, String newPassword);
	
	List<SysUser> selectBylist(Map<String, Object> params,int pageNo,int pageSize);
	
	SysUser getById(Long id);
	
	public Set<Resources> selectByResources(Long userId);
	
	Set<Roles> queryByUserId(long userId);
	
	@CacheEvict(value = "sysUser", allEntries = true)
    void delUser(Long userId);
}
