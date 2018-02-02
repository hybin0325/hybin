package net.medcrm.yjb.workflow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.medcrm.yjb.workflow.domain.HflowModelProcdef;
import net.medcrm.yjb.workflow.mapper.HflowModelProcdefMapper;
import net.medcrm.yjb.workflow.service.IHflowModelProcdefService;
import net.medcrm.yjb.workflow.util.StringUtils;

@Service
public class HflowModelProcdefServiceImpl implements IHflowModelProcdefService {

	@Autowired
	private HflowModelProcdefMapper modelProcdefMapper;

	@Override
	@Transactional
	public void saveModelProcdef(String modelId, String proId) {
		HflowModelProcdef modelProcdef = modelProcdefMapper.selectProcdefByModelId(modelId, proId);
		if (StringUtils.isNotNull(modelId)&& StringUtils.isNotNull(proId) && StringUtils.isNull(modelProcdef)) {
			HflowModelProcdef hmp = new HflowModelProcdef();
			hmp.createPersistentObject();
			hmp.sethModel(modelId);
			hmp.sethProcdefId(proId);
			modelProcdefMapper.insert(hmp);
		}
	}

}
