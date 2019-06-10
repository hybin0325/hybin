package com.edas.edasmessage.entity.mq;

import java.io.Serializable;
import java.util.List;

import com.edas.edasmessage.entity.dto.CarOutParkDTO;

import lombok.Data;

@Data
public class CarOutParkMsg implements Serializable {

	private String messageId;

	private List<CarOutParkDTO> message;

}
