package com.edas.business.qywechat.entity.template;

import java.io.Serializable;
import java.util.List;

import com.edas.business.qywechat.util.WxGsonBuilder;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class WxMaTemplateLibraryGetResult implements Serializable{
	
	  private String id;
	  private String title;
	  @SerializedName("keyword_list")
	  private List<KeywordInfo> keywordList;

	  @Data
	  public static class KeywordInfo{

	    @SerializedName("keyword_id")
	    private int keywordId;
	    private String name;
	    private String example;
	  }

	  public static WxMaTemplateLibraryGetResult fromJson(String json){
	    return WxGsonBuilder.create().fromJson(json, WxMaTemplateLibraryGetResult.class);
	  }
}
