package com.edas.business.qywechat.service.impl;


import com.edas.business.qywechat.dao.master.ZtMessreciMapper;
import com.edas.business.qywechat.entity.ZtMessreci;
import com.edas.business.qywechat.service.ZtMessreciService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 
* @ClassName: ZtMessreciServiceImpl
* @Description: 秘钥配置
* @author nl
* @date 2019年4月19日
*
 */
@Slf4j
@Service
public class ZtMessreciServiceImpl implements ZtMessreciService{
	
	@Autowired
	private ZtMessreciMapper ZtMessreciMapper;
	
	@Transactional
	@CacheEvict(value = "ZtMessreci", allEntries = true)
	public void saveZtMessreci(ZtMessreci conf) {
		ZtMessreciMapper.insert(conf);
	}

	@Transactional
	@CacheEvict(value = "ZtMessreci", allEntries = true)
	public void updateZtMessreci(ZtMessreci conf) {
		ZtMessreciMapper.updateByPrimaryKeySelective(conf);
	}


	
	@Transactional
	@CacheEvict(value = "ZtMessreci", allEntries = true)
	public void deleteZtMessreciById(int id) {
		ZtMessreciMapper.deleteByPrimaryKey(id);
		
	}

	@Cacheable(value = "ZtMessreci", key = "#type")
	public ZtMessreci findByType(String type) {
		return ZtMessreciMapper.findZtMessreci(type);
	}

//	@Cacheable(value = "ZtMessreci", key = "#type")
	public ZtMessreci findZtMessreciByDld(ZtMessreci conf) {
		log.info("dd"+conf);
		return ZtMessreciMapper.findZtMessreciByDld(conf);
	}
//	public ZtMessreci findZtMessreciByDld(Integer conf) {
//		return ZtMessreciMapper.findZtMessreciByDld(conf);
//	}

	@Cacheable(cacheNames = "ZtMessreci.service.all")
	public List<ZtMessreci> findAll() {
		return ZtMessreciMapper.selectAll();
	}

	@Cacheable(value = "ZtMessreci", key = "#id")
	public ZtMessreci getZtMessreci(int id) {
		ZtMessreci conf = new ZtMessreci();
		conf.setId(id);
		return ZtMessreciMapper.selectOne(conf);
	}


	
	public List<ZtMessreci> findByList(ZtMessreci conf) {
		return ZtMessreciMapper.selectByList(conf);
	}

	

}
