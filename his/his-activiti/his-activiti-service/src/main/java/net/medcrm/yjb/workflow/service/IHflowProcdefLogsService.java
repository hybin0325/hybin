package net.medcrm.yjb.workflow.service;

public interface IHflowProcdefLogsService {
	void save(String acReprodId, String user);

	void update(String acReprodId, String user);
	
	void saveOrUpdate(String acReprodId, String user);
	
	/**
	 * 向上、向下排序
	 * @param currentId
	 * @param currentSort
	 * @param changeId
	 * @param changeSort
	 */
	String updateChangeSort(String currentId,String changeId);
}
