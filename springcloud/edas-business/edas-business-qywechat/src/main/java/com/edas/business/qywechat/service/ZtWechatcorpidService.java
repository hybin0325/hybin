package com.edas.business.qywechat.service;

import com.edas.business.qywechat.entity.ZtWechatcorpid;
import com.edas.edascommon.core.Service;

/**
 * @Description: ShopwwiZtWechatcorpidService接口
 * @author zwx
 * @date 2019/01/25 16:07
 */
public interface ZtWechatcorpidService extends Service<ZtWechatcorpid> {


	public void snderWechat(String msg);
}
