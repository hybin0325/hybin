/**
 * 
 */
package net.medcrm.yjb.workflow.ext;

import javax.annotation.Resource;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;

/**
 * @author hybin
 * 注意类的隐藏和实例创建
 */
//组管理工厂类
public class CustomGroupEntityManagerFactory implements SessionFactory {
	@Resource
	private CustomGroupEntityManager customGroupEntityManager; 
	
	public Class<?> getSessionType() {
		// TODO Auto-generated method stub
		return GroupIdentityManager.class;
	}
	public Session openSession() {
		// TODO Auto-generated method stub
		return customGroupEntityManager;
	}

}
