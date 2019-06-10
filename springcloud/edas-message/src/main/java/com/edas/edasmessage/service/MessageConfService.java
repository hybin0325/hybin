package com.edas.edasmessage.service;

import java.util.List;

import com.edas.edascommon.core.Service;
import com.edas.edasmessage.entity.MessageConf;

public interface MessageConfService extends Service<MessageConf>{

	public void saveMessageConf(MessageConf conf);

	public void updateMessageConf(MessageConf conf);

	public List<MessageConf> findByType(String keyType);
	
	public MessageConf findByCommKey(String commKey);

	public List<MessageConf> findAll();

	public void deleteMessageConf(int id);

	public MessageConf getMessageConf(int id);
	
	public List<MessageConf> findByList(MessageConf conf);
	

}
