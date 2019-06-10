package com.edas.business.byrobot.service;

import java.util.List;

import com.edas.business.byrobot.entity.Robot;
import com.edas.edascommon.core.Service;


/**
 * <p>
 * File Name: RobotService.java
 * </p>
 * <p>
 * Description: 话术service
 * </p>
 * <p>
 * Date：2019年4月29日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface RobotService extends Service<Robot>{
	public List<Robot> findByCompanyId(int id);
	
	/**
     * 
     * @Description 同步话术
     *
     * @param id
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void syncRobot(int id);
	
	/**
     * 
     * @Description 保存
     * @param robot
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void saveRobot(Robot robot);
	
	/**
     * 
     * @Description 更新
     * @param robot
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void updateRobot(Robot robot);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月8日
     * @author zzw
     */
	public void deleteRobot(String id);
}