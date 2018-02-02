package net.medcrm.yjb.his.omp.domain;

import java.io.Serializable;
import java.util.List;

public class Division implements Serializable{
    private String id;
    private String fullName;
    private String abbr;
    private String code;
    private String telphone1;
    private String telphone2;
    private String fax;
    private String address;
    private Integer status;
    private Integer type;
    private Integer diviType;
    private Integer sort;
    private String pid;
    private String pids;
    private Integer level;
    private String postCode;
    private Integer bedNumber;
    private String meeting;
    private String duty;
    private String leaderName;
    private String visibleInDiagram;
    private List<EmployeeBasic> employeeBasics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTelphone1() {
        return telphone1;
    }

    public void setTelphone1(String telphone1) {
        this.telphone1 = telphone1;
    }

    public String getTelphone2() {
        return telphone2;
    }

    public void setTelphone2(String telphone2) {
        this.telphone2 = telphone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDiviType() {
        return diviType;
    }

    public void setDiviType(Integer diviType) {
        this.diviType = diviType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Integer bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getVisibleInDiagram() {
        return visibleInDiagram;
    }

    public void setVisibleInDiagram(String visibleInDiagram) {
        this.visibleInDiagram = visibleInDiagram;
    }

    public List<EmployeeBasic> getEmployeeBasics() {
        return employeeBasics;
    }

    public void setEmployeeBasics(List<EmployeeBasic> employeeBasics) {
        this.employeeBasics = employeeBasics;
    }
}
