package com.edas.business.dingtalk.entity;

public class User {

    private Integer id = 34132;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String username = "C.Ronaldo";
    private String sex = "男";
}