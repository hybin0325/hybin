package com.edas.business.qywechat.entity.req;

import com.edas.business.qywechat.entity.ArticlesData;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeChatText implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9131938757067921277L;
	private String content;
	private String title;
	private String description;
	private String url;
	private String btntxt;
	private String media_id;
	private String articles;

}
