package com.his.oauth;

import com.his.oauth.service.UserFeignClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lings on 2017/10/26.
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // Feign支持
@EnableGlobalMethodSecurity(prePostEnabled = true)
@CrossOrigin
@MapperScan("com.his.oauth.mapper")
public class HisAuthorizationOAuthApplication {

    @Bean
        //@LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private UserFeignClient userFeignClient;


    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return userFeignClient.hiService(name);
    }
    public static void main(String[] args) {
        SpringApplication.run(HisAuthorizationOAuthApplication.class, args);
    }
}
