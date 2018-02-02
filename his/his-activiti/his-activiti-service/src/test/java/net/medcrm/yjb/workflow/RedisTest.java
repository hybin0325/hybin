package net.medcrm.yjb.workflow;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import net.medcrm.yjb.his.cache.redis.RedisTemplate;

@RunWith(SpringRunner.class)
@EnableTransactionManagement 
@SpringBootTest
public class RedisTest {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void  setKey() {
    	System.out.println(redisTemplate.lpush("12144", "asdfaaaaaaaaaaaaaaaaaa"));
    }
    
    //@Test
    public void  getKey() {
    	System.out.println(redisTemplate.get("12144"));
    }

}
