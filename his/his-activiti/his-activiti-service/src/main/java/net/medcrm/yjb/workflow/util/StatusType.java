package net.medcrm.yjb.workflow.util;

/**
 * 状态码
 * @author Administrator
 *
 */
public enum StatusType {
	TES(1,"可用"),NO(0,"停用"),GQ(2,"挂起"),DRAFTS(6,"草稿箱");

	private int index;
	
	private String name;
	
	private StatusType( int index,String name) {
		this.index=index;
		this.name=name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
