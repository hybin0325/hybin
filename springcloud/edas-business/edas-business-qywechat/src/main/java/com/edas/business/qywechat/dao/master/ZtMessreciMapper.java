package com.edas.business.qywechat.dao.master;


import com.edas.business.qywechat.entity.ZtMessreci;
import com.edas.edascommon.core.BaseCrudMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ZtMessreciMapper继承基类
 */
@Repository
public interface ZtMessreciMapper extends BaseCrudMapper<ZtMessreci> {

	@Select("select * from shopwwi_zt_messreci where messtemp_id=#{messtempId} and status = 0")
	public ZtMessreci findZtMessreci(String messtemp_id);

//	@Select("select * from shopwwi_zt_messreci where messtemp_id=#{messtempId} and dld='GS'")
//	public ZtMessreci findZtMessreciByDld(Integer messtempId);
	@Select("select messtemp_id,dld,mess_rec,mess_dep,mess_rol from shopwwi_zt_messreci where messtemp_id=#{messtempId} and dld=#{dld}")
	public ZtMessreci findZtMessreciByDld(ZtMessreci ZtMessreci);

	public List<ZtMessreci> selectByList(ZtMessreci ZtMessreci);

}