package net.medcrm.yjb.his.omp.dao;

import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DivisionRePositionMapper {

//增
        //新增
        int insert(DivisionRePosition record);
//删
        //删除角色内的人员
        int deletePosiEmploy(DivisionRePosition divisionRePosition);
//改
        //编辑角色内的人员
        int updatePosiEmploy(DivisionRePosition divisionRePosition);
//查
        //根据divisionId获取角色列表
        List<DivisionRePosition> selectPositionsById(@Param("id") String id);

        //根据divisionId获取主要负责人角色的employeeId
        String selectEmployIdByDiviId(@Param("id") String id);









    //获得符合divisionId和positionId的条数
    int countByDidAndPid(@Param("divisionId") String divisionId,@Param("positionId") String positionId);

    //判断某个角色下是否有人员
    DivisionRePosition isNullofEmploy(@Param("divisionId")String divisionId,@Param("positionId") String positionId);

    //根据人员id获取关系
    List<DivisionRePosition> selectByEmployId(@Param("id") String id);

    //根据divisionId获取人员列表
    List<DivisionRePosition> selectEmploysByDiviId(String id);

    //根据3个id确定某条数据
    DivisionRePosition selectByThreeId(DivisionRePosition divisionRePosition);

    //编辑删除人员后的employeeId
    int deleteEmployId(DivisionRePosition divisionRePosition);


}