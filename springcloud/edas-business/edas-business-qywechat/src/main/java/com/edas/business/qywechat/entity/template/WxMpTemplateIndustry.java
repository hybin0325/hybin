package com.edas.business.qywechat.entity.template;

import java.io.Serializable;
import com.edas.business.qywechat.util.WxMpGsonBuilder;
import lombok.Data;

/**
 * <p>
 * File Name: WxMpTemplateData.java
 * </p>
 * <p>
 * Description: 模板行业
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
public class WxMpTemplateIndustry implements Serializable {

  private Industry primaryIndustry;
  private Industry secondIndustry;

  public WxMpTemplateIndustry() {
  }

  public WxMpTemplateIndustry(Industry primaryIndustry, Industry secondIndustry) {
    this.primaryIndustry = primaryIndustry;
    this.secondIndustry = secondIndustry;
  }

  public static WxMpTemplateIndustry fromJson(String json) {
    return WxMpGsonBuilder.create().fromJson(json, WxMpTemplateIndustry.class);
  }

  @Override
  public String toString() {
    return WxMpGsonBuilder.create().toJson(this);
  }

  public String toJson() {
    return WxMpGsonBuilder.create().toJson(this);
  }

  /**
   * 官方文档中，创建和获取的数据结构不一样。所以采用冗余字段的方式，实现相应的接口.
   */
  @Data
  public static class Industry implements Serializable {
    private static final long serialVersionUID = -1707184885588012142L;
    private String id;
    private String firstClass;
    private String secondClass;

    public Industry() {
    }

    public Industry(String id) {
      this.id = id;
    }

    public Industry(String id, String firstClass, String secondClass) {
      this.id = id;
      this.firstClass = firstClass;
      this.secondClass = secondClass;
    }

    @Override
    public String toString() {
      return WxMpGsonBuilder.create().toJson(this);
    }

  }
}