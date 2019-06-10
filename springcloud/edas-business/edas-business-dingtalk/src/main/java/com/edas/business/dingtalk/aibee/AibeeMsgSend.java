package com.edas.business.dingtalk.aibee;


import com.alibaba.fastjson.JSON;
import com.edas.business.dingtalk.entity.AibeeData;
import com.edas.business.dingtalk.aibee.SHA1Utils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class AibeeMsgSend {
    private CloseableHttpClient httpClient;
    /**
     *  用于提交登陆数据
     */
    private HttpPost httpPost;
    /**
     *  用于获得登录后的页面
     */
    private HttpGet httpGet;
    public static final String CONTENT_TYPE = "Content-Type";


    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 注册客户
    public String addUser(List groups,Map content)throws IOException{

//        contents.put("user",content.toString());
//        contents.put("check","true");
//        contents.put("ret_feature","true");
//        contents.put("groups","['test']");
        String data =this.createpostdata(groups,true,true,content);
        System.out.println("请求参数："+data+"完");
        String st = this.post("","","https://face.aibee.cn/test/1vn/users/v1/add",data,"");
        return st;
    }

    //更新用户id user_id
    public String updateUserId(String olduserid,String newuserid)throws IOException{

        String data =this.createUpdata(olduserid,newuserid);
        System.out.println("请求参数："+data+"完");
        String st = this.post("","","https://face.aibee.cn/test/1vn/users/v1/update-user-id",data,"");
        return st;
    }
    //将用户从某个组移除
    public String removeGroup(String olduserid,String newuserid)throws IOException{

        String data =this.createUpdata(olduserid,newuserid);
        System.out.println("请求参数："+data+"完");
        String st = this.post("","","https://face.aibee.cn/test/1vn/users/v1/update-user-id",data,"");
        return st;
    }
    //查询用户信息
    public String info(String userid,Boolean simple_res)throws IOException{

        String data =this.createInfodata(userid,simple_res);
        System.out.println("请求参数："+data+"完");
        String st = this.post("","","https://face.aibee.cn/test/1vn/users/v1/info",data,"");
        return st;
    }
    //查询组信息
    public String ginfo(String userid,Boolean simple_res)throws IOException{

        String st = this.sendGet("https://face.aibee.cn/test/1vn/groups/v1/info","");
        return st;
    }
    //查询组 用户信息
    public String guserinfo(String userid,Boolean simple_res)throws IOException{
        String data =this.createGusereInfodata("hjx-test",1,10,true);
        System.out.println("请求参数："+data+"完");
        String st = this.post("","","https://face.aibee.cn/test/1vn/groups/v1/user-list",data,"");
        return st;
    }

    //1vn 人脸对比
    public String compareVn(String userid,Boolean simple_res)throws IOException{
        String data =this.createGusereInfodata("hjx-test",1,10,true);
        System.out.println("请求参数："+data+"完");
        String st = this.post("","","https://face.aibee.cn/test/1vn/groups/v1/user-list",data,"");
        return st;
    }


    /**
     * @return String
     */
    public String createpostdata(List groups, Boolean ret_feature, Boolean check, Object user){
        AibeeData ddd = new AibeeData();
        ddd.setCheck(check);
//        ddd.setDept_id_list(dept_id_list);
        ddd.setGroups(groups);
        ddd.setRet_feature(ret_feature);
        ddd.setUser(user);

        return JSON.toJSONString(ddd);
    }

    public String createUpdata(String olduserid,String newuserid){
        AibeeData ddd = new AibeeData();
        ddd.setOld_user_id(olduserid);
        ddd.setNew_user_id(newuserid);
        return JSON.toJSONString(ddd);
    }
    public String createInfodata(String userid,Boolean simple_res){
        AibeeData ddd = new AibeeData();
        ddd.setUser_id(userid);
        ddd.setSimple_res(simple_res);
        return JSON.toJSONString(ddd);
    }
    public String createGusereInfodata(String group_id,Integer page,Integer num,Boolean simple_res){
        AibeeData ddd = new AibeeData();
        ddd.setGroup_id(group_id);
        ddd.setPage(page);
        ddd.setNum(num);
        ddd.setSimple_res(simple_res);
        return JSON.toJSONString(ddd);
    }

    public String createComparevndata(String group_id,String top_n){
        AibeeData ddd = new AibeeData();
        ddd.setGroup_id(group_id);
        ddd.setTop_n(top_n);

        return JSON.toJSONString(ddd);
    }

    /**
     * @Title  创建aibee发送请求post实体
     * charset消息编码    ，contentType消息体内容类型，
     * url消息发送请求地址，data为post数据，token鉴权token
     * @return String
     */
    public String post(String charset, String contentType, String url,
                       String data,String token) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        System.out.println("我来到了这里"+url);
        SHA1Utils sha = new SHA1Utils();
//        url = "https://face.aibee.cn/test/1v1/users/v1/add";
        httpPost = new HttpPost(url);
        httpPost.setHeader(CONTENT_TYPE, "application/json");
//        builder.header("Aibee-Auth-ApiKey", mKey);
        httpPost.setHeader("Aibee-Auth-ApiKey","3htkHXEu9MfcMb2JsQLlIxGDLKyZyaV8");

        System.out.println("头部"+httpPost.getAllHeaders().toString());
        httpPost.setEntity(new StringEntity(data, charset));
        final String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        System.out.println("当前时间戳"+timeStamp);
        String secret = "JvfD4SIzL7nm9od9fmosLkVakUoq1tqd";

        String signs  =  data+timeStamp + secret;
        System.out.println("参数:"+signs);
        String sign = sha.hex_sha1(signs);
        System.out.println("Aibee-Auth-Sign:"+sign);
        httpPost.setHeader("Aibee-Auth-Sign",sign);
        httpPost.setHeader("Aibee-Auth-TimeStamp",timeStamp);
        CloseableHttpResponse response = httpclient.execute(httpPost);
        String resp;
        System.out.println("我来到了这里1"+response);
        try {
            HttpEntity entity = response.getEntity();
            System.out.println("我来到了这里2"+entity);
            resp = EntityUtils.toString(entity, "utf-8");
            System.out.println("我来到了这里2"+resp);

//            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
        return resp;
//        LoggerFactory.getLogger(getClass()).info("call [{}], param:{}, resp:{}", url, data, resp);

//        return toString();
//        return resp;

    }

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            SHA1Utils sha = new SHA1Utils();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty(CONTENT_TYPE, "application/json");
            connection.setRequestProperty("Aibee-Auth-ApiKey","3htkHXEu9MfcMb2JsQLlIxGDLKyZyaV8");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            final String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
            String secret = "JvfD4SIzL7nm9od9fmosLkVakUoq1tqd";
            String signs  =  param+timeStamp + secret;
            System.out.println("参数:"+signs);
            System.out.println("时间戳:"+timeStamp);
            String sign = sha.hex_sha1(signs);
            System.out.println("Aibee-Auth-Sign:"+sign);
            connection.setRequestProperty("Aibee-Auth-Sign",sign);
            connection.setRequestProperty("Aibee-Auth-TimeStamp",timeStamp);
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }


}
