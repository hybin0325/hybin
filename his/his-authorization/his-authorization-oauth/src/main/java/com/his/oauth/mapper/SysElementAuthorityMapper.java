package com.his.oauth.mapper;

import com.his.oauth.vo.SysElementAuthorityVO;

/**
 * Created by Administrator on 2017/11/3.
 */
public interface SysElementAuthorityMapper {

    public SysElementAuthorityVO selectSysElementAuthorityByElementIdAndGroupId(Integer groupId,Integer elementId);
}
