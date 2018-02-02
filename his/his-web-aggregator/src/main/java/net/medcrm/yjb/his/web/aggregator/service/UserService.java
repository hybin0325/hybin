package net.medcrm.yjb.his.web.aggregator.service;

import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.web.aggregator.dto.Employee;
import net.medcrm.yjb.his.web.aggregator.dto.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public SysUserVO userInfo(String access_token){
        return restTemplate.getForObject("http://AUTH-SERVER/api/user/user_info?access_token=" + access_token,SysUserVO.class);
    }

    /*@ApiOperation(value="获取系统管理用户信息", notes="获取系统管理用户信息")
    @GetMapping("/list")
    public BaseResp<List<SysUser>> findUser(){

        BaseResp resp = new BaseResp();
        List<SysUser> list = sysUserMapper.selectAllUser();
        resp.setData(list);
        return  resp;
    }*/
    public BaseResp list(String access_token){
        return restTemplate.getForObject("http://AUTH-SERVER/api/user/list?access_token=" + access_token,BaseResp.class);
    }

    public BaseResp list2(String access_token){
        return restTemplate.getForObject("http://AUTH-SERVER2/api/user/list?access_token=" + access_token,BaseResp.class);
    }

    public Employee selectById(String id, String access_token){
        return restTemplate.getForObject("http://HIS-OMP/api/employee/select?id=" + id +"access_token=" + access_token,Employee.class);
    }

    public String getOrder(String access_token){
         return restTemplate.getForObject("http://ORDER-SERVICE/api/demo?access_token=" + access_token, String.class);
    }
}
