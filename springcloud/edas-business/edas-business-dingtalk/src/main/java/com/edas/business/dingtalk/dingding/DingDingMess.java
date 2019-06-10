package com.edas.business.dingtalk.dingding;


import com.edas.business.dingtalk.entity.DingDingUrlData;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

@Slf4j
public class DingDingMess {
    public static String main(String appkey,String  appsecret,String userlist,Number agentid,Object content,Integer ts){

//        DingDingMsgSend ds = new DingDingMsgSend();
        try{
            if(ts == null){
                ts = 0; // 默认是文本消息
            };
            String  postdata = "";
            log.info("appKey"+appkey);
            log.info("appSecret"+appsecret);
            String token = DingDingMsgSend.getToken(appkey,appsecret);
//            if(ts == 1){  //图片消息
//                //图片消息 media_id = @lADPDeC2t7XYo7zNAaLNAoA
////            cnew.put("media_id","@lADPDeC2t7XYo7zNAaLNAoA");
////            content.put("msgtype","image");
////            content.put("image",cnew);
////             postdata = ds.createpostdata(appkey,"061329325439962625","",false,content);
//
//
//            }else{
//
//            }
            postdata = DingDingMsgSend.createpostdata(agentid,userlist,"",false,content);
            log.info("钉钉推送数据"+postdata);
            String rep = DingDingMsgSend.post("utf-8",DingDingMsgSend.CONTENT_TYPE,(new  DingDingUrlData().getSendMessage_Url()),postdata,token);

//            String postdata = ds.createpostdata(238939211,"061329325439962625","",false,content);
//
//            Map<Object, Object> content = new HashMap<Object, Object>();
//            Map<Object, Object> cnew = new HashMap<Object, Object>();
            //文本消息
//            cnew.put("content","张三的请假申请");
//            content.put("msgtype","text");
//            content.put("text",cnew);
//            String postdata = ds.createpostdata(238939211,"061329325439962625","",false,content);
//
            //文件消息 media_id = @lArPDeC2t7XA4U7OOogQ_M4ZhoHH
//            cnew.put("media_id","@lArPDeC2t7XA4U7OOogQ_M4ZhoHH");
//            content.put("msgtype","file");
//            content.put("file",cnew);
//            String postdata = ds.createpostdata(238939211,"061329325439962625","",false,content);

       //图片消息 media_id = @lADPDeC2t7XYo7zNAaLNAoA
//            cnew.put("media_id","@lADPDeC2t7XYo7zNAaLNAoA");
//            content.put("msgtype","image");
//            content.put("image",cnew);
//            String postdata = ds.createpostdata(238939211,"061329325439962625","",false,content);


       //语音消息 media_id = @lAfPDeC2t7X5kaDOE2bAa85xn6zr
//            cnew.put("media_id","@lAfPDeC2t7X5kaDOE2bAa85xn6zr");
//            content.put("msgtype","voice");
//            content.put("voice",cnew);
//            String postdata = ds.createpostdata(238939211,"061329325439962625","",false,content);


            //获取员工信息
//            String postdata = ds.createpostusdata("23428","zh_CN");
//            String postdata =token+"&userid=23428&lang=zh_CN";
//            String rep = ds.sendGet((new DingDingUrlData().getSendUser_Url()),postdata);

//            System.out.println("创建的数据"+postdata);

            return rep;
//            System.out.println("钉钉返回的数据结果"+rep);
        }catch (IOException e){
            e.printStackTrace();
        }
        return  "ERROR";
    }
    public static void mainget(String appkey,String  appsecret){
        DingDingMsgSend ds = new DingDingMsgSend();
        try {
            String token = ds.getToken(appkey,appsecret);
            String postdata = token + "&userid=061329325439962625&lang=zh_CN";
            String rep = ds.sendGet((new DingDingUrlData().getSendUser_Url()), postdata);

            System.out.println("创建的数据" + postdata);
            System.out.println("钉钉的token" + token);
            System.out.println("钉钉返回的数据结果" + rep);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //文件
    public static String  wenjian(String resourceurl,String type,String appkey,String appsec,Number agentid) {
        DingDingMsgSend swx = new DingDingMsgSend();
//        resourceurl = "C:\\Users\\nl\\Desktop\\图片库\\timg (5).jpg";
//        resourceurl = "http://pics.sc.chinaz.com/files/pic/pic9/201905/hpic999.jpg";
//        resourceurl = "http:\\14.152.78.36:8070\\group1\\M00\\00\\00\\CgoAB1zrn7GAGsBbAACNdkmSj9o955.jpg";
        System.out.println("我还是可以的");
        try {
            String token = swx.getToken(appkey,appsec);

            //文件
            String resp = swx.uploadmat((new DingDingUrlData()).getUpload_Url()+token+"&type="+type, new File(resourceurl));
//            String resp = swx.uploadmatNew((new DingDingUrlData()).getUpload_Url()+token+"&type="+type, resourceurl);
            //图片
//            String resp = swx.uploadmat((new DingDingUrlData()).getUpload_Url()+token+"&type=image", new File("C:\\Users\\nl\\Desktop\\图片库\\timg.jpg"));
            //语音
            //String resp = swx.uploadmat((new DingDingUrlData()).getUpload_Url()+token+"&type=voice", new File("C:\\Users\\nl\\Desktop\\图片库\\10673.wav"));

//            System.out.println("获取到的token======>" + token);

           // System.out.println("发送微信的响应数据======>" + resp);
//            System.out.println("发送微信的响应数据======>" + resp);

            return  resp;
//            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  "ERROR";
    }



   //文件
    public static String  wenjianNew(String resourceurl,String type,String appkey,String appsec,Number agentid) {
        DingDingMsgSend swx = new DingDingMsgSend();
//        resourceurl = "C:\\Users\\nl\\Desktop\\图片库\\timg (5).jpg";
//        resourceurl = "http://pics.sc.chinaz.com/files/pic/pic9/201905/hpic999.jpg";
//        resourceurl = "http:\\14.152.78.36:8070\\group1\\M00\\00\\00\\CgoAB1zrn7GAGsBbAACNdkmSj9o955.jpg";
        System.out.println("我还是可以的");
        try {
            String token = swx.getToken(appkey,appsec);

            //文件
//            String resp = swx.uploadmat((new DingDingUrlData()).getUpload_Url()+token+"&type="+type, new File(resourceurl));
            String resp = swx.uploadmatNew((new DingDingUrlData()).getUpload_Url()+token+"&type="+type, resourceurl);
            //图片
//            String resp = swx.uploadmat((new DingDingUrlData()).getUpload_Url()+token+"&type=image", new File("C:\\Users\\nl\\Desktop\\图片库\\timg.jpg"));
            //语音
            //String resp = swx.uploadmat((new DingDingUrlData()).getUpload_Url()+token+"&type=voice", new File("C:\\Users\\nl\\Desktop\\图片库\\10673.wav"));

//            System.out.println("获取到的token======>" + token);

           // System.out.println("发送微信的响应数据======>" + resp);
//            System.out.println("发送微信的响应数据======>" + resp);

            return  resp;
//            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  "ERROR";
    }





}
