package net.medcrm.yjb.workflow.service;

import net.medcrm.yjb.workflow.domain.HflowCustomRealTemplate;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by linsheng on 2017/12/26.
 */
public interface HflowCustomRealTemplateService {

    public List<HflowCustomRealTemplate> select();
    public HflowCustomRealTemplate selectByPrimaryKey(String id);
    public HflowCustomRealTemplate selectByFlowIdAndNodeId(@Param("flowId")String flowId, @Param("nodeId")String nodeId);
    public int insert(HflowCustomRealTemplate hflowCustomRealTemplate);
    public int update(HflowCustomRealTemplate hflowCustomRealTemplate);
    public int delete(String id);
}
