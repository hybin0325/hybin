package net.medcrm.yjb.workflow.service;

import java.util.List;

import net.medcrm.yjb.workflow.dto.OnlineForm;

public interface IOnlineFormService {
	void delete(OnlineForm obj);
	void design(OnlineForm obj);
	void save(OnlineForm obj);
	void update(OnlineForm obj);
	List<OnlineForm> list(OnlineForm obj);
}
