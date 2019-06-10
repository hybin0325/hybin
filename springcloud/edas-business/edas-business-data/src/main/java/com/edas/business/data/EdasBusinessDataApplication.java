package com.edas.business.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableAsync
@EnableCaching
@MapperScan(basePackages = "com.edas.business.data.dao.master")
public class EdasBusinessDataApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdasBusinessDataApplication.class, args);
	}
}
