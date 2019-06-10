package com.edas.edasmessage.task;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.edas.edasmessage.entity.req.CarInParkDataReq;
import com.edas.edasmessage.service.impl.DeliyunServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * 异步调用
 * 
 * @author nl
 *
 */
@Slf4j
@Component
public class AsyncTask {

	@Async // 异步方法注解
	public Future<Boolean> task1() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(1000);
		long end = System.currentTimeMillis();
		System.out.println("=====任务1 耗时：" + (end - start) + "======");
		// 返回true，告诉此任务已完成
		return new AsyncResult<Boolean>(true);
	}

	@Async // 异步方法注解
	public Future<Boolean> task2() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(800);
		long end = System.currentTimeMillis();
		System.out.println("=====任务2 耗时：" + (end - start) + "======");
		// 返回true，告诉此任务已完成
		return new AsyncResult<Boolean>(true);
	}

	@Async // 异步方法注解
	public Future<Boolean> task3() throws InterruptedException {
		long start = System.currentTimeMillis();
		Thread.sleep(600);
		long end = System.currentTimeMillis();
		System.out.println("=====任务3 耗时：" + (end - start) + "======");
		// 返回true，告诉此任务已完成
		return new AsyncResult<Boolean>(true);
	}
	
	
	
	
	@Async // 异步方法注解
	public Future<Boolean> task4(CarInParkDataReq dataReq, String timestamp) throws InterruptedException {
		
		return new AsyncResult<Boolean>(true);
	}
	
	@Async
    public Future<String> doReturn(int i){
        try {
            // 这个方法需要调用500毫秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 消息汇总
        return new AsyncResult<>(String.format("这个是第{%s}个异步调用的证书", i));
    }
	
	@Async
    public void doNoReturn(){
        try {
            // 这个方法执行需要三秒
            Thread.sleep(3000);
            System.out.println("方法执行结束" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

}
