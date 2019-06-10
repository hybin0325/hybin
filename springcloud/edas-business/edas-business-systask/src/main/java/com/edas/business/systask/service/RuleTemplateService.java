package com.edas.business.systask.service;

import com.edas.business.systask.entity.RuleTemplate;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: RuleTemplateService.java
 * </p>
 * <p>
 * Description: 跟进规则模板service
 * </p>
 * <p>
 * Date：2019年5月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface RuleTemplateService extends Service<RuleTemplate>{
	
	
	/**
     * 
     * @Description 保存
     *
     */
	public void saveRuleTemplate(RuleTemplate template);
	
	/**
     * 
     * @Description 更新
     *
     */
	public void updateRuleTemplate(RuleTemplate template);
	
	/**
     * 
     * @Description 删除
     *
     */
	public void deleteRuleTemplate(String id);
	
}