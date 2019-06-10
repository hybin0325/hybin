package com.edas.system.auth.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.edas.system.auth.entity.SysLogs;

@Mapper
@Repository
public interface SysLogsMapper {

	@Insert("insert into shopwwi_sys_logs(user_id, module, flag, remark, created_time,url) values(#{user.id}, #{module}, #{flag}, #{remark}, now(),#{url})")
	int save(SysLogs sysLogs);

	int count(@Param("params") Map<String, Object> params);

	List<SysLogs> list(@Param("params") Map<String, Object> params, @Param("offset") Integer offset,
			@Param("limit") Integer limit);

	@Delete("delete from shopwwi_sys_logs where created_time <= #{time}")
	int deleteLogs(String time);
}
