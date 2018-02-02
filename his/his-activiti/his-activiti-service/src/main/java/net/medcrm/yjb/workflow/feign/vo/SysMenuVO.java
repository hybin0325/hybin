package net.medcrm.yjb.workflow.feign.vo;

import java.io.Serializable;
/**
 * Created by Administrator on 2017/11/24.
 */
public class SysMenuVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7409124260921347363L;

	private String id;

    private String title;

    private Integer parentId;

    private String href;

    private String icon;

    private Integer type = 4;

    private Integer status = 1;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
