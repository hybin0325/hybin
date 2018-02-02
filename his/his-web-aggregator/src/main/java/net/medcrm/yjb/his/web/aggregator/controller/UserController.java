package net.medcrm.yjb.his.web.aggregator.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.discovery.DiscoveryClient;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.web.aggregator.dto.Employee;
import net.medcrm.yjb.his.web.aggregator.dto.SysUserVO;
import net.medcrm.yjb.his.web.aggregator.service.EmpService;
import net.medcrm.yjb.his.web.aggregator.service.EmployeeService;
import net.medcrm.yjb.his.web.aggregator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/11/1.
 */

@RestController
@RequestMapping("/uaa/api/user")
public class UserController {


    @Autowired
    private EmpService empService;
    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/info")
    public BaseResp findById(String access_token) {

        System.out.println(userService.getOrder(access_token));
        System.out.println(userService.list2(access_token));

        System.out.println(empService.selectById("124be3fa35dd4f6b905c05aae12baa36", access_token));
        //System.out.println(employeeService.selectById("124be3fa35dd4f6b905c05aae12baa36"));
        /*employeeService.selectById("124be3fa35dd4f6b905c05aae12baa36",access_token);
        SysUserVO vo = userService.userInfo(access_token);
        System.out.println(vo.getUsername());
        System.out.println("================================");
        System.out.println(userService.getOrder(access_token));
        System.out.println("================================");
        System.out.println(JSONObject.toJSON(userService.list(access_token)).toString());;
        //userService.selectById("124be3fa35dd4f6b905c05aae12baa36",access_token);
        //
       System.out.println(empService.selectById("124be3fa35dd4f6b905c05aae12baa36"));
        System.out.println("================================");
        //employeeService.selectById(vo.getId() + "");
*/

        return userService.list2(access_token);
    }
}
