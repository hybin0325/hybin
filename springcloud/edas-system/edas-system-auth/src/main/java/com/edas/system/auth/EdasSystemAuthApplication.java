package com.edas.system.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 权限认证、资源系统
 * @author nl
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class EdasSystemAuthApplication {
	public static void main(String[] args) {
		SpringApplication.run(EdasSystemAuthApplication.class, args);
	}
}
