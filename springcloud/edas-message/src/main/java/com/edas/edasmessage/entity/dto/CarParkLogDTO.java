package com.edas.edasmessage.entity.dto;

import com.edas.edasmessage.entity.req.BasePageReq;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CarParkLogDTO extends BasePageReq{
	/**
	 * 车牌号
	 */
	private String plateNum;
	
	private String inTimeStart;
	
	private String inTimeEnd;

	private String outTimeStart;
	
	private String outTimeEnd;
	
	private Long controlId;
}
