package net.medcrm.yjb.workflow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by lings on 2017/10/26.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * 使用enableMVC注解的话,该配置必须,否则无法映射资源
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		System.out.println("=============================Access-Control-Allow-Origin=================================");
		registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE")
				.allowedHeaders("Content-Type", "X-Requested-With","x-prototype-version", "accept", "Origin", "Access-Control-Request-Method",
						"Access-Control-Request-Headers", "Authorization")
				.allowCredentials(true);
		System.out.println("============================Access-Control-Allow-Origin==================================");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
	}
}
