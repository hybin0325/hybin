package com.edas.business.data.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "shopwwi_zt_carcus")
@Data
@ToString
public class ShopwwiZtCarcus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;
    private String license;


    /**
     * 我的标签
     */

    private String licenseData;



}
