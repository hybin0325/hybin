package net.medcrm.yjb.his.omp.dao;

import net.medcrm.yjb.his.omp.domain.Division;
import net.medcrm.yjb.his.omp.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DivisionMapper {
    //批量删除机构、部门或工作组
    int deleteByListId(@Param("listId")List<String> listId);

    //新增
    int insert(Division division);

    //编辑
    int update(Division division);

    //根据id获取机构基本信息
    Division selectBasicById(String id);

    //根据id查询pids
    Division selectPidsById(String id);

    //根据id判断该机构是否为父级
    int isParentById(String id);

    //根据pid和level查询同级别下的数量
    int countByLevelAndPid(@Param("level")Integer level, @Param("pid")String pid);

    //获取机构列表
    List<Division> selectAll();

    //根据diviType,查询已停用列表
    List<Division> selectSuspendAll(@Param("diviType") int diviType);

    //查询某个division下的所有子类
    List<Division> selectChildrenById(@Param("id") String id);

    //根据id获取fullName
    String selectFullNameById(String id);

    //获取某个机构下的部门、工作组列表
    List<Division> selectDivisionChildById(@Param("id") String id,@Param("status") int status);
}