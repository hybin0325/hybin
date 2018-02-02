package net.medcrm.yjb.his.web.aggregator.service;
import net.medcrm.yjb.his.web.aggregator.dto.Employee;
import net.medcrm.yjb.his.web.aggregator.fallbacks.EmployeeFallback;/*
import net.medcrm.yjb.his.web.aggregator.feign.OAuth2FeignAutoConfiguration;*/
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Justin on 2017/10/29.
 */
@FeignClient(name="his-omp",fallback = EmployeeFallback.class/* , configuration = {OAuth2FeignAutoConfiguration.class}*/)
public interface EmployeeService {
    @RequestMapping(method = RequestMethod.POST,value = "/api/employee/employee")
    public int insertOrUpdate(@RequestBody Employee employee);

    @RequestMapping(method = RequestMethod.POST,value = "/api/employee/delete")
    public int deleteByIds(@RequestParam("listId") String listId);

    @RequestMapping(method = RequestMethod.GET,value = "/api/employee/select")
    public Employee selectById(@RequestParam("id") String id);

    @RequestMapping(method = RequestMethod.GET,value = "/api/employee/list")
    public List<Employee> selectEmployList(@RequestParam("id") String id);
}
