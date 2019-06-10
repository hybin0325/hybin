package com.edas.business.byrobot.entity;

import lombok.Data;

/**
 * <p>
 * File Name: MessageConfDTO.java
 * </p>
 * <p>
 * Description: MessageConfDTO
 * </p>
 * <p>
 * Date：2019年5月9日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Data
public class MessageConfDTO {
	private Integer id;

	/**
	 * 类型 001门店 002钉钉 003微信
	 */
	private String typeKey;

	/**
	 * 值
	 */
	private String commKey;

	/**
	 * 所属门店
	 */
	private String dld;

	/**
	 * 所属集团
	 */
	private String clique;
}
