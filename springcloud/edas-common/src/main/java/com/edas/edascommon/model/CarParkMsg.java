package com.edas.edascommon.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CarParkMsg implements Serializable{
	
	/**
	 * 车牌号 20
	 */
	@Size(min=0, max=20) 
	private String plateNum;

}
