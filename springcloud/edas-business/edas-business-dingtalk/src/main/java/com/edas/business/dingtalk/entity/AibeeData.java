package com.edas.business.dingtalk.entity;

import java.util.List;

public class AibeeData {
    private Boolean check;
    private Boolean ret_feature;
    private Boolean simple_res;
    private String user_id;
    private List groups;
    private Object user;
    private String old_user_id;
    private String new_user_id;
    private Integer page;
    private String group_id;
    private Integer num;
    private String top_n;

    public String getTop_n(){
        return  top_n;
    }
    public void setTop_n(String top_n){
        this.top_n = top_n;
    }

    public Integer getNum(){
        return  num;
    }
    public void setNum(Integer num){
        this.num = num;
    }

    public Integer getPage(){
        return  page;
    }
    public void setPage(Integer page){
        this.page = page;
    }

    public String getGroup_id(){
        return  group_id;
    }
    public void setGroup_id(String group_id){
        this.group_id = group_id;
    }

    public String getUser_id(){
        return user_id;
    }
    public void setUser_id(String user_id){
        this.user_id = user_id;
    }

    public Boolean getSimple_res(){
        return  simple_res;
    }
    public void setSimple_res(Boolean simple_res){
        this.simple_res = simple_res;
    }

    public String getOld_user_id(){
        return old_user_id;
    }
    public void setOld_user_id(String old_user_id){
        this.old_user_id = old_user_id;
    }
    public String getNew_user_id(){
        return  new_user_id;
    }
    public void setNew_user_id(String new_user_id){
        this.new_user_id = new_user_id;
    }
    /**
     * 实际接收list类型数据 文件
     */
    public List getGroups() {
        return groups;
    }
    public void setGroups(List groups) {
        this.groups = groups;
    }
 /**
     * 实际接收Map类型数据 文件
     */
    public Object getUser() {
        return user;
    }
    public void setUser(Object user) {
        this.user = user;
    }


    public void setRet_feature(Boolean ret_feature){
        this.ret_feature = ret_feature;
    }
    public Boolean getRet_feature(){
        return  ret_feature;
    }

    public void setCheck(Boolean check){
        this.check = check;
    }
    public Boolean getCheck(){
        return  check;
    }
}
