package net.medcrm.yjb.workflow.util;

public enum ProcdefType {
	MODEL(0,"流程模板"),PRCDE(1,"流程"),CFROM(2,"表单"),EXCEL(3,"报表"),QUERY(4,"查询表");

	private int index;
	
	private String name;
	
	private ProcdefType( int index,String name) {
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
