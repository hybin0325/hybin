package com.edas.system.auth.configurer.custom;

import com.edas.system.common.model.LoginUsers;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义token携带内容
 */
@Slf4j
public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
		LoginUsers user = (LoginUsers) authentication.getUserAuthentication().getPrincipal();
		log.info("user:------------------------------------------- "+user);
		additionalInfo.put("name", user.getName());
		additionalInfo.put("username", user.getUsername());
		additionalInfo.put("authorities", user.getAuthorities());
		additionalInfo.put("roles", user.getRoles());
		additionalInfo.put("resources", user.getResources());
		additionalInfo.put("id", user.getId());
		additionalInfo.put("password", user.getPassword());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
		return accessToken;
    }
}