package com.edas.business.byrobot.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * <p>
 * File Name: ZtConfigkeyDTO.java
 * </p>
 * <p>
 * Description: ZtConfigkeyDTO
 * </p>
 * <p>
 * Date：2019年5月9日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Data
public class ZtConfigkeyDTO {
	
	private Integer id;

	/**
	 * 类型 001门店 002钉钉 003微信 004百应
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