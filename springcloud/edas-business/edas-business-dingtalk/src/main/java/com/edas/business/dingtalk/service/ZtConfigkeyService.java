package com.edas.business.dingtalk.service;



import com.edas.business.dingtalk.entity.ZtConfigkey;

import java.util.List;

public interface ZtConfigkeyService {

	/**
	 * 新增
	 */
	public void saveZtConfigkey(ZtConfigkey conf);

	/**
	 * 修改
	 */
	public void updateZtConfigkey(ZtConfigkey conf);

	/**
	 * 删除
	 */
	public void deleteZtConfigkey(int id);

	/**
	 * 查询
	 */
	public ZtConfigkey findByType(String type);

	public ZtConfigkey findZtConfigkeyByDld(ZtConfigkey conf);

	/**
	 * 主键查询
	 */
	public ZtConfigkey getZtConfigkey(int id);

	/**
	 * 秘钥查询
	 */
	public ZtConfigkey findBySecretKey(String secretKey);

	/**
	 * 查询所有
	 */
	public List<ZtConfigkey> findByList(ZtConfigkey conf);

}
