package net.medcrm.yjb.workflow.jump;

import java.io.Serializable;

public class MyBeanStartTimerEvent implements Serializable {
	 
    private static final long serialVersionUID = 1L;
 
    public void execute(){
        System.out.println("execute()");
    }
     
}