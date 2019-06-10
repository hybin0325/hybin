package com.edas.business.qywechat.service.impl;


import com.edas.business.qywechat.dao.master.CxxmMapper;
import com.edas.business.qywechat.entity.Cxxm;
import com.edas.business.qywechat.service.CxxmService;
import com.edas.edascommon.core.AbstractServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: CxxmServiceImpl接口实现类
 * @author hjx
 * @date 2019/04/10 15:40
 */
@Slf4j
@Service
public class CxxmServiceImpl extends AbstractServices<Cxxm> implements CxxmService {

	@Resource
	private CxxmMapper CxxmMapper;



	public List<Cxxm> getDataByTbname(String  tbname){


		List<Cxxm> Cxxms= selectListBy("tbname",tbname);

		return Cxxms;
	};

	public void sendMsg(String message) {

	}
}