package com.edas.business.tripartite.entity.robot;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * File Name: CustomerDTO.java
 * </p>
 * <p>
 * Description: 客户信息
 * </p>
 * <p>
 * Date：2019年5月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@SuppressWarnings("serial")
@Data
@ToString
public class CustomerDTO implements Serializable{
	
	@ApiModelProperty(notes = "公司id", example = "66", required = true)
	private Integer companyId;
	
	@ApiModelProperty(notes = "任务id", example = "5888", required = true)
	private Integer taskId;
	
	@ApiModelProperty(notes = "客户列表", required = true, dataType="Customer")
	private List<Customer> customerInfoList;
	
	/**
     * 是否强制转移客户 1：是 0：否（默认1）
     */
	@ApiModelProperty(notes = "否强制转移客户", example = "1", required = true)
    private Integer forceTransferCustomer;
	
}
