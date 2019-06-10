package com.edas.system.auth.configurer;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.edas.system.auth.configurer.custom.CustomTokenEnhancer;
import com.edas.system.auth.configurer.custom.CustomerAccessTokenConverter;
import com.edas.system.auth.exception.Oauth2WebResponseExceptionTranslator;

@Configuration
@EnableAuthorizationServer
public class AuthenticationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Qualifier("dataSource")
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private Oauth2WebResponseExceptionTranslator  oauth2WebResponseExceptionTranslator;

	/**
	 * jwt 对称加密密钥
	 */
	@Value("${spring.security.oauth2.jwt.signingKey}")
	private String signingKey;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.jdbc(dataSource);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// endpoints.accessTokenConverter(accessTokenConverter());
		// endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
		endpoints.tokenStore(tokenStore()).authorizationCodeServices(authorizationCodeServices())
				.approvalStore(approvalStore())
				.tokenEnhancer(tokenEnhancerChain()).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService)
		        .reuseRefreshTokens(true).exceptionTranslator(oauth2WebResponseExceptionTranslator);

		// 配置TokenServices参数
		DefaultTokenServices tokenServices = (DefaultTokenServices) endpoints
				.getDefaultAuthorizationServerTokenServices();
		tokenServices.setTokenStore(endpoints.getTokenStore());
		tokenServices.setSupportRefreshToken(true);
		tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
		tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
		tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); // 1天
		endpoints.tokenServices(tokenServices);

		super.configure(endpoints);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		// 允许表单认证 
		oauthServer.allowFormAuthenticationForClients();
		
		//验证获取Token的验证信息 //对获取Token的请求不再拦截
		oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	/**
	 * 自定义token
	 *
	 * @return tokenEnhancerChain
	 */
	@Bean
	public TokenEnhancerChain tokenEnhancerChain() {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(new CustomTokenEnhancer(), accessTokenConverter()));
		return tokenEnhancerChain;
	}

	// JWT
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		final JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		// 测试用,资源服务使用相同的字符达到一个对称加密的效果,生产时候使用RSA非对称加密方式
		accessTokenConverter.setSigningKey(signingKey);
		accessTokenConverter.setAccessTokenConverter(new CustomerAccessTokenConverter());
		return accessTokenConverter;
	}

	@Bean
	public TokenStore tokenStore() {
		RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
		return tokenStore;
	}

	/**
	 * 授权信息持久化实现
	 * 
	 * @return JdbcApprovalStore
	 */
	@Bean
	public ApprovalStore approvalStore() {
		return new JdbcApprovalStore(dataSource);
	}

	/**
	 * 授权码模式持久化授权码code
	 *
	 * @return JdbcAuthorizationCodeServices
	 */
	@Bean
	protected AuthorizationCodeServices authorizationCodeServices() {
		// 授权码存储等处理方式类，使用jdbc，操作oauth_code表
		return new JdbcAuthorizationCodeServices(dataSource);
	}

	

}