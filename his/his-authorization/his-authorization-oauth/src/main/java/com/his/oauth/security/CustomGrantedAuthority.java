package com.his.oauth.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface CustomGrantedAuthority extends GrantedAuthority {
    Integer getAuthorityId();
}
