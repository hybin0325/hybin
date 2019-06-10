package com.edas.system.auth.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.edas.edascommon.model.Result;
import com.edas.system.auth.entity.Resource;
import com.edas.system.auth.entity.dto.LoginUser;
import com.edas.system.auth.entity.dto.PageTableRequest;
import com.edas.system.auth.service.IResourceService;
import com.edas.system.auth.utils.UserUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 权限相关接口
 *
 */
@Slf4j
@RestController
@RequestMapping("/resources")
//@Api(value="访问资源controller",tags={"资源"})
public class ResourceController {

	@Autowired
	private IResourceService resourceService;

	@ApiOperation(value = "当前登录用户拥有的权限")
	@GetMapping("/current")
	public Result permissionsCurrent() {
		LoginUser loginUser = UserUtil.getLoginUser();
		List<Resource> list = loginUser.getResources();
		final List<Resource> permissions = list.stream().filter(l -> l.getType().equals(1))
				.collect(Collectors.toList());

		List<Resource> firstLevel = permissions.stream().filter(p -> p.getParentId().equals(0L))
				.collect(Collectors.toList());
		firstLevel.parallelStream().forEach(p -> {
			setChild(p, permissions);
		});

		return Result.success(firstLevel);
	}

	/**
	 * 设置子元素
	 *
	 * @param p
	 * @param permissions
	 */
	private void setChild(Resource p, List<Resource> resources) {
		List<Resource> child = resources.parallelStream().filter(a -> a.getParentId().equals(p.getId()))
				.collect(Collectors.toList());
		p.setChild(child);
		if (!CollectionUtils.isEmpty(child)) {
			child.parallelStream().forEach(c -> {
				// 递归设置子元素，多级菜单支持
				setChild(c, resources);
			});
		}
	}

	private void setChild(List<Resource> resources) {
		resources.parallelStream().forEach(per -> {
			List<Resource> child = resources.stream().filter(p -> p.getParentId().equals(per.getId()))
					.collect(Collectors.toList());
			per.setChild(child);
		});
	}

	/**
	 * 菜单列表
	 * 
	 * @param pId
	 * @param permissionsAll
	 * @param list
	 */
	private void setPermissionsList(Long pId, List<Resource> permissionsAll, List<Resource> list) {
		for (Resource per : permissionsAll) {
			if (per.getParentId().equals(pId)) {
				list.add(per);
				if (permissionsAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
					setPermissionsList(per.getId(), permissionsAll, list);
				}
			}
		}
	}

	@GetMapping
	@ApiOperation(value = "菜单列表")
	@PreAuthorize("hasAuthority('sys:menu:query')")
	public Result permissionsList() {
		List<Resource> permissionsAll = resourceService.selectAll();
		List<Resource> list = Lists.newArrayList();
		setPermissionsList(0L, permissionsAll, list);
		return Result.success(list);
	}

	@GetMapping("/all")
	@ApiOperation(value = "所有菜单")
	@PreAuthorize("hasAuthority('sys:menu:query')")
	public Result permissionsAll() {
		List<Resource> permissionsAll = resourceService.selectAll();
		JSONArray array = new JSONArray();
		setPermissionsTree(0L, permissionsAll, array);
		return Result.success(array);
	}

	@GetMapping("/parents")
	@ApiOperation(value = "一级菜单")
	@PreAuthorize("hasAuthority('sys:menu:query')")
	public Result parentMenu() {
		List<Resource> parents = resourceService.findByParents();
		return Result.success(parents);
	}

	/**
	 * 菜单树
	 * 
	 * @param pId
	 * @param permissionsAll
	 * @param array
	 */
	private void setPermissionsTree(Long pId, List<Resource> permissionsAll, JSONArray array) {
		for (Resource per : permissionsAll) {
			if (per.getParentId().equals(pId)) {
				String string = JSONObject.toJSONString(per);
				JSONObject parent = (JSONObject) JSONObject.parse(string);
				array.add(parent);
				if (permissionsAll.stream().filter(p -> p.getParentId().equals(per.getId())).findAny() != null) {
					JSONArray child = new JSONArray();
					parent.put("child", child);
					setPermissionsTree(per.getId(), permissionsAll, child);
				}
			}
		}
	}

	@GetMapping(params = "roleId")
	@ApiOperation(value = "根据角色id获取权限")
	@PreAuthorize("hasAnyAuthority('sys:menu:query','sys:role:query')")
	public Result listByRoleId(Long roleId) {
		return Result.success(resourceService.findByByRoleId(roleId));
	}

	@PostMapping("/save")
	@ApiOperation(value = "保存菜单")
	@PreAuthorize("hasAuthority('sys:menu:add')")
	public Result save(@RequestBody Resource permission) {
		resourceService.saveResource(permission);
		return Result.success();
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "根据菜单id获取菜单")
	@PreAuthorize("hasAuthority('sys:menu:query')")
	public Result get(@PathVariable Long id) {
		return Result.success(resourceService.selectById(id + ""));
	}

	@PutMapping("/edit")
	@ApiOperation(value = "修改菜单")
	@PreAuthorize("hasAuthority('sys:menu:add')")
	public Result update(@RequestBody Resource permission) {
		resourceService.updateResource(permission);
		return Result.success();
	}

	/**
	 * 校验权限
	 * 
	 * @return
	 */
	@GetMapping("/owns")
	@ApiOperation(value = "校验当前用户的权限")
	public Set<String> ownsPermission() {
		List<Resource> permissions = UserUtil.getLoginUser().getResources();
		if (CollectionUtils.isEmpty(permissions)) {
			return Collections.emptySet();
		}
		return permissions.parallelStream().filter(p -> !StringUtils.isEmpty(p.getCode())).map(Resource::getCode)
				.collect(Collectors.toSet());
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "删除菜单")
	@PreAuthorize("hasAuthority('sys:menu:del')")
	public Result delete(@PathVariable Long id) {
		resourceService.deleteResource(id);
		return Result.success();
	}
	
	
	@PostMapping("/page")
	@ApiOperation(value = "分页资源列表")
	@PreAuthorize("hasAuthority('sys:menu:query')")
	public Result findpage(@RequestBody PageTableRequest request) {
		log.info("分页参数 PageTableRequest:{}",request);
		List<Resource> list = resourceService.selectBylist(request.getParams(), request.getPageNo(), request.getPageSize());
		PageInfo<Resource> pageInfo =new PageInfo<Resource>(list);
	    Map<String,Object> map=Maps.newHashMap();
	    log.info("分页数据 ： List{} ==>  "+pageInfo.getList());
	    map.put("list", pageInfo.getList());
	    map.put("total", pageInfo.getTotal());
		return Result.success(map);
	}
}
