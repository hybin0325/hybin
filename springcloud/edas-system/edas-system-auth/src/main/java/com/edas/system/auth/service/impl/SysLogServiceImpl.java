package com.edas.system.auth.service.impl;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.edas.system.auth.dao.SysLogsMapper;
import com.edas.system.auth.entity.SysLogs;
import com.edas.system.auth.entity.SysUser;
import com.edas.system.auth.service.SysLogService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogsMapper sysLogsDao;

	/**
	 * 2018.05.12将该方法改为异步,用户由调用者设置
	 *
	 * @param sysLogs
	 * @see com.boot.security.server.advice.LogAdvice
	 */
	@Async
	@Override
	public void save(SysLogs sysLogs) {
//		SysUser user = UserUtil.getLoginUser();
		log.info("sysLogs {} "+sysLogs);
		if (sysLogs == null || sysLogs.getUser() == null ) {
			return;
		}

//		sysLogs.setUser(user);
		sysLogsDao.save(sysLogs);
	}

	@Async
	@Override
	public void save(Long userId, String module, Boolean flag, String remark) {
		SysLogs sysLogs = new SysLogs();
		sysLogs.setFlag(flag);
		sysLogs.setModule(module);
		sysLogs.setRemark(remark);

		SysUser user = new SysUser();
		user.setId(userId);
		sysLogs.setUser(user);

		sysLogsDao.save(sysLogs);

	}

	@Override
	public void deleteLogs() {
		Date date = DateUtils.addMonths(new Date(), -3);
		String time = DateFormatUtils.format(date, DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.getPattern());

		int n = sysLogsDao.deleteLogs(time);
		log.info("删除{}之前日志{}条", time, n);
	}
}
