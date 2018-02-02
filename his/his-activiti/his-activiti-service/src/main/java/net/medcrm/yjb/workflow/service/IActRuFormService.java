package net.medcrm.yjb.workflow.service;

import java.util.Map;

public interface IActRuFormService {
	
	void saveSubmit( String taskId, Map<String, String> formProperties,String userId);
}
