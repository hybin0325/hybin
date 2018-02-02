package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

public class OnlineForm extends PersistentObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1541622925021186081L;
	private String  key ;//'表单名称',
	private String  descr;//'描述',
	private String  html ;//
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	
	 
}
