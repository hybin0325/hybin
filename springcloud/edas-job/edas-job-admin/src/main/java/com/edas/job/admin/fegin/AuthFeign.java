package com.edas.job.admin.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.edas.edascommon.model.Result;
import com.edas.job.admin.core.dto.QueryRes;
import com.edas.job.admin.core.dto.ResourceDTO;
import com.edas.job.admin.core.dto.RolesDTO;
import com.edas.job.admin.core.model.XxlJobUser;

//@FeignClient(value = "edas-message",  fallbackFactory = MsgFeignFallbackFactory.class)
@FeignClient(name = "edas-system-auth", url = "http://14.152.78.200:13012/api-auth")
//@FeignClient(name = "edas-system-auth", url = "http://127.0.0.1:19012")
public interface AuthFeign {

	@PostMapping(value = "/oauth/login")
	public Result userLogin(@RequestParam String username, @RequestParam String password);

	@GetMapping(value = "/users/{username}")
	public Result getUserName(@RequestHeader(value = "Authorization") String authorization,
			@PathVariable String username);

	@GetMapping(value = "/api/{username}")
	public Result<XxlJobUser> getUserName(@PathVariable String username);

	@PostMapping(value = "/users/page")
	public Result listUsers(@RequestHeader(value = "Authorization") String authorization,
			@RequestBody QueryRes request);

	@GetMapping(value = "/roles/all")
	public Result findRoles(@RequestHeader(value = "Authorization") String authorization);

	@PostMapping(value = "/roles/page")
	public Result findPageRoles(@RequestHeader(value = "Authorization") String authorization,
			@RequestBody QueryRes request);

	@GetMapping(value = "/resources/all")
	public Result findResources(@RequestHeader(value = "Authorization") String authorization);

	@GetMapping(value = "/resources/page")
	public Result findPageResources(@RequestHeader(value = "Authorization") String authorization,
			@RequestBody QueryRes request);
	
	@GetMapping(value = "/resources/parents")
	public Result findParentResources(@RequestHeader(value = "Authorization") String authorization);
	
	@DeleteMapping("/resources/{id}")
	public Result deleteResource(@RequestHeader(value = "Authorization") String authorization, @PathVariable Long id);

	@PostMapping("/resources/save")
	public Result saveResource(@RequestHeader(value = "Authorization") String authorization,
			@RequestBody ResourceDTO permission);

	@PutMapping("/resources/edit")
	public Result updateResource(@RequestHeader(value = "Authorization") String authorization,
			@RequestBody ResourceDTO permission);

	@PostMapping("/users/save")
	public Result saveUser(@RequestHeader(value = "Authorization") String authorization,
			@RequestBody XxlJobUser userDto);

	@DeleteMapping("/users/{id}")
	public Result delete(@RequestHeader(value = "Authorization") String authorization, @PathVariable Long id);

	@DeleteMapping("/roles/{id}")
	public Result deleteRole(@RequestHeader(value = "Authorization") String authorization, @PathVariable Long id);

	@PostMapping("/roles/saveOrUp")
	public void saveOrUpRole(@RequestHeader(value = "Authorization") String authorization, @RequestBody RolesDTO roleDto);
	
	@PostMapping("/roles/save")
	public void saveRole(@RequestHeader(value = "Authorization") String authorization, @RequestBody RolesDTO roleDto);
	
	@PutMapping("/roles/edit")
	public void editRole(@RequestHeader(value = "Authorization") String authorization, @RequestBody RolesDTO roleDto);

	@PutMapping("/users/{username}")
	public Result changePassword(@RequestHeader(value = "Authorization") String authorization,
			@PathVariable String username, @RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword);

	@GetMapping("/oauth/revoke-token")
	public Result removeToken(@RequestHeader(value = "Authorization") String authorization);

	@PutMapping("/users/edit")
	public Result updateUser(@RequestHeader(value = "Authorization") String authorization,
			@RequestBody XxlJobUser userDto);

}