package com.edas.edasmessage.entity.req;

import java.io.Serializable;
import java.util.List;

import com.edas.edasmessage.entity.CarParkLog;

import lombok.Data;

@Data
public class CarParkReq implements Serializable {
	
	private String unitKey ;
	private List<CarParkLog>  data;

}
