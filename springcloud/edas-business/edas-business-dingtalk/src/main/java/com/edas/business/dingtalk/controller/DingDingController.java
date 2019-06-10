package com.edas.business.dingtalk.controller;

import com.alibaba.fastjson.JSON;
import com.edas.business.dingtalk.dingding.DingDingMess;
import com.edas.business.dingtalk.dingding.DingDingMsgSend;
import com.edas.business.dingtalk.entity.*;
import com.edas.business.dingtalk.service.*;
import com.edas.business.dingtalk.service.impl.ShopwwiZtDingdingcorpidService;



import com.edas.edascommon.model.MQDataMsg;
import com.edas.edascommon.utils.StringTemplateUtils;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(description = "钉钉接口")
@RestController
@Slf4j
@RequestMapping("ding")
public class DingDingController {
    @Resource
    private ShopwwiZtDingdingcorpidService shopwwiZtDingdingcorpidService;
    @Resource
    private ZtConfigkeyService ztConfigkeyService;
    @Resource
    private ZtMessreciService ztMessreciService;
    @RequestMapping(value = "/ss", method = {RequestMethod.POST})
    public String ss(HttpServletRequest request) throws Exception {
//        ZtConfigkey s = new ZtConfigkey();
//        s.setDld("GS");
//        s.setType("001");
//        ZtConfigkey ztConfigkey = ztConfigkeyService.findZtConfigkeyByDld(s);
//        System.out.println("ff"+ztConfigkey.getCorpid());
        ZtMessreci ztMessreci = new ZtMessreci();
        ztMessreci.setMesstempId(3);
        ztMessreci.setDld("GS");
        ZtMessreci ztMeOne = ztMessreciService.findZtMessreciByDld(ztMessreci);
        log.info("获取到的内容"+ztMeOne.getMessRec());
        return "Ok";
    }
    @Resource
    ZtCarcusService ztCarcusService;
    @Resource
    ZtMesstempService ztMesstempService;
    @Resource
    CxxmService cxxmService;
    @Resource
    ZtMesssendlogService ztMesssendlogService;

    @ApiImplicitParam(name = "ZtMesssendlog", value = "实体ZtMesssendlog", dataType = "ZtMesssendlog")
    @PostMapping(value = "/save")
    public RetResult<Object> save(@RequestBody ZtMesssendlog conf) throws Exception {
        log.info("我接收到的实体"+conf);
        ztMesssendlogService.saveZtMesssendlog(conf);
        log.info("保存后的结果");
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/cheshi", method = {RequestMethod.POST})
    public String cheshi(HttpServletRequest request) throws Exception {
        String dld = request.getParameter("dld");
        String license = request.getParameter("license");
        String clid = request.getParameter("clid");
        Integer clids = Integer.parseInt(clid);
        System.out.println("license"+license);
        Integer messtempId = clids;
        //根据
        final String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);

        ZtCarcus ZtCarcus = ztCarcusService.getDataByLicense(license);

        ZtMesstemp ztMesstemp = ztMesstempService.getDataById(messtempId);
        log.info("这是模板 "+ztMesstemp);

        List<Cxxm> Cxxms = cxxmService.getDataByTbname("shopwwi_zt_carcus");



        String nrong1 = ZtCarcus.getLicenseData();
        // 把内容转为对象
        LicenseData licenseData = com.edas.edascommon.utils.StringUtils.stringToBean(nrong1, LicenseData.class);

        String yaoThdd = ztMesstemp.getMessCon();


        // 获取对应关系
        // 先把短信模板 替换成 英文的字段内容
        for (int i = 0; i < Cxxms.size(); i++) {
            String yingwen = "{" + Cxxms.get(i).getEnname() + "}";
            String zhongwen = "{" + Cxxms.get(i).getChname() + "}";
            yaoThdd = yaoThdd.replace(zhongwen, yingwen);
        }

        String fsdldsj = "";
        // json 转成对象
        // 把英文替换成 内容
        List<CarcusInfo> listCar = licenseData.getCarcusInfo();
        for (CarcusInfo info : listCar) {
            fsdldsj = StringTemplateUtils.processTemplate(yaoThdd, info);
        }

        String s = fsdldsj;
        MQDataMsg dataMsg = new MQDataMsg();
        dataMsg.setMessage(s);
        dataMsg.setDld(dld);

        dataMsg.setMesstempType(ztMesstemp.getChanTemp());
        String jsFs =ztMesstemp.getTypeMessage();
        log.info("这是开始的 jsfs"+jsFs);


        jsFs = jsFs.replace("{tihuan}",s);

        dataMsg.setMesstempTypeMessage(jsFs);

        dataMsg.setMesstempId(ztMesstemp.getId());
        dataMsg.setTemType(ztMesstemp.getTemType());
        dataMsg.setTemName(ztMesstemp.getTemName());
        dataMsg.setFrame("");
        dataMsg.setLicense(license);
//        dataMsg.setTiaozhuanUrl("http://www.92egj.com/ding/Gjbcgjao/tiaozhuan.html?dld=|dld|&license=|license|&type=3");
//        dataMsg.setMesstempType("text");
//        String jsFs ="{车牌} 客户:{客户姓名} 进场, 距离保险到期日:{距离保险到期天数},请续保顾问:{续保顾问} 及时跟进[{所属门店}]";


        String msg = JSON.toJSONString(dataMsg);
        log.info(msg);

//        shopwwiZtWechatcorpidService.snderWechat(msg);
        shopwwiZtDingdingcorpidService.snderDingTalk(msg);

        return "Ok";
    }


//    @RequestMapping(value = "/cheshi", method = {RequestMethod.POST})
//    public String cheshi(HttpServletRequest request) throws Exception {
//        String dld = request.getParameter("dld");
//        final String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
//        String s = "妞妞妞妞"+timeStamp;
//        MQDataMsg dataMsg = new MQDataMsg();
//        dataMsg.setMessage(s);
//        dataMsg.setDld(dld);
////        dataMsg.setMesstempType("text");
////        dataMsg.setMesstempTypeMessage("{\"content\":\"{tihuan}\"}");
//
//        dataMsg.setMesstempType("textcard");
//        String jsFs ="{\"title\":\"门禁通知\",\"markdown\":\"{tihuan}\",\"single_url\":\"http://www.baidu.com\",\"single_title\":\"更多\"}";
////        jsFs = jsFs.replace("{tihuan}",s);
//        dataMsg.setMesstempTypeMessage(jsFs);
//        String msg = JSON.toJSONString(dataMsg);
//        shopwwiZtDingdingcorpidService.snderDingTalk(msg);
//        return "Ok";
//    }

    @ApiOperation(value = "发送文本消息" ,  notes="发送文本消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String")
    })

//    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法
    @RequestMapping(value = "/sendText", method = {RequestMethod.POST})
    public String send(@RequestBody ResBodyParmData resBodyParmData) throws Exception {
        DingDingMess ddm = new DingDingMess();
        // 根据dld 获取 密钥
//        String dld = request.getParameter("dld");
//
//        String users = request.getParameter("users");
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getDld();
        String license = resBodyParmData.getLicense();
        String imgurl= resBodyParmData.getPic_url();

        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
//        users = "061329325439962625";


        System.out.println(dld);

        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("001");
        ztConfigkey.setDld(dld);
        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);

        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();



        System.out.println("我来到了这里");
        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //文本消息
        cnew.put("content",license+"车主您好！你的生日快到了，在这里祝你生日快乐，幸福安康！");
        content.put("msgtype","text");
        content.put("text",cnew);
        Integer agentids = Integer.parseInt(agentid);
        String  uslist = users;

        String Results = ddm.main(appkey,appsec,uslist,agentids,content,0);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");

        return Results;
    }

    @ApiOperation(value = "发送OA消息" ,  notes="发送OA消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String")
    })
//    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法
    @RequestMapping(value = "/sendOa", method = {RequestMethod.POST})
    public String sendoa(HttpServletRequest request) throws Exception {
        DingDingMess ddm = new DingDingMess();
        // 根据dld 获取 密钥
        String dld = request.getParameter("dld");
        String license = request.getParameter("license");
        String users = request.getParameter("users");
        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
        users = "061329325439962625";


        System.out.println(dld);
        ShopwwiZtDingdingcorpid miyue = this.getZtDingBdld(dld);
        String appkey = miyue.getAppkey();
        String appsec = miyue.getAppsecret();
        String agentid = miyue.getAgentId();
        System.out.println("我来到了这里");
        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        Map<Object, Object> ns = new HashMap<Object, Object>();
        Map<Object, Object> nt = new HashMap<Object, Object>();
        Map<Object, Object> tt = new HashMap<Object, Object>();
        Map<Object, Object> tt1 = new HashMap<Object, Object>();
        Map<Object, Object> sg = new HashMap<Object, Object>();
        Map<Object, Object> tz = new HashMap<Object, Object>();
        Map<Object, Object> xl = new HashMap<Object, Object>();
        Map<Object, Object> ah = new HashMap<Object, Object>();
        Map<Object, Object> rich = new HashMap<Object, Object>();
//        tt.put("key","姓名");
//        tt.put("value","张珊");
//        tt1.put("key","年龄");
//        tt1.put("value","18");
//        sg.put("key","身高");
//        sg.put("value","1.8米");
//        tz.put("key","体重");
//        tz.put("value","120斤");
//        xl.put("key","学历");
//        xl.put("value","本科");
//        ah.put("key","爱好");
//        ah.put("value","打球、听音乐");
        List<Object> list = new ArrayList<>();
//        list.add(tt);
//        list.add(tt1);
//        list.add(sg);
//        list.add(tz);
//        list.add(xl);
//        list.add(ah);


        //文本消息
//        nt.put("author","李斯");
//        nt.put("file_count","3");
//        nt.put("image","@lADPDeC2t7XYo7zNAaLNAoA");
        cnew.put("message_url","http://www.baidu.com");
//        cnew.put("content","大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本");
        rich.put("num","15.69");
        rich.put("unit","元");
        ns.put("bgcolor","FFBBBBBB");
        ns.put("text","头部标题");
        nt.put("title","正文标题");
        nt.put("content","大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本");
//        nt.put("from",list);
//        nt.put("rich",rich);
        cnew.put("head",ns);
        cnew.put("body",nt);
        content.put("msgtype","oa");
        content.put("oa",cnew);
        Integer agentids = Integer.parseInt(agentid);
        String  uslist = users;

        String Results = ddm.main(appkey,appsec,uslist,agentids,content,0);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");

        return Results;
    }



    @ApiOperation(value = "发送markdown消息" ,  notes="发送markdown消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String")
    })
//    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法
    @RequestMapping(value = "/sendMarkdown", method = {RequestMethod.POST})
    public String sendmarkdown(@RequestBody ResBodyParmData resBodyParmData) throws Exception {
        DingDingMess ddm = new DingDingMess();
        // 根据dld 获取 密钥
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();
        String license = resBodyParmData.getLicense();

        String title = resBodyParmData.getTitle();

        String content_s = resBodyParmData.getContent();
        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
//        users = "061329325439962625";

        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("001");
        ztConfigkey.setDld(dld);
        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        System.out.println("我来到了这里");
        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //文本消息
        cnew.put("title",title);
        cnew.put("text",content_s);
//        cnew.put("single_title","查看详情");
//        cnew.put("single_url","http://www.baidu.com");
        content.put("msgtype","markdown");
        content.put("markdown",cnew);
//        "msgtype": "action_card",
//                "action_card": {
//            "title": "是透出到会话列表和通知的文案",
//                    "markdown": "支持markdown格式的正文内容",
//                    "single_title": "查看详情",
//                    "single_url": "https://open.dingtalk.com"
//        }
        Integer agentids = Integer.parseInt(agentid);
        String  uslist = users;

        String Results = ddm.main(appkey,appsec,uslist,agentids,content,0);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");

        return Results;
    }


    @ApiOperation(value = "发送测试图片上传" ,  notes="发送测试图片上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "tiaozhuan_url", value = "跳转地址", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "title", value = "标题", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "content", value = "标题", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pic_url", value = "图片地址(图标)", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/sendcs", method = {RequestMethod.POST})
    public String sendCs(HttpServletRequest request) throws Exception {
//        log.info("结果"+request.getParameter("license"));
//
        DingDingMess ddm = new DingDingMess();
//        // 根据dld 获取 密钥
        String dld = request.getParameter("dld");
        String license = request.getParameter("license");
        String users = request.getParameter("users");
        String tiaozhuan_url= request.getParameter("tiaozhuan_url");
        String pic_url= request.getParameter("pic_url");
        log.info("图片"+pic_url);
        String title= request.getParameter("title");
        String content_s= request.getParameter("content");

        if(ServletFileUpload.isMultipartContent(request)) {
            MultipartFile file = ((MultipartHttpServletRequest) request).getFile("pic_url");
            log.info("图片名称"+file.getName());
            log.info("图片名称"+file.getOriginalFilename());
        }


//        String dld = data.getDld();
//        String users = data.getUsers();
//        String tiaozhuan_url = data.getTiaozhuan_url();
//        String content_s = data.getContent();
//        String title = data.getTitle();
//        String sig_url = data.getSingle_url();
        log.info("dld"+dld);

        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
//        users = "061329325439962625";


        System.out.println(dld);
//        ShopwwiZtDingdingcorpid miyue = this.getZtDingBdld(dld);
        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("001");
        ztConfigkey.setDld(dld);
        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);

        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        Integer agentids = Integer.parseInt(agentid);


//        String cv = "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。";


//        String corpid ="dingl5vzo4nnxeghc1gt";
//        String corpsecret ="eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b";
//        Integer applids = 238939211;

        DingDingMsgSend swx = new DingDingMsgSend();
        String token = swx.getToken(appkey,appsec);


        //文本消息
//
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");

        return "e";
    }






    @ApiOperation(value = "发送link链接消息" ,  notes="发送link链接消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "tiaozhuan_url", value = "跳转地址", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "title", value = "标题", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "content", value = "标题", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pic_url", value = "图片地址(图标)", required = true, paramType = "query", dataType = "String")
    })
//    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法
    @RequestMapping(value = "/sendLink", method = {RequestMethod.POST})
    public String sendlink(@RequestBody ResBodyParmData resBodyParmData) throws Exception {
//        log.info("结果"+request.getParameter("license"));
//
        DingDingMess ddm = new DingDingMess();
//        // 根据dld 获取 密钥
//        String dld = request.getParameter("dld");
//        String license = request.getParameter("license");
//        String users = request.getParameter("users");
//        String tiaozhuan_url= request.getParameter("tiaozhuan_url");
//        String pic_url = request.getParameter("pic_url");
//        String title= request.getParameter("title");
//        String content_s= request.getParameter("content");
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();
        String license = resBodyParmData.getLicense();
        String tiaozhuan_url = resBodyParmData.getTiaozhuan_url();
        String title = resBodyParmData.getTitle();
        String pic_url = resBodyParmData.getPic_url();
        String content_s = resBodyParmData.getContent();


//        String dld = data.getDld();
//        String users = data.getUsers();
//        String tiaozhuan_url = data.getTiaozhuan_url();
//        String content_s = data.getContent();
//        String title = data.getTitle();
//        String sig_url = data.getSingle_url();
        log.info("dld"+dld);

        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
//        users = "061329325439962625";


        System.out.println(dld);
//        ShopwwiZtDingdingcorpid miyue = this.getZtDingBdld(dld);
        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("001");
        ztConfigkey.setDld(dld);
        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);

        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        Integer agentids = Integer.parseInt(agentid);
        System.out.println("我来到了这里");
        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //文本消息
//        cnew.put("messageUrl","http://s.dingtalk.com/market/dingtalk/error_code.php");
        cnew.put("messageUrl",tiaozhuan_url);
        //图片上传
        String media_id =this.uploadNew(pic_url,"image",appkey,appsec,agentids);
        JSONObject mdi = new JSONObject(media_id);
//        @lADPDeC2t7XYo7zNAaLNAoA
        cnew.put("picUrl",mdi.get("media_id"));
//        cnew.put("title","测试ss");
        cnew.put("title",title);
//        cnew.put("text","测试ss");
        cnew.put("text",content_s);
//        cnew.put("single_title","查看详情");
//        cnew.put("single_url","http://www.baidu.com");
        content.put("msgtype","link");
        content.put("link",cnew);
//        "msgtype": "action_card",
//                "action_card": {
//            "title": "是透出到会话列表和通知的文案",
//                    "markdown": "支持markdown格式的正文内容",
//                    "single_title": "查看详情",
//                    "single_url": "https://open.dingtalk.com"
//        }

        String  uslist = users;

        String Results = ddm.main(appkey,appsec,uslist,agentids,content,0);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");

        return Results;
    }


    @ApiOperation(value = "发送卡片消息" ,  notes="发送卡片消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String")
    })
//    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法
    @RequestMapping(value = "/sendCard", method = {RequestMethod.POST})
    public String sendcard(@RequestBody ResBodyParmData resBodyParmData) throws Exception {
        DingDingMess ddm = new DingDingMess();
        // 根据dld 获取 密钥
//        String dld = request.getParameter("dld");
//        String license = request.getParameter("license");
//        String users = request.getParameter("users");
        //        // 根据dld 获取 密钥
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();
        String license = resBodyParmData.getLicense();
        String contents = resBodyParmData.getContent();
        String tiaozhuan_url = resBodyParmData.getTiaozhuan_url();
        String title = resBodyParmData.getTitle();


        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
//        users = "061329325439962625";

        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("001");
        ztConfigkey.setDld(dld);

        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
        log.info("这里是密钥 数据 "+miyue);
        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();

        log.info("这里是 appid "+ appkey);
        log.info("这里是 secret "+ appsec);

        System.out.println("我来到了这里");
        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //文本消息
        cnew.put("title",title);
        cnew.put("markdown",license+contents);
        cnew.put("single_title","查看详情");
        cnew.put("single_url",tiaozhuan_url);
        content.put("msgtype","action_card");
        content.put("action_card",cnew);
//        "msgtype": "action_card",
//                "action_card": {
//            "title": "是透出到会话列表和通知的文案",
//                    "markdown": "支持markdown格式的正文内容",
//                    "single_title": "查看详情",
//                    "single_url": "https://open.dingtalk.com"
//        }
        Integer agentids = Integer.parseInt(agentid);
        String  uslist = users;

        String Results = ddm.main(appkey,appsec,uslist,agentids,content,0);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");

        return Results;
    }

    @ApiOperation(value = "发送图片消息" ,  notes="发送图片消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
//            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
//            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pic_url", value = "图片地址", required = true, paramType = "query", dataType = "String")
    })

//    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法
    @RequestMapping(value = "/sendImage", method = {RequestMethod.POST})
    public String sendImage(@RequestBody ResBodyParmData resBodyParmData) throws Exception {
        DingDingMess ddm = new DingDingMess();
//        // 根据dld 获取 密钥
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();

        String imgurl= resBodyParmData.getPic_url();
        log.info("图片"+imgurl);

        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
//        users = "061329325439962625";
        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("001");
        ztConfigkey.setDld(dld);

        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
        log.info("这里是密钥 数据 "+miyue);
        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        Integer agentids = Integer.parseInt(agentid);
        log.info("这里是 appid "+ appkey);
        log.info("这里是 secret "+ appsec);
        log.info("这里是 agentid "+ agentids);
        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //获取 媒体id
        String media_id = this.uploadNew(imgurl,"image",appkey,appsec,agentids);
        JSONObject mdi = new JSONObject(media_id);
        //图片消息
        cnew.put("media_id",mdi.get("media_id"));
        content.put("msgtype","image");
        content.put("image",cnew);
//        content.put("msgtype","image");
//        content.put("image",cnew);
        String  uslist = users;
        log.info("消息接收人" + users);
        String Results = ddm.main(appkey,appsec,uslist,agentids,content,1);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");
        return Results;
    }


//    @ApiOperation(value = "发送图片" ,  notes="发送图片上传")
//    @RequestMapping(value = "/sendImage", method = {RequestMethod.POST})
//    public String sendImage(@RequestBody ResBodyParmData resBodyParmData) throws Exception {
////        log.info("结果"+request.getParameter("license"));
////
//
//        DingDingMess ddm = new DingDingMess();
////        // 根据dld 获取 密钥
//        String dld = resBodyParmData.getDld();
//        String license = resBodyParmData.getLicense();
//        String users = resBodyParmData.getDld();
//        String tiaozhuan_url= resBodyParmData.getTiaozhuan_url();
//        String pic_url= resBodyParmData.getPic_url();
//        log.info("图片"+pic_url);
//        String title= resBodyParmData.getTitle();
//        String content_s= resBodyParmData.getContent();
//
//
//        log.info("dld"+content_s);
//
//        if(dld == null){
//            dld = "GS";
//        }else if(dld.trim().length() == 0){
//            dld = "GS";
//        };
//        if(users == null){
//            users = "23428";
//        }else if(users.trim().length() == 0){
//            users = "23428";
//        };
//        users = "061329325439962625";
//
//
//        System.out.println(dld);
////        ShopwwiZtDingdingcorpid miyue = this.getZtDingBdld(dld);
//        ZtConfigkey ztConfigkey = new ZtConfigkey();
//        ztConfigkey.setType("001");
//        ztConfigkey.setDld(dld);
//        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
//
//        String appkey = miyue.getCorpid();
//        String appsec = miyue.getSecretKey();
//        String agentid = miyue.getApplicationId();
//        Integer agentids = Integer.parseInt(agentid);
//
//
////        String cv = "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。";
//
//
////        String corpid ="dingl5vzo4nnxeghc1gt";
////        String corpsecret ="eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b";
////        Integer applids = 238939211;
//
//        DingDingMsgSend swx = new DingDingMsgSend();
//        String token = swx.getToken(appkey,appsec);
//
//
//        //文本消息
////
////        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");
//
//        return "e";
//    }
//


//    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法

    @RequestMapping(value = "/cs", method = {RequestMethod.POST})
    public String cs(HttpServletRequest request) throws Exception {
        DingDingMess ddm = new DingDingMess();

        // 根据dld 获取 密钥
        String dld = request.getParameter("dld");

        String license = request.getParameter("license");
        String users = request.getParameter("users");
        String imgurl = request.getParameter("imgurl");
        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
        users = "061329325439962625";

        ShopwwiZtDingdingcorpid miyue = this.getZtDingBdld(dld);
        String appkey = miyue.getAppkey();
        String appsec = miyue.getAppsecret();
        String agentid = miyue.getAgentId();
        Integer agentids = Integer.parseInt(agentid);
        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //获取 媒体id
        String media_id = this.uploadNew(imgurl,"image",appkey,appsec,agentids);
        JSONObject mdi = new JSONObject(media_id);
        //图片消息
        cnew.put("media_id",mdi.get("media_id"));
        content.put("msgtype","image");
        content.put("image",cnew);
//        content.put("msgtype","image");
//        content.put("image",cnew);
        String  uslist = users;
        String Results = ddm.main(appkey,appsec,uslist,agentids,content,1);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");
        return Results;
    }

    @ApiOperation(value = "发送文件消息" ,  notes="发送文件消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
//            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
//            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "fileurl", value = "文件地址", required = true, paramType = "query", dataType = "String")
    })
    //    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法
    @RequestMapping(value = "/sendFile", method = {RequestMethod.POST})
    public String sendfile(@RequestBody ResBodyParmData resBodyParmData) throws Exception {
        DingDingMess ddm = new DingDingMess();

        // 根据dld 获取 密钥
//        String dld = request.getParameter("dld");
//        System.out.println(dld);
//        String license = request.getParameter("license");
//        String users = request.getParameter("users");
//        String imgurl = request.getParameter("fileurl");
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();
        String license = resBodyParmData.getLicense();
        String tiaozhuan_url = resBodyParmData.getTiaozhuan_url();
        String title = resBodyParmData.getTitle();
        String pic_url = resBodyParmData.getPic_url();
        String content_s = resBodyParmData.getContent();

        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
//        users = "061329325439962625";

        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("001");
        ztConfigkey.setDld(dld);
        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);

        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        Integer agentids = Integer.parseInt(agentid);

        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //获取 媒体id
        String media_id = this.uploadNew(pic_url,"image",appkey,appsec,agentids);
        JSONObject mdi = new JSONObject(media_id);
        //图片消息
        cnew.put("media_id",mdi.get("media_id"));
        content.put("msgtype","file");
        content.put("file",cnew);
//        content.put("msgtype","image");
//        content.put("image",cnew);
        String  uslist = users;
        String Results = ddm.main(appkey,appsec,uslist,agentids,content,1);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");
        return Results;
    }

    @ApiOperation(value = "发送语音消息" ,  notes="发送语音消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dld", value = "4s店", required = true, paramType = "query", dataType = "String"),
//            @ApiImplicitParam(name = "users", value = "员工编号用逗号隔开 如 2235,1234", required = true, paramType = "query", dataType = "String"),
//            @ApiImplicitParam(name = "license", value = "车牌", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "fileurl", value = "文件地址", required = true, paramType = "query", dataType = "String")
    })
    //    , RequestMethod.POST post 方法  RequestMethod.GET 这是get 方法
    @RequestMapping(value = "/sendVoice", method = {RequestMethod.POST})
    public String sendvoice(@RequestBody ResBodyParmData resBodyParmData) throws Exception {
        DingDingMess ddm = new DingDingMess();

        // 根据dld 获取 密钥
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();
        String license = resBodyParmData.getLicense();
        String tiaozhuan_url = resBodyParmData.getTiaozhuan_url();
        String title = resBodyParmData.getTitle();
        String pic_url = resBodyParmData.getPic_url();
        String content_s = resBodyParmData.getContent();


        if(dld == null){
            dld = "GS";
        }else if(dld.trim().length() == 0){
            dld = "GS";
        };
        if(users == null){
            users = "23428";
        }else if(users.trim().length() == 0){
            users = "23428";
        };
//        users = "061329325439962625";

        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("001");
        ztConfigkey.setDld(dld);
        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);

        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();

        Integer agentids = Integer.parseInt(agentid);
        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //获取 媒体id
        String media_id = this.upload(pic_url,"voice",appkey,appsec,agentids);
        JSONObject mdi = new JSONObject(media_id);
        //图片消息
        cnew.put("media_id",mdi.get("media_id"));
        content.put("msgtype","voice");
        content.put("voice",cnew);
//        content.put("msgtype","image");
//        content.put("image",cnew);
        String  uslist = users;
        String Results = ddm.main(appkey,appsec,uslist,agentids,content,1);
//        getTokenDD("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");
        return Results;
    }


    @ApiOperation(value = "获取客户信息" ,  notes="获取客户信息")
    @RequestMapping(value = "/getuser", method = {RequestMethod.GET})
    public Object getUser(HttpServletRequest request) throws Exception {
        Object tt = new Object();
        DingDingMess ddm = new DingDingMess();
        ddm.mainget("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");
        return tt;
    }
//
//    @ApiOperation(value = "测试" ,  notes="测试")
//    @ApiImplicitParam(name = "params" , paramType = "body",examples = @Example({
//            @ExampleProperty(value ="{\"text\":\"124\"}", mediaType = "application/json")
//    }))
//    @RequestMapping(value = "/postjson",produces = MediaType.APPLICATION_JSON_VALUE, method = {RequestMethod.POST})
//    public Object postjson(HttpServletRequest request) throws Exception {
//        BufferedReader read = request.getReader();
//        System.out.println(read);
//        char[] buf = new char[512];
//
//        int len = 0;
//
//        StringBuffer contentBuffer = new StringBuffer();
//
//        while ((len = read.read(buf)) != -1) {
//
//            contentBuffer.append(buf, 0, len);
//
//        }
//
//        String content = contentBuffer.toString();
//        System.out.println("这是返回的内容");
//        System.out.println(content);
//
//        if(content == null){
//
//            content = "";
//
//        }
//        Object tt = new Object();
////        DingDingMess ddm = new DingDingMess();
////        ddm.mainget("dingl5vzo4nnxeghc1gt","eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b");
//
//        return tt;
//    }



    //获取媒体文件id
//    @RequestMapping(value = "/upload", method = {RequestMethod.GET, RequestMethod.POST})
    public String upload(String imgurl,String type,String appkey,String appsec,Number agentid) {
//        String ss = null;
//        System.out.println("字符串为null"+ss.length());

        System.out.println("地址"+imgurl);



        // 根据dld 获取 密钥
//        String dld = request.getParameter("dld");


        DingDingMess ddm = new DingDingMess();
//        String cv = "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。";


//        String corpid ="dingl5vzo4nnxeghc1gt";
//        String corpsecret ="eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b";
//        Integer applids = 238939211;


       String media_id  =   ddm.wenjian(imgurl,type,appkey,appsec,agentid);

       System.out.println(media_id);


        return media_id;
    }
    //获取媒体文件id
//    @RequestMapping(value = "/upload", method = {RequestMethod.GET, RequestMethod.POST})
    public String uploadNew(String imgurl,String type,String appkey,String appsec,Number agentid) {
//        String ss = null;
//        System.out.println("字符串为null"+ss.length());

        System.out.println("地址"+imgurl);



        // 根据dld 获取 密钥
//        String dld = request.getParameter("dld");


        DingDingMess ddm = new DingDingMess();
//        String cv = "你的快递已到，请携带工卡前往邮件中心领取。\n出发前可查看<a href=\"http://work.weixin.qq.com\">邮件中心视频实况</a>，聪明避开排队。";


//        String corpid ="dingl5vzo4nnxeghc1gt";
//        String corpsecret ="eNA40GXYF6dqm0C6s57AAHiocKQc4oQSax0i9NBHpHatB0YmYogsnv_j7CgPf50b";
//        Integer applids = 238939211;


       String media_id  =   ddm.wenjianNew(imgurl,type,appkey,appsec,agentid);

       System.out.println(media_id);


        return media_id;
    }

    public ShopwwiZtDingdingcorpid getZtDingBdld(String dld)  {

        System.out.println("我进来了"+dld);
        ShopwwiZtDingdingcorpid shopwwiZtDingdingcorpid= shopwwiZtDingdingcorpidService.selectBy("dld",dld);
        System.out.println(shopwwiZtDingdingcorpid);
        System.out.println(shopwwiZtDingdingcorpid.getAgentId());
        return shopwwiZtDingdingcorpid;
//        return ;
    }



    /**
     * 从网络Url中下载文件
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException{
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        //文件保存位置
        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }


        System.out.println("info:"+url+" download success");

    }

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
    @RequestMapping(value = "/mainst", method = {RequestMethod.GET})
    public static void mainst() {
        try{
            downLoadFromUrl("http://www.92egj.com//uploads/hr_pic/1d33334fad7bb4f583f511565871ba97.jpeg",
                    "百度.jpg","C:/Users/nl/Desktop/图片库/");
        }catch (Exception e) {
            // TODO: handle exception
        }
    }

}
