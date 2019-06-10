package com.edas.business.dingtalk.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edas.edascommon.utils.DateUtils;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;

@Component
@Slf4j
//@EnableScheduling
public class UserTask {
	private static final int FOURTEEN_MIN = 1000;

	//@Scheduled(cron = "0/15 * * * * ?")
	//@SchedulerLock(name = "TaskScheduler_scheduledTask", lockAtMostFor = FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
	public void processItem() throws InterruptedException {
		log.warn("@Scheduled service");
		log.info(DateUtils.dateToString() + "\n");
	}

}
