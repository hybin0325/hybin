package com.edas.business.dingtalk.controller;


import com.edas.business.dingtalk.aibee.AibeeMsgSend;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(description = "aibee接口")
@RestController
@RequestMapping("aibee")
public class AibeeController {

    @RequestMapping(value = "/addUser", method = { RequestMethod.POST})
    public String adduser(HttpServletRequest request) throws Exception{
        System.out.println("哈哈哈");
        AibeeMsgSend ms = new AibeeMsgSend();
        String tpurl = "http://ai.168egj.com:8001/down/CapturePhoto/2019-03-26/0/9/9X148X1553589593747.jpg";
        List groups = new ArrayList();
        groups.add("hjx-test");
//        Map<String,String> contents = new HashMap<String, String>();
        Map<Object, Object> content = new HashMap<Object, Object>();
        content.put("image_url",tpurl);
        content.put("user_id","");
        content.put("image","");
        content.put("image_feature","");
        content.put("image_created_at","");
        content.put("additional","");
//        String data = ms.createpostdata(groups,true,true,content);
//        System.out.println("请求参数："+data+"完");
        String rs= ms.addUser(groups,content);
//        ms.post1("",contents);
        return  rs;
    }
    @RequestMapping(value = "/updateUserId", method = { RequestMethod.POST})
    public String updateuserid(HttpServletRequest request) throws Exception{

        AibeeMsgSend ms = new AibeeMsgSend();

//旧的useid   05dd149b-383c-4d39-8503-c8995acb9bba
//    新的userid  20019-03-27-001
        String rs= ms.updateUserId("05dd149b-383c-4d39-8503-c8995acb9bba","05dd149b-383c-4d39-8503-c8995acb9bbb");
//        ms.post1("",contents);
        return  rs;
    }
    @RequestMapping(value = "/removeGroup", method = { RequestMethod.POST})
    public String removegroup(HttpServletRequest request) throws Exception{

        AibeeMsgSend ms = new AibeeMsgSend();

//旧的useid   05dd149b-383c-4d39-8503-c8995acb9bba
//    新的userid  20019-03-27-001
        String rs= ms.updateUserId("05dd149b-383c-4d39-8503-c8995acb9bba","05dd149b-383c-4d39-8503-c8995acb9bbb");
//        ms.post1("",contents);
        return  rs;
    }
    @RequestMapping(value = "/info", method = { RequestMethod.POST})
    public String info(HttpServletRequest request) throws Exception{

        AibeeMsgSend ms = new AibeeMsgSend();

//旧的useid   05dd149b-383c-4d39-8503-c8995acb9bba
//    新的userid  20019-03-27-001
        String rs= ms.info("05dd149b-383c-4d39-8503-c8995acb9bba",true);

//        ms.post1("",contents);
        return  rs;
    }
    @RequestMapping(value = "/ginfo", method = { RequestMethod.GET})
    public String ginfo(HttpServletRequest request) throws Exception{

        AibeeMsgSend ms = new AibeeMsgSend();

//旧的useid   05dd149b-383c-4d39-8503-c8995acb9bba
//    新的userid  20019-03-27-001
        String rs= ms.ginfo("05dd149b-383c-4d39-8503-c8995acb9bba",true);
//        ms.post1("",contents);
        return  rs;
    }
    @RequestMapping(value = "/guserinfo", method = { RequestMethod.GET})
    public String guserinfo(HttpServletRequest request) throws Exception{

        AibeeMsgSend ms = new AibeeMsgSend();

//旧的useid   05dd149b-383c-4d39-8503-c8995acb9bba
//    新的userid  20019-03-27-001
        String rs= ms.guserinfo("05dd149b-383c-4d39-8503-c8995acb9bba",true);
//        ms.post1("",contents);
        return  rs;
    }
    @RequestMapping(value = "/compareVn", method = { RequestMethod.GET})
    public String comparevn(HttpServletRequest request) throws Exception{

        AibeeMsgSend ms = new AibeeMsgSend();

//旧的useid   05dd149b-383c-4d39-8503-c8995acb9bba
//    新的userid  20019-03-27-001
        String rs= ms.compareVn("05dd149b-383c-4d39-8503-c8995acb9bba",true);
//        ms.post1("",contents);
        return  rs;
    }

}
