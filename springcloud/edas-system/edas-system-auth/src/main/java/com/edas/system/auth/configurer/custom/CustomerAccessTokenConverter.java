package com.edas.system.auth.configurer.custom;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;

import com.edas.system.common.model.LoginUsers;

/**
 * 自定义CustomerAccessTokenConverter 这个类的作用主要用于AccessToken的转换，
 * 默认使用DefaultAccessTokenConverter 这个装换器
 * DefaultAccessTokenConverter有个UserAuthenticationConverter，这个转换器作用是把用户的信息放入token中，
 * 默认只是放入username
 * <p>
 * 自定义了下这个方法，加入了额外的信息
 * <p>
 * . 2017-03-20 9:54
 */
public class CustomerAccessTokenConverter extends DefaultAccessTokenConverter {

	public CustomerAccessTokenConverter() {
		super.setUserTokenConverter(new CustomerUserAuthenticationConverter());
	}

	private class CustomerUserAuthenticationConverter extends DefaultUserAuthenticationConverter {

		@Override
		public Map<String, ?> convertUserAuthentication(Authentication authentication) {
			LinkedHashMap<String, Object> response = new LinkedHashMap<>();
			response.put("username", authentication.getName());
			LoginUsers user = (LoginUsers) authentication.getPrincipal();
			response.put("name", user.getName());
			response.put("email", user.getEmail());
			response.put("roles", user.getRoles());
			response.put("resources", user.getResources());
			response.put("id", user.getId());
			response.put("password", user.getPassword());
			if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
				response.put("authorities", AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
			}
			return response;
		}
	}

}
