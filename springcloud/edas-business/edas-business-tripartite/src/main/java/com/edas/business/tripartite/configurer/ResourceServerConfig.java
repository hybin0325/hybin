package com.edas.business.tripartite.configurer;

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
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.edas.system.common.exception.AuthExceptionEntryPoint;

/**
 * <p>
 * Description: 资源服务配置类
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Value("${spring.security.oauth2.jwt.signingKey}")
	private String signingKey;

	private static final String SOURCE_ID = "order";

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	// 自定义的Token存储器，存到Redis中
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

	/**
	 * 创建一个默认的资源服务token
	 */
	@Bean
	public ResourceServerTokenServices defaultTokenServices() {
		final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		// 使用自定义的Token转换器
		defaultTokenServices.setTokenEnhancer(accessTokenConverter());
		// 使用自定义的tokenStore
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}

	@Override
	@CrossOrigin
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(SOURCE_ID).stateless(true);
		resources.tokenServices(defaultTokenServices());
		resources.authenticationEntryPoint(new AuthExceptionEntryPoint());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		// 放开以/api/*开头的请求不用认证
		http.authorizeRequests()
				.antMatchers("/static/**", "/favicon.ico", "/api/**", "/webjars/**", "/doc.html", "/resources/**",
						"/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs")
				.permitAll().and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest()
				.authenticated();
	}

}