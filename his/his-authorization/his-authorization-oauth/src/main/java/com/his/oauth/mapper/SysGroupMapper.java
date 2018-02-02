package com.his.oauth.mapper;

import com.his.oauth.domain.SysGroup;
import com.his.oauth.vo.SysGroupVO;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface SysGroupMapper {

    List<SysGroup> selectSysGroupByUserId(Integer userId);
    SysGroupVO selectSysGroupVOById(Integer id);
}
