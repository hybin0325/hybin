package com.his.oauth.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/3.
 */
public class SysElementAuthorityVO implements Serializable{
    private Integer groupId;

    private Integer authId;

    private Integer elementId;

    private String name;


    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public Integer getElementId() {
        return elementId;
    }

    public void setElementId(Integer elementId) {
        this.elementId = elementId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
