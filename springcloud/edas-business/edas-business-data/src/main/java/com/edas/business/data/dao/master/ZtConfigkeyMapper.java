package com.edas.business.data.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.edas.business.data.entity.ZtConfigkey;
import com.edas.edascommon.core.BaseCrudMapper;

/**
 * ZtConfigkeyMapper继承基类
 */
@Repository
public interface ZtConfigkeyMapper extends BaseCrudMapper<ZtConfigkey> {

	@Select("select * from shopwwi_zt_configkey where type=#{type}")
	public List<ZtConfigkey> findZtConfigkey(String type);

	@Select("select * from shopwwi_zt_configkey where secret_key=#{secretKey}")
	public ZtConfigkey selectBySecretKey(String secretKey);

	@Update({
			"update shopwwi_zt_configkey set status = #{status},update_user_id = #{updateUserId},update_user_name = #{updateUserName},update_date = #{updateDate, jdbcType=TIMESTAMP} where id = #{id}" })
	public int DeleteZtConfigkey(ZtConfigkey ztConfigkey);
	
	
	public List<ZtConfigkey> selectByList(ZtConfigkey ztConfigkey);

}