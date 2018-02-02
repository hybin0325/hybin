package com.his.oauth.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 权限拥有者
 * Created by lings on 2017/10/27.
 */
@Entity(name = "sys_manager")
public class SysManager implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 权限主体ID(人员、机构、角色)
     */
    @Column(name = "ower_id")
    private Integer owerId;
    /**
     * 访问控制组ID
     */
    @Column(name = "group_id")
    private Integer groupId;
    /**
     *  名称
     */
    @Column
    private String name;
    /**
     *  类型(组织机构1、角色2或者人员3)
     */
    @Column
    private Integer type;

    /**
     *  POSITION_ORG_TYPE(1,"组织机构"),
     *  POSITION_ROLE_TYPE(2,"组织机构"),
     *  OPERATION_ORG(1, "机构"),
     *  OPERATION_POS(2, "部门"),
     *  OPERATION_GRP(3, "工作组"),
     *  OPERATION_ORG_ROLE(1, "机构角色"),
     *  OPERATION_POS_ROLE(2, "部门角色"),
     *  OPERATION_GRP_ROLE(3, "工作组角色");
     *  类型对应的类型
     */
    @Column(name = "type_id")
    private Integer typeId;
    /**
     * 添加时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creatTime = new Date();

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getOwerId() {
        return owerId;
    }

    public void setOwerId(Integer owerId) {
        this.owerId = owerId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
