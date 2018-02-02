/**
 * 
 */
package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 自定义模块
 * 
 * @author hybin
 *
 */
public class HflowModel extends PersistentObject {

	private static final long serialVersionUID = 7481316665349061059L;
	
	private String mName;// '名称',
	private String mIco;// '图标',
	private String mCode;// '编码',
	private String description;// '描述',
	private Integer mSort;// '0' COMMENT '排序',
	
	private String menuId;
	
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmIco() {
		return mIco;
	}
	public void setmIco(String mIco) {
		this.mIco = mIco;
	}
	public String getmCode() {
		return mCode;
	}
	public void setmCode(String mCode) {
		this.mCode = mCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getmSort() {
		return mSort;
	}
	public void setmSort(Integer mSort) {
		this.mSort = mSort;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}
