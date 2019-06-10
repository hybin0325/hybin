package com.edas.business.dingtalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "com.edas.business.dingtalk.dao.master")
public class EdasBusinessDingtalkApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdasBusinessDingtalkApplication.class, args);
	}
}
