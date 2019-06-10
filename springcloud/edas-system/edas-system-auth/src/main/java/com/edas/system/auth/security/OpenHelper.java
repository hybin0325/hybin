package com.edas.system.auth.security;



import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

import com.edas.system.auth.utils.BeanConvertUtils;
import com.edas.system.common.model.LoginUsers;

import java.util.Map;

/**
 * 认证信息帮助类
 * @author 
 */
public class OpenHelper {

    /**
     * 获取认证用户信息
     * @return
     */
    public static LoginUsers getAuthUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() != null) {
            if (authentication.getPrincipal() instanceof LoginUsers) {
                return (LoginUsers) authentication.getPrincipal();
            }
            if (authentication.getPrincipal() instanceof Map) {
                return BeanConvertUtils.mapToObject((Map) authentication.getPrincipal(), LoginUsers.class);
            }
        }
        return null;
    }

    /**
     * 是否拥有权限
     * @param authority
     * @return
     */
    public static Boolean hasAuthority(String authority) {
    	LoginUsers auth = getAuthUser();
        if (auth == null) {
            return false;
        }
        if (AuthorityUtils.authorityListToSet(auth.getAuthorities()).contains(authority)) {
            return true;
        }
        return false;
    }

    /**
     * 构建token转换器
     *
     * @return
     */
    public static DefaultAccessTokenConverter buildAccessTokenConverter() {
        OpenAuthUserConverter userAuthenticationConverter = new OpenAuthUserConverter();
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(userAuthenticationConverter);
        return accessTokenConverter;
    }

    /**
     * 构建自定义远程Token服务类
     *
     * @param properties
     * @return
     */
    public static RemoteTokenServices buildRemoteTokenServices(ResourceServerProperties properties) {
        // 使用自定义系统用户凭证转换器
        DefaultAccessTokenConverter accessTokenConverter = buildAccessTokenConverter();
        RemoteTokenServices services = new RemoteTokenServices();
        services.setCheckTokenEndpointUrl(properties.getTokenInfoUri());
        services.setClientId(properties.getClientId());
        services.setClientSecret(properties.getClientSecret());
        services.setAccessTokenConverter(accessTokenConverter);
        return services;
    }
}
