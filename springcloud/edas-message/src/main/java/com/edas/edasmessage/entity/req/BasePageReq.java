package com.edas.edasmessage.entity.req;

import javax.persistence.Transient;

import lombok.Data;

@Data
public class BasePageReq {
	@Transient
	private int pageNo=1;
	@Transient
	private int pageSize=10;
}
