package com.edas.edasusers.task;

import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edascommon.utils.DateUtils;
import com.edas.edasusers.service.impl.AsyncService;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;

@Component
@Slf4j
@EnableScheduling
public class UserTask {
	@Autowired
	private AsyncService asyncService;
	private static final int FOURTEEN_MIN = 1000;

	//@Scheduled(cron = "0/6 * 8-21 * * ? ")
	@SchedulerLock(name = "taskScheduler_carParkInLogs", lockAtMostFor = FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
	public void processItem() throws InterruptedException {
		log.warn("@Scheduled service");
		log.info(DateUtils.dateToString() + "\n");
		HashSet<Long> set=new HashSet<>();
		getFixedThreadPool(50,set);
		log.info("set总数："+set.size());
	}
	
	@Async
	//@Scheduled(cron = "0/15 * 8-21 * * ? ")
	@SchedulerLock(name = "taskScheduler_sendPark", lockAtMostFor = FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
	public void sendPark() throws InterruptedException {
		
		log.info(DateUtils.dateToString() + "\n");
		asyncService.sendPark();
	}
	
	@Async
	//@Scheduled(cron = "0/6 * 8-21 * * ? ")
	@SchedulerLock(name = "taskScheduler_sendPark2", lockAtMostFor = FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
	public void sendPark2() throws InterruptedException {
		
		log.info(DateUtils.dateToString() + "\n");
		asyncService.sendPark();
	}
	
	@SneakyThrows
	public void getFixedThreadPool(int temp ,HashSet<Long> set) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
		for (int i=0;i<temp;i++) {
			final int mc = i;
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					asyncService.getLongId2(mc, set,idWorker);
				}
			});
		}
		fixedThreadPool.shutdown();

	}


}
