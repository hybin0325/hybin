package com.edas.edasmessage.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.edas.edascommon.constants.Constants;
import com.edas.edascommon.utils.DateUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrokerMessageLogServiceTest {
	
	@Autowired
	private BrokerMessageLogService brokerMessageLogService;
	
	@Test
    public void update() {
    	Long messageId=312955231409549312L;
    	System.out.println(DateUtils.dateToString());
    	brokerMessageLogService.changeBrokerMessageLogStatus(messageId, Constants.PARK_SEND_SUCCESS);
    	System.out.println(DateUtils.dateToString());
    }

}
