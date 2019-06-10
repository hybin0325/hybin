package com.edas.edasmessage.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edas.edasmessage.redis.CommonRedisHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	@Autowired
	private  CommonRedisHelper commonRedisHelper;
	
	@Test
	public void getLockValue() {
		System.out.println(commonRedisHelper.getLockValue("getCarParkInLog", "carParkInLog")+"-------------------------------");
	}
}
