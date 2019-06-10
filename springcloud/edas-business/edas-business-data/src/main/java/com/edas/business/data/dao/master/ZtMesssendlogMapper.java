package com.edas.business.data.dao.master;


import com.edas.business.data.entity.ZtMesssendlog;
import com.edas.edascommon.core.BaseCrudMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ZtConfigkeyMapper继承基类
 */
@Repository
public interface ZtMesssendlogMapper extends BaseCrudMapper<ZtMesssendlog> {

	@Select("select * from shopwwi_zt_messsendlog where push_chan=#{pushChan}")
	public List<ZtMesssendlog> findZtMesssendlog(String pushChan);

	@Select("select * from shopwwi_zt_messsendlog where mess_class=#{messClass}")
	public ZtMesssendlog selectByMessClass(String messClass);

	@Update({
			"update shopwwi_zt_messsendlog set is_read = #{isRead},userid_up = #{useridUp},username_up = #{usernameUp},upd_date = #{updDate, jdbcType=TIMESTAMP} where id = #{id}" })
	public int DeleteZtMesssendlog(ZtMesssendlog ztMesssendlog);
	
	
	public List<ZtMesssendlog> selectByList(ZtMesssendlog ztMesssendlog);

}