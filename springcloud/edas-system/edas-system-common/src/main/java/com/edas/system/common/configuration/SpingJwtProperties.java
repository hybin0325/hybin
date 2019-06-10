package com.edas.system.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.fasterxml.jackson.annotation.JsonIgnore;

@ConfigurationProperties(prefix = "spring.security.oauth2.jwt")
public class SpingJwtProperties {
	// @Value("${spring.security.oauth2.jwt.signingKey}")
	@JsonIgnore
	private String signingKey;

	public String getSigningKey() {
		return signingKey;
	}

	public void setSigningKey(String signingKey) {
		this.signingKey = signingKey;
	}

	@Override
	public String toString() {
		return "SpingJwtProperties [signingKey=" + signingKey + "]";
	}
}
