package com.edas.business.data.controller;

import com.alibaba.fastjson.JSON;
import com.edas.business.data.entity.*;
import com.edas.business.data.service.*;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("carcus")
public class CarcusController {

    @Resource
    DeliyunCarPlateService deliyunCarPlateService;
    @Resource
    ShopwwiZtCarcusService shopwwiZtCarcusService;
    @Resource
    ZtConfigkeyService ztConfigkeyService;
    @Resource
    ZtCarParkCliqueMapService ztCarParkCliqueMapService;

    @RequestMapping(value = "/repls", method = { RequestMethod.GET, RequestMethod.POST })
    public String  repls(HttpServletRequest request) throws Exception {




        String license = request.getParameter("license");
        String dld = request.getParameter("dld");
        String controlId = request.getParameter("controlId");
//        license = "浙L8297G";
//        dld = "GV01";
        DeliyunCarPlate d=new DeliyunCarPlate();
        d.setPlateNum(license);
//        SimpleDateFormat sdf1 = new SimpleDateFormat("mm:sss");
//        Date s = new Date("mm:ss");
        d.setInTime(new Date());
        //18887
        d.setControlId(controlId);
//        String jsonStr="{\"plateNum\":\"闽EVM053\"}";
        String jsonStr=  JSON.toJSONString(d);
       deliyunCarPlateService.sendMsg(jsonStr);

        return "ok";
    }

    @RequestMapping(value = "/qqc", method = { RequestMethod.GET, RequestMethod.POST })
    public String  qqc(HttpServletRequest request) throws Exception {

        String license = request.getParameter("license");
        String dld = request.getParameter("dld");
        license = "浙L8297G";
        dld = "GV01";

        log.info("我来到了这里");
//        ShopwwiZtCarcus shopwwiZtCarcus = shopwwiZtCarcusService.getDataByLicense(license);
//        log.info("这里有数据"+shopwwiZtCarcus);
//       deliyunCarPlateService.sendMsg(jsonStr);
//        List<ZtConfigkey> ztConfigkey =  ztConfigkeyService.findByType("001");
//        log.info("中台"+ztConfigkey);
//        String ss = "18885";
        String ss = request.getParameter("ss");
        ZtCarParkCliqueMap ztCarParkCliqueMap = ztCarParkCliqueMapService.findZtCarparkCliqueMap(ss);
        log.info("dld 结果是 "+ztCarParkCliqueMap);
        return "ok";
    }



}
