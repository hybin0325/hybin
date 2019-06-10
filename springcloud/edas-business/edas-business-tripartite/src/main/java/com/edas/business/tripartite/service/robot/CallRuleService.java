package com.edas.business.tripartite.service.robot;

import com.edas.business.tripartite.entity.robot.CallRule;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * Description 重拨规则service
 * </p>
 * <p>
 * Date：2019年5月7日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface CallRuleService extends Service<CallRule>{
	
	/**
     * 
     * @Description 保存
     * @param robot
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void saveCallRule(CallRule callRule);
	
	/**
     * 
     * @Description 更新
     * @param robot
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void updateCallRule(CallRule callRule);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void deleteCallRule(String id);
}