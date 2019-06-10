package com.edas.edasusers.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.edas.edascommon.core.AbstractServices;
import com.edas.edasusers.dao.master.ShopwwiRylistMapper;
import com.edas.edasusers.entity.ShopwwiRylist;
import com.edas.edasusers.service.ShopwwiRylistService;

/**
 * @Description: ShopwwiRylistService接口实现类
 * @author zwx
 * @date 2019/01/25 16:07
 */
@Service
public class ShopwwiRylistServiceImpl extends AbstractServices<ShopwwiRylist> implements ShopwwiRylistService {

    @Resource
    private ShopwwiRylistMapper shopwwiRylistMapper;
    
    public ShopwwiRylist findById(int id) { 
    	return  shopwwiRylistMapper.findById(id);
    }

}