package com.edas.business.qywechat.dao.master;



import com.edas.business.qywechat.entity.ZtMesssendlog;
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


	public List<ZtMesssendlog> selectByList(ZtMesssendlog ztMesssendlog);

}