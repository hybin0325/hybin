package net.medcrm.yjb.his.web.aggregator;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@EnableScheduling
@EnableFeignClients
@SpringBootApplication
@EnableZuulProxy
@EnableHystrix
@EnableDiscoveryClient
@EnableOAuth2Sso
@ComponentScan("net.medcrm.yjb.his.web.aggregator")
public class HisWebAggregatorApplication {

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(HisWebAggregatorApplication.class, args);
	}

	/*@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {

		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate requestTemplate) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
				System.out.println("************************************************");
				System.out.println(details.getTokenValue());
				System.out.println("************************************************");
				requestTemplate.header("Authorization", "Bearer " + details.getTokenValue());
			}
		};
	}*/

}
