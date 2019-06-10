package com.edas.system.auth.configurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

	// 这个东西是项目的根路径，也就是“/oauth/token”前面的那一串
	// 这个东西在配置文件里写的，大家也可以直接写死在配置文件中
	@Value("${edas.common.accessTokenUri}")
	private String AUTH_SERVER;

	/**
	 * 主要是这个方法，其他的方法是抽出去的，所以大家不要害怕为啥有这么多方法 在 basePackage 里面写需要生成文档的 controller 路径
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.edas.system.auth.controller")).paths(PathSelectors.any())
				.build().securityContexts(Collections.singletonList(securityContext()))
				.securitySchemes(Arrays.asList(securitySchema(), apiKey(), apiCookieKey())).apiInfo(apiInfo());
	}

	/**
	 * 这个方法主要是写一些文档的描述
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("权限服务API").description("权限服务").termsOfServiceUrl("https://www.nanling.com")
				.contact(new Contact("zzw", "https://www.nanling.com", "yuanbing@126.com")).version("1.0").build();
	}

	/**
	 * 这个类决定了你使用哪种认证方式，我这里使用密码模式 其他方式自己摸索一下，完全莫问题啊
	 */
	/*
	 * private SecurityScheme securityScheme() { GrantType grantType = new
	 * ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER);
	 * 
	 * return new
	 * OAuthBuilder().name("api-auth").grantTypes(Collections.singletonList(
	 * grantType)) .scopes(Arrays.asList(scopes())).build(); }
	 */

	/**
	 * 这里设置 swagger2 认证的安全上下文
	 */
	/*
	 * private SecurityContext securityContext() { return SecurityContext.builder()
	 * .securityReferences(Collections.singletonList(new
	 * SecurityReference("api-auth", scopes())))
	 * .forPaths(PathSelectors.any()).build(); }
	 */

	/**
	 * 这里是写允许认证的scope
	 */
	private AuthorizationScope[] scopes() {
		return new AuthorizationScope[] { new AuthorizationScope("all", "All scope is trusted!") };
	}

	@Bean
	public SecurityScheme apiKey() {
		return new ApiKey(HttpHeaders.AUTHORIZATION, "apiKey", "header");
	}

	@Bean
	public SecurityScheme apiCookieKey() {
		return new ApiKey(HttpHeaders.COOKIE, "apiKey", "cookie");
	}

	private OAuth securitySchema() {

		List<AuthorizationScope> authorizationScopeList = new ArrayList();
		authorizationScopeList.add(new AuthorizationScope("read", "read all"));
		authorizationScopeList.add(new AuthorizationScope("write", "access all"));

		List<GrantType> grantTypes = new ArrayList();
		GrantType passwordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(AUTH_SERVER);
		grantTypes.add(passwordCredentialsGrant);

		return new OAuth("oauth2", authorizationScopeList, grantTypes);
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {

		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
		authorizationScopes[0] = new AuthorizationScope("read", "read all");
		authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
		authorizationScopes[2] = new AuthorizationScope("write", "write all");

		return Collections.singletonList(new SecurityReference("oauth2", authorizationScopes));
	}

	@Bean
	public SecurityConfiguration security() {
		return new SecurityConfiguration("client", "secret", "", "", "Bearer access token", ApiKeyVehicle.HEADER,
				HttpHeaders.AUTHORIZATION, "");
	}

}
