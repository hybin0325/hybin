package net.medcrm.yjb.workflow.service;

import java.util.List;

import net.medcrm.yjb.workflow.domain.HflowDraftBox;

public interface IHflowDraftBoxService {
	void save(HflowDraftBox record);
	void delete(String id);
	List<HflowDraftBox> findAll(String userId,String queryValue,int pageNum, int pageSize);
	HflowDraftBox findById(String id);
}
