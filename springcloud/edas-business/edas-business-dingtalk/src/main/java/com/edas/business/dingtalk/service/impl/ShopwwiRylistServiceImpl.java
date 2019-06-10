package com.edas.business.dingtalk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edas.business.dingtalk.core.AbstractServices;
import com.edas.business.dingtalk.dao.master.ShopwwiRylistMapper;
import com.edas.business.dingtalk.entity.ShopwwiRylist;
import com.edas.business.dingtalk.service.ShopwwiRylistService;

/**
 * @Description: ShopwwiRylistService接口实现类
 * @author zwx
 * @date 2019/01/25 16:07
 */
@Service
public class ShopwwiRylistServiceImpl extends AbstractServices<ShopwwiRylist> implements ShopwwiRylistService {

	@Resource
	private ShopwwiRylistMapper shopwwiRylistMapper;

}