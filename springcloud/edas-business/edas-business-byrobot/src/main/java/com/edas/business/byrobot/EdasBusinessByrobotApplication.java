package com.edas.business.byrobot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 * File Name: EdasBusinessByrobotApplication.java
 * </p>
 * <p>
 * Description: 启动类
 * </p>
 * <p>
 * Date：2019年4月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@MapperScan(basePackages = "com.edas.business.byrobot.dao.master")
@ComponentScan(basePackages = { "com.edas.business.byrobot", "com.edas.edascommon" })
public class EdasBusinessByrobotApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdasBusinessByrobotApplication.class, args);
	}
}
