package com.edas.edasusers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edas.edasusers.service.impl.AsyncService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EdasUsersApplicationTests {
	@Autowired
	private AsyncService service;
	
    @Test
    public void contextLoads() {
    	service.sendPark2();
    }

}

