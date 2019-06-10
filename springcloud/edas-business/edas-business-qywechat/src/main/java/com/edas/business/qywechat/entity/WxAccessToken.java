package com.edas.business.qywechat.entity;

import java.io.Serializable;
import com.edas.business.qywechat.util.WxGsonBuilder;
import lombok.Data;

/**
 * <p>
 * File Name: WxAccessToken.java
 * </p>
 * <p>
 * Description:  access token
 * </p>
 * <p>
 * Date：2019年5月18日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Data
public class WxAccessToken implements Serializable {
	
  private String accessToken;

  private int expiresIn = -1;

  public static WxAccessToken fromJson(String json) {
    return WxGsonBuilder.create().fromJson(json, WxAccessToken.class);
  }

}
