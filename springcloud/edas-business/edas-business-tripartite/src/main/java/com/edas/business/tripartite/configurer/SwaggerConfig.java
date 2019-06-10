package com.edas.business.tripartite.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * <p>
 * Description: Swagger配置类
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.edas.business.tripartite"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("百应API")
                .description("1、参数-数据类型-模型 标注optional为非必填，没有optional的为必填项<br> 2、参数-数据类型-示例 为测试数据")
                .termsOfServiceUrl("http://14.152.78.200:17086/markDown/view")
                .contact(new Contact("张振武", "http://14.152.78.200:17086/markDown/view", "zzwovo@126.com"))
                .version("1.0")
                .build();
    }
}