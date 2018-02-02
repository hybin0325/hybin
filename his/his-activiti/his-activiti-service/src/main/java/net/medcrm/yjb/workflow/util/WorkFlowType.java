package net.medcrm.yjb.workflow.util;

public enum WorkFlowType {

	/**
	 * 和流程布署中一至
	 */
	LEAVE("leave","请假流程"),
	SHENPI("jiandanshenpi","简单审批"),
	CONSULTATION("consultation","会诊流程");

	private String index;
	
	private String name;
	
	private WorkFlowType( String index,String name) {
		this.index=index;
		this.name=name;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
