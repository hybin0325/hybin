package net.medcrm.yjb.his.omp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // Feign支持
@EnableGlobalMethodSecurity(prePostEnabled = true)
@CrossOrigin
@MapperScan("net.medcrm.yjb.his.omp.dao")
public class HisOmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisOmpApplication.class, args);
	}


}
