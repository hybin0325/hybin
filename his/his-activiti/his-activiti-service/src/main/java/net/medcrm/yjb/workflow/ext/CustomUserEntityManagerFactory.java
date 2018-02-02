package net.medcrm.yjb.workflow.ext;

import javax.annotation.Resource;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
/**
 * @author hybin
 * 注意类的隐藏和实例创建
 */
//用户管理工厂类
public class CustomUserEntityManagerFactory implements SessionFactory {
	@Resource
	private CustomUserEntityManager customUserEntityManager;
	
	public Class<?> getSessionType() {
		// TODO Auto-generated method stub
		return UserIdentityManager.class;
	}
	public Session openSession() {
		// TODO Auto-generated method stub
		return customUserEntityManager;
	}

}
