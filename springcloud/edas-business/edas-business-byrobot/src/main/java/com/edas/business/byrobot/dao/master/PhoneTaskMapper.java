package com.edas.business.byrobot.dao.master;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.edas.business.byrobot.entity.PhoneTask;
import com.edas.edascommon.core.BaseCrudMapper;

/**
 * <p>
 * File Name: PhoneTaskMapper.java
 * </p>
 * <p>
 * Description: 任务mapper
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface PhoneTaskMapper extends BaseCrudMapper<PhoneTask>{
	
	/**
	 * 修改
	 * @param companyId
	 * @param taskId
	 * @param status
	 * @return
	 */
	@Update("update shopwwi_zt_ai_baiying_task set status=#{status} where company_id=#{companyId} and task_id=#{taskId}")
	public int changeTaskStatus(@Param("companyId") Integer companyId, @Param("taskId") Integer taskId, @Param("status") Integer status);
}