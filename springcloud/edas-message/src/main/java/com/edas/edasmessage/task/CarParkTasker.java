package com.edas.edasmessage.task;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edas.edascommon.constants.Constants;
import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edasmessage.entity.MessageConf;
import com.edas.edasmessage.enums.KeyTypeEnum;
import com.edas.edasmessage.service.DeliyunService;
import com.edas.edasmessage.service.MessageConfService;
import com.edas.edasmessage.utils.CarParkUtils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@EnableScheduling
public class CarParkTasker {
	private static final int FOURTEEN_MIN = 2000;

	@Autowired
	private DeliyunService deliyunService;

	@Autowired
	private MessageConfService messageConfService;

	/**
	 * 车辆出场定时器
	 */
	@Scheduled(cron = "0/10 * 8-21 * * ? ")
	@Async
	// @SchedulerLock(name = "taskScheduler_carParkOutLogs", lockAtMostFor =
	// FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
	public void getCarParkOutLogs() {
		log.info("----------------CarParkOutLogs 定时任务 ----------------");
		List<MessageConf> list = messageConfService.findByType(KeyTypeEnum.DLD.getIndex());
		SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIdWorkerInstance();
		log.info("list:" + list.size() + "  " + list);
		for (MessageConf messageConf : list) {
			log.info("messageConf:  " + messageConf);
			deliyunService.findParkOutLog(CarParkUtils.getCarOutParkDataReq(), messageConf.getCommKey(), idWorker);
		}
	}

	/**
	 * 车辆进场 每天8点到21点 每1秒定时取数据
	 */
	@Scheduled(cron = "0/6 * 8-21 * * ? ")
	// @Async
	// @SchedulerLock(name = "taskScheduler_carParkInLogs", lockAtMostFor =
	// FOURTEEN_MIN, lockAtLeastFor = FOURTEEN_MIN)
	public void getCarParkInLogs() {
		log.info("---------------- CarParkInLogs 定时任务 ----------------");
		List<MessageConf> list = messageConfService.findByType(KeyTypeEnum.DLD.getIndex());
		log.info("list:" + list.size() + "  " + list);
		if (list != null && list.size() > 0) {
			// for (MessageConf messageConf : list) {
			// deliyunService.findParkInLog(CarParkUtils.getCarInParkDataReq(),
			// messageConf.getCommKey());
			// }
			getFixedThreadPool(list, Constants.CAR_IN_PARK);
		}
	}

	public void getSingleThreadExecutor(List<MessageConf> list) {
		final CountDownLatch cdl = new CountDownLatch(list.size());
		long starttime = System.currentTimeMillis();
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for (MessageConf messageConf : list) {
			final MessageConf mc = messageConf;
			singleThreadExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						log.info("messageConf:" + mc);
						deliyunService.findParkInLog(CarParkUtils.getCarInParkDataReq(), mc.getCommKey());
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		try {
			cdl.await();
			long spendtime = System.currentTimeMillis() - starttime;
			log.info(list.size() + "个线程花费时间:" + spendtime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 多线程池
	 * 
	 */
	@SneakyThrows
	public void getFixedThreadPool(List<MessageConf> list, String typeMethod) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
		SnowflakeIdWorker idWorker = SnowflakeIdWorker.getIdWorkerInstance();
		for (MessageConf messageConf : list) {
			final MessageConf mc = messageConf;
			fixedThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					log.info("messageConf:" + mc);
					if (typeMethod.equals(Constants.CAR_IN_PARK)) {
						deliyunService.findParkInLog(CarParkUtils.getCarInParkDataReq(), mc.getCommKey(), idWorker);
					}
				}
			});
		}
		fixedThreadPool.shutdown();

	}

}
