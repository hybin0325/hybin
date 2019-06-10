package com.edas.business.qywechat.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "shopwwi_zt_wechatcorpid")
@Data
public class ZtWechatcorpid {
	@Id
	private String userid;
	private String username;
	private Integer id;
	private String corpid;
	private String corpsecret;
	@Column(name = "application_id")
	private String applicationId;
	private String dld;
	private String clique;
	@Column(name = "add_date")
	private String addDate;
	@Column(name = "userid_up")
	private String useridUp;
	@Column(name = "username_up")
	private String usernameUp;
	@Column(name = "upd_date")
	private Date updDate;
	private Integer status;
}
