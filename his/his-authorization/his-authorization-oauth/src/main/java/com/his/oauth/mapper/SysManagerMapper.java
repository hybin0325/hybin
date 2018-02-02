package com.his.oauth.mapper;

import com.his.oauth.domain.SysManager;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface SysManagerMapper {

    List<SysManager> selectSysManagerByUserId(Integer userId);
}
