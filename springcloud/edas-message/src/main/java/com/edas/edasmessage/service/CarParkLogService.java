package com.edas.edasmessage.service;

import java.util.List;

import com.edas.edascommon.core.Service;
import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edasmessage.entity.CarParkLog;
import com.edas.edasmessage.entity.User;
import com.edas.edasmessage.entity.dto.CarInParkDTO;
import com.edas.edasmessage.entity.dto.CarOutParkDTO;
import com.edas.edasmessage.entity.dto.CarParkLogDTO;

public interface CarParkLogService extends Service<CarParkLog> {

	public User getUserInfo();


	/**
	 * 业务数据
	 * 
	 * @param msg
	 * @throws Exception
	 */
	public void saveDataMsg(MQDataMsg message) throws Exception;

	/**
	 * 车进场、出场消息推送 去重保存DB、发送到队列
	 */
	public void saveCarParkLos(List<CarParkLog> list,SnowflakeIdWorker idWorker);
	
	public void saveCarParkLos(List<CarParkLog> list,String commKey);
	
	public void saveCarParkLos(List<CarParkLog> list,String commKey,SnowflakeIdWorker idWorkers);
	

	/**
	 * 
	 * @Title: findCarParkLog @Description: 查询分页 @param @param
	 * carParkLogDTO @param @return 参数 @return List<CarParkLog> 返回类型 @throws
	 */
	List<CarParkLog> findCarParkLog(CarParkLogDTO carParkLogDTO);

}
