package net.medcrm.yjb.his.web.aggregator.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/10/25.
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("=============================Access-Control-Allow-Origin222=================================");
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods(
                        "GET",
                        "POST",
                        "HEAD",
                        "OPTIONS",
                        "PUT",
                        "DELETE")
                .allowedHeaders(
                        "Content-Type",
                        "X-Requested-With",
                        "accept",
                        "Origin",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers",
                        "Authorization").allowCredentials(true);
        System.out.println("=============================Access-Control-Allow-Origin222=================================");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").addResourceLocations("/swagger-ui.html");
        //registry.addResourceHandler("*.css").addResourceLocations("classpath:/static/css/");
    }
}
