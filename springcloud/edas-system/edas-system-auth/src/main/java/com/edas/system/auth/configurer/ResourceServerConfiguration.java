package com.edas.system.auth.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.edas.system.common.exception.AuthExceptionEntryPoint;
import com.edas.system.common.exception.OpenAccessDeniedHandler;
import com.edas.system.common.exception.OpenAuthenticationEntryPoint;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义资源服务器配置
 *
 *
 */
@Slf4j
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Value("${spring.security.oauth2.jwt.signingKey}")
	private String signingKey;

	private static final String SOURCE_ID = "order";

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	private BearerTokenExtractor tokenExtractor = new BearerTokenExtractor();

	/**
	 * 自定义登录成功处理器
	 */

	@Override
	@CrossOrigin
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.resourceId(SOURCE_ID).stateless(true);
		resources.tokenServices(defaultTokenServices());
		resources.authenticationEntryPoint(new AuthExceptionEntryPoint());

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		log.info("HttpSecurity {} --------------");
		http.authorizeRequests()
				.antMatchers("/oauth/**", "/api/**", "/resources/**", "/swagger-ui.html", "/swagger-resources/**",
						"/v2/api-docs")
				.permitAll().and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest()
				.authenticated().and()
				// 认证鉴权错误处理,为了统一异常处理。每个资源服务器都应该加上。
				.exceptionHandling().accessDeniedHandler(new OpenAccessDeniedHandler())
				.authenticationEntryPoint(new OpenAuthenticationEntryPoint()).and().csrf().disable();
	}

	@Bean
	public TokenStore tokenStore() {
		RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
		return tokenStore;
	}

	// Token转换器

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter() {
		};
		accessTokenConverter.setSigningKey(signingKey);
		return accessTokenConverter;
	}

	// 创建一个默认的资源服务token
	@Bean
	public ResourceServerTokenServices defaultTokenServices() {
		final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		// 使用自定义的Token转换器
		defaultTokenServices.setTokenEnhancer(accessTokenConverter());
		// 使用自定义的tokenStore
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}

}
