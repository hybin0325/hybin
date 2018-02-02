package net.medcrm.yjb.his.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class HisEurekaApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(HisEurekaApplication.class).web(true).run(args);
	}
}
