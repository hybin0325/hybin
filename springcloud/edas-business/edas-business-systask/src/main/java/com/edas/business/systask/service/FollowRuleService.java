package com.edas.business.systask.service;

import com.edas.business.systask.entity.FollowRule;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: FollowRuleService.java
 * </p>
 * <p>
 * Description: 跟进规则service
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface FollowRuleService extends Service<FollowRule>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void saveFollowRule(FollowRule rule);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updateFollowRule(FollowRule rule);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deleteFollowRule(String id);
	
}