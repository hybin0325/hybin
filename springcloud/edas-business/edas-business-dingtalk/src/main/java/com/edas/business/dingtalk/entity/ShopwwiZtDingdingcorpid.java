package com.edas.business.dingtalk.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "shopwwi_zt_dingdingcorpid")
public class ShopwwiZtDingdingcorpid {
    @Id
    private String userid;
    private  String username;
    private Integer id;
    private  String appkey;
    private String appsecret;

    @Column(name = "agent_id")
    private String agentId;
    private String  dld;
    private String  clique;
    @Column(name = "add_date")
    private String addDate;
    @Column(name = "userid_up")
    private  String useridUp;
    @Column(name = "username_up")
    private  String usernameUp;
    @Column(name = "upd_date")
    private  Date updDate;
    private Integer  status;
    public Integer getStatus(){
        return status;
    }
    public void setStatus(Integer status){
        this.status = status ;
    }

    public Date getUpdDate() {
        return updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }
    public String getUsernameUp() {
        return usernameUp;
    }

    public void setUsernameUp(String usernameUp) {
        this.usernameUp = usernameUp== null ? null : usernameUp.trim();
    }
    public String getUseridUp() {
        return useridUp;
    }

    public void setUseridUp(String useridUp) {
        this.useridUp = useridUp== null ? null : useridUp.trim();
    }
    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate== null ? null : addDate.trim();
    }
    public String getClique() {
        return clique;
    }

    public void setClique(String clique) {
        this.clique = clique== null ? null : clique.trim();
    }
    public String getDld() {
        return dld;
    }

    public void setDld(String dld) {
        this.dld = dld== null ? null : dld.trim();
    }
    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username == null ? null :username.trim();
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id ;
    }

    public String getAppkey(){
        return appkey;
    }
    public void setAppkey(String appkey){
        this.appkey = appkey == null ? null :appkey.trim();
    }

    public String getAppsecret(){
        return appsecret;
    }
    public void setAppsecret(String appsecret){
        this.appsecret= appsecret== null ? null :appsecret.trim();
    }


}
