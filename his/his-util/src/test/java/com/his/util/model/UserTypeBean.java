package com.his.util.model;

import java.util.List;

import net.medcrm.yjb.his.excelutil.model.BaseModel;
import net.medcrm.yjb.his.excelutil.persistence.FieldNote;


public class UserTypeBean extends BaseModel implements java.io.Serializable{
    

    private static final long serialVersionUID = -5217032731630006972L;
    
    @FieldNote(logicalName = "姓名",physicalName = "fullName",notNull = true)
    private String fullName;
    
    @FieldNote(logicalName = "帐号",physicalName = "accountName",notNull = true)
    private String accountName;
    
    @FieldNote(logicalName = "机构",physicalName = "tvTypeName",notNull = true)
    private String tvTypeName;
    
    @FieldNote(logicalName = "部门",physicalName = "tvTypeAbridgeName",notNull = true)
    private String tvTypeAbridgeName;
    
    @FieldNote(logicalName = "性别",physicalName = "sex")
    private String sex;
    
    @FieldNote(logicalName = "手机1",physicalName = "phone1")
    private String phone1;
    
    @FieldNote(logicalName = "手机2",physicalName = "phone2")
    private String phone2;
    
    @FieldNote(logicalName = "座机",physicalName = "tel")
    private String tel;
    
    @FieldNote(logicalName = "微信",physicalName = "wechat")
    private String wechat;
    
    @FieldNote(logicalName = "党员",physicalName = "partyMember")
    private String partyMember;
    
    @FieldNote(logicalName = "邮箱",physicalName = "email")
    private String email;
    
    @FieldNote(logicalName = "职位",physicalName = "jobTitleName")
    private String jobTitleName;
    
    //@FieldNote(logicalName = "排序字段",physicalName = "orderBy")
    //private String orderBy;

    @Override
    public List<Object> check(BaseModel model, List<Object> valueList){
        valueList = super.check(model,valueList);
        valueList.add("fullName");
       return valueList;
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTvTypeName() {
		return tvTypeName;
	}

	public void setTvTypeName(String tvTypeName) {
		this.tvTypeName = tvTypeName;
	}

	public String getTvTypeAbridgeName() {
		return tvTypeAbridgeName;
	}

	public void setTvTypeAbridgeName(String tvTypeAbridgeName) {
		this.tvTypeAbridgeName = tvTypeAbridgeName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getPartyMember() {
		return partyMember;
	}

	public void setPartyMember(String partyMember) {
		this.partyMember = partyMember;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitleName() {
		return jobTitleName;
	}

	public void setJobTitleName(String jobTitleName) {
		this.jobTitleName = jobTitleName;
	}
   
}