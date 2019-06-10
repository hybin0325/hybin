package com.edas.business.dingtalk.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DingtalkText implements Serializable {
    private String content;
    private String title;
    private String markdown;
    private String single_url;
    private String single_title;
    private String text;
}
