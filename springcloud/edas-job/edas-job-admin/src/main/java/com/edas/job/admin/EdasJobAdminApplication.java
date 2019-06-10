package com.edas.job.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EdasJobAdminApplication {

	public static void main(String[] args) {
        SpringApplication.run(EdasJobAdminApplication.class, args);
	}

}