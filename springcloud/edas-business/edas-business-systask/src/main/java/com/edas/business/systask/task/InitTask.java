package com.edas.business.systask.task;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.edas.business.systask.entity.Task;
import com.edas.business.systask.service.TaskService;
import com.edas.business.systask.service.impl.CallTaskService;
import com.edas.edascommon.utils.ListUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: InitTask.java
 * </p>
 * <p>
 * Description: 初始化任务
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@Component
@Order(value = 0)
public class InitTask implements CommandLineRunner{
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private CallTaskService callTaskService;
	
    @Override
    public void run(String... args) {        
    	
    	Runnable runnable = new Runnable() {
            @Override
            public void run() {
            	log.info("--------------------启动线程"); 
            	/*while(true) {
            		
            		try {
            			List<Task> taskList = taskService.selectAll();
            			if(ListUtils.isEmpty(taskList)){
            				return;
            			}
            			log.info("--------------------"+taskList.toString());            			
            			            			            			           			            			            			
                    }
                    catch (Exception e) {
                        log.error("init task error =:", e);
                    }                	
                	
                } */          			            			
            			            			            			           			            			            			                                             	            	
            }
        };
        
        new Thread(runnable).start();
    }
}