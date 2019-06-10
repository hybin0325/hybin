package com.edas.business.data.service;

import com.edas.business.data.entity.ZtMesssendlog;


import java.util.List;

public interface ZtMesssendlogService {

	/**
	 * 新增
	 */
	public void saveZtMesssendlog(ZtMesssendlog conf);

	/**
	 * 修改
	 */
	public void updateZtMesssendlog(ZtMesssendlog conf);


	/**
	 * 查询
	 */
	public List<ZtMesssendlog> findByType(String type);

	/**
	 * 主键查询
	 */
	public ZtMesssendlog getZtMesssendlog(int id);

	/**
	 * 秘钥查询
	 */
	public ZtMesssendlog findBySecretKey(String secretKey);

	/**
	 * 查询所有
	 */
	public List<ZtMesssendlog> findByList(ZtMesssendlog conf);

}
