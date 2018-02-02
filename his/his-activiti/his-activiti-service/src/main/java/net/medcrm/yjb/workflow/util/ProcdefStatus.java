package net.medcrm.yjb.workflow.util;

public enum ProcdefStatus {
	TES(1,"可用"),NO(0,"停用"),GQ(2,"挂起");

	private int index;
	
	private String name;
	
	private ProcdefStatus( int index,String name) {
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
