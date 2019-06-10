package com.edas.edasmessage.entity.mq;

import java.io.Serializable;
import java.util.List;

import com.edas.edasmessage.entity.dto.CarInParkDTO;

import lombok.Data;

@Data
public class CarInParkMsg implements Serializable{
	
	private String messageId;
	
	private List<CarInParkDTO> message;

}
