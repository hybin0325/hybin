package com.edas.edasmessage;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 消息服务
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan(basePackages = "com.edas.edasmessage.dao")
@ComponentScan(basePackages = { "com.edas.edasmessage", "com.edas.edascommon" })
@EnableAsync
@EnableCaching
public class EdasMessageApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdasMessageApplication.class, args);
	}

}
