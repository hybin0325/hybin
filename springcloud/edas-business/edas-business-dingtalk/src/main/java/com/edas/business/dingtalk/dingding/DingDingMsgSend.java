package com.edas.business.dingtalk.dingding;

import com.alibaba.fastjson.JSON;
import com.edas.business.dingtalk.entity.DingDingData;
import com.edas.business.dingtalk.entity.DingDingUrlData;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Slf4j
public class DingDingMsgSend {
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
    /**
     * 微信授权请求，GET类型，获取授权响应，用于其他方法截取token
     * @param Get_Token_Url
     * @return String 授权响应内容
     * @throws IOException
     */
    protected String toAuth(String Get_Token_Url) throws IOException {


        httpClient = HttpClients.createDefault();
        httpGet = new HttpGet(Get_Token_Url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        String resp;
        try {
            HttpEntity entity = response.getEntity();
            resp = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }
        LoggerFactory.getLogger(getClass()).info(" resp:{}", resp);
        return resp;
    }


    /**corpid应用组织编号   corpsecret应用秘钥
     * 获取toAuth(String Get_Token_Url)返回结果中键值对中access_token键的值
     * @param
     */
    public static String getToken(String corpid,String corpsecret) throws IOException {
        DingDingMsgSend sw = new DingDingMsgSend();

        DingDingUrlData uData = new DingDingUrlData();
        uData.setGet_Token_Url(corpid,corpsecret);
        String resp = sw.toAuth(uData.getGet_Token_Url());

        try{
            Map<String, Object> map = JSON.parseObject(resp,Map.class);
            return map.get("access_token").toString();
        }catch (Exception e) {
            return resp;
        }
//        return "ok";
    }
    /**
     * @Title:创建钉钉发送请求post数据
     * touser发送消息接收者
     * application_id应用编号。
     * 本方法适用于text型微信消息，contentKey和contentValue只能组一对
     * @return String
     */
    public static String createpostdata(Number agent_id,String userid_list,String dept_id_list,Boolean to_all_user,Object msg){
        DingDingData ddd = new DingDingData();
        ddd.setAgent_id(agent_id);
        if(userid_list != null){
            if(userid_list.length() >0){
                ddd.setUserid_list(userid_list);
            }
        }
        if(dept_id_list != null){
            if(dept_id_list.length() > 0){
                ddd.setDept_id_list(dept_id_list);
            }
        }

//        ddd.setDept_id_list(dept_id_list);
        ddd.setTo_all_user(to_all_user);
        ddd.setMsg(msg);

        return JSON.toJSONString(ddd);
    }

        /**
     * @Title:创建钉钉发送请求post数据
     * touser发送消息接收者
     * application_id应用编号。
     * 本方法适用于text型微信消息，contentKey和contentValue只能组一对
     * @return String
     */
    public String createpostusdata(String userid,String lang){
        DingDingData ddd = new DingDingData();
        ddd.setUserid(userid);
        ddd.setLang(lang);
//        if(userid_list != null){
//            if(userid_list.length() >0){
//                ddd.setUserid_list(userid_list);
//            }
//        }
//        if(dept_id_list != null){
//            if(dept_id_list.length() > 0){
//                ddd.setDept_id_list(dept_id_list);
//            }
//        }

//        ddd.setDept_id_list(dept_id_list);
//        ddd.setTo_all_user(to_all_user);
//        ddd.setMsg(msg);

        return JSON.toJSONString(ddd);
    }


    /**
     * @Title:创建钉钉发送请求postmd数据
     * touser发送消息接收者
     * application_id应用编号。
     * 本方法适用于text型微信消息，contentKey和contentValue只能组一对
     * @return String
     */
    public String createpostmddata(Number agent_id,String type,String media){
        DingDingData ddd = new DingDingData();
        ddd.setAgent_id(agent_id);


//        ddd.setDept_id_list(dept_id_list);
        ddd.setType(type);
        ddd.setMedia(media);

        return JSON.toJSONString(ddd);
    }


    /**
     * @Title  创建钉钉发送请求post实体
     * charset消息编码    ，contentType消息体内容类型，
     * url微信消息发送请求地址，data为post数据，token鉴权token
     * @return String
     */
    public static String post(String charset, String contentType, String url,
                       String data,String token) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url+token);
        httpPost.setHeader(CONTENT_TYPE, contentType);
        httpPost.setEntity(new StringEntity(data, charset));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        String resp;
        System.out.println("我来到了这里1");
        try {
            HttpEntity entity = response.getEntity();
            System.out.println("我来到了这里2"+entity);
            resp = EntityUtils.toString(entity, charset);
            EntityUtils.consume(entity);
        } finally {
            response.close();
        }

        log.info("call [{}], param:{}, resp:{}", url, data, resp);

//        return toString();
        return resp;

    }

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
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

    /**
     * @desc ：微信上传素材的请求方法
     *
     * @param requestUrl  微信上传临时素材的接口url
     * @param file    要上传的文件
     * @return String  上传成功后，微信服务器返回的消息
     */
    public  String uploadmat(String requestUrl, File file) {
        StringBuffer buffer = new StringBuffer();

        System.out.println(file.length());
        try{
            //1.建立连接
            URL url = new URL(requestUrl);
            System.out.println("临时文件上传链接"+requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  //打开链接

            //1.1输入输出设置
            httpUrlConn.setDoInput(true);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setUseCaches(false); // post方式不能使用缓存
            //1.2设置请求头信息
            httpUrlConn.setRequestProperty("Connection", "Keep-Alive");
            httpUrlConn.setRequestProperty("Charset", "UTF-8");
            //1.3设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            httpUrlConn.setRequestProperty("Content-Type","multipart/form-data; boundary="+ BOUNDARY);

            System.out.println(file.length());
            // 请求正文信息
            // 第一部分：
            //2.将文件头输出到微信服务器
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length()
                    + "\";filename=\""+ file.getName() + "\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream outputStream = new DataOutputStream(httpUrlConn.getOutputStream());
            // 将表头写入输出流中：输出表头
            outputStream.write(head);

            //3.将文件正文部分输出到微信服务器
            // 把文件以流文件的方式 写入到微信服务器中
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();
            //4.将结尾部分输出到微信服务器
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();

            System.out.println(httpUrlConn.getInputStream());
            //5.将微信服务器返回的输入流转换成字符串

            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();


        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public  String uploadmatNew(String requestUrl, String fileurl) {
        StringBuffer buffer = new StringBuffer();
        try{

            URL url1 = new URL(fileurl);
            HttpURLConnection conn = (HttpURLConnection)url1.openConnection();
            //得到输入流
            InputStream in = conn.getInputStream();



            //1.建立连接
            URL url = new URL(requestUrl);
            System.out.println("临时文件上传链接 新"+requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  //打开链接

            //1.1输入输出设置
            httpUrlConn.setDoInput(true);
            httpUrlConn.setDoOutput(true);
            httpUrlConn.setUseCaches(false); // post方式不能使用缓存
            //1.2设置请求头信息
            httpUrlConn.setRequestProperty("Connection", "Keep-Alive");
            httpUrlConn.setRequestProperty("Charset", "UTF-8");
            //1.3设置边界
            String BOUNDARY = "----------" + System.currentTimeMillis();
            httpUrlConn.setRequestProperty("Content-Type","multipart/form-data; boundary="+ BOUNDARY);

//            System.out.println(file.length());
            // 请求正文信息
            // 第一部分：
            //2.将文件头输出到微信服务器
            StringBuilder sb = new StringBuilder();
            sb.append("--"); // 必须多两道线
            sb.append(BOUNDARY);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + String.valueOf(in.available())
                    + "\";filename=\"text.png\"\r\n");
            sb.append("Content-Type:application/octet-stream\r\n\r\n");
            byte[] head = sb.toString().getBytes("utf-8");
            // 获得输出流
            OutputStream outputStream = new DataOutputStream(httpUrlConn.getOutputStream());
            // 将表头写入输出流中：输出表头
            outputStream.write(head);

            //3.将文件正文部分输出到微信服务器
            // 把文件以流文件的方式 写入到微信服务器中
//            DataInputStream in = new DataInputStream(new FileInputStream(file));
//            DataInputStream in = re;
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                outputStream.write(bufferOut, 0, bytes);
            }
            in.close();
            //4.将结尾部分输出到微信服务器
            byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
            outputStream.write(foot);
            outputStream.flush();
            outputStream.close();

            System.out.println(httpUrlConn.getInputStream());
            //5.将微信服务器返回的输入流转换成字符串

            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();


        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
