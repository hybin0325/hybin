package com.edas.business.qywechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableAsync
@MapperScan(basePackages = "com.edas.business.qywechat.dao.master")
public class EdasBusinessQywechatApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdasBusinessQywechatApplication.class, args);
	}
}
