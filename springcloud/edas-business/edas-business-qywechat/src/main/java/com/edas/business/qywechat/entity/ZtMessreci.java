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
@Table(name = "shopwwi_zt_messreci")
@Data
@ToString
public class ZtMessreci implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * 消息模板id(来自消息模板 messtemp 表)
	 */

	private Integer messtempId;

	/**
	 * 消息接收人(用逗号隔开)
	 */
	private String messRec;

	/**
	 * 指定接收部门(用逗号隔开)
	 */
	private String messDep;

	/**
	 * 指定接收角色(用逗号隔开)
	 */
	private String messRol;

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
	private String userid;

	/**
	 * 新增人姓名
	 */
	private String username;

	/**
	 * 添加时间
	 */
	private LocalDateTime  addDate;

	/**
	 * 修改人工号
	 */
	private String useridUp;

	/**
	 * 修改人姓名
	 */
	private String usernameUp;

	/**
	 * 修改时间
	 */
	private LocalDateTime updDate;

	
}