package com.edas.edasmessage.entity.req;

import java.util.List;

import com.edas.edasmessage.entity.dto.CarInParkDTO;

import lombok.Data;

@Data
public class CarInParkReq {
	
	private String unitKey ;
	private List<CarInParkDTO>  data;

}
