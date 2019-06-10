package com.edas.edasmessage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.edas.edascommon.core.BaseCrudMapper;
import com.edas.edasmessage.entity.MessageConf;

/**
 * ShopwwiMessageConfDAO继承基类
 */
public interface MessageConfMapper extends BaseCrudMapper<MessageConf> {
	
	List<MessageConf> selectByTypeKey(@Param("typeKey") String typeKey);

	MessageConf selectByCommKey(@Param("commKey") String commKey);

	List<MessageConf> selectByList(MessageConf messageConf);

}