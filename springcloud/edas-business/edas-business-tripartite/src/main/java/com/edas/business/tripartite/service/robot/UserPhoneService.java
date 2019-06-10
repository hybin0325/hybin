package com.edas.business.tripartite.service.robot;

import java.util.List;

import com.edas.business.tripartite.entity.robot.UserPhone;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * Description: 主叫电话service
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface UserPhoneService extends Service<UserPhone>{
	
	/**
     * 
     * @Description 根据公司id查询
     * @param id
     *
     * @date 2019年4月29日
     * @author zzw
     */
	public List<UserPhone> findByCompanyId(int id);
	
	/**
     * 
     * @Description 同步主叫电话
     *
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void syncUserPhone(int id);
	
	/**
     * 
     * @Description 保存
     * @param userPhone
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void saveUserPhone(UserPhone userPhone);
	
	/**
     * 
     * @Description 更新
     * @param userPhone
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void updateUserPhone(UserPhone userPhone);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void deleteUserPhone(String id);
}
