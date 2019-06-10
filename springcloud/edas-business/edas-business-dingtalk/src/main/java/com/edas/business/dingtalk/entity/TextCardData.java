package com.edas.business.dingtalk.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class TextCardData implements Serializable {
    private String single_url;
    private String single_title;
    private String markdown;
    private String title;
    private String content;


}
