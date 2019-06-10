package com.edas.edasmessage.controller;

import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edasmessage.entity.User;
import com.edas.edasmessage.task.AsyncTask;



@RestController
@RequestMapping("sender")
public class SenderController {
	
	@Autowired
    private AsyncTask asyncTask;
    
    @RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST})
    public String send(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");

        User user1 = new User();
        user1.setId(1);
        user1.setUsername("pwl");

        
        System.out.println("Fanout模式 Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息");

        System.out.println("==============>>>>>>>>>>>>>>>>>>>>>>>>>>");

        User user2 = new User();
        user2.setId(2);
        user2.setUsername("pw2");

        
        System.out.println("direct模式  消息中的路由键（routing key）如果和 Binding 中的 binding key 一致，");

        System.out.println("==============>>>>>>>>>>>>>>>>>>>>>>>>>>");

        System.err.println("msg is "+id);
        
        System.out.println("topic模式  基本思想和路由模式是一样的，只不过路由键支持模糊匹配，符号“#”匹配一个或多个词，符号“*”匹配不多不少一个词");

        return "ok";
    }
    
    @GetMapping("test")
    public String test() throws InterruptedException {
        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncTask.task1();
        Future<Boolean> b = asyncTask.task2();
        Future<Boolean> c = asyncTask.task3();

        //循环到三个任务全部完成
        while (!a.isDone()||!b.isDone()||!c.isDone()) {
            if (a.isDone()&&b.isDone()&&c.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        String result = "任务完成，一共用时为："+(end-start)+"毫秒";
        System.out.println(result);
        return result;  
    }

}
