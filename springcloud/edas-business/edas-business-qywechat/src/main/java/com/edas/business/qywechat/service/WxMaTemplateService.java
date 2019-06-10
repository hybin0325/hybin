package com.edas.business.qywechat.service;

import java.util.List;

import com.edas.business.qywechat.entity.template.WxMaTemplateAddResult;
import com.edas.business.qywechat.entity.template.WxMaTemplateLibraryGetResult;
import com.edas.business.qywechat.entity.template.WxMaTemplateLibraryListResult;
import com.edas.business.qywechat.entity.template.WxMaTemplateListResult;
import com.edas.business.qywechat.exception.WxErrorException;

/**
 * <p>
 * File Name: WxMaTemplateService.java
 * </p>
 * <p>
 * Description: 小程序模板消息Service
 * </p>
 * <p>
 * Date：2019年5月21日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
public interface WxMaTemplateService {

	/**
	 * <pre>
	 * 获取小程序模板库标题列表
	 *
	 * 详情请见: <a href=
	"https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1500465446_j4CgR&token=&lang=zh_CN">获取小程序模板库标题列表</a>
	 * 接口url格式: https://api.weixin.qq.com/cgi-bin/wxopen/template/library/list?access_token=ACCESS_TOKEN
	 * </pre>
	 * 
	 * @param offset
	 * @param count
	 * @return
	 */
	WxMaTemplateLibraryListResult findTemplateLibraryList(int offset, int count) throws WxErrorException;

	/**
	 * <pre>
	 * 获取模板库某个模板标题下关键词库
	 *
	 * 详情请见: <a href=
	"https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1500465446_j4CgR&token=&lang=zh_CN">获取小程序模板库标题列表</a>
	 * 接口url格式: https://api.weixin.qq.com/cgi-bin/wxopen/template/library/get?access_token=ACCESS_TOKEN
	 * </pre>
	 * 
	 * @param id
	 * @return
	 */
	WxMaTemplateLibraryGetResult findTemplateLibraryKeywordList(String id) throws WxErrorException;

	/**
	 * <pre>
	 * 组合模板并添加至帐号下的个人模板库
	 *
	 * 详情请见: <a href=
	"https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1500465446_j4CgR&token=&lang=zh_CN">获取小程序模板库标题列表</a>
	 * 接口url格式: https://api.weixin.qq.com/cgi-bin/wxopen/template/add?access_token=ACCESS_TOKEN
	 * </pre>
	 * 
	 * @param id
	 * @param keywordIdList
	 * @return
	 */
	WxMaTemplateAddResult addTemplate(String id, List<Integer> keywordIdList) throws WxErrorException;

	/**
	 * <pre>
	 * 获取帐号下已存在的模板列表
	 *
	 * 详情请见: <a href=
	"https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1500465446_j4CgR&token=&lang=zh_CN">获取小程序模板库标题列表</a>
	 * 接口url格式: https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token=ACCESS_TOKEN
	 * </pre>
	 * 
	 * @param offset
	 * @param count
	 * @return
	 */
	WxMaTemplateListResult findTemplateList(int offset, int count) throws WxErrorException;

	/**
	 * <pre>
	 * 删除帐号下的某个模板
	 *
	 * 详情请见: <a href=
	"https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1500465446_j4CgR&token=&lang=zh_CN">获取小程序模板库标题列表</a>
	 * 接口url格式: https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token=ACCESS_TOKEN
	 * </pre>
	 * 
	 * @param templateId
	 */
	boolean delTemplate(String templateId) throws WxErrorException;
	
	/**
	 * <pre>
	 * 发送模板消息
	 *
	 * 接口url格式: https://api.weixin.qq.com/cgi-bin/wxopen/template/send?access_token=ACCESS_TOKEN
	 * </pre>
	 * 
	 * @param templateMessage
	 */
	void sendTemplateMsg(String appId, String appSecret, String templateMessage) throws WxErrorException;
}
