package com.edas.business.dingtalk.service.impl;

import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edas.business.dingtalk.entity.*;
import com.edas.business.dingtalk.service.ZtConfigkeyService;
import com.edas.business.dingtalk.service.ZtMessreciService;

import com.edas.business.dingtalk.service.ZtMesssendlogService;
import org.springframework.stereotype.Service;

import com.edas.business.dingtalk.core.AbstractServices;

import com.edas.business.dingtalk.dingding.DingDingMess;

import com.edas.business.dingtalk.enums.DingtalkEnum;
import com.edas.edascommon.model.MQDataMsg;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShopwwiZtDingdingcorpidServiceImpl extends AbstractServices<ShopwwiZtDingdingcorpid>
		implements ShopwwiZtDingdingcorpidService {



	@Resource
	private ZtConfigkeyService ztConfigkeyService;

	@Resource
	private ZtMessreciService ztMessreciService;
	@Resource
	private ZtMesssendlogService ztMesssendlogService;

	/**
	 * 发送到钉钉
	 */
	public void snderDingTalk(String msg)  {
		log.info("钉钉进来了"+msg+"钉钉");

		MQDataMsg dataMsg= com.edas.edascommon.utils.StringUtils.stringToBean(msg, MQDataMsg.class);

		String dld = dataMsg.getDld();

		String type = dataMsg.getMesstempType();
		String jsonStr = dataMsg.getMesstempTypeMessage();
		log.info("这是最原始的 jsonstr"+jsonStr);
		Integer tempId = dataMsg.getMesstempId();

//		dld = "GS";
//		tempId = 3;

		try {
//		DingDingMess ddm = new DingDingMess();
//		String users = "manager7705";
		String users = "061329325439962625";
//		ShopwwiZtDingdingcorpid miyue = selectBy("dld",dld);

		ZtMessreci ztMessreci = new ZtMessreci();
		ztMessreci.setMesstempId(tempId);
		ztMessreci.setDld(dld);

		ZtMessreci ztMeOne = ztMessreciService.findZtMessreciByDld(ztMessreci);

		users = ztMeOne.getMessRec(); // 按接收人接收


		ZtConfigkey ztConfigkey = new ZtConfigkey();
		ztConfigkey.setType("001");
		ztConfigkey.setDld(dld);

		ZtConfigkey miyue = ztConfigkeyService.findZtConfigkeyByDld(ztConfigkey);

		String appkey = miyue.getCorpid();
        String appsec = miyue.getSecretKey();
        String agentid = miyue.getApplicationId();



//			Map<Object, Object> content = new HashMap<Object, Object>();
//			Map<Object, Object> cnew = new HashMap<Object, Object>();
//			Map<Object, Object> ns = new HashMap<Object, Object>();
//			Map<Object, Object> nt = new HashMap<Object, Object>();
//
//			Map<Object, Object> rich = new HashMap<Object, Object>();
//
//			List<Object> list = new ArrayList<>();
//
//			cnew.put("message_url","http://www.baidu.com");
////        cnew.put("content","大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本");
//
//			ns.put("bgcolor","FFBBBBBB");
//			ns.put("text","头部标题");
//			nt.put("title","正文标题");
//			nt.put("content","大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本大段文本");
////        nt.put("from",list);
////        nt.put("rich",rich);
//			cnew.put("head",ns);
//			cnew.put("body",nt);
//			content.put("msgtype","oa");
//			content.put("oa",cnew);

        Map<Object, Object> content = new HashMap<Object, Object>();
        Map<Object, Object> cnew = new HashMap<Object, Object>();
        //文本消息
//		final String timeStamp = String.valueOf(System.currentTimeMillis() / 1000);
			for (DingtalkEnum e : DingtalkEnum.values()) {

				jsonStr  = jsonStr.replace("#*"+e.getIndex()+"*#",e.getName());
			}
			String vvf = dataMsg.getMessage() ;
			jsonStr  = jsonStr.replace("{tihuan}",vvf);
			log.info("这是替换了内容的 jsonStr"+jsonStr);

			if(type.equals("textcard")){
				String tiaozhuan_url = "http://www.92egj.com/ding/Gjbcgjao/tiaozhuan.html?dld=|dld|&license=|license|&type=3";
				log.info("这是 url "+tiaozhuan_url);
				try{
					tiaozhuan_url = dataMsg.getTiaozhuanUrl();
				}catch (Exception es) {
					log.error("跳转链接报错:"+es.getMessage());
				}
				if (tiaozhuan_url == null || tiaozhuan_url.trim().length() == 0){
					tiaozhuan_url = "http://www.92egj.com/ding/Gjbcgjao/tiaozhuan.html?dld=|dld|&license=|license|&type=3";
				}

				log.info("这是原始 jsonstr "+jsonStr);
				log.info("这是 url "+tiaozhuan_url);
				tiaozhuan_url = tiaozhuan_url.replace("|license|",dataMsg.getLicense());
				tiaozhuan_url = tiaozhuan_url.replace("|dld|",dataMsg.getDld());
				tiaozhuan_url = tiaozhuan_url.replace("|frame|",dataMsg.getFrame());
				log.info("这是替换了车牌和dld 的 url" + tiaozhuan_url);
				String yuming = getUrl(tiaozhuan_url);
				log.info("域名是"+yuming);
				//http://www.92egj.com/ding/skips/index.html?link=
				String tiaozhuan_url_new = "http://"+yuming+"/ding/skips/index.html?link="+ URLEncoder.encode(tiaozhuan_url);
//			String tiaozhuan_url_new = URLEncoder.encode(tiaozhuan_url);
				Map<Object, Object> nt = new HashMap<Object, Object>();
				Map<Object, Object> ns = new HashMap<Object, Object>();
				jsonStr = jsonStr.replace("{tiaozhuan_url}","");
				TextCardData txc= com.edas.edascommon.utils.StringUtils.stringToBean(jsonStr, TextCardData.class);
				cnew.put("message_url",tiaozhuan_url_new);
//				nt.put("");
				log.info("获取到的 title" + dataMsg.getTemName());
				log.info("获取到的 内容" + txc.getMarkdown());
//				nt.put("title",txc.getTitle());
//				nt.put("title","");
//				nt.put("title",txc.getMarkdown());
				nt.put("content","["+dataMsg.getTemName()+"]"+txc.getMarkdown());
//				ns.put("bgcolor","FFBBBBBB");
				ns.put("text","头部标题");
				cnew.put("head",ns);
				cnew.put("body",nt);
				jsonStr = JSON.toJSONString(cnew);

//				nt.put("")
				log.info("这是替换了url 的jsonstr"+jsonStr);
			}else{
				log.info("这是原始 jsonstr "+jsonStr);
//				String tiaozhuan_url = dataMsg.getTiaozhuanUrl();
				TextCardData txc= com.edas.edascommon.utils.StringUtils.stringToBean(jsonStr, TextCardData.class);
				cnew.put("content","["+dataMsg.getTemName()+"]"+txc.getContent());
				jsonStr = JSON.toJSONString(cnew);

//				tiaozhuan_url = tiaozhuan_url.replace("|license|",dataMsg.getLicense());
//				tiaozhuan_url = tiaozhuan_url.replace("|dld|",dataMsg.getDld());
//				//http://www.92egj.com/ding/skips/index.html?link=
//				String tiaozhuan_url_new = "http://www.92egj.com/ding/skips/index.html?link="+ URLEncoder.encode(tiaozhuan_url);
////			String tiaozhuan_url_new = URLEncoder.encode(tiaozhuan_url);
//				jsonStr = jsonStr.replace("{tiaozhuan_url}",tiaozhuan_url_new);
				log.info("这是替换了url 的jsonstr"+jsonStr);
			}



		//替换分解后的内容

//		jsonStr = jsonStr.replace("|license|",dataMsg.getLicense());
//		jsonStr = jsonStr.replace("|dld|",dataMsg.getDld());


			JSONObject jsonStrs = JSON.parseObject(jsonStr);
		log.info("这里是 jsstr"+jsonStr);

//        cnew.put("content",vvf);
//			String type1 = 	DingtalkEnum.getName(type);
//        cnew.put("content",vvf);
		String type1 = 	DingtalkEnum.getName(type);
        content.put("msgtype",type1);


        content.put(type1,jsonStrs);


        Integer agentids = Integer.parseInt(agentid);
        String  uslist = users;
		log.info("钉钉开始推送"+jsonStr);

        String Results = DingDingMess.main(appkey,appsec,uslist,agentids,content,0);
//发送记录
			ZtMesssendlog ztMesssendlog = new ZtMesssendlog();

			ztMesssendlog.setChanTemp(type);
			ztMesssendlog.setMessRec(ztMeOne.getMessRec());
			ztMesssendlog.setMessCont(dataMsg.getMessage());
//			ztMesssendlog.setMessCont(jsonStr);

			ztMesssendlog.setMessDeliTime(LocalDateTime.now());
			ztMesssendlog.setPushChan("钉钉");
			ztMesssendlog.setMessClass(dataMsg.getTemType());
			ztMesssendlog.setTemName(dataMsg.getTemName());
			ztMesssendlog.setTempDataSou(tempId.toString());
			ztMesssendlog.setMessSour("钉钉");
			ztMesssendlog.setMessModel("售后");
			ztMesssendlog.setLicense(dataMsg.getLicense());
			ztMesssendlog.setFrame(dataMsg.getFrame());
//			ztMesssendlog.setCusNum(dataMsg.getCusNum());
//			ztMesssendlog.setMemLevel(dataMsg.getMemLevel());
//			ztMesssendlog.setLicense("");
//			ztMesssendlog.setFrame("");
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
        log.info("钉钉推送完成"+jsonStr);
		}catch (Exception e) {
			
		}
	}

	public static String  getUrl(String url) throws Exception{
		java.net.URL  urls = new  java.net.URL(url);
		String host = urls.getHost();// 获取主机名
		return host;// 结果 blog.csdn.net
	}
}
