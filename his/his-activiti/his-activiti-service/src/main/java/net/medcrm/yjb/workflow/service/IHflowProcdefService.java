package net.medcrm.yjb.workflow.service;

import java.util.List;

import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import net.medcrm.yjb.his.feign.HflowProcdefVO;
import net.medcrm.yjb.workflow.domain.HflowProcdef;
import net.medcrm.yjb.workflow.dto.FlowDeployDto;
import net.medcrm.yjb.workflow.vo.HandleVO;
import net.medcrm.yjb.workflow.vo.HistoryVO;

public interface IHflowProcdefService {
	void save(HflowProcdef record)  throws  Exception;

	void update(HflowProcdef record);

	HflowProcdef findById(String id);
	
	List<HflowProcdef> findAllProcdef(String type,int pageNum, int pageSize,String modelId, String queryValue);
	
	/**
	 * 向上、向下排序
	 * @param currentId
	 * @param currentSort
	 * @param changeId
	 * @param changeSort
	 */
	void updateChangeSort(String currentId,String changeId);
	
	/**
	 * 停用
	 * @param id
	 * @param status
	 */
	int updateDisable(String id ,int status);
	
	List<FlowDeployDto> findAllDeploy(int type,String modelId );
	
	public List<HandleVO> getHandleHFlow(int type, String modelId, String userId, PageInfo<HandleVO> page,int[] pageParams) ;
	
	/**
	 * 经办列表
	 * @param type
	 * @param modelId
	 * @param userId
	 * @param page
	 * @param pageParams
	 * @return
	 */
	public List<HistoryVO> findHistoryFlow(int type, String modelId, String userId, PageInfo<HistoryVO> page,int[] pageParams);
	
	List<HflowProcdefVO> findAllList();
	
	/**
	 * 根据菜单查询所有
	 * @param modelId
	 * @return
	 */
	List<String> getProcdefIdByModelId(String modelId);
	
	HflowProcdef saveByActModel(Model model,String user,String description);
	
	public HflowProcdef saveHflowProcdef(Model model, ProcessDefinition processDefinition ,String dec) throws Exception;
	
	HflowProcdef findByPrimaryKeyType(String actKey, Integer type);
	
	public int updateDisableByPro(String proId, int status);
	
	public HflowProcdef findProcdefInfo(String id);
	
}
