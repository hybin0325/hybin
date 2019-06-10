package com.edas.business.qywechat.entity.req;

import lombok.Data;

/**
 * 
 * @ClassName: MessageConfDTO
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author nl
 * @date 2019年4月19日
 *
 */
@Data
public class MessageConfDTO {
	private Integer id;

	/**
	 * 类型 001门店 002钉钉 003微信
	 */
	private String typeKey;

	/**
	 * 值
	 */
	private String commKey;

	/**
	 * 所属门店
	 */
	private String dld;

	/**
	 * 所属集团
	 */
	private String clique;
}
