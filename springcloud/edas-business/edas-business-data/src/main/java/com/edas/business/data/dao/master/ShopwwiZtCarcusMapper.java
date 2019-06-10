package com.edas.business.data.dao.master;

import com.edas.business.data.entity.ShopwwiZtCarcus;
import com.edas.edascommon.core.BaseCrudMapper;
import org.apache.ibatis.annotations.Select;

public interface ShopwwiZtCarcusMapper extends BaseCrudMapper<ShopwwiZtCarcus> {
    @Select("select * from shopwwi_zt_carcus where license=#{license}")
    public ShopwwiZtCarcus findZtCarcusBylicense(ShopwwiZtCarcus license);
}