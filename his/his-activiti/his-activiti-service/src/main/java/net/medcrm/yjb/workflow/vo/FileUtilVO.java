package net.medcrm.yjb.workflow.vo;

import java.io.Serializable;

public class FileUtilVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 151647368109092301L;
	private String base64Str;
	private String fileName;
	private String modelId;
	public String getBase64Str() {
		return base64Str;
	}
	public void setBase64Str(String base64Str) {
		this.base64Str = base64Str;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	
	
}
