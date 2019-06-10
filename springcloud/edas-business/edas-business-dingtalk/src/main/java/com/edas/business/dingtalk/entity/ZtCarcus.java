package com.edas.business.dingtalk.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "shopwwi_zt_carcus")
@Data
@ToString
public class ZtCarcus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String license;

    private Integer id;

    /**
     * 我的标签
     */
    @Column(name = "license_data")
    private String licenseData;

    /**
     * @return license
     */
    public String getLicense() {
        return license;
    }

    /**
     * @param license
     */
    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return licenseData
     */
    public String getLicenseData() {
        return licenseData;
    }

    /**
     * @param licenseData
     */
    public void setLicenseData(String licenseData) {
        this.licenseData= licenseData;
    }

}
