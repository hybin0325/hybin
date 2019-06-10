package com.edas.system.auth.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.assertj.core.util.Sets;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.edas.system.auth.dao.ResourceMapper;
import com.edas.system.auth.dao.RoleMapper;
import com.edas.system.auth.dao.UserMapper;
import com.edas.system.auth.entity.Resource;
import com.edas.system.auth.entity.Role;
import com.edas.system.auth.entity.SysUser;
import com.edas.system.auth.entity.SysUser.Status;
import com.edas.system.auth.entity.dto.UserDto;
import com.edas.system.auth.service.IUserService;
import com.edas.system.common.model.LoginUsers;
import com.edas.system.common.model.Resources;
import com.edas.system.common.model.Roles;
import com.github.pagehelper.PageHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private ResourceMapper resourceMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public SysUser getByUsername(String username) {
		// return userMapper.getByUsername(username);
		return userMapper.selectByUsername(username);
	}

	public void create(SysUser user) {
		// 进行加密
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = user.getPassword().trim();
		user.setPassword(encoder.encode(password));

	}

	@Override
	public List<Resource> selectByUserId(Long userId) {
		return userMapper.selectByUserId(userId);
	}

	public Set<Resources> selectByResources(Long userId) {
		Set<Resources> sets = Sets.newHashSet();
		Set<Resource> set = resourceMapper.selectByResources(userId);
		for (Resource resource : set) {
			Resources resources = new Resources();
			BeanUtils.copyProperties(resource, resources);
			sets.add(resources);
		}
		return sets;
	}
	
	public Long saveUsers(SysUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setStatus(Status.VALID);
		int userInt= userMapper.insert(user);
		log.debug("新增用户 id{} === >", user.getId());
		if(userInt<0) {
			return null;
		}
		if(user.getId()<1) {
			int id=userMapper.getLastId();
			log.debug("最后 id{} === >", id);
			return Long.parseLong(id+"");
		}
		return user.getId();
	}

	@Override
	public SysUser saveUser(UserDto userDto) {
		SysUser user = userDto;
		Long userId= saveUsers(user);
		log.debug("角色 id{}", userDto.getRoleIds());
		if (userDto.getRoleIds() != null && userDto.getRoleIds().size() > 0 && userId>0) {
			saveUserRoles(userId, userDto.getRoleIds());
		}
		log.debug("新增用户{}", user.getUsername());
		return user;
	}

	private void saveUserRoles(Long userId, List<Long> roleIds) {
		if (roleIds != null) {
			userMapper.deleteUserRole(userId);
			if (!CollectionUtils.isEmpty(roleIds)) {
				userMapper.saveUserRoles(userId, roleIds);
			}
		}
	}

	@Override
	public SysUser updateUser(UserDto userDto) {
		userMapper.updateByPrimaryKeySelective(userDto);
		saveUserRoles(userDto.getId(), userDto.getRoleIds());
		return userDto;
	}

	@Override
	public SysUser getUser(String username) {
		return userMapper.selectByUsername(username);
	}

	@Override
	public void changePassword(String username, String oldPassword, String newPassword) {
		SysUser user = userMapper.selectByUsername(username);
		if (user == null) {
			throw new IllegalArgumentException("用户不存在");
		}

		if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
			throw new IllegalArgumentException("旧密码错误");
		}

		userMapper.changePassword(user.getId(), passwordEncoder.encode(newPassword));

		log.debug("修改{}的密码", username);
	}

	@Override
	public List<SysUser> selectBylist(Map<String, Object> params, int pageNo, int pageSize) {
		params.put("status", SysUser.Status.VALID);
		PageHelper.startPage(pageNo, pageSize);
		List<SysUser> list = userMapper.selectBylist(params);
		for (SysUser sysUser : list) {
			Set<Role> roles= roleMapper.queryByUserId(sysUser.getId());
			sysUser.setSetRole(roles);
			//List<String> names = roles.stream().map(p -> p.getName()).collect(Collectors.toList());

		}
		return list;
	}

	@Override
	public SysUser getById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public Set<Roles> queryByUserId(long userId) {
		Set<Roles> sets = Sets.newHashSet();
		Set<Role> set = roleMapper.selectByRole(userId);
		for (Role role : set) {
			Roles roles = new Roles();
			BeanUtils.copyProperties(role, roles);
			sets.add(roles);
		}
		return sets;
	}
	
	public void delUser(Long userId) {
		SysUser user=userMapper.selectByPrimaryKey(userId);
		if(user!=null) {
			user.setStatus(SysUser.Status.DISABLED);
			userMapper.updateByPrimaryKeySelective(user);
		}
		
	
	}
}
