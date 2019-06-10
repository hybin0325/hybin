package com.edas.business.dingtalk.dao.master;

import com.edas.business.dingtalk.entity.ZtMesstemp;
import com.edas.edascommon.core.BaseCrudMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ZtMesstempMapper extends BaseCrudMapper<ZtMesstemp> {
    @Select(" select tem_num temNum,tem_type temType,tem_name temName,chan_temp chanTemp,dld,clique,mess_con messCon,type_message typeMessage from shopwwi_zt_messtemp where tem_type='门禁通知' and status='1'")
    List<ZtMesstemp> findByStatus() ;
}
