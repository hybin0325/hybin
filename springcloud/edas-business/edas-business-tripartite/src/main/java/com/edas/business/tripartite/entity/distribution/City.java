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
 * Description: 城市实体
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_distribution_city")
@Data
@ToString
@ApiModel(description = "城市实体")
public class City implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer id;

    private Integer cityId;

    private String cityName;

    private String name;

    private String carNumberPrefix;

    private Integer carCodeLen;

    private Integer carEngineLen;
               
}