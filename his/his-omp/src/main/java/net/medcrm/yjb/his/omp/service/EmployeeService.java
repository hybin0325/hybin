package net.medcrm.yjb.his.omp.service;

import net.medcrm.yjb.his.omp.domain.Employee;
import net.medcrm.yjb.his.omp.domain.EmployeeRelation;

import java.util.List;
import java.util.Map;

/**
 * Created by Justin on 2017/10/28.
 */
public interface EmployeeService {
    int insertOrUpdate(Employee employee);

//    int update(Map<String,Object> map);

    int deleteByIds(String listId);

    Employee selectById(String id);

    //根据id，查询人员列表(或已停用)
    List<Employee> selectEmployList(String id,int status);

    //获取所有人员列表（或已停用）
    List<Employee> selectAll(int status);
}
