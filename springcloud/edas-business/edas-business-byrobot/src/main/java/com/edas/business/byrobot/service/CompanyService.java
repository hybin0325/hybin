package com.edas.business.byrobot.service;

import java.util.Map;

import com.edas.business.byrobot.entity.Company;
import com.edas.edascommon.core.Service;

/**
 * <p>
 * File Name: CompanyService.java
 * </p>
 * <p>
 * Description: 公司service
 * </p>
 * <p>
 * Date：2019年4月28日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface CompanyService extends Service<Company>{
	
	
	/**
     * 
     * @Description 保存
     * @param company
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void saveCompany(Company company);
	
	/**
     * 
     * @Description 更新
     * @param company
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void updateCompany(Company company);
	
	/**
     * 
     * @Description 删除
     * @param id
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void deleteCompany(String id);
	
	/**
     * 
     * @Description 同步公司
     *
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public void syncCompany();
	
	/**
     * 
     * @Description 获取公司坐席
     * @param id
     * @return Map
     *
     * @date 2019年5月7日
     * @author zzw
     */
	public Map<String,Object> getCompanySeat(int id);

}
