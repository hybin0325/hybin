package com.edas.business.dingtalk.configurer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;



@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class TaskSchedulerConfig {
	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.port}")
	private Integer port;
	
	@Value("${spring.redis.password}")
	private String password;
	
	@Value("${spring.redis.database}")
	private String database;
	
	@Bean
	public LockProvider lockProvider() {
		
		//JedisPool jedisPool = new JedisPool(host, port);
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(300);
		config.setMaxTotal(1000);
		config.setMaxWaitMillis(1000);
		config.setBlockWhenExhausted(false);
		config.setTestOnBorrow(false);
		JedisPool jedisPool = new JedisPool(config, host,port,3000, password);
		
		return new net.javacrumbs.shedlock.provider.redis.jedis.JedisLockProvider(jedisPool);
	}
}
