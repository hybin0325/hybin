package com.edas.business.qywechat.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: WeMpController.java
 * </p>
 * <p>
 * Description: 公众号controller
 * </p>
 * <p>
 * Date：2019年6月4日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Controller
@RequestMapping("wxmp")
public class WeMpController {
	
	 private static final String token = "test";
	 
	    //微信公众号接入
	    @RequestMapping("/getToken")
	    public void getToken(HttpServletResponse response, String signature, String timestamp, String nonce, String echostr){
	 
	        try {
	            PrintWriter out = response.getWriter();
	            if(checkSignature(signature, timestamp, nonce)){	                
	                log.info(echostr);
	                out.print(echostr);
	            }
	            out.close();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	 
	    }

	    public static boolean checkSignature(String signature,String timestamp,String nonce){
	        String[] arr = new String[]{token,timestamp,nonce};
	        //排序
	        Arrays.sort(arr);
	 
	        //生成字符串
	        StringBuffer content = new StringBuffer();
	        for (int i = 0; i < arr.length; i++) {
	            content.append(arr[i]);
	        }
	 
	        //sha1加密
	        String temp = getSha1(content.toString());
	 
	        return temp.equals(signature);
	 
	    }
	 
	    public static String getSha1(String str){
	        if (null == str || 0 == str.length()){
	            return null;
	        }
	        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
	                'a', 'b', 'c', 'd', 'e', 'f'};
	        try {
	            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	            mdTemp.update(str.getBytes("UTF-8"));
	 
	            byte[] md = mdTemp.digest();
	            int j = md.length;
	            char[] buf = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                buf[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(buf);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}