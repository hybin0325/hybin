package com.edas.business.byrobot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edas.business.byrobot.service.CallDetailService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EdasBusinessByrobotApplication.class)
public class CallDetailServiceTest {
	
	@Autowired
    private CallDetailService callDetailService;
  
    @Test
    public void testHandleUnCallBack() throws Exception {
    	
		/*parmsMap.put("companyId", 16443);
		parmsMap.put("dataType", 0);
		
		String startDates = "2019-5-1";
		String endDates = "2019-5-12";
		Date startDate = null;
		Date endDate = null;
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			startDate = sdf.parse(startDates);
			endDate = sdf.parse(endDates);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
	        
		parmsMap.put("startDate", startDate);
		parmsMap.put("endDate", endDate);*/
    	
    	//String canshu = "?companyId=16443&callJobId=545346&dataType=0&startDate=2019-5-1&endDate=2019-5-12";
		
    	callDetailService.handleUnCallBack(null);
    }

}
