package com.edas.system.auth.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.constants.ResultEnum;
import com.edas.edascommon.model.Result;
import com.edas.system.auth.autoconfigure.LogAnnotation;
import com.edas.system.auth.entity.SysUser;
import com.edas.system.auth.entity.dto.PageTableRequest;
import com.edas.system.auth.entity.dto.UserDto;
import com.edas.system.auth.service.IUserService;
import com.edas.system.auth.utils.UserUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/users")
//@Api(value="用户controller",tags={"用户"})
public class UserController {

    @Autowired
    private TokenStore tokenStore;
    
    @Autowired
	private IUserService userService;

    @GetMapping("/user")
    public Principal user(Principal user) {
    	
    	log.info("user "+user);
        return user;
    }

    @RequestMapping("/oauth/remove_token")
    public Result removeToken(@RequestParam("access_token") String token) {
    	log.info("token----------------------------"+ token);
        if (token != null) {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
            tokenStore.removeAccessToken(accessToken);
        } else {
            return Result.fail(ResultEnum.BAD_CREDENTIALS);
        }

        return Result.success();
    }
    
    
    @GetMapping("/user/test")
    public Result getTest() {
    	 return Result.success();
    }
    
   
    @LogAnnotation
	@PostMapping("/save")
	@ApiOperation(value = "保存用户")
	@PreAuthorize("hasAuthority('sys:user:add')")
	public Result saveUser(@RequestBody UserDto userDto) {
    	log.info("saveUser {} === >"+userDto);
		SysUser u = userService.getUser(userDto.getUsername());
		if (u != null) {
			throw new IllegalArgumentException(userDto.getUsername() + "已存在");
		}
		return Result.success(userService.saveUser(userDto));
	}

    @LogAnnotation
	@PutMapping("/edit")
	@ApiOperation(value = "修改用户")
	@PreAuthorize("hasAuthority('sys:user:add')")
	public Result updateUser(@RequestBody UserDto userDto) {
		return Result.success(userService.updateUser(userDto));
	}

	
	@PutMapping("/{username}")
	@ApiOperation(value = "修改密码")
	@PreAuthorize("hasAuthority('sys:user:password')")
	public Result changePassword(@PathVariable String username, String oldPassword, String newPassword) {
		userService.changePassword(username, oldPassword, newPassword);
		return Result.success();
	}

	
	@PostMapping("/page")
	@ApiOperation(value = "用户列表")
	@PreAuthorize("hasAuthority('sys:user:query')")
	public Result listUsers(@RequestBody PageTableRequest request) {
		log.info("-------------------------------------------");
		List<SysUser> list = userService.selectBylist(request.getParams(), request.getPageNo(), request.getPageSize());
		PageInfo<SysUser> pageInfo =new PageInfo<SysUser>(list);
	    Map<String,Object> map=Maps.newHashMap();
	    log.info("分页数据 ： List{} ==>  "+pageInfo.getList());
	    map.put("list", pageInfo.getList());
	    map.put("total", pageInfo.getTotal());
		return Result.success(map);

	}

	@ApiOperation(value = "根据用户id获取用户")
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('sys:user:query')")
	public Result getUser(@PathVariable Long id) {
		return Result.success(userService.getById(id));
	}
	
	@ApiOperation(value = "根据用户username获取用户")
	@GetMapping("/{username}")
	@PreAuthorize("hasAuthority('sys:user:query')")
	public Result getUserName(@PathVariable String username) {
		return Result.success(userService.getByUsername(username));
	}
	
	@ApiOperation(value = "当前登录用户")
	@GetMapping("/current")
	public Result currentUser() {
		return Result.success(UserUtil.getCurrentUserUsername());
	}
	
	@ApiOperation(value = "删除用户id获取用户")
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('sys:user:query')")
	public Result delete(@PathVariable Long id) {
		userService.delUser(id);
		return Result.success();
	}

}

