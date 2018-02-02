package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

public class HflowProcdefLogs extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actReProId;
	private Integer pSort;
	public String getActReProId() {
		return actReProId;
	}
	public void setActReProId(String actReProId) {
		this.actReProId = actReProId;
	}
	public Integer getpSort() {
		return pSort;
	}
	public void setpSort(Integer pSort) {
		this.pSort = pSort;
	}
	
	
}
 