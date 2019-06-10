package com.edas.edasmessage.service;
/**
 * 测试重复
 * @author nl
 *
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edas.edasmessage.entity.User;
import com.edas.edasmessage.redis.BloomFilter;
import com.edas.edasmessage.redis.RedisBloomFilter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisBloomFilterTest {

	@Autowired
	private RedisBloomFilter redisBloomFilter;
	
	@Autowired
	private	BloomFilter<User> bloomFilter;

	//@Test
	public void getString() {
		String str = "abcd";
		boolean isExist = redisBloomFilter.contains(str);
		if (isExist) {
			System.out.println(isExist + " 有值+++++++++++++");
		} else {
			redisBloomFilter.addValue(str);
			System.out.println(isExist + " 成功+++++++++++");
		}
	}
	
	
	@Test
	public void getString2() {
		User user=new User();
		user.setId(1);
		user.setUsername("李明");
		//user.setSex("女");
		boolean isExist = bloomFilter.contains(user);
		if (isExist) {
			System.out.println(isExist + " bloomFilter有值---------------------");
		} else {
			bloomFilter.add(user);
			System.out.println(isExist + " bloomFilter成功-----------------------");
		}
	}
}
