package com.edas.business.systask.service;

import com.edas.business.systask.entity.AiPhone;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: AiPhoneService.java
 * </p>
 * <p>
 * Description: ai电话关联service
 * </p>
 * <p>
 * Date：2019年5月27日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface AiPhoneService extends Service<AiPhone>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void saveAiPhone(AiPhone phone);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updateAiPhone(AiPhone phone);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deleteAiPhone(String id);
	
}