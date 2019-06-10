package com.edas.business.tripartite.service.distribution;

import com.edas.business.tripartite.entity.distribution.Province;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * Description: 省service
 * </p>
 * <p>
 * Date：2019年6月6日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface ProvinceService extends Service<Province>{
	
	/**
     * 
     * @Description 保存
     * @param entity
     */
	public void saveEntity(Province entity);
	
	/**
     * 
     * @Description 更新
     * @param entity
     * 
     */
	public void updateEntity(Province entity);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     */
	public void deleteEntity(String id);
	
}