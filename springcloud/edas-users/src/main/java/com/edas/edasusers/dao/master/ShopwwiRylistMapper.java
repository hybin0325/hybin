package com.edas.edasusers.dao.master;

import org.apache.ibatis.annotations.Select;

import com.edas.edascommon.core.BaseCrudMapper;
import com.edas.edasusers.entity.ShopwwiRylist;

public interface ShopwwiRylistMapper extends BaseCrudMapper<ShopwwiRylist> {

	@Select("select * from shopwwi_rylist where id=#{id}")
	public ShopwwiRylist findById(int id);
}
