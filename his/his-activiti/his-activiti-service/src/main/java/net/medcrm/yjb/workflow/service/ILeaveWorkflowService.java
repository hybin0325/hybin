package net.medcrm.yjb.workflow.service;

import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

import net.medcrm.yjb.workflow.domain.Leave;

public interface ILeaveWorkflowService {
	 /**
     * 启动流程
     *
     * @param entity
     */
    public ProcessInstance startWorkflow(Leave entity, Map<String, Object> variables);

    /**
     * 查询待办任务
     *
     * @param userId 用户ID
     * @return
     */
    public List<Leave> findTodoTasks(String userId, PageInfo<Leave> page, int[] pageParams);

    /**
     * 读取运行中的流程
     *
     * @return
     */
    public List<Leave> findRunningProcessInstaces(PageInfo<Leave> page, int[] pageParams);

    /**
     * 读取已结束中的流程
     *
     * @return
     */
    List<Leave> findFinishedProcessInstaces(PageInfo<Leave> page, int[] pageParams) ;
    
    public Leave findById(String id);

}
