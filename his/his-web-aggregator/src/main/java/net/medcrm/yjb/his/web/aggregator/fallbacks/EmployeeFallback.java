package net.medcrm.yjb.his.web.aggregator.fallbacks;

import net.medcrm.yjb.his.web.aggregator.dto.Employee;
import net.medcrm.yjb.his.web.aggregator.dto.EmployeeRelation;
import net.medcrm.yjb.his.web.aggregator.service.EmployeeService;

import java.util.List;
import java.util.Map;

/**
 * Created by Justin on 2017/10/29.
 */
public class EmployeeFallback implements EmployeeService{



    @Override
    public int insertOrUpdate(Employee employee) {
        return 0;
    }

    @Override
    public int deleteByIds(String listId) {
        return 0;
    }

    @Override
    public Employee selectById(String id) {
        return null;
    }

    @Override
    public List<Employee> selectEmployList(String id) {
        return null;
    }
}
