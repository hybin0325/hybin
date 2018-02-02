package net.medcrm.yjb.workflow.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import net.medcrm.yjb.workflow.domain.Shenpi;
import net.medcrm.yjb.workflow.vo.ShenpiVO;

public interface IShenpiService {

	public ProcessInstance startWorkflow(Shenpi entity, Map<String, Object> variables);

	/**
	 * 查询待办任务
	 *
	 * @param userId
	 *            用户ID
	 * @return
	 */
	public PageInfo<ShenpiVO> findTodoTasks(String userId, PageInfo<ShenpiVO> page, int[] pageParams);

	/**
	 * 读取运行中的流程
	 *
	 * @return
	 */
	public List<Shenpi> findRunningProcessInstaces(PageInfo<Shenpi> page, int[] pageParams);

}
