package com.edas.business.byrobot.configurer;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
 
@Configuration
public class RestTemplateConfig {
 
    @Autowired
    private HttpPool httpPool;
 
    @Bean
    public RestTemplate restTemplate() {
    	RestTemplate restTemplate = new RestTemplate(httpRequestFactory());
    	restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        return restTemplate;
    }
 
    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }
 
    @Bean
    public HttpClient httpClient() {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(registry);
        connectionManager.setMaxTotal(httpPool.getMaxTotal());        
        connectionManager.setDefaultMaxPerRoute(httpPool.getDefaultMaxPerRoute());
        connectionManager.setValidateAfterInactivity(httpPool.getValidateAfterInactivity());
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(httpPool.getSocketTimeout()) //服务器返回数据(response)的时间，超过抛出read timeout
                .setConnectTimeout(httpPool.getConnectTimeout()) //连接上服务器(握手成功)的时间，超出抛出connect timeout
                .setConnectionRequestTimeout(httpPool.getConnectionRequestTimeout())//从连接池中获取连接的超时时间，超时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
                .build();
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .build();
    }
}