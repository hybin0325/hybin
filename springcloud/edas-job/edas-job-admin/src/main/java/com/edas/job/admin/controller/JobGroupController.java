package com.edas.job.admin.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edas.job.admin.core.conf.XxlJobAdminConfig;
import com.edas.job.admin.core.model.XxlJobGroup;
import com.edas.job.admin.core.model.XxlJobRegistry;
import com.edas.job.admin.core.util.I18nUtil;
import com.edas.job.admin.dao.XxlJobGroupDao;
import com.edas.job.admin.dao.XxlJobInfoDao;
import com.edas.job.core.biz.model.ReturnT;
import com.edas.job.core.enums.RegistryConfig;

/**
 * job group controller
 * @author xuxueli 2016-10-02 20:52:56
 */
@Controller
@RequestMapping("/jobgroup")
public class JobGroupController {

	@Resource
	public XxlJobInfoDao xxlJobInfoDao;
	@Resource
	public XxlJobGroupDao xxlJobGroupDao;

	@RequestMapping
	public String index(Model model) {

		// job group (executor)
		List<XxlJobGroup> list = xxlJobGroupDao.findAll();

		model.addAttribute("list", list);
		return "jobgroup/jobgroup.index";
	}

	@RequestMapping("/save")
	@ResponseBody
	public ReturnT<String> save(XxlJobGroup xxlJobGroup){

		// valid
		if (xxlJobGroup.getAppName()==null || xxlJobGroup.getAppName().trim().length()==0) {
			return new ReturnT<String>(500, (I18nUtil.getString("system_please_input")+"AppName") );
		}
		if (xxlJobGroup.getAppName().length()<4 || xxlJobGroup.getAppName().length()>64) {
			return new ReturnT<String>(500, I18nUtil.getString("jobgroup_field_appName_length") );
		}
		if (xxlJobGroup.getTitle()==null || xxlJobGroup.getTitle().trim().length()==0) {
			return new ReturnT<String>(500, (I18nUtil.getString("system_please_input") + I18nUtil.getString("jobgroup_field_title")) );
		}
		if (xxlJobGroup.getAddressType()!=0) {
			if (xxlJobGroup.getAddressList()==null || xxlJobGroup.getAddressList().trim().length()==0) {
				return new ReturnT<String>(500, I18nUtil.getString("jobgroup_field_addressType_limit") );
			}
			String[] addresss = xxlJobGroup.getAddressList().split(",");
			for (String item: addresss) {
				if (item==null || item.trim().length()==0) {
					return new ReturnT<String>(500, I18nUtil.getString("jobgroup_field_registryList_unvalid") );
				}
			}
		}

		int ret = xxlJobGroupDao.save(xxlJobGroup);
		return (ret>0)?ReturnT.SUCCESS:ReturnT.FAIL;
	}

	@RequestMapping("/update")
	@ResponseBody
	public ReturnT<String> update(XxlJobGroup xxlJobGroup){
		// valid
		if (xxlJobGroup.getAppName()==null || xxlJobGroup.getAppName().trim().length()==0) {
			return new ReturnT<String>(500, (I18nUtil.getString("system_please_input")+"AppName") );
		}
		if (xxlJobGroup.getAppName().length()<4 || xxlJobGroup.getAppName().length()>64) {
			return new ReturnT<String>(500, I18nUtil.getString("jobgroup_field_appName_length") );
		}
		if (xxlJobGroup.getTitle()==null || xxlJobGroup.getTitle().trim().length()==0) {
			return new ReturnT<String>(500, (I18nUtil.getString("system_please_input") + I18nUtil.getString("jobgroup_field_title")) );
		}
		if (xxlJobGroup.getAddressType() == 0) {
			// 0=自动注册
			List<String> registryList = findRegistryByAppName(xxlJobGroup.getAppName());
			String addressListStr = null;
			if (registryList!=null && !registryList.isEmpty()) {
				Collections.sort(registryList);
				addressListStr = "";
				for (String item:registryList) {
					addressListStr += item + ",";
				}
				addressListStr = addressListStr.substring(0, addressListStr.length()-1);
			}
			xxlJobGroup.setAddressList(addressListStr);
		} else {
			// 1=手动录入
			if (xxlJobGroup.getAddressList()==null || xxlJobGroup.getAddressList().trim().length()==0) {
				return new ReturnT<String>(500, I18nUtil.getString("jobgroup_field_addressType_limit") );
			}
			String[] addresss = xxlJobGroup.getAddressList().split(",");
			for (String item: addresss) {
				if (item==null || item.trim().length()==0) {
					return new ReturnT<String>(500, I18nUtil.getString("jobgroup_field_registryList_unvalid") );
				}
			}
		}

		int ret = xxlJobGroupDao.update(xxlJobGroup);
		return (ret>0)?ReturnT.SUCCESS:ReturnT.FAIL;
	}

	private List<String> findRegistryByAppName(String appNameParam){
		HashMap<String, List<String>> appAddressMap = new HashMap<String, List<String>>();
		List<XxlJobRegistry> list = XxlJobAdminConfig.getAdminConfig().getXxlJobRegistryDao().findAll(RegistryConfig.DEAD_TIMEOUT);
		if (list != null) {
			for (XxlJobRegistry item: list) {
				if (RegistryConfig.RegistType.EXECUTOR.name().equals(item.getRegistryGroup())) {
					String appName = item.getRegistryKey();
					List<String> registryList = appAddressMap.get(appName);
					if (registryList == null) {
						registryList = new ArrayList<String>();
					}

					if (!registryList.contains(item.getRegistryValue())) {
						registryList.add(item.getRegistryValue());
					}
					appAddressMap.put(appName, registryList);
				}
			}
		}
		return appAddressMap.get(appNameParam);
	}

	@RequestMapping("/remove")
	@ResponseBody
	public ReturnT<String> remove(int id){

		// valid
		int count = xxlJobInfoDao.pageListCount(0, 10, id, -1,  null, null);
		if (count > 0) {
			return new ReturnT<String>(500, I18nUtil.getString("jobgroup_del_limit_0") );
		}

		List<XxlJobGroup> allList = xxlJobGroupDao.findAll();
		if (allList.size() == 1) {
			return new ReturnT<String>(500, I18nUtil.getString("jobgroup_del_limit_1") );
		}

		int ret = xxlJobGroupDao.remove(id);
		return (ret>0)?ReturnT.SUCCESS:ReturnT.FAIL;
	}

}
