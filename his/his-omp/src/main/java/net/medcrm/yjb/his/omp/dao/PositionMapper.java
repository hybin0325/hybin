package net.medcrm.yjb.his.omp.dao;

import net.medcrm.yjb.his.omp.domain.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PositionMapper {

    int deleteByPrimaryKey(String id);

    int insert(Position record);


    int insertSelective(Position record);


    Position selectByPrimaryKey(String id);


    int updateByPrimaryKeySelective(Position record);


    int updateByPrimaryKey(Position record);



    //根据type获取公有的角色
    List<Position> selectPositions(int type);

    //根据id获取name
    String selectNameById(String id);

    //根据type和exclusive获取角色列表
    List<Position> selectByType(@Param("type") int type, @Param("exclusive")int exclusive);
}