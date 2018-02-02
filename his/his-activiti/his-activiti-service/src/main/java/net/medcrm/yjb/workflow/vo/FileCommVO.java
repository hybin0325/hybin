package net.medcrm.yjb.workflow.vo;

public class FileCommVO {
	private String base64Str;
	private String fileName;
	private String describe;
	
	private String businessKey;
	private String businessId;
	
	private String fileId;
	
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
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getBusinessKey() {
		return businessKey;
	}
	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
}
