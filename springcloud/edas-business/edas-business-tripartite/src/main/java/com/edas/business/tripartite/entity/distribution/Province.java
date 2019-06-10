package com.edas.business.tripartite.entity.distribution;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * Description: 省实体
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_distribution_province")
@Data
@ToString
@ApiModel(description = "省实体")
public class Province implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    private Integer provinceId;

    private String provinceName;

    private String provincePrefix;
    
    private List<City> cities;
    
}