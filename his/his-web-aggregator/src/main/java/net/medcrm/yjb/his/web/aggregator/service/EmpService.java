package net.medcrm.yjb.his.web.aggregator.service;

import net.medcrm.yjb.his.web.aggregator.dto.Employee;
import net.medcrm.yjb.his.web.aggregator.dto.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/11/2.
 */
@Service
public class EmpService {

    @Autowired
    RestTemplate restTemplate;

    public Employee selectById(String id,String access_token){
        return restTemplate.getForObject("http://HIS-OMP/api/employee/select?id=" + id +"access_token=" + access_token,Employee.class);
    }
}
