package com.edas.business.qywechat.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * shopwwi_zt_configkey
 * 
 * @author
 */
@Table(name = "shopwwi_zt_configkey")
@Data
@ToString
public class ZtConfigkey implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * 类型 001门店 002钉钉 003微信
	 */
	private String type;

	/**
	 * 应用id
	 */
	private String corpid;

	/**
	 * 应用密钥
	 */
	private String secretKey;

	/**
	 * 应用编号
	 */
	private String applicationId;

	/**
	 * ibu编号
	 */
	private String dld;

	/**
	 * 集团(公司)
	 */
	private String clique;

	/**
	 * 新增人工号
	 */
	private String userId;

	/**
	 * 新增人姓名
	 */
	private String userName;

	/**
	 * 添加时间
	 */
	private LocalDateTime  createDate;

	/**
	 * 修改人工号
	 */
	private String updateUserId;

	/**
	 * 修改人姓名
	 */
	private String updateUserName;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateDate;

	/**
	 * 状态：0有效，1无效
	 */
	private Byte status;

	
}