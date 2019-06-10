package com.edas.business.systask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>
 * File Name: EdasBusinessSysTaskApplication.java
 * </p>
 * <p>
 * Description 启动类
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@MapperScan(basePackages = "com.edas.business.systask.dao.master")
@ComponentScan(basePackages = { "com.edas.business.systask", "com.edas.edascommon" })
public class EdasBusinessSysTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdasBusinessSysTaskApplication.class, args);
	}
}
