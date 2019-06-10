package com.edas.business.data.dao.master;

import com.edas.business.data.entity.ShopwwiZtMesstemp;
import com.edas.edascommon.core.BaseCrudMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopwwiZtMesstempMapper extends BaseCrudMapper<ShopwwiZtMesstemp> {
    @Select(" select id,tem_num temNum,tem_type temType,tem_name temName,chan_temp chanTemp,dld,clique,mess_con messCon,type_message typeMessage from shopwwi_zt_messtemp where tem_type='门禁通知'  and status='1'")
    List<ShopwwiZtMesstemp> findByStatus() ;
    @Select(" select id,tem_num temNum,tem_type temType,tem_name temName,chan_temp chanTemp,dld,clique,mess_con messCon,type_message typeMessage,tiaozhuan_url tiaozhuanUrl  from shopwwi_zt_messtemp where tem_type='门禁通知'  and status='1' and dld=#{dld}")
    List<ShopwwiZtMesstemp> findByStatusAndDld(String dld) ;
}
