package com.his.oauth.service;

import com.his.oauth.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Administrator on 2017/11/1.
 */
@Service
public class UserFeignClient {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://AUTH-SERVER/home?access_token=acae5ded-d0d8-4c81-b847-412cc68b2435&name="+name,String.class);
    }

}
