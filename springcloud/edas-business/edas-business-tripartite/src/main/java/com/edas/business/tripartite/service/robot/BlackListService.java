package com.edas.business.tripartite.service.robot;

import com.edas.business.tripartite.entity.robot.BlackList;
import com.edas.edascommon.core.Service;
import com.edas.edascommon.utils.web.RetResult;

/**
 * <p>
 * Description: 黑名单service
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface BlackListService extends Service<BlackList>{
	
	/**
     * 
     * @Description 保存
     * @param BlackList
     *
     */
	public RetResult<Object> saveBlackList(BlackList blackList);
	
	public RetResult<Object> addBlackListToBy(BlackList BlackList);
	
	
	/**
     * 
     * @Description 更新
     * @param BlackList
     *
     */
	public void updateBlackList(BlackList blackList);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     */
	public void deleteBlackList(String id);
}