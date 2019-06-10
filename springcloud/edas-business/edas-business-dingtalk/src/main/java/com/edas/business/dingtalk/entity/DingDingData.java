package com.edas.business.dingtalk.entity;

import lombok.Data;

@Data
public class DingDingData {

    private Number agent_id;
    private String userid_list;
    private String dept_id_list;
    private String type;
    private String media;
    private String userid;
    private String title;
    private String markdown;
    private String single_title;
    private String single_url;
    private String lang;
    private String content;
    private Boolean to_all_user;
    private Object msg;
    public void setMedia(String media){
        this.media = media;
    }
    public String getMedia(){
        return  media;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return  type;
    }
    public void setLang(String lang){
        this.userid = lang;
    }
    public String getLang(){
        return  lang;
    }

    public void setUserid(String userid){
        this.userid = userid;
    }
    public String getUserid(){
        return  userid;
    }

    public void setUserid_list(String userid_list){
        this.userid_list = userid_list;
    }
    public String getUserid_list(){
        return  userid_list;
    }

    public void  setDept_id_list(String dept_id_list){
        this.dept_id_list = dept_id_list;
    }
    public  String getDept_id_list(){
        return  dept_id_list;
    }
    public void setTo_all_user(Boolean to_all_user){
        this.to_all_user = to_all_user;
    }
    public Boolean getTo_all_user(){
        return to_all_user;
    }
    /**
     * 实际接收Map类型数据 文件
     */
    public Object getMsg() {
        return msg;
    }
    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Number getAgent_id(){
        return agent_id;
    }
    public void setAgent_id(Number agent_id){
        this.agent_id = agent_id;
    }
}
