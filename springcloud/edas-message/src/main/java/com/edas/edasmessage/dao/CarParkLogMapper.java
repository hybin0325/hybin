package com.edas.edasmessage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edas.edascommon.core.BaseCrudMapper;
import com.edas.edasmessage.entity.CarParkLog;
import com.edas.edasmessage.entity.dto.CarParkLogDTO;


public interface CarParkLogMapper extends BaseCrudMapper<CarParkLog>{
	
	//@Select("select * from permission where permission_code in (select permission_code from role_permission where role_code = #{roleCode})")
    //Set<CarParkLog> getRolePermissions(String roleCode);
	
	List<CarParkLog> findCarParkLog(CarParkLogDTO carParkLogDTO);

}
