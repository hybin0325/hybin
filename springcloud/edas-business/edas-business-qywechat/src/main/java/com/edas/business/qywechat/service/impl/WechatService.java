package com.edas.business.qywechat.service.impl;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WechatService {
	
	/**
	 * 发送消息的请求
	 */
	@Value("${wechat.sendMessageUrl}")
	private String sendMessage;
	
	/**
	 * 获取ToKen的请求
	 */
	@Value("${wechat.getTokenUrl}")
	private String tokenUrl;
	/**
	 *
	 */
	@Value("${wechat.uploadUrl}")
	private String uploadUrl;

	@Value("${wechat.getMediaUrl}")
	private String getMediaUrl;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	/**
	 * 
	* @Title: getToken
	* @Description: 
	* @param @param corpid
	* @param @param corpsecret
	* @return String    返回类型
	* @throws
	 */
	@SuppressWarnings("unchecked")
	public String getToken(String corpid, String corpsecret) {
		String url = tokenUrl+"?corpid={corpid}&corpsecret={corpsecret}";
        Map<String,String> params = new HashMap<>();
        params.put("corpid",corpid);
        params.put("corpsecret",corpsecret);
        
        String request = restTemplate.getForObject(url,String.class,params);
        log.info("返回参数：" +request);
        if(StringUtils.isNotBlank(request)) {
        	 Map<String, Object> map = JSON.parseObject(request,Map.class);
        	 return map.get("access_token").toString();
        }
        return null;
	}
	
	 /**
     * @Title  创建微信发送请求post实体
     * charset消息编码    ，contentType消息体内容类型，
     * url微信消息发送请求地址，data为post数据，token鉴权token
     * @return String
     */
	@Async
    public void sendPost(String data,String token)  {
    	String sendMessageUrl=sendMessage+"?access_token="+token;
    	HttpHeaders headers = new HttpHeaders();
		//headers.add("Content-Type", "application/x-www-form-urlencoded");
    	headers.add("Content-Type", "text/plain;charset=UTF-8");
		HttpEntity<String> formEntity = new HttpEntity<>(data, headers);
		
		JSONObject json = restTemplate.postForEntity(sendMessageUrl, formEntity, JSONObject.class).getBody();
		log.info("json:  " + json.toJSONString());
    }




	public  String uploadmatNew(String access_token,String type, String fileurl) {
		String requestUrl =  uploadUrl+"?access_token="+access_token+"&type="+type;
		log.info("这是上传文件要用的地址"+requestUrl);
		log.info("这是上传文件的网络地址"+fileurl);
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

	//获取媒体文件 https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
	public String getMedia(String acken,String media_id){
		String url = tokenUrl+"?access_token={acken}&media_id={media_id}";
		Map<String,String> params = new HashMap<>();
		params.put("access_token",acken);
		params.put("media_id",media_id);

		String request = restTemplate.getForObject(url,String.class,params);
		log.info("返回参数：" +request);
		if(StringUtils.isNotBlank(request)) {
			Map<String, Object> map = JSON.parseObject(request,Map.class);
			return map.get("access_token").toString();
		}
		return  null;
	};

}
