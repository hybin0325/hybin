package com.edas.business.byrobot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.edas.business.byrobot.entity.CallRule;
import com.edas.business.byrobot.entity.PhoneTask;
import com.edas.business.byrobot.service.PhoneTaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EdasBusinessByrobotApplication.class)
public class PhoneTaskServiceTest {
	
	@Autowired
	private PhoneTaskService phoneTaskService;

	 @Test
	 public void addTask() throws Exception {
		//创建任务参数
		 PhoneTask phoneTask = new PhoneTask();
		//默认参数 fasle
		 phoneTask.setRepeatCall(false);
		 
		 phoneTask.setCompanyId(16443);
		 phoneTask.setTaskName("test02");
		 phoneTask.setTaskType(2);
		 List<Integer> userPhoneIds = new ArrayList<>();
		 userPhoneIds.add(49232);
		 phoneTask.setCallType(2);
		 phoneTask.setConcurrencyQuota(1);
		 phoneTask.setStartDate("2019-06-07");
		 phoneTask.setWorkingStartTime("09:50");
		 phoneTask.setWorkingEndTime("19:20");
		 phoneTask.setUserPhoneIds(userPhoneIds);
		 phoneTask.setRobotDefId(72913);
		 phoneTask.setSceneDefId(72925);
		 phoneTask.setSceneRecordId(72921);
		 phoneTask.setRemark("测试");
		 
		 CallRule rule = new CallRule();
		 rule.setPhoneStatus(10);
		 rule.setInterval(5);
		 rule.setTimes(2);
		 phoneTask.setRepeatCallRule(Arrays.asList(rule));
		 
		 phoneTaskService.savePhoneTask(phoneTask);
		 
	 }
}