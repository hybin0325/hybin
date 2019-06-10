package com.edas.business.qywechat.service.impl;

import com.edas.business.qywechat.entity.ZtConfigkey;
import com.edas.business.qywechat.entity.ZtMessreci;
import com.edas.business.qywechat.entity.ZtMesssendlog;
import com.edas.business.qywechat.service.ZtConfigkeyService;
import com.edas.business.qywechat.service.ZtMessreciService;
import com.edas.business.qywechat.service.ZtMesssendlogService;
import io.swagger.models.auth.In;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.edas.business.qywechat.entity.ZtWechatcorpid;
import com.edas.business.qywechat.entity.req.WeChatData;
import com.edas.business.qywechat.entity.req.WeChatText;
import com.edas.business.qywechat.enums.WechatEnum;
import com.edas.business.qywechat.feign.ZtConfigkeyFeign;
import com.edas.business.qywechat.service.ZtWechatcorpidService;
import com.edas.edascommon.core.AbstractServices;
import com.edas.edascommon.model.MQDataMsg;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.net.URLEncoder;
import java.time.LocalDateTime;

/**
 * @Description: ShopwwiZtWechatcorpidServiceImpl接口实现类
 * @author hjx
 * @date 2019/03/01 16:07
 */
@Slf4j
@Service
public class ShopwwiZtWechatcorpidServiceImpl extends AbstractServices<ZtWechatcorpid>
		implements ZtWechatcorpidService {

	@Autowired
	private WechatService wechatService;
	
	@SuppressWarnings("unused")
	@Autowired
	private ZtConfigkeyFeign ztConfigkeyFeign;
	@Resource
	private ZtConfigkeyService ztConfigkeyService;
	@Resource
	private ZtMessreciService ztMessreciService;
	@Resource
	private ZtMesssendlogService ztMesssendlogService;



	
	public void snderWechat(String msg) {
		log.info("进来企业微信: " + msg);
		MQDataMsg dataMsg = com.edas.edascommon.utils.StringUtils.stringToBean(msg, MQDataMsg.class);
//		String dld = "GS";
		String dld = dataMsg.getDld();
		String typeFs = dataMsg.getMesstempType();
		String jsFs = dataMsg.getMesstempTypeMessage();
		Integer tempId = dataMsg.getMesstempId();
		try {
			//String userids = "17262|23428";
			ZtMessreci ztMessreci = new ZtMessreci();

			ztMessreci.setMesstempId(tempId);
			ztMessreci.setDld(dld);

			ZtMessreci ztMeOne = ztMessreciService.findZtMessreciByDld(ztMessreci);
//			log.info("就是这里 ztMeOne"+ztMeOne.getMessRec());

			String userids = ztMeOne.getMessRec(); // 按接收人接收
//			String userids = "23428,17262,26582";


			userids = userids.replace(",","|");
//			if(dld.equals("GV01")){
//				userids = userids+"|10011";
//			}
//			userids = "23428";
			log.info("接收人id"+userids);

//			ZtWechatcorpid miyue = getZtWechtBdld(dld);

			ZtConfigkey ztConfigkey = new ZtConfigkey();
			ztConfigkey.setType("002");
			ztConfigkey.setDld(dld);
			log.info("这是查询密钥条件" + ztConfigkey);
			ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
			log.info("这是密钥" + miyue);
			if (miyue == null || miyue.getCorpid().length() == 0) {
				log.info("找不到企业微信应用秘钥，请联系相关人员设置");
			}

			String cv = dataMsg.getMessage();
			String corpid = miyue.getCorpid();
			String corpsecret = miyue.getSecretKey();
			String applid = miyue.getApplicationId();
			Integer applids = Integer.parseInt(applid);
			//			 //跳转url
//			String tiaozhuan_url = dataMsg.getTiaozhuanUrl();
			String tiaozhuan_url = "http://www.92egj.com/ding/Gjbcgjao/tiaozhuan.html?dld=|dld|&license=|license|&type=3";

			try{
				tiaozhuan_url = dataMsg.getTiaozhuanUrl();
			}catch (Exception es) {
				log.error("跳转链接报错:"+es.getMessage());
			}
			if (tiaozhuan_url == null || tiaozhuan_url.trim().length() == 0){
				tiaozhuan_url = "http://www.92egj.com/ding/Gjbcgjao/tiaozhuan.html?dld=|dld|&license=|license|&type=3";
			}

			log.info("这是 url "+tiaozhuan_url);
			tiaozhuan_url = tiaozhuan_url.replace("|license|",dataMsg.getLicense());
			tiaozhuan_url = tiaozhuan_url.replace("|dld|",dataMsg.getDld());
			tiaozhuan_url = tiaozhuan_url.replace("|frame|",dataMsg.getFrame());
			String yuming = getUrl(tiaozhuan_url);
			log.info("域名是"+yuming);

			//http://www.92egj.com/ding/login/skips?link=
			String tiaozhuan_url_new = "http://"+yuming+"/ding/login/skips?link="+URLEncoder.encode(tiaozhuan_url);
//			String tiaozhuan_url_new = URLEncoder.encode(tiaozhuan_url);
			jsFs = jsFs.replace("{tiaozhuan_url}",tiaozhuan_url_new);

			jsFs = jsFs.replace("{tihuan}", cv);

			//替换分解后的内容

			for (WechatEnum e : WechatEnum.values()) {
				System.out.println(e.toString());
				System.out.println(e.getIndex());
				System.out.println(e.getName());
				jsFs  = jsFs.replace("#*"+e.getIndex()+"*#",e.getName());
			}

			log.info("开始推送" + msg);
			log.info("开始推送" + jsFs);
			String token = wechatService.getToken(corpid, corpsecret);
			String postdata = createpostdataAll(userids, typeFs, applids, cv, jsFs,dataMsg.getTemName());
			wechatService.sendPost(postdata, token);
			//发送记录
			ZtMesssendlog ztMesssendlog = new ZtMesssendlog();

			ztMesssendlog.setChanTemp(typeFs);
			ztMesssendlog.setMessRec(ztMeOne.getMessRec());
//			ztMesssendlog.setMessCont(jsFs);
			ztMesssendlog.setMessCont(dataMsg.getMessage());
			ztMesssendlog.setMessDeliTime(LocalDateTime.now());
			ztMesssendlog.setPushChan("企业微信");
			ztMesssendlog.setMessClass(dataMsg.getTemType());
			ztMesssendlog.setTemName(dataMsg.getTemName());
			ztMesssendlog.setTempDataSou(tempId.toString());
			ztMesssendlog.setMessSour("企业微信");
			ztMesssendlog.setMessModel("售后");
//			ztMesssendlog.setLicense(dataMsg.getLicense());
//			ztMesssendlog.setFrame(dataMsg.getFrame());
//			ztMesssendlog.setCusNum(dataMsg.getCusNum());
//			ztMesssendlog.setMemLevel(dataMsg.getMemLevel());
			ztMesssendlog.setLicense(dataMsg.getLicense());
			ztMesssendlog.setFrame(dataMsg.getFrame());
			ztMesssendlog.setCusNum("");
			ztMesssendlog.setMemLevel("");
			ztMesssendlog.setClique("nanling");
			ztMesssendlog.setDld(dataMsg.getDld());
			ztMesssendlog.setAddDate(LocalDateTime.now());
			ztMesssendlog.setUpdDate(null);
			ztMesssendlog.setUserid("");
			ztMesssendlog.setUsername("");
			ztMesssendlog.setUseridUp("");
			ztMesssendlog.setUsernameUp("");
			Byte st = 0;
			ztMesssendlog.setIsRead(st);
			ztMesssendlog.setReadDate(null);
			log.info("添加数据"+ztMesssendlog);
			ztMesssendlogService.saveZtMesssendlog(ztMesssendlog);
			log.info("添加成功");
			log.info("推送完成" + msg);
		} catch (Exception e) {
			log.debug(e.getMessage());
		}

	}

	public static String  getUrl(String url) throws Exception{
		java.net.URL  urls = new  java.net.URL(url);
		String host = urls.getHost();// 获取主机名
		return host;// 结果 blog.csdn.net
	}

	/**
	 * @Title:创建微信发送请求post数据 touser发送消息接收者 ，msgtype消息类型（动态 创建）， application_id应用编号。
	 *                       本方法适用于动态类型创建传输数据
	 * @return String
	 */
	public String createpostdataAll(String touser, String msgtype, int application_id, String conval, String json,String temName) {
		log.info("创建数据");
		log.info("touser: " + touser);
		WeChatData<WeChatText> wcd = new WeChatData<>();
		wcd.setTouser(touser);
		wcd.setAgentid(application_id);
		wcd.setMsgtype(msgtype);
		// 把json 转为对象
		log.info("需要转的json: " + json);
		WeChatText dataMsg = com.edas.edascommon.utils.StringUtils.stringToBean(json, WeChatText.class);
		log.info("duix: " + dataMsg);
		String wMsgtype = WechatEnum.getName(msgtype);
		if (wMsgtype.equals("text")) {
			dataMsg.setContent("["+temName+"]"+dataMsg.getContent());
			wcd.setText(dataMsg);
		}
		if (wMsgtype.equals("textcard")) {
			dataMsg.setTitle(temName);
			dataMsg.setDescription("["+temName+"]"+dataMsg.getDescription());
			wcd.setTextcard(dataMsg);
		}
		log.info(wMsgtype);
		if (wMsgtype.equals("image")){
			wcd.setImage(dataMsg);
		}
		if (wMsgtype.equals("file")){
			wcd.setFile(dataMsg);
		}
		if(wMsgtype.equals("voice")){
			wcd.setVoice(dataMsg);
		}
		if(wMsgtype.equals("video")){
			wcd.setVideo(dataMsg);
		}
		if(wMsgtype.equals("news")){
			wcd.setNews(dataMsg);
		}
		if(wMsgtype.equals("markdown")){
			wcd.setMarkdown(dataMsg);
		}
		log.info("真正的数据传输"+wcd);
		String strData = JSON.toJSONString(wcd);
		log.info("WeChatData: " + strData);
		return strData;
	}

	public String sendPostAll(String corpid,String corpsecret,Integer applids,String userids,String typeFs,String cv,String jsFs ){
//		ZtConfigkey ztConfigkey = new ZtConfigkey();
//		ztConfigkey.setType("002");
//		ztConfigkey.setDld(dld);
//		log.info("这是查询密钥条件" + ztConfigkey);
//		ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);
//		log.info("这是密钥" + miyue);
//		if (miyue == null || miyue.getCorpid().length() == 0) {
//			log.info("找不到企业微信应用秘钥，请联系相关人员设置");
//		}
//
//		String cv = dataMsg.getMessage();
//		String corpid = miyue.getCorpid();
//		String corpsecret = miyue.getSecretKey();
//		String applid = miyue.getApplicationId();
//		Integer applids = Integer.parseInt(applid);
		String token = wechatService.getToken(corpid, corpsecret);
		String postdata = createpostdataAll(userids, typeFs, applids, cv, jsFs,"");
		wechatService.sendPost(postdata, token);
		return "ERROR";
	}



}