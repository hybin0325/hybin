package com.edas.edasmessage.entity.req;

import java.util.List;

import com.edas.edasmessage.entity.dto.CarOutParkDTO;

import lombok.Data;

@Data
public class CarOutParkReq {
	private String unitKey ;
	private List<CarOutParkDTO>  data;
}
