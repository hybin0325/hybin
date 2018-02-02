package com.his.oauth.mapper;


import com.his.oauth.domain.SysUser;

import java.util.List;

public interface SysUserMapper{

    List<SysUser> selectAllUser();
}