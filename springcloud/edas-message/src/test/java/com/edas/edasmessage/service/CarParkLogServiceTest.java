package com.edas.edasmessage.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edas.edasmessage.entity.dto.CarInParkDTO;
import com.edas.edasmessage.entity.dto.CarOutParkDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarParkLogServiceTest {
	
	@Autowired
	private CarParkLogService carParkLogService;

	 @Test
	 public void saveCarPark() throws Exception {
		List<CarOutParkDTO> list=new ArrayList<>();
		for (int i = 0; i < 5000; i++) {
			 CarOutParkDTO dto=new CarOutParkDTO();
			 dto.setPlateNum("京"+i);
		}
		//carParkLogService.saveCarOutParkLos(list);
	 }
}
