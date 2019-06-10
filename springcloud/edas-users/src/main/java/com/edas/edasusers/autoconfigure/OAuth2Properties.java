package com.edas.edasusers.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.security.oauth2.client")
public class OAuth2Properties {
    private String clientId;
    private String clientSecret;
    private String accessTokenUri;
    private String userAuthorizationUri;
    private String clientAuthenticationScheme;
}