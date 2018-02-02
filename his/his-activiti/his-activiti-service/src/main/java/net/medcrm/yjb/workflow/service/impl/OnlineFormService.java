package net.medcrm.yjb.workflow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.medcrm.yjb.workflow.dto.OnlineForm;
import net.medcrm.yjb.workflow.mapper.OnlineFormMapper;
import net.medcrm.yjb.workflow.service.IOnlineFormService;

@Service
public class OnlineFormService implements IOnlineFormService {
	
	@Autowired
	private OnlineFormMapper mapper;

	@Override
	public void delete(OnlineForm obj) {
	
	}

	@Override
	public void design(OnlineForm obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(OnlineForm obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(OnlineForm obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OnlineForm> list(OnlineForm obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
