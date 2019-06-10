package com.edas.business.dingtalk.service.impl;


import com.edas.business.dingtalk.dao.master.ZtConfigkeyMapper;
import com.edas.business.dingtalk.entity.ZtConfigkey;
import com.edas.business.dingtalk.service.ZtConfigkeyService;
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
public class ZtConfigkeyServiceImpl implements ZtConfigkeyService{
	
	@Autowired
	private ZtConfigkeyMapper ztConfigkeyMapper;
	
	@Transactional
	@CacheEvict(value = "ztConfigkey", allEntries = true)
	public void saveZtConfigkey(ZtConfigkey conf) {
		ztConfigkeyMapper.insert(conf);
	}

	@Transactional
	@CacheEvict(value = "ztConfigkey", allEntries = true)
	public void updateZtConfigkey(ZtConfigkey conf) {
		ztConfigkeyMapper.updateByPrimaryKeySelective(conf);
	}

	@Transactional
	@CacheEvict(value = "ztConfigkey", allEntries = true)
	public void deleteZtConfigkey(int id) {
		ZtConfigkey conf=new  ZtConfigkey();
		conf.setStatus(Constants.DELETE_STATUS);
		conf.setUpdateDate(LocalDateTime.now());
		conf.setId(id);
		ztConfigkeyMapper.DeleteZtConfigkey(conf);
	}
	
	@Transactional
	@CacheEvict(value = "ztConfigkey", allEntries = true)
	public void deleteZtConfigkeyById(int id) {
		ztConfigkeyMapper.deleteByPrimaryKey(id);
		
	}

	@Cacheable(value = "ztConfigkey", key = "#type")
	public ZtConfigkey findByType(String type) {
		return ztConfigkeyMapper.findZtConfigkey(type);
	}

	@Cacheable(value = "ztConfigkey", key = "#type")
	public ZtConfigkey findZtConfigkeyByDld(ZtConfigkey conf) {
		return ztConfigkeyMapper.findZtConfigkeyByDld(conf);
	}

	@Cacheable(cacheNames = "ztConfigkey.service.all")
	public List<ZtConfigkey> findAll() {
		return ztConfigkeyMapper.selectAll();
	}

	@Cacheable(value = "ztConfigkey", key = "#id")
	public ZtConfigkey getZtConfigkey(int id) {
		ZtConfigkey conf = new ZtConfigkey();
		conf.setId(id);
		return ztConfigkeyMapper.selectOne(conf);
	}

	@Cacheable(value = "ztConfigkey", key = "#secretKey")
	public ZtConfigkey findBySecretKey(String secretKey) {

		return ztConfigkeyMapper.selectBySecretKey(secretKey);
	}

	
	public List<ZtConfigkey> findByList(ZtConfigkey conf) {
		return ztConfigkeyMapper.selectByList(conf);
	}

	

}
