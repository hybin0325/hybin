package com.edas.business.data.dao.master;

import com.edas.business.data.entity.ShopwwiCxxm;
import com.edas.edascommon.core.BaseCrudMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ShopwwiCxxmMapper extends BaseCrudMapper<ShopwwiCxxm> {
    @Select("select * from shopwwi_cxxm where tbname=#{tbname}")
    public List<ShopwwiCxxm> findCxxmBytbname(ShopwwiCxxm tbname);
}
