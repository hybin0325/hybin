package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

public class HflowfBusinessFormFile extends PersistentObject {

	private static final long serialVersionUID = -2074269269360250357L;

	private String formId;// 业务ID
	private String fileId;// 附件ID
	private String businessKey;// 业务类型

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

}
