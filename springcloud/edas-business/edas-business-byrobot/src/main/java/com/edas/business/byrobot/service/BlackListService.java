package com.edas.business.byrobot.service;

import com.edas.business.byrobot.entity.BlackList;
import com.edas.edascommon.core.Service;
import com.edas.edascommon.utils.web.RetResult;

/**
 * <p>
 * File Name: BlackListService.java
 * </p>
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
     * @date 2019年5月7日
     * @author zzw
     */
	public RetResult<Object> saveBlackList(BlackList blackList);
	
	public RetResult<Object> addBlackListToBy(BlackList BlackList);
	
	
	/**
     * 
     * @Description 更新
     * @param BlackList
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void updateBlackList(BlackList blackList);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void deleteBlackList(String id);
}