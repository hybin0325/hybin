package net.medcrm.yjb.workflow.mail;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.impl.test.PluggableActivitiTestCase;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.test.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
*@author 原饼
*@version 创建时间2018年2月1日下午3:23:45
**/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private ProcessEngine processEngine;
	
	@Test  
   // @Deployment(resources = "his-activiti-service/processes/mail/mail-process.bpmn")  
    public void test() {  
        //直接开启流程就好了  
       // runtimeService.startProcessInstanceByKey("mail-process");  
		 try{  
		        //流程定义的key  
		        String processDefinitionKey = "test-email";  
		        ProcessInstance pi = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的Service  
		                        .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应helloworld.bpmn文件中id的属性值，使用key值启动，默认是按照最新版本的流程定义启动  
		        System.out.println(pi.getId());
		 }catch(Exception e){  
		            e.printStackTrace();  
		        }  
    }  
}
