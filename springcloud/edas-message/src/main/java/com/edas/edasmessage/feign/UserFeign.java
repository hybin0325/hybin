package com.edas.edasmessage.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.edas.edascommon.utils.web.RetResult;
import com.edas.edasmessage.entity.User;


//@FeignClient(value ="edas-users",url="127.0.0.1:18081")
@FeignClient(value ="edas-users")
public interface UserFeign {
	
	 @PostMapping("/user/getUser")
	 public RetResult<User> getUserInfo();

}
