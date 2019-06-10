package com.edas.business.data.entity;

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
@Table(name = "shopwwi_zt_car_park_clique_map")
@Data
@ToString
public class ZtCarParkCliqueMap implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	/**
	 * 类型 001门店 002钉钉 003微信
	 */
	private String controlId;

	/**
	 * ibu编号
	 */
	private String dld;

	/**
	 * 集团(公司)
	 */
	private String clique;






	
}