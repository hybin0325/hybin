package com.edas.edasmessage.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.edas.edasmessage.task.AsyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncTaskTest {
	@Autowired
	private AsyncTask asyncTask;

	//@Test
	public void test() throws InterruptedException {
		long start = System.currentTimeMillis();
		Future<Boolean> a = asyncTask.task1();
		Future<Boolean> b = asyncTask.task2();
		Future<Boolean> c = asyncTask.task3();

		// 循环到三个任务全部完成
		while (!a.isDone() || !b.isDone() || !c.isDone()) {
			if (a.isDone() && b.isDone() && c.isDone()) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		String result = "任务完成，一共用时为：" + (end - start) + "毫秒";
		System.out.println(result);
		
	}
	
	//@Test
	public void testAsyncReturn() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
 
        Map<String, Object> map = new HashMap<>();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = asyncTask.doReturn(i);
            futures.add(future);
        }
        List<String> response = new ArrayList<>();
        for (Future future : futures) {
            String string = (String) future.get();
            response.add(string);
        }
        map.put("data", response);
        map.put("消耗时间", String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
        System.out.println(map);
	}
	
	
	@Test
	public void testAsyncReturn2() {
		long start = System.currentTimeMillis();
		asyncTask.doNoReturn();
        System.out.println(String.format("任务执行成功,耗时{%s}", System.currentTimeMillis() - start));
	}
}
