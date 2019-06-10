package com.edas.business.qywechat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.edas.business.qywechat.entity.WxError;
import com.edas.business.qywechat.enums.WxType;
import com.edas.business.qywechat.exception.WxErrorException;
import com.edas.business.qywechat.exception.WxErrorType;
import com.edas.business.qywechat.exception.WxException;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * File Name: AbstractWxService.java
 * </p>
 * <p>
 * Description: 微信公众号父类
 * </p>
 * <p>
 * Date：2019年5月21日
 * </p>
 * 
 * @version 1.0
 * @author <a href="zzwovo@126.com">zzw</a>
 */
@Slf4j
public abstract class AbstractWxService {

	// *********************************微信公众号WXMP*********************
	/**
	 * 获取access_token.
	 */
	protected static final String WXMP_GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

	/**
	 * 获得各种类型的ticket.
	 */
	protected static final String WXMP_GET_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=";

	/**
	 * 长链接转短链接接口.
	 */
	protected static final String WXMP_SHORTURL_API_URL = "https://api.weixin.qq.com/cgi-bin/shorturl";

	/**
	 * 语义查询接口.
	 */
	protected static final String WXMP_SEMANTIC_SEMPROXY_SEARCH_URL = "https://api.weixin.qq.com/semantic/semproxy/search";

	/**
	 * 用code换取oauth2的access token.
	 */
	protected static final String WXMP_OAUTH2_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

	/**
	 * 刷新oauth2的access token.
	 */
	protected static final String WXMP_OAUTH2_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%s&grant_type=refresh_token&refresh_token=%s";

	/**
	 * 用oauth2获取用户信息.
	 */
	protected static final String WXMP_OAUTH2_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s";

	/**
	 * 验证oauth2的access token是否有效.
	 */
	protected static final String WXMP_OAUTH2_VALIDATE_TOKEN_URL = "https://api.weixin.qq.com/sns/auth?access_token=%s&openid=%s";

	/**
	 * 获取微信服务器IP地址.
	 */
	protected static final String WXMP_GET_CALLBACK_IP_URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip";

	/**
	 * 第三方使用网站应用授权登录的url.
	 */
	protected static final String WXMP_QRCONNECT_URL = "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";

	/**
	 * oauth2授权的url连接.
	 */
	protected static final String WXMP_CONNECT_OAUTH2_AUTHORIZE_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s&connect_redirect=1#wechat_redirect";

	/**
	 * 获取公众号的自动回复规则.
	 */
	protected static final String WXMP_GET_CURRENT_AUTOREPLY_INFO_URL = "https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info";

	/**
	 * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零.
	 */
	protected static final String WXMP_CLEAR_QUOTA_URL = "https://api.weixin.qq.com/cgi-bin/clear_quota";

	/**
	 * 公众号模板消息前缀.
	 */
	protected static final String WXMP_TEMPLATE_MSG_PREFIX = "https://api.weixin.qq.com/cgi-bin/message/template/";

	// *********************************微信公众号*********************

	// *********************************微信小程序WXMA*********************
	
	// 获取小程序模板库标题列表
	protected static final String WXMA_TEMPLATE_LIBRARY_LIST_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/library/list";

	// 获取模板库某个模板标题下关键词库
	protected static final String WXMA_TEMPLATE_LIBRARY_KEYWORD_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/library/get";

	// 组合模板并添加至帐号下的个人模板库
	protected static final String WXMA_TEMPLATE_ADD_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/add";

	// 获取帐号下已存在的模板列表
	protected static final String WXMA_TEMPLATE_LIST_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/list";

	// 删除帐号下的某个模板
	protected static final String WXMA_TEMPLATE_DEL_URL = "https://api.weixin.qq.com/cgi-bin/wxopen/template/del";

	// 发送模板消息
	protected static final String WXMA_TEMPLATE_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send";
	
	// *********************************微信小程序*********************
	
	protected static final int retrySleepMillis = 1000;

	protected static final int maxRetryTimes = 2;

	@Autowired
	private RestTemplate restTemplate;

	protected String post(String appId, String appSecret, String url, String postData, WxType type) throws WxErrorException {
		int retryTimes = 0;
		do {
			try {				
				return executeInternal(appId, appSecret, url, postData, type);
			} catch (WxErrorException e) {				
				if (retryTimes + 1 > maxRetryTimes) {
					log.warn("重试达到最大次数【{}】", maxRetryTimes);
					// 最后一次重试失败后，直接抛出异常，不再等待
					throw e;
					//new WxException(WxErrorType.WX_ERROR)
				}
				WxError error = e.getError();
				// -1 系统繁忙, 1000ms后重试				
				if (error.getErrorCode() == -1) {
					int sleepMillis = retrySleepMillis * (1 << retryTimes);
					try {
						log.warn("微信系统繁忙，{} ms 后重试(第{}次)", sleepMillis, retryTimes + 1);
						Thread.sleep(sleepMillis);
					} catch (InterruptedException e1) {
						throw new WxException();
					}
				}else {
					throw e;
				}
			}
		} while (retryTimes++ < maxRetryTimes);
		log.warn("重试达到最大次数【{}】", maxRetryTimes);
		throw new WxException(WxErrorType.WX_ERROR);
	}
	
	/**
	   * <pre>
	   * 获取access_token
	   * </pre>
	   *
	   */
	protected String getAccessToken(String appId, String appSecret, WxType type) {
		//这里暂时这样，后续会改
		if(type == WxType.MP) {			 
			String url = "http://www.92egj.com/foreign/Weixin/access_token_info";
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "text/plain;charset=UTF-8");
			headers.add("appid", appId);
			headers.add("appsecret", appSecret);
			HttpEntity<String> formEntity = new HttpEntity<>(null, headers);			
			String result = restTemplate.postForEntity(url, formEntity, String.class).getBody();
			return result;
		}
		if(type == WxType.MiniApp) {			
			return  "22_IANr_SfUYbiBNYYk6DRqBA3n5Y9GVCTjZE7bDscmKDWuNpXcsJgYOl42q1vYpyObuBONa_7pRi2QYGwfRBf0iOvTjC-QGmsbUp5giWJhVD8N6eO2rRiSil10Ce5bskX344PNZ5Zjj38Hx3TUSNQfAIAYTW";				
		}
		return null;
	}
	
	protected String executeInternal(String appId, String appSecret, String uri, String data, WxType type) throws WxErrorException {
		String accessToken = getAccessToken(appId, appSecret, type);
	    String uriWithAccessToken = uri + "?access_token=" + accessToken;	    
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/plain;charset=UTF-8");
		HttpEntity<String> formEntity = new HttpEntity<>(data, headers);
		try {			
			String result = restTemplate.postForEntity(uriWithAccessToken, formEntity, String.class).getBody();
			log.info("\n【请求地址】: {}\n【响应数据】：{}", uriWithAccessToken, result);		
			
			if (result.isEmpty()) {			
				throw new WxErrorException(WxError.builder().errorCode(9999).errorMsg("无响应内容").build());
			}
			// xml格式输出直接返回
			if (result.startsWith("<xml>")) {
				return result;
			}
			WxError error = WxError.fromJson(result, type);
			if (error.getErrorCode() != 0) {
				throw new WxErrorException(error);
			}
			return result;		
		}catch(WxErrorException e) {
			WxError error = e.getError();
			if(error.getErrorCode() == 42001 || error.getErrorCode() == 40001 || error.getErrorCode() == 40014){
				/*
			       * 发生以下情况时尝试刷新access_token
			       * 40001 获取access_token时AppSecret错误，或者access_token无效
			       * 42001 access_token超时
			       * 40014 不合法的access_token，请开发者认真比对access_token的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口
			       */				      
			    //access token过期，重新请求，可以刷新access token，这里先注释，token逻辑没未定		
				//return post(appId, appSecret, uri, data, type);
			}
			if (error.getErrorCode() != 0) {		        
		        throw new WxErrorException(error, e);
		      }
		      return null;
		}
	}

	protected String get(String url, String queryParam) {

		return null;
	}
}