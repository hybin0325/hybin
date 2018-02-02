package net.medcrm.yjb.workflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.medcrm.yjb.workflow.dto.OnlineForm;
import net.medcrm.yjb.workflow.service.IOnlineFormService;

@Controller
@RequestMapping("/onlineForm")
public class OnlineFormController {
	@Autowired
	private IOnlineFormService onlineFormService;
	
	@RequestMapping(value="list")	
	@ResponseBody
	public List<OnlineForm> list(OnlineForm obj){
		List<OnlineForm> list = onlineFormService.list(obj);
		return list;
	}
	
	/**
	 * 保存表单
	 * @param obj
	 * @return
	 */
	@RequestMapping(value="save")
	@ResponseBody
	public Object save(OnlineForm obj){
			onlineFormService.save(obj);
		//}else{
		//	obj.setModUserId(AccountShiroUtil.getCurrentUser().getAccountId());
		//	onlineFormService.update(obj);
		//}
	
		return null;
	}
	/**
	 * 设计表单
	 * @param obj
	 * @return
	 */
	@RequestMapping(value="design")
	@ResponseBody
	public Object design(OnlineForm obj){
		
		//obj.setModUserId(AccountShiroUtil.getCurrentUser().getAccountId());
		onlineFormService.design(obj);
		return null;
	}
	
	/**
	 * 删除记录
	 * @param obj
	 * @return
	 */
	@RequestMapping(value="delete")
	@ResponseBody
	public Object delete(Model model,OnlineForm obj){
		onlineFormService.delete(obj);
		return null;
	}
}

