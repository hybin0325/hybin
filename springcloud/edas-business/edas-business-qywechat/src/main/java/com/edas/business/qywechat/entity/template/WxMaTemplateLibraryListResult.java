package com.edas.business.qywechat.entity.template;

import java.io.Serializable;
import java.util.List;

import com.edas.business.qywechat.util.WxGsonBuilder;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class WxMaTemplateLibraryListResult implements Serializable{

	  @SerializedName("total_count")
	  private int totalCount;
	  private List<TemplateItem> list;

	  public static WxMaTemplateLibraryListResult fromJson(String json){
	    return WxGsonBuilder.create().fromJson(json, WxMaTemplateLibraryListResult.class);
	  }

	  @Data
	  public static class TemplateItem{

	    private String id;
	    private String title;
	  }
}
