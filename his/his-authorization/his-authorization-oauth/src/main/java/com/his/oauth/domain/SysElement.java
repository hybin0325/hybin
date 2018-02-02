package com.his.oauth.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * /**
 * 资源（如增删改查按键）列表
 * Created by lings on 2017/10/26.
 */
@Entity(name = "sys_element")
public class SysElement implements Serializable{

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 权限编码
     */
    @Column
    private String auth;
    /**
     * 元素类型
     */
    @Column
    private String type;
    /**
     * 元素名称
     */
    @Column
    private String name;
    /**
     *元素url
     */
    @Column
    private String url;
    @Column(name = "parent_id")
    /**
     * 父级节点menu_id
     */
    private Integer parentId;

    /**
     * 元素说明
     */
    @Column
    private String description;
    /**
     * 元素添加时间
     */
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creatTime = new Date();

    /**
     * 0未选 1勾选
     */
    @Column
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
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
}
