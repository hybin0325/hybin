package com.his.oauth.domain;

import com.his.oauth.util.CommonConstant;
import com.his.oauth.vo.SysOrgVO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 系统菜单
 * Created by lings on 2017/10/25.
 */
@Entity(name = "sys_menu")
public class SysMenu implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "parent_id")
    private Integer parentId = CommonConstant.ROOT;

    @Column(name = "href")
    private String href;

    @Column(name = "icon")
    private String icon;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "crt_user")
    private String crtUser;

    @Column(name = "crt_name")
    private String crtName;

    @Transient
    private List<SysElement> elements = new ArrayList<>();


    @Transient
    private List<SysOrgVO> orgs = new ArrayList<>();

    public List<SysElement> getElements() {
        return elements;
    }

    public void setElements(List<SysElement> elements) {
        this.elements = elements;
    }

    public List<SysOrgVO> getOrgs() {
        return orgs;
    }

    public void setOrgs(List<SysOrgVO> orgs) {
        this.orgs = orgs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public String getCrtName() {
        return crtName;
    }

    public void setCrtName(String crtName) {
        this.crtName = crtName;
    }
}
