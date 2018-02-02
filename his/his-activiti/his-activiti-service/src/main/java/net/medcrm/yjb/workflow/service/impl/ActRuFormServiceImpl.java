package net.medcrm.yjb.workflow.service.impl;

import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.medcrm.yjb.workflow.service.IActRuFormService;

@Service
public class ActRuFormServiceImpl implements IActRuFormService {
	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private FormService formService;

	@Override
	public void saveSubmit(String taskId, Map<String, String> formProperties,String userId) {
		try {
            identityService.setAuthenticatedUserId(userId);

            formService.submitTaskFormData(taskId, formProperties);
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
	}

}
