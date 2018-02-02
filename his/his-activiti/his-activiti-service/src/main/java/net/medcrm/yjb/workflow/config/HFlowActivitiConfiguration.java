package net.medcrm.yjb.workflow.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.activiti.engine.DynamicBpmnService;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.StrongUuidGenerator;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import net.medcrm.yjb.workflow.ext.CustomGroupEntityManagerFactory;
import net.medcrm.yjb.workflow.ext.CustomUserEntityManagerFactory;

/**
 * activiti工作流配置
 */
@Configuration
public class HFlowActivitiConfiguration {

	// 流程配置，与spring整合采用SpringProcessEngineConfiguration这个实现
	@Bean
	public ProcessEngineConfiguration processEngineConfiguration(DataSource dataSource,
			PlatformTransactionManager transactionManager) {
		SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
		processEngineConfiguration.setDataSource(dataSource);
		processEngineConfiguration.setDatabaseSchemaUpdate("true");
		processEngineConfiguration.setDatabaseType("mysql");
		processEngineConfiguration.setJobExecutorActivate(false);
		processEngineConfiguration.setHistory("full");
		processEngineConfiguration.setProcessDefinitionCacheLimit(10);
		processEngineConfiguration.setJdbcMaxActiveConnections(200);
		processEngineConfiguration.setJdbcMaxIdleConnections(20);
		processEngineConfiguration.setJdbcMaxCheckoutTime(20000);
		processEngineConfiguration.setJdbcPingEnabled(true);
		processEngineConfiguration.setJdbcPingConnectionNotUsedFor(3600*1000);
		//processEngineConfiguration.buildProcessEngine();
		processEngineConfiguration.setTransactionManager(transactionManager);
		//邮件任务的配置如下  
		processEngineConfiguration.setMailServerPort(25);
		processEngineConfiguration.setMailServerHost("smtp.163.com");
		processEngineConfiguration.setMailServerUsername("15813369850@163.com");
		processEngineConfiguration.setMailServerDefaultFrom("15813369850@163.com");
		processEngineConfiguration.setMailServerPassword("bin0325117");
		processEngineConfiguration.setMailServerUseSSL(true);

		// 流程图字体
		processEngineConfiguration.setActivityFontName("宋体");
		processEngineConfiguration.setAnnotationFontName("宋体");
		processEngineConfiguration.setLabelFontName("宋体");
		// customSessionFactories
		List<SessionFactory> customSessionFactories = new ArrayList<SessionFactory>();
		
		customSessionFactories.add(customGroupEntityManagerFactory());
		customSessionFactories.add(customUserEntityManagerFactory());
		processEngineConfiguration.setCustomSessionFactories(customSessionFactories);
		
		processEngineConfiguration.setIdGenerator(uuidGenerator());

		return processEngineConfiguration;
	}

	// 流程引擎，与spring整合使用factoryBean
	@Bean
	public ProcessEngineFactoryBean processEngine(ProcessEngineConfiguration processEngineConfiguration) {
		ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
		processEngineFactoryBean
				.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);
		return processEngineFactoryBean;
	}

	// 八大接口
	@Bean
	public RepositoryService repositoryService(ProcessEngine processEngine) {
		return processEngine.getRepositoryService();
	}

	@Bean
	public RuntimeService runtimeService(ProcessEngine processEngine) {
		return processEngine.getRuntimeService();
	}

	@Bean
	public TaskService taskService(ProcessEngine processEngine) {
		return processEngine.getTaskService();
	}

	@Bean
	public HistoryService historyService(ProcessEngine processEngine) {
		return processEngine.getHistoryService();
	}

	@Bean
	public FormService formService(ProcessEngine processEngine) {
		return processEngine.getFormService();
	}

	@Bean
	public IdentityService identityService(ProcessEngine processEngine) {
		return processEngine.getIdentityService();
	}

	@Bean
	public ManagementService managementService(ProcessEngine processEngine) {
		return processEngine.getManagementService();
	}

	@Bean
	public DynamicBpmnService dynamicBpmnService(ProcessEngine processEngine) {
		return processEngine.getDynamicBpmnService();
	}
	// 八大接口 end
	
	@Bean
	public StrongUuidGenerator uuidGenerator() {
		StrongUuidGenerator uuidGenerator=new  StrongUuidGenerator();
		return uuidGenerator;
	}

	@Bean
	public CustomUserEntityManagerFactory customUserEntityManagerFactory() {
		CustomUserEntityManagerFactory customUserEntityManagerFactory = new CustomUserEntityManagerFactory();
		return customUserEntityManagerFactory;
	}

	@Bean
	public CustomGroupEntityManagerFactory customGroupEntityManagerFactory() {
		CustomGroupEntityManagerFactory customGroupEntityManagerFactory = new CustomGroupEntityManagerFactory();
		return customGroupEntityManagerFactory;
	}

}
