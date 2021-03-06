package com.edas.business.dingtalk.service;



import com.edas.business.dingtalk.entity.ZtMessreci;

import java.util.List;

public interface ZtMessreciService {

	/**
	 * 新增
	 */
	public void saveZtMessreci(ZtMessreci conf);

	/**
	 * 修改
	 */
	public void updateZtMessreci(ZtMessreci conf);


	/**
	 * 查询
	 */
	public ZtMessreci findByType(String type);

	public ZtMessreci findZtMessreciByDld(ZtMessreci conf);

	/**
	 * 主键查询
	 */
	public ZtMessreci getZtMessreci(int id);


	/**
	 * 查询所有
	 */
	public List<ZtMessreci> findByList(ZtMessreci conf);

}
