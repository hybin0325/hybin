package com.edas.business.systask.configurer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Slf4j
public class WebServerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.debug("HttpSecurity configure method");
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/api/**", "/resources/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs")
				.permitAll().anyRequest().authenticated();
	}
}