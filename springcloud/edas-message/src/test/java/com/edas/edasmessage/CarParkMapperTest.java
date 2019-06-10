package com.edas.edasmessage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edas.edasmessage.dao.CarParkLogMapper;
import com.edas.edasmessage.entity.CarParkLog;
import com.edas.edasmessage.entity.dto.CarOutParkDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarParkMapperTest {

	@Autowired
	private CarParkLogMapper carParkLogMapper;

	 @Test
	 public void saveCarPark() throws Exception {
		List<CarParkLog> list=new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			CarParkLog dto=new CarParkLog();
			 dto.setPlateNum("京"+i);
			 carParkLogMapper.insert(dto);
			 System.out.println("------------"+dto.getId());
		}
		//carParkLogMapper.insertList(list);
	 }
}
