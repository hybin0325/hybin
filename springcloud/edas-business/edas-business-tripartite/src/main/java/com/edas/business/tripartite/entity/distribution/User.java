package com.edas.business.tripartite.entity.distribution;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * Description: 用户实体
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_distribution_user")
@Data
@ToString
@ApiModel(description = "用户实体")
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    private String loginName;

    private String userPwd;

    private String webSiteId;

    private Integer userId;

    private String token;
}