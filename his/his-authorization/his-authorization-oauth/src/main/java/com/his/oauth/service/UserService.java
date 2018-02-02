package com.his.oauth.service;

import com.his.oauth.vo.SysUserVO;

import java.security.Principal;

/**
 * Created by Administrator on 2017/11/1.
 */
public interface UserService {

    public SysUserVO getUserInfo(Principal user);
}
