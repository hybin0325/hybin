package com.edas.business.data.entity;

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
//     #region 新加的字段
    private String isOfficialCar; //公务车否 =1 才推
    private  String OfficialCarType;//公务车车辆类型

    private  String OfficialCarOwner; //公务车所属

//            #endregion
//
//            #region -----------年审到期-----------------

    private String isAnnual = "0"; //年审到期 =1 才推
    private String annual_day; //距离年审到期天数 

//            #endregion
//
//            #region -----------五年车-----------------

    private String isFiveYearCar = "0"; //五年车否 =1 才推
    private String fiveYear_con; //五年车顾问
    private String fiveYear_con_id; //五年车顾问id

    private String isRenlimit = "0"; //保险到期否=1 才推

           

}
