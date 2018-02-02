package net.medcrm.yjb.his.omp.dao;

import net.medcrm.yjb.his.omp.domain.DivisionReEmployee;

public interface DivisionReEmployeeMapper {

    int deleteByPrimaryKey(String id);


    int insert(DivisionReEmployee record);

    int insertSelective(DivisionReEmployee record);


    DivisionReEmployee selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(DivisionReEmployee record);

    int updateByPrimaryKey(DivisionReEmployee record);
}