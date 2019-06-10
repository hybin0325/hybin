package com.edas.business.qywechat.controller;

import com.alibaba.fastjson.JSON;

import com.edas.business.qywechat.entity.*;
import com.edas.business.qywechat.feign.ZtMesslogFeign;
import com.edas.business.qywechat.service.*;

import com.edas.business.qywechat.service.impl.ShopwwiZtWechatcorpidServiceImpl;
import com.edas.business.qywechat.service.impl.WechatService;
import com.edas.edascommon.model.MQDataMsg;

import com.edas.edascommon.utils.StringTemplateUtils;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(description = "企业微信接口")
@RestController
@RequestMapping("qywechat")
public class QywechatController {

    @Resource
    private ShopwwiZtWechatcorpidServiceImpl shopwwiZtWechatcorpidService;

    @Resource
    ZtCarcusService ztCarcusService;
    @Resource
    ZtMessreciService ztMessreciService;
    @Resource
    CxxmService cxxmService;
    @Resource
    ZtMesstempService ztMesstempService;
    @Resource
    ZtMesssendlogService ztMesssendlogService;
    @Resource
    ZtConfigkeyService ztConfigkeyService;
    @Autowired
    private WechatService wechatService;

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
//        final String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
        log.info("车牌号是："+license);
        ZtCarcus  shopwwiZtCarcus = ztCarcusService.getDataByLicense(license);
        log.info("这是要替换的车牌信息"+shopwwiZtCarcus);
        ZtMesstemp shopwwiZtMesstemp = ztMesstempService.getDataById(messtempId);
        log.info("这是要要替换的模板"+shopwwiZtMesstemp);
        List<Cxxm> shopwwiCxxms = cxxmService.getDataByTbname("shopwwi_zt_carcus");

        log.info("这是要替换的项目名称项"+shopwwiCxxms);

        String nrong1 = shopwwiZtCarcus.getLicenseData();
        // 把内容转为对象
        LicenseData licenseData = com.edas.edascommon.utils.StringUtils.stringToBean(nrong1, LicenseData.class);
        log.info("这是要替换的对象"+licenseData);
        String yaoThdd = shopwwiZtMesstemp.getMessCon();
        log.info("这是要替换的真正模板"+yaoThdd);

        // 获取对应关系
        // 先把短信模板 替换成 英文的字段内容
        for (int i = 0; i < shopwwiCxxms.size(); i++) {
            String yingwen = "{" + shopwwiCxxms.get(i).getEnname() + "}";
            String zhongwen = "{" + shopwwiCxxms.get(i).getChname() + "}";
            yaoThdd = yaoThdd.replace(zhongwen, yingwen);
        }
        log.info("已经替换了中文为英文模板"+yaoThdd);
        String fsdldsj = "";
        String frame = "";
        // json 转成对象
        // 把英文替换成 内容
        List<CarcusInfo> listCar = licenseData.getCarcusInfo();
        for (CarcusInfo info : listCar) {
            frame = info.getFrame();
            license = info.getLicense();
            fsdldsj = StringTemplateUtils.processTemplate(yaoThdd, info);
        }
        log.info("已经把英文替换成真正的内容模板的消息"+fsdldsj);

        String s = fsdldsj;
        MQDataMsg dataMsg = new MQDataMsg();
        dataMsg.setMessage(s);
        dataMsg.setDld(dld);

        dataMsg.setFrame(frame);
//        dataMsg.setMesstempType("text");
//        dataMsg.setMesstempTypeMessage("{\"content\":\"{tihuan}\"}");

//        dataMsg.setMesstempType("textcard");

//        sendcard
//        String jsFs ="{\"title\":\"门禁通知\",\"mess_con\":\"{tihuan}\",\"tz_url\":\"http://www.baidu.com\",\"tz_btn\":\"更多\"}";
//        dataMsg.setMesstempTypeMessage(jsFs);

//        markdown
//        cnew.put("title",license+"首屏会话透出的展示内容");
//        cnew.put("text","# 这是支持markdown的文本 \n## 标题2  \n* 列表1 \n![alt 啊](https://gw.alipayobjects.com/zos/skylark-tools/public/files/b424a1af2f0766f39d4a7df52ebe0083.png)");
////        cnew.put("single_title","查看详情");
////        cnew.put("single_url","http://www.baidu.com");
//        content.put("msgtype","markdown");
//        content.put("markdown",cnew);
        dataMsg.setMesstempType(shopwwiZtMesstemp.getChanTemp());
        String jsFs =shopwwiZtMesstemp.getTypeMessage();
//        dataMsg.setMesstempType("markdown");
//        String jsFs ="{\"content\": \"您的会议室已经预定，稍后会同步到`邮箱`>**事项详情**>事　项：<font color=\\\"info\\\">开会</font>>组织者：@miglioguan>参与者：@miglioguan、@kunliu、@jamdeezhou、@kanexiong、@kisonwang>>会议室：<font color=\\\"info\\\">广州TIT 1楼 301</font>>日　期：<font color=\\\"warning\\\">2018年5月18日</font>>时　间：<font color=\\\"comment\\\">上午9:00-11:00</font>>>请准时参加会议。>>如需修改会议信息，请点击：[修改会议信息](https://work.weixin.qq.com)\"}";
//        dataMsg.setMesstempType("video");
//        String jsFs ="{\"media_id\": \"3TF4_4LrErGQoYczaQMn_w5iz2v6ExJw7VF5E0RrFtQFF5V_Sl7421_ffOztQIjnf\"}";

        //oa
//        dataMsg.setMesstempType("oa");


//        //文本消息
//        cnew.put("message_url","http://www.baidu.com");
//        ns.put("bgcolor","FFBBBBBB");
//        ns.put("text","头部标题");
//        cnew.put("head",ns);

//        nt.put("content","大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本");
//        rich.put("num","15.69");
//        rich.put("unit","元");
//        nt.put("rich",rich);
//
//        nt.put("title","正文标题");
//        nt.put("from",list);
//        nt.put("image","@lADPDeC2t7XYo7zNAaLNAoA");
//        nt.put("author","李斯");
//        nt.put("file_count","3");
//        cnew.put("body",nt);
//        content.put("msgtype","oa");
//        content.put("oa",cnew);
//        Integer agentids = Integer.parseInt(agentid);
//        String jsFs ="{\"head\":{\"bgcolor\":\"FFBBBBBB\",\"text\":\"头部标题{tihuan}\"},\"body\":{\"file_count\":\"3\",\"image\":\"@lADPDeC2t7XYo7zNAaLNAoA\",\"author\":\"李斯{tihuan}\",\"rich\":{\"unit\":\"元\",\"num\":\"15.69\"},\"from\":[{\"value\":\"张珊\",\"key\":\"姓名\"},{\"value\":\"18\",\"key\":\"年龄\"},{\"value\":\"1.8米\",\"key\":\"身高\"},{\"value\":\"120斤\",\"key\":\"体重\"},{\"value\":\"本科\",\"key\":\"学历\"},{\"value\":\"打球、听音乐\",\"key\":\"爱好\"}],\"title\":\"正文标题\",\"content\":\"大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本{tihuan}\"},\"message_url\":\"http://www.baidu.com\"}";
//        String jsFs = JSON.toJSONString(content);
        jsFs = jsFs.replace("{tihuan}",s);
        System.out.println(jsFs);
        dataMsg.setMesstempTypeMessage(jsFs);
        log.info("模板id是"+shopwwiZtMesstemp.getId());
        dataMsg.setMesstempId(shopwwiZtMesstemp.getId());
//        dataMsg.setMesstempType("text");
//        String jsFs ="{车牌} 客户:{客户姓名} 进场, 距离保险到期日:{距离保险到期天数},请续保顾问:{续保顾问} 及时跟进[{所属门店}]";

        dataMsg.setTemType(shopwwiZtMesstemp.getTemType());
        dataMsg.setTemName(shopwwiZtMesstemp.getTemName());
        dataMsg.setLicense(license);
        dataMsg.setTiaozhuanUrl(shopwwiZtMesstemp.getTiaozhuanUrl());

        String msg = JSON.toJSONString(dataMsg);

        shopwwiZtWechatcorpidService.snderWechat(msg);

        return "Ok";
    }

    @ApiOperation(value = "发送图片/文件/语音消息" ,  notes="发送图片/文件/语音消息 用type区分type=image 图片消息，type=file 文件消息，type=voice 语音消息")
    @RequestMapping(value = "/sendImage", method = {RequestMethod.POST})
    public String sendImage(@RequestBody ResBodyParmData resBodyParmData)throws Exception{
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();

        String imgurl= resBodyParmData.getPic_url();
        String type= resBodyParmData.getType();
        log.info("媒体文件 url"+imgurl);
        log.info("媒体文件 类型"+type);
        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("002");
        ztConfigkey.setDld(dld);

        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
        log.info("这里是密钥 数据 "+miyue);
        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        Integer agentids = Integer.parseInt(agentid);
        //先上传图片
        String acctoken = wechatService.getToken(appkey,appsec);
        log.info("这是获取图片数据的seck"+acctoken);
        String media_id = wechatService.uploadmatNew(acctoken,type,imgurl);
        JSONObject mdi = new JSONObject(media_id);
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //图片消息
        cnew.put("media_id",mdi.get("media_id"));
        log.info("媒体文件上传返回的结果"+media_id);
        String jsFs = JSON.toJSONString(cnew);
        shopwwiZtWechatcorpidService.sendPostAll(appkey,appsec,agentids,users,type,"",jsFs);

        return jsFs;
    }

    @ApiOperation(value = "发送视频消息" ,  notes="发送视频消息 用type=video ")
    @RequestMapping(value = "/sendVideo", method = {RequestMethod.POST})
    public String sendVideo(@RequestBody ResBodyParmData resBodyParmData)throws Exception{
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();

        String imgurl= resBodyParmData.getPic_url();
        String type= resBodyParmData.getType();
        String title = resBodyParmData.getTitle();
        String content = resBodyParmData.getContent();
        log.info("媒体文件 url"+imgurl);
        log.info("媒体文件 类型"+type);
        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("002");
        ztConfigkey.setDld(dld);

        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
        log.info("这里是密钥 数据 "+miyue);
        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        Integer agentids = Integer.parseInt(agentid);
        //先上传图片
        String acctoken = wechatService.getToken(appkey,appsec);
        log.info("这是获取图片数据的seck"+acctoken);
        String media_id = wechatService.uploadmatNew(acctoken,type,imgurl);
        JSONObject mdi = new JSONObject(media_id);
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //图片消息
        cnew.put("media_id",mdi.get("media_id"));
        cnew.put("title",title);
        cnew.put("description",content);
        log.info("媒体文件上传返回的结果"+media_id);
        String jsFs = JSON.toJSONString(cnew);
        shopwwiZtWechatcorpidService.sendPostAll(appkey,appsec,agentids,users,type,"",jsFs);

        return jsFs;
    }

    @ApiOperation(value = "发送图文消息" ,  notes="发送图文消息 用type=news ")
    @RequestMapping(value = "/sendNews", method = {RequestMethod.POST})
    public String sendNews(@RequestBody ResBodyParmData resBodyParmData)throws Exception{
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();

        String imgurl= resBodyParmData.getPic_url();
        String type= resBodyParmData.getType();
        String title = resBodyParmData.getTitle();
        String content = resBodyParmData.getContent();
        log.info("返回的内容"+resBodyParmData);

        String articles = resBodyParmData.getArticles();
        log.info("返回的 articles"+articles);
//        log.info("媒体文件 类型"+type);
        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("002");
        ztConfigkey.setDld(dld);

        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
        log.info("这里是密钥 数据 "+miyue);
        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        Integer agentids = Integer.parseInt(agentid);
        //先上传图片
        String acctoken = wechatService.getToken(appkey,appsec);
        log.info("这是获取图片数据的seck"+acctoken);
//        String media_id = wechatService.uploadmatNew(acctoken,type,imgurl);
//        JSONObject mdi = new JSONObject(media_id);
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //图片消息
//        cnew.put("media_id",mdi.get("media_id"));
        cnew.put("articles",articles);
//        cnew.put("description",content);
//        log.info("媒体文件上传返回的结果"+media_id);
        String jsFs = JSON.toJSONString(cnew);
        shopwwiZtWechatcorpidService.sendPostAll(appkey,appsec,agentids,users,type,"",jsFs);

        return jsFs;
    }

    @ApiOperation(value = "发送markdown消息" ,  notes="发送markdown type=markdown ")
    @RequestMapping(value = "/sendMarkdown", method = {RequestMethod.POST})
    public String sendMarkdown(@RequestBody ResBodyParmData resBodyParmData)throws Exception{
        String dld = resBodyParmData.getDld();
        //用逗号隔开
        String users = resBodyParmData.getUsers();

        String imgurl= resBodyParmData.getPic_url();
        String type= resBodyParmData.getType();
        String content  = resBodyParmData.getContent();
        log.info("媒体文件 url"+imgurl);
        log.info("媒体文件 类型"+type);
        ZtConfigkey ztConfigkey = new ZtConfigkey();
        ztConfigkey.setType("002");
        ztConfigkey.setDld(dld);

        ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
        log.info("这里是密钥 数据 "+miyue);
        String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();
        Integer agentids = Integer.parseInt(agentid);
        //先上传图片
        String acctoken = wechatService.getToken(appkey,appsec);


        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //图片消息
//        cnew.put("media_id",mdi.get("media_id"));
        cnew.put("content",content);
        String jsFs = JSON.toJSONString(cnew);
        shopwwiZtWechatcorpidService.sendPostAll(appkey,appsec,agentids,users,type,"",jsFs);

        return jsFs;
    }


}
