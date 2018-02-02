package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

public class HflowModelProcdef extends PersistentObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2214353231222449539L;

	private String hModel;
	private String hProcdefId;
	public String gethModel() {
		return hModel;
	}
	public void sethModel(String hModel) {
		this.hModel = hModel;
	}
	public String gethProcdefId() {
		return hProcdefId;
	}
	public void sethProcdefId(String hProcdefId) {
		this.hProcdefId = hProcdefId;
	}
	
	

}
