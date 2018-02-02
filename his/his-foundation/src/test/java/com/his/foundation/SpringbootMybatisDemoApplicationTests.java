package com.his.foundation;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.his.foundation.model.User;
import com.his.foundation.service.UserService;

import net.minidev.json.JSONArray;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisDemoApplicationTests {
	
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
		
	}
	
	//@Test
	public void save(){
		User user=new User();
		for(int i=0;i<10;i++){
			user.setUserName("test_"+i);
			user.setPassword("123"+i);
			user.setPhone("15825555"+i);
			userService.addUser(user);
		}
		
	}
	
	@Test
	public void findAll(){
		List<User> list =userService.findAllUser(2, 3);
		
		String json =JSONArray.toJSONString(list);
        System.out.println("size:"+list.size()+"  " +json);  
		
	}

}
