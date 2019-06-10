package com.edas.edasmessage.service;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edas.edascommon.utils.DateUtils;
import com.edas.edasmessage.entity.CarParkLog;
import com.edas.edasmessage.entity.req.CarInParkDataReq;
import com.edas.edasmessage.redis.BloomFilter;
import com.edas.edasmessage.service.impl.DeliyunServiceImpl;
import com.edas.edasmessage.task.AsyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeliyunServiceTest {
	
	@Autowired
	private DeliyunServiceImpl deliyunService;
	
	@Autowired
	private	BloomFilter<CarParkLog> bloomFilter;
	
	@Autowired
    private AsyncTask asyncTask;
	
	@Test
	public void  findParkInLogTest() {
		long start = System.currentTimeMillis();
		String timestamp = DateUtils.dateToLong("2019-04-3 09:20") + "";
		CarInParkDataReq cdata = new CarInParkDataReq();
		cdata.setPage(1);
		cdata.setSize(100);
		Long currentTime = System.currentTimeMillis();
		cdata.setInTimeStart(DateUtils.getAgoMinutes30(currentTime) / 1000);
		cdata.setInTimeEnd(currentTime / 1000);
		deliyunService.findParkInLog(cdata, timestamp);
		long end = System.currentTimeMillis();
		String result = "任务完成，一共用时为：" + (end - start) + "毫秒";
		System.out.println(result);
	}
	
	//@Test
	public void  findParkInLogTest2() throws InterruptedException {
		long start = System.currentTimeMillis();
		String timestamp = DateUtils.dateToLong("2019-04-3 09:20") + "";
		CarInParkDataReq cdata = new CarInParkDataReq();
		cdata.setPage(1);
		cdata.setSize(100);
		Long currentTime = System.currentTimeMillis();
		cdata.setInTimeStart(DateUtils.getAgoMinutes30(currentTime) / 1000);
		cdata.setInTimeEnd(currentTime / 1000);
		Future<Boolean> k=asyncTask.task4(cdata, timestamp);
		long end = System.currentTimeMillis();
		String result = "任务完成，一共用时为：" + (end - start) + "毫秒";
		System.out.println(result);
	}
	
	//@Test
    public void getTest() {
    	CarParkLog c= new CarParkLog();
    	c.setIden("OZprxCSnOpud4lMGbiP");
    	c.setPlateNum("粤GVG981");
    	c.setChannelId(6473L);
    	c.setControlId(36621L);
    	c.setRealName("值班员");
    	c.setCarTypeId(1l);
    	c.setCarType("小型车");
    	c.setCardTypeId(4);
    	c.setCardType("临时车1");
    	c.setInTime(DateUtils.parseDate("2019-04-08 15:45:45"));
    	c.setChannelName("入口通道");
    	c.setInPhoto("http://imgl.deliyun.cn/?host=10.8.5.144&url=/c/190408/OZprxCSnOpud4lMGbiP.jpg");
    	
    	boolean isExist = bloomFilter.contains(c);
		if (isExist) {
			System.out.println(isExist + " bloomFilter有值---------------------");
		} else {
			bloomFilter.add(c);
			System.out.println(isExist + " bloomFilter成功-----------------------");
		}
    }
	
	
}
