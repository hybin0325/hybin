package com.edas.edasusers.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CarParkReq implements Serializable {
	private String unitKey ;
	private List<CarParkLog>  data;
}
