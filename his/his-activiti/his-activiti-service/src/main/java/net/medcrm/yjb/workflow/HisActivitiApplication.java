package net.medcrm.yjb.workflow;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.client.RestTemplate;



@EnableAutoConfiguration
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan({"net.medcrm.yjb.his.config","net.medcrm.yjb.workflow"})
@MapperScan("net.medcrm.yjb.workflow.mapper")
public class HisActivitiApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(HisActivitiApplication.class, args);
	}
	
}
