package com.edas.edasmessage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edas.edascommon.core.AbstractServices;
import com.edas.edasmessage.dao.MessageConfMapper;
import com.edas.edasmessage.entity.MessageConf;
import com.edas.edasmessage.enums.KeyTypeEnum;
import com.edas.edasmessage.service.MessageConfService;

@Service
public class MessageConfServiceImpl extends AbstractServices<MessageConf> implements MessageConfService {
	@Autowired
	private MessageConfMapper messageConfMapper;

	@Transactional
	@CacheEvict(value = "messageConf", allEntries = true)
	public void saveMessageConf(MessageConf conf) {
		messageConfMapper.insert(conf);
	}

	@Transactional
	@CacheEvict(value = "messageConf", allEntries = true)
	public void updateMessageConf(MessageConf conf) {
		messageConfMapper.updateByPrimaryKeySelective(conf);
	}

	@Transactional
	@CacheEvict(value = "messageConf", allEntries = true)
	public void deleteMessageConf(int id) {
		messageConfMapper.deleteByPrimaryKey(id);
	}

	@Cacheable(value = "messageConf", key = "#typeKey")
	public List<MessageConf> findByType(String typeKey) {
		return messageConfMapper.selectByTypeKey(typeKey);
	}

	@Cacheable(cacheNames = "messageConf.service.all")
	public List<MessageConf> findAll() {
		return messageConfMapper.selectAll();
	}

	@Cacheable(value = "messageConf", key = "#id")
	public MessageConf getMessageConf(int id) {
		MessageConf conf = new MessageConf();
		conf.setId(id);
		return messageConfMapper.selectOne(conf);
	}

	@Cacheable(value = "messageConf", key = "#commKey")
	public MessageConf findByCommKey(String commKey) {

		return messageConfMapper.selectByCommKey(commKey);
	}

	public List<MessageConf> findByList(MessageConf messageConf) {

		return messageConfMapper.selectByList(messageConf);
	}

}
