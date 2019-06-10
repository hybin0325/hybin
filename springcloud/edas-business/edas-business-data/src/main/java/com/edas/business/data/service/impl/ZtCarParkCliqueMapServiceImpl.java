package com.edas.business.data.service.impl;


import com.edas.business.data.dao.master.ZtCarParkCliqueMapMapper;
import com.edas.business.data.entity.ZtCarParkCliqueMap;
import com.edas.business.data.service.ZtCarParkCliqueMapService;
import com.edas.edascommon.constants.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
* @ClassName: ZtConfigkeyServiceImpl
* @Description: 秘钥配置
* @author nl
* @date 2019年4月19日
*
 */
@Slf4j
@Service
public class ZtCarParkCliqueMapServiceImpl implements ZtCarParkCliqueMapService{
	
	@Autowired
	private ZtCarParkCliqueMapMapper ztCarParkCliqueMapMapper;

	@Cacheable(value = "ztCarParkClique", key = "#controlId")
	public ZtCarParkCliqueMap findZtCarparkCliqueMap(String controlId) {
		return ztCarParkCliqueMapMapper.findZtCarparkCliqueMap(controlId);
	}

	public List<ZtCarParkCliqueMap> findZtCarparkCliqueMapAll(String controlId) {
		return ztCarParkCliqueMapMapper.findZtCarparkCliqueMapAll(controlId);
	}



	


}
