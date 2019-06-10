package com.edas.system.auth.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.model.Result;
import com.edas.system.auth.autoconfigure.LogAnnotation;
import com.edas.system.auth.entity.Role;
import com.edas.system.auth.entity.SysUser;
import com.edas.system.auth.entity.dto.PageTableRequest;
import com.edas.system.auth.entity.dto.RoleDto;
import com.edas.system.auth.entity.dto.UserDto;
import com.edas.system.auth.service.IRoleService;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @param id
 */

@Slf4j
@RestController
@RequestMapping("/roles")
//@Api(value="用户角色controller",tags={"角色"})
public class RoleController {

	@Autowired
	private IRoleService roleService;

	@PostMapping("/saveOrUp")
	@ApiOperation(value = "保存角色")
	@PreAuthorize("hasAuthority('sys:role:add')")
	public void saveOrUpRole(@RequestBody RoleDto roleDto) {
		log.info("参数RoleDto:{} ==>", roleDto);
		roleService.saveRole(roleDto);
	}

	@PostMapping("/page")
	@ApiOperation(value = "角色列表")
	// @PreAuthorize("hasAuthority('sys:role:query')")
	public Result listRoles(@RequestBody PageTableRequest request) {
		log.info("参数request:{} ==>", request);
		List<Role> list = roleService.findAll(request.getParams(), request.getPageNo(), request.getPageSize());
		PageInfo<Role> pageInfo = new PageInfo<Role>(list);
		Map<String, Object> map = Maps.newHashMap();
		map.put("list", pageInfo.getList());
		map.put("total", pageInfo.getTotal());
		return Result.success(map);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "根据id获取角色")
	@PreAuthorize("hasAuthority('sys:role:query')")
	public Result get(@PathVariable Long id) {

		return Result.success(roleService.selectById(id));
	}

	@GetMapping("/all")
	@ApiOperation(value = "所有角色")
	@PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
	public Result roles() {
		List<Role> list = roleService.findByList();
		return Result.success(list);
	}

	@GetMapping("/getByUserId")
	@ApiOperation(value = "根据用户id获取拥有的角色")
	@PreAuthorize("hasAnyAuthority('sys:user:query','sys:role:query')")
	public Result findRoles(@RequestParam("userId") Long userId) {
		return Result.success(roleService.listByUserId(userId));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除角色")
	@PreAuthorize("hasAuthority('sys:role:del')")
	public Result delete(@PathVariable Long id) {
		roleService.deleteRole(id);
		return Result.success();
	}

	@LogAnnotation
	@PostMapping("/save")
	@ApiOperation(value = "保存角色")
	@PreAuthorize("hasAuthority('sys:role:add')")
	public Result saveRole(@RequestBody RoleDto roleDto) {
		log.info("RoleDto {} === >" + roleDto);
		roleService.saveRole2(roleDto);
		return Result.success();
	}
	
	@LogAnnotation
	@PutMapping("/edit")
	@ApiOperation(value = "修改角色")
	@PreAuthorize("hasAuthority('sys:role:add')")
	public Result updateUser(@RequestBody RoleDto roleDto) {
		log.info("RoleDto {} === >" + roleDto);
		roleService.updateRole(roleDto);
		return Result.success();
	}
}
