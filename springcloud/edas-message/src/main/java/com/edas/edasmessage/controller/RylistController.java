package com.edas.edasmessage.controller;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edas.edascommon.utils.DateUtils;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.edas.edasmessage.entity.ShopwwiRylist;
import com.edas.edasmessage.entity.req.CarInParkDataReq;
import com.edas.edasmessage.entity.req.CarOutParkDataReq;
import com.edas.edasmessage.service.CarParkLogService;
import com.edas.edasmessage.service.DeliyunService;
import com.edas.edasmessage.service.ShopwwiRylistService;
import com.edas.system.common.model.CurrentUser;
import com.edas.system.common.model.UserContext;
import com.edas.system.common.utils.AuthUtils;
import com.esotericsoftware.minlog.Log;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("rylist")
public class RylistController {

    @Resource
    private ShopwwiRylistService shopwwiRylistService;
    
    @Autowired
	private CarParkLogService carParkLogService;
    
    @Autowired
   	private DeliyunService deliyunService;

    
    @RequestMapping(value = "/setMsg", method = { RequestMethod.GET, RequestMethod.POST })
    public RetResult<String> setMsg(HttpServletRequest request){
    	shopwwiRylistService.getMsg();
    	return RetResponse.makeOKRsp(null);
    }

    @RequestMapping(value = "/selectById", method = { RequestMethod.GET, RequestMethod.POST })
    public RetResult<ShopwwiRylist> selectById(HttpServletRequest request) throws Exception {

        String id = request.getParameter("id");

        ShopwwiRylist shopwwiRylist = shopwwiRylistService.selectById(id);

        return RetResponse.makeOKRsp(shopwwiRylist);
    }

    @RequestMapping(value = "/byId", method = { RequestMethod.GET, RequestMethod.POST })
    public ShopwwiRylist byId(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        ShopwwiRylist shopwwiRylist = shopwwiRylistService.selectById(id);
        return shopwwiRylist;
    }


    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    public RetResult<PageInfo<ShopwwiRylist>> list(HttpServletRequest request) throws Exception {

        String page = request.getParameter("page");
        String size = request.getParameter("size");

        int s = Integer.parseInt(size);
        int p = Integer.parseInt(page);

        PageHelper.startPage(p > 0 ? p : 1, s > 0 ? s : 15);
        List<ShopwwiRylist> list = shopwwiRylistService.selectAll();
        PageInfo<ShopwwiRylist> pageInfo = new PageInfo<ShopwwiRylist>(list);
        
       

        return RetResponse.makeOKRsp(pageInfo);
    }
    
    @ApiOperation(value = "车辆出场记录", notes = "车辆出场记录")
	@PostMapping(value = "/addCarOutPark")
	public Object addCarOutPark() throws Exception {
    	String timestamp= DateUtils.dateToLong("2019-04-3 09:20") + "";
    	CarInParkDataReq cdata=new CarInParkDataReq();
    	cdata.setPage(1);
    	cdata.setSize(8);
    	deliyunService.findParkInLog(cdata,timestamp);
    	CarOutParkDataReq data = new CarOutParkDataReq();
		data.setPage(1);
		data.setSize(100);
		//Long currentTime=System.currentTimeMillis(); 
		
		//data.setOutTimeStart(DateUtils.getAgoMinutes10(currentTime)/1000);
		
		//data.setOutTimeEnd(currentTime/1000);
		//Log.info("outtime"+new Date().getTime()/1000);
    	//deliyunService.findParkOutLog(data,timestamp);
		return RetResponse.makeOKRsp();
	}
    
    
   
    @PostMapping(value = "/getUser")
    public RetResult getUserInfo(){
    	log.info("getUser: " );
    	CurrentUser suser=UserContext.current();
		System.out.println(suser.toString());
    	return RetResponse.makeOKRsp(suser);
    }
}

