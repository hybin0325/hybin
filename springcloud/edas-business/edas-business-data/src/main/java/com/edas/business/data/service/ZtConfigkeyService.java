package com.edas.business.data.service;

import java.util.List;

import com.edas.business.data.entity.ZtConfigkey;

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
	public List<ZtConfigkey> findByType(String type);

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
