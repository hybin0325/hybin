package com.edas.business.dingtalk.dao.master;


import com.edas.business.dingtalk.entity.ZtCarcus;
import com.edas.edascommon.core.BaseCrudMapper;
import org.apache.ibatis.annotations.Select;

public interface ZtCarcusMapper extends BaseCrudMapper<ZtCarcus> {
    @Select("select * from shopwwi_zt_carcus where license=#{license}")
    public ZtCarcus findZtCarcusBylicense(ZtCarcus license);
}
