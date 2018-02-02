package net.medcrm.yjb.his.omp.dao;

import net.medcrm.yjb.his.omp.domain.Division;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Justin on 2017/10/27.
 */
public interface Division2Mapper {
    //新增部门
    int insertDivision(Division division);

    //根据pid和level查询部门数
    int countDivisionByLevel(@Param("level")Integer level, @Param("pid")String pid);

    //根据id获取部门基本信息
    Division selectBaseDivisionById(String id);

    //新增
    int insert(Division division);
}
