package com.his.oauth.service.impl;

import com.his.oauth.domain.SysAuthority;
import com.his.oauth.domain.SysUser;
import com.his.oauth.repository.UserRepository;
import com.his.oauth.service.UserService;
import com.his.oauth.vo.SysUserVO;
import net.medcrm.yjb.his.common.model.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public SysUserVO getUserInfo(Principal user){
        System.out.println(user);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        System.out.println(userDetails);
        System.out.println(userDetails.getUsername());
        SysUser sysUser =  userRepository.findByUsernameCaseInsensitive(userDetails.getUsername());
        SysUserVO vo = new SysUserVO();
        vo.setId(sysUser.getId());
        vo.setUsername(sysUser.getUsername());
        vo.setActivated(sysUser.isActivated());
        vo.setEmail(sysUser.getEmail());
        List<String> sysAuthorities = new ArrayList<>();
        userDetails.getAuthorities().forEach(o ->{
            sysAuthorities.add(o.getAuthority());
        });
        vo.setAuthorities(sysAuthorities);
        BaseResp resp = new BaseResp();
        resp.setData(vo);
        return vo;
    }


    @RequestMapping("/home")
    public String home(@RequestParam String name) {
        System.out.println("name");
        return "hi "+name+",i am from port:";
    }
}
