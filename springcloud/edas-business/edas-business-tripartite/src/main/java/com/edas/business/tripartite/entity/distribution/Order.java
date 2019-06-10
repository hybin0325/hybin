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
 * Description: 年审订单实体
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Table(name = "shopwwi_zt_distribution_order")
@Data
@ToString
@ApiModel(description = "年审订单实体")
public class Order implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    private Integer orderId;

    private String webSiteId;

    private String carNumber;

    private String carCode;

    private String engineNumber;

    private String orderAmount;

    private String created;

    private String handle;

    private String proxyName;

    private String orderType;

    private String proxyAddress;

    private String proxyMobile;

    private String userAddress;

    private String userMobile;

    private String userRealName;

    private String memo;

    private String carRegisterDate;

    private Integer state;

    private String carType;

    private String carSeatType;

    private String privateFlag;

    private String idNumber;

    private String userDoorAddress;

    private String userDoorMobile;

    private String userDoorRealName;
}
