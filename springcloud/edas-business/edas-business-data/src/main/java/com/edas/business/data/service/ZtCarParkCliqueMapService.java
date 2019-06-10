package com.edas.business.data.service;

import com.edas.business.data.entity.ZtCarParkCliqueMap;

import java.util.List;

public interface ZtCarParkCliqueMapService {



	/**
	 * 查询
	 */
	public ZtCarParkCliqueMap findZtCarparkCliqueMap(String controlId);
	public List<ZtCarParkCliqueMap> findZtCarparkCliqueMapAll(String controlId);



}
