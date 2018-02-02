package net.medcrm.yjb.workflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import net.medcrm.yjb.workflow.domain.HflowDraftBox;
import net.medcrm.yjb.workflow.mapper.HflowDraftBoxMapper;
import net.medcrm.yjb.workflow.service.IHflowDraftBoxService;

@Service
public class HflowDraftBoxServiceImpl implements IHflowDraftBoxService {
	
	@Autowired
	private HflowDraftBoxMapper flowDraftBoxMapper;

	@Override
	@Transactional
	public void save(HflowDraftBox record) {
		record.createPersistentObject();
		flowDraftBoxMapper.insert(record);
	}

	@Override
	@Transactional
	public void delete(String id) {
		flowDraftBoxMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<HflowDraftBox> findAll(String userId,String queryValue,int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<HflowDraftBox> list= flowDraftBoxMapper.selectAll(userId,queryValue);
		return list;
	}

	@Override
	public HflowDraftBox findById(String id) {
		return flowDraftBoxMapper.selectByPrimaryKey(id);
	}

}
