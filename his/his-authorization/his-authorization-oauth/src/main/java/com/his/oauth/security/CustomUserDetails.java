package com.his.oauth.security;

import com.his.oauth.domain.SysAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/1.
 */
public class CustomUserDetails extends User implements Serializable{


    private List<SysAuthority> sysAuthoritys;

 /*   Set<GrantedAuthority> authorities = new HashSet<>();
    public  CustomUserDetails(String username, String password, List<SysAuthority> sysAuthoritys){

        sysAuthoritys.forEach(vo -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(vo.getName());
            authorities.add(grantedAuthority);
        });
        this(username, password, true, true, true, true, authorities);

    }*/

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public List<SysAuthority> getSysAuthoritys() {
        return sysAuthoritys;
    }

    public void setSysAuthoritys(List<SysAuthority> sysAuthoritys) {
        this.sysAuthoritys = sysAuthoritys;
    }
}
