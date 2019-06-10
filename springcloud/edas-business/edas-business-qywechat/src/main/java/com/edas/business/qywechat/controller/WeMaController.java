package com.edas.business.qywechat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.qywechat.entity.template.WxMaTemplateData;
import com.edas.business.qywechat.entity.template.WxMaTemplateMessage;
import com.edas.business.qywechat.rabbitmq.WxMaMsgSender;
import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: WeMaController.java
 * </p>
 * <p>
 * Description: 小程序controller
 * </p>
 * <p>
 * Date：2019年6月4日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
@RestController
@RequestMapping("wxma")
public class WeMaController {

	@Autowired
	private WxMaMsgSender wxMaMsgSender;

	/**
	 * 
	 * @Description: 发送mq消息
	 *
	 */
	@GetMapping("/sendMq")
	public String sendMq() {
		WxMaTemplateMessage mess = WxMaTemplateMessage.builder().toUser("xxx").templateId("xxx").formId("FORMID")
				.data(Lists.newArrayList(new WxMaTemplateData("keyword1", "339208499"),
						new WxMaTemplateData("keyword2", "粤海喜来登酒店"), new WxMaTemplateData("keyword3", "xxxx"),
						new WxMaTemplateData("keyword4", "广州市天河区天河路208号")))
				.emphasisKeyword("keyword1.DATA").build();

		log.info("message  " + mess.toJson());
		try {
			wxMaMsgSender.sendDataMsg("xxxxxxxx", mess.toJson(), "wxmaExchage", "wxma.queue");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ok";
	}
}
