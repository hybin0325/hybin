package com.edas.edasusers.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.edas.edascommon.model.SnowflakeIdWorker;
import com.edas.edasusers.entity.CarParkLog;
import com.edas.edasusers.entity.CarParkReq;
import com.edas.edasusers.feign.MsgFeign;
import com.edas.edasusers.utils.RandomString;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncService {

	@Autowired
	private MsgFeign msgFeign;

	@Async
	public AsyncResult<String> asyncMethodWithResult() {
		// do something（可能发生异常）

		return new AsyncResult("hello");
	}

	@Async
	public void getLongId(int a, HashSet<Long> set) {
		SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
		for (int i = 0; i < 100; i++) {

			long id = idWorker.nextId();
			set.add(id);
			System.out.println("a:" + a + " i: " + i + " " + id);
		}
		System.out.println("set: " + set.size());
	}

	public void getLongId2(int a, HashSet<Long> set, SnowflakeIdWorker idWorker) {

		for (int i = 0; i < 100; i++) {

			long id = idWorker.nextId();
			set.add(id);

			log.info("a:" + a + " i: " + i + " " + id);
		}

		log.info("set: " + set.size());
	}

	
	public void sendPark() {
		CarParkReq req = new CarParkReq();
		List<CarParkLog> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			CarParkLog pl = new CarParkLog();
			pl.setPlateNum(RandomString.generateCarID());
			pl.setInTime(new Date());
			list.add(pl);
		}
		log.info("list: " + list);
		req.setData(list);

		msgFeign.addCarInPark(req);
	}
	

	
	public void sendPark2() {
		CarParkReq req = new CarParkReq();
		List<CarParkLog> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			CarParkLog pl = new CarParkLog();
			pl.setPlateNum(RandomString.generateCarID());
			pl.setInTime(new Date());
			list.add(pl);
		}
		log.info("list: " + list);
		req.setData(list);

		msgFeign.addCarInPark(req);
	}

}
