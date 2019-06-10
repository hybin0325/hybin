package com.edas.business.data.service.impl;

import com.edas.business.data.dao.master.ZtMesssendlogMapper;
import com.edas.business.data.entity.ZtMesssendlog;
import com.edas.business.data.service.ZtMesssendlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
* @ClassName: ZtMesssendlogServiceImpl
* @Description: 秘钥配置
* @author nl
* @date 2019年4月19日
*
 */
@Slf4j
@Service
public class ZtMesssendlogServiceImpl implements ZtMesssendlogService{
	
	@Autowired
	private ZtMesssendlogMapper ztMesssendlogMapper;
	
	@Transactional
	@CacheEvict(value = "ztMesssendlog", allEntries = true)
	public void saveZtMesssendlog(ZtMesssendlog conf) {
		ztMesssendlogMapper.insert(conf);
	}

	@Transactional
	@CacheEvict(value = "ztMesssendlog", allEntries = true)
	public void updateZtMesssendlog(ZtMesssendlog conf) {
		ztMesssendlogMapper.updateByPrimaryKeySelective(conf);
	}


	@Transactional
	@CacheEvict(value = "ztMesssendlog", allEntries = true)
	public void deleteZtMesssendlogById(int id) {
		ztMesssendlogMapper.deleteByPrimaryKey(id);
		
	}

	@Cacheable(value = "ztMesssendlog", key = "#type")
	public List<ZtMesssendlog> findByType(String type) {
		return ztMesssendlogMapper.findZtMesssendlog(type);
	}

	@Cacheable(cacheNames = "ztMesssendlog.service.all")
	public List<ZtMesssendlog> findAll() {
		return ztMesssendlogMapper.selectAll();
	}

	@Cacheable(value = "ztMesssendlog", key = "#id")
	public ZtMesssendlog getZtMesssendlog(int id) {
		ZtMesssendlog conf = new ZtMesssendlog();
		conf.setId(id);
		return ztMesssendlogMapper.selectOne(conf);
	}

	@Cacheable(value = "ztMesssendlog", key = "#messClass")
	public ZtMesssendlog findBySecretKey(String messClass) {

		return ztMesssendlogMapper.selectByMessClass(messClass);
	}

	
	public List<ZtMesssendlog> findByList(ZtMesssendlog conf) {
		return ztMesssendlogMapper.selectByList(conf);
	}

	

}
