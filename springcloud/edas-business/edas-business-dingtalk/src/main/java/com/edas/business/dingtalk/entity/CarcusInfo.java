package com.edas.business.dingtalk.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Data
public class CarcusInfo implements Serializable {
    private String clique;
    private String dld;
    private String license;
    private String frame;
    private String buy_time;
    private String mileage;
    private String final_time;
    private String cus_name;
    private String cus_phone;
    private String cus_id;
    private String cus_id_erp;
    private String appoint_time;
    private String mem_level;
    private String mem_score;
    private String mem_period;
    private String exten_period;
    private String warranty_period;
    private String is_renlimit;
    private String ren_con;
    private String ren_con_id;
    private String insur_day;
    private String accountmanager;
    private String accountmanager_id;
    private String yuyue_type;
    private String yuyue_guwen_id;
    private String yuyue_guwen_name;
    private String jc1_tixing;
    private String jc2_tixing;
    private String ybBegin_time;
    private  String hytips;

}
