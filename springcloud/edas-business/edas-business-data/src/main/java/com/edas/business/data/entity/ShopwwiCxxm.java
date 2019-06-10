package com.edas.business.data.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "shopwwi_cxxm")
@Data
@ToString
public class ShopwwiCxxm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id

    private Integer id;
    private Integer fieldtype;
    private Integer cxId;

    private String chname;
    private String enname;
    private String lx;
    private String primarykey;
    private String virtualkey;
    private String tbname;
    private String virtualexp;
    private String tbchname;
    private String coltype;
    private String colwidth;
    private String combovaluetype;
    private String openclassid;
    private String bz;
    private String opentype;
    private String dateformat;

}
