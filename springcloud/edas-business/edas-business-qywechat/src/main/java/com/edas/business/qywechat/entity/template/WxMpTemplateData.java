package com.edas.business.qywechat.entity.template;

import lombok.Data;
import java.io.Serializable;

/**
 * <p>
 * File Name: WxMpTemplateData.java
 * </p>
 * <p>
 * Description: 模板消息数据
 * </p>
 * <p>
 * Date：2019年5月16日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Data
public class WxMpTemplateData implements Serializable {
  
  private String name;
  private String value;
  private String color;

  public WxMpTemplateData() {
  }

  public WxMpTemplateData(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public WxMpTemplateData(String name, String value, String color) {
    this.name = name;
    this.value = value;
    this.color = color;
  }
}