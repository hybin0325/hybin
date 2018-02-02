package com.his.oauth.security;

import com.his.oauth.domain.*;
import com.his.oauth.mapper.SysManagerMapper;
import com.his.oauth.mapper.SysUserPositionMapper;
import com.his.oauth.repository.SysGroupRepository;
import com.his.oauth.repository.SysManagerRepository;
import com.his.oauth.repository.UserPositionRepository;
import com.his.oauth.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by lings on 2017/10/26.
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPositionRepository userPositionRepository;

    @Autowired
    private SysManagerRepository sysManagerRepository;

    @Autowired
    private SysGroupRepository sysGroupRepository;

    @Autowired
    private SysManagerMapper sysManagerMapper;

    @Autowired
    private SysUserPositionMapper sysUserPositionMapper;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {

        log.debug("Authenticating {}", login);
        String lowercaseLogin = login.toLowerCase();

        SysUser userFromDatabase;
        if(lowercaseLogin.contains("@")) {
            userFromDatabase = userRepository.findByEmail(lowercaseLogin);
        } else {
            userFromDatabase = userRepository.findByUsernameCaseInsensitive(lowercaseLogin);
        }

        if (userFromDatabase == null) {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        } else if (!userFromDatabase.isActivated()) {
            throw new UserNotActivatedException("User " + lowercaseLogin + " is not activated");
        }

        System.out.println("================================用户权限=========================================");
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        /**
         * 查询登录用户所属于机构（对应的组织机构或者角色）
         */
        List<SysUserPosition> positionList = sysUserPositionMapper.selectSysUserPositionByUserId(userFromDatabase.getId());

        for(SysUserPosition position : positionList){
            System.out.println(position.getPositionType());
        }
        Set<SysAuthority> authorities = new HashSet<>();
        List<SysManager> sysManagers = sysManagerMapper.selectSysManagerByUserId(userFromDatabase.getId());
        sysManagers.forEach(manager -> {
            List<SysGroup> sysGroup = sysGroupRepository.getById(manager.getGroupId());
            sysGroup.forEach(group -> {
                authorities.addAll(group.getAuthorities());
            });
        });
       /* Set<SysGroup> groups = userFromDatabase.getGroups();

        Set<SysAuthority> authorities = new HashSet<>();
        groups.forEach(group -> {
            Set<SysAuthority> groupAuthorities = group.getAuthorities();
            authorities.addAll(groupAuthorities);
        });

        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (SysAuthority authority : authorities) {
            System.out.println("权限名称：" + authority.getName());
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            grantedAuthorities.add(grantedAuthority);
        }*/
        /*Set<SysAuthority> authrities = userFromDatabase.getAuthorities();
        System.out.println("权限集合个数：" + authrities.size());
        System.out.println();
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        */
        for (SysAuthority authority : authorities) {
            System.out.println("权限名称：" + authority.getName());
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
            CustomGrantedAuthority customGrantedAuthority = new CustomGrantedAuthority() {
                @Override
                public Integer getAuthorityId() {
                    return authority.getId();
                }

                @Override
                public String getAuthority() {
                    return authority.getName();
                }
            };
            grantedAuthorities.add(grantedAuthority);
        }


        System.out.println("================================用户权限=========================================");
        return new org.springframework.security.core.userdetails.User(userFromDatabase.getUsername(), userFromDatabase.getPassword(), grantedAuthorities);

    }

}
