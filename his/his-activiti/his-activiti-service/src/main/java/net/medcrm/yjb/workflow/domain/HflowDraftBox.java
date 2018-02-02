package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

public class HflowDraftBox extends PersistentObject {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    private String processDefinitionId;

    private String fileIds;
    
    private String processInstanceName;

    private String fromObject;

	public String getProcessDefinitionId() {
		return processDefinitionId;
	}

	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	
	public String getFileIds() {
		return fileIds;
	}

	public void setFileIds(String fileIds) {
		this.fileIds = fileIds;
	}

	public String getProcessInstanceName() {
		return processInstanceName;
	}

	public void setProcessInstanceName(String processInstanceName) {
		this.processInstanceName = processInstanceName;
	}

	public String getFromObject() {
		return fromObject;
	}

	public void setFromObject(String fromObject) {
		this.fromObject = fromObject;
	}  
}