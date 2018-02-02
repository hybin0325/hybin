package com.his.oauth.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 登录用户对应的组织机构或者角色实体
 * Created by lings on 2017/10/27.
 */
@Entity
public class SysUserPosition implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;
    /**
     * 机构或角色ID
     */
    @Column(name = "org_id")
    private Integer orgId;
    /**
     * 组织机构或者角色类型Id 1,2,3
     */
    @Column(name = "position_id")
    private Integer positionId;

    /**
     * 组织机构或者角色1,2
     */
    @Column(name = "position_type")
    private Integer positionType;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getPositionType() {
        return positionType;
    }

    public void setPositionType(Integer positionType) {
        this.positionType = positionType;
    }
}
