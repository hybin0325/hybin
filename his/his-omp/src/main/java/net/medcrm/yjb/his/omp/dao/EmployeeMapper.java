package net.medcrm.yjb.his.omp.dao;

import net.medcrm.yjb.his.omp.domain.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Justin on 2017/10/26.
 */

public interface EmployeeMapper {
    int insert(Employee employee);

    int update(Employee employee);

    int deleteByIds(@Param("listId") List<String> listId);

    //查看人员基本信息
    Employee selectById(@Param("id") String id);

    //根据major，查询某机构下的主要所属人员
    List<Employee> selectByMajor(@Param("id")String id,@Param("status") int status);

    //查询所有人员列表或已停用
    List<Employee> selectAll(@Param("status") int status);

    //根据id查询人员姓名
    String selectNameById(String id);

}
