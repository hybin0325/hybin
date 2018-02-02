package com.his.oauth.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/3.
 */
public class SysOrgVO implements Serializable{
    private String id;

    private Integer type;

    private Integer typeId;

    private String name;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
