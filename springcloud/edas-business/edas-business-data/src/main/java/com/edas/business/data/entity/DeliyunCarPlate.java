package com.edas.business.data.entity;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * 接口-德立云门禁获取车牌
 */
@Data
@ToString
public class DeliyunCarPlate {

	/**
	 * 集团编号 NL
	 */
	public String clique;

	/**
	 * 分公司编号：ibu GS
	 */
	public String dld;
	
	/**
	 * 门禁编号
	 */
	private String controlId;

	/**
	 * 车牌号
	 */
	public String plateNum;

	private Date inTime;

}
