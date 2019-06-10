package com.edas.business.qywechat.entity.template;

import java.io.Serializable;
import java.util.List;

import com.edas.business.qywechat.util.WxMpGsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

/**
 * <p>
 * File Name: WxMpTemplate.java
 * </p>
 * <p>
 * Description: 模板列表信息
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
public class WxMpTemplate implements Serializable {
	
  private static final JsonParser JSON_PARSER = new JsonParser();

  /**
   * template_id.
   * 模板ID
   */
  @SerializedName("template_id")
  private String templateId;
  
  /**
   * title.
   * 模板标题
   */
  @SerializedName("title")
  private String title;
  
  /**
   * primary_industry.
   * 模板所属行业的一级行业
   */
  @SerializedName("primary_industry")
  private String primaryIndustry;
  
  /**
   * deputy_industry.
   * 模板所属行业的二级行业
   */
  @SerializedName("deputy_industry")
  private String deputyIndustry;
  
  /**
   * content.
   * 模板内容
   */
  @SerializedName("content")
  private String content;
  
  /**
   * example.
   * 模板示例
   */
  @SerializedName("example")
  private String example;

  public static List<WxMpTemplate> fromJson(String json) {
    return WxMpGsonBuilder.create().fromJson(JSON_PARSER.parse(json).getAsJsonObject().get("template_list"),
      new TypeToken<List<WxMpTemplate>>() {
      }.getType());
  }

  @Override
  public String toString() {
    return WxMpGsonBuilder.create().toJson(this);
  }

}
