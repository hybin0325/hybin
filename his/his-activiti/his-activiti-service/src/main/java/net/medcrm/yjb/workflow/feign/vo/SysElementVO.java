package net.medcrm.yjb.workflow.feign.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linsheng on 2017/12/12.
 */
public class SysElementVO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 865704601758939570L;
	/**
     * 主键ID
     */
    private String id;
    /**
     * 权限编码
     */
    private String auth;
    /**
     * 元素类型
     */
    private String type;
    /**
     * 元素名称
     */
    private String name;
    /**
     *元素url
     */
    private String url;
    /**
     * 父级节点menu_id
     */
    private String parentId;

    /**
     * 元素说明
     */
    private String description;
    /**
     * 元素添加时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creatTime = new Date();

    /**
     * 0未选 1勾选
     */
    private Integer status = 0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
   
}
