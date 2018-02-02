package net.medcrm.yjb.workflow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Package org.jon.lv.swagger2.SwaggerConfig
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/5/19 10:45
 * version V1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig  {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("api")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("net.medcrm.yjb.workflow.controller"))
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("jon","http://","316476844.com");
        return new ApiInfoBuilder()
                .title("工作流")
                .description("工作流模块")
                .contact(contact)
                .version("1.0")
                .build();
    }
}