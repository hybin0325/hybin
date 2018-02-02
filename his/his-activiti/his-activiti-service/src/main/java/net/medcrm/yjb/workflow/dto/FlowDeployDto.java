package net.medcrm.yjb.workflow.dto;

/**
 * 发起流程
 * 
 * @author Administrator
 *
 */
public class FlowDeployDto {
	private String procodefId;// 自定义内容ID
	private String titleName;// 标题
	private String description;//
	private String actProcodefId;// 流程布署成功后流和定义id
	private String createUser;// 创建人

	private String resourceName;// xml文件
	private String diagramResourceName;// 图片
	
	private String actKey;
	private String ico;
	
	private String startEventId;
	private String startEventName;

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActProcodefId() {
		return actProcodefId;
	}

	public void setActProcodefId(String actProcodefId) {
		this.actProcodefId = actProcodefId;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDiagramResourceName() {
		return diagramResourceName;
	}

	public void setDiagramResourceName(String diagramResourceName) {
		this.diagramResourceName = diagramResourceName;
	}

	public String getProcodefId() {
		return procodefId;
	}

	public void setProcodefId(String procodefId) {
		this.procodefId = procodefId;
	}

	public String getActKey() {
		return actKey;
	}

	public void setActKey(String actKey) {
		this.actKey = actKey;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getStartEventId() {
		return startEventId;
	}

	public void setStartEventId(String startEventId) {
		this.startEventId = startEventId;
	}

	public String getStartEventName() {
		return startEventName;
	}

	public void setStartEventName(String startEventName) {
		this.startEventName = startEventName;
	}

}
