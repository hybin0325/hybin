package com.edas.system.auth.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edas.system.auth.entity.Role;
import com.edas.system.auth.entity.SysUser;
import com.edas.system.auth.entity.SysUser.Status;
import com.edas.system.auth.service.IRoleService;
import com.edas.system.auth.service.IUserService;
import com.edas.system.common.model.LoginUsers;
import com.edas.system.common.model.Resources;
import com.edas.system.common.model.Roles;

import lombok.extern.slf4j.Slf4j;

@Service("userDetailsService")
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;

	/*
	 * @Override public UserDetails loadUserByUsername(String username) { SysUser
	 * user = userService.getByUsername(username); if (user == null) { throw new
	 * RuntimeException("用户不存在"); }else if (!user.getEnabled()) { throw new
	 * LockedException("用户被锁定,请联系管理员"); } log.info("loadByUsername:{}",
	 * user.toString()); return new
	 * org.springframework.security.core.userdetails.User(username,
	 * user.getPassword(), user.getEnabled(), user.getAccountNonExpired(),
	 * user.getCredentialsNonExpired(), user.getAccountNonLocked(),
	 * this.obtainGrantedAuthorities(user)); }
	 */

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("--------------------查询用户---------------------");
		SysUser sysUser = userService.getByUsername(username);
		if (sysUser == null) {
			throw new AuthenticationCredentialsNotFoundException("用户名不存在");
		} else if (sysUser.getStatus() == Status.LOCKED) {
			throw new LockedException("用户被锁定,请联系管理员");
		}

		LoginUsers loginUser = new LoginUsers();
		BeanUtils.copyProperties(sysUser, loginUser);
		loginUser.setId(sysUser.getId());

		Set<Resources> resources = userService.selectByResources(sysUser.getId());

		log.info("resources " + resources);
		loginUser.setResources(resources);
		Set<Roles> roles = userService.queryByUserId(sysUser.getId());
		loginUser.setRoles(roles);
		//tokenService.saveCacheLoginUser(loginUser);
		return loginUser;
	}

	/**
	 * 获得登录者所有角色的权限集合.
	 *
	 * @param user
	 * @return
	 */

	private Set<GrantedAuthority> obtainGrantedAuthorities(SysUser user) {
		Set<Role> roles = roleService.queryUserRolesByUserId(user.getId());
		log.info("user:{},roles:{}", user.getUsername(), roles);
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toSet());
	}

}
