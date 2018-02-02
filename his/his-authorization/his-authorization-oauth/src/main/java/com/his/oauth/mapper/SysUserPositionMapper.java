package com.his.oauth.mapper;


import com.his.oauth.domain.SysUserPosition;

import java.util.List;

public interface SysUserPositionMapper {

    List<SysUserPosition> selectSysUserPositionByUserId(Integer userId);
}