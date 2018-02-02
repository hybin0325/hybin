package com.his.oauth.util;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by asus on 2017/10/25.
 */
public class Test {

    public static  void main(String[] args){
        //使用base64进行加密
        byte[] tokenByte = Base64.encodeBase64(("$2a$10$XOVs4Z1YtPKqKwQVywG9j.xLAqXYRQLGZMGMrZDNbtl6pUC0Weteq"+":"+"$2a$10$XOVs4Z1YtPKqKwQVywG9j.xLAqXYRQLGZMGMrZDNbtl6pUC0Weteq").getBytes());
        //将加密的信息转换为string
        //String tokenStr = DataTypeChange.bytesSub2String(tokenByte, 0, tokenByte.length);

        System.out.println();
        byte[] resBytes = new byte[tokenByte.length];
        System.arraycopy(tokenByte, 0, resBytes, 0, tokenByte.length);
        String result_str = new String(resBytes);
        String token = "Basic "+result_str;
        System.out.println(token);
    }
    //Basic JDJhJDEwJFhPVnM0WjFZdFBLcUt3UVZ5d0c5ai54TEFxWFlSUUxHWk1HTXJaRE5idGw2cFVDMFdldGVxOiQyYSQxMCRYT1ZzNFoxWXRQS3FLd1FWeXdHOWoueExBcVhZUlFMR1pNR01yWkROYnRsNnBVQzBXZXRlcQ==
    //Basic JDJhJDEwJFhPVnM0WjFZdFBLcUt3UVZ5d0c5ai54TEFxWFlSUUxHWk1HTXJaRE5idGw2cFVDMFdldGVxOiQyYSQxMCRYT1ZzNFoxWXRQS3FLd1FWeXdHOWoueExBcVhZUlFMR1pNR01yWkROYnRsNnBVQzBXZXRlcQ==
    //Basic JDJhJDEwJFhPVnM0WjFZdFBLcUt3UVZ5d0c5ai54TEFxWFlSUUxHWk1HTXJaRE5idGw2cFVDMFdldGVxOiQyYSQxMCRYT1ZzNFoxWXRQS3FLd1FWeXdHOWoueExBcVhZUlFMR1pNR01yWkROYnRsNnBVQzBXZXRlcQ==
}
