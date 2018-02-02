package net.medcrm.yjb.workflow.service;

import net.medcrm.yjb.workflow.domain.HflowCustomTable;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;

import java.util.List;

/**
 * Created by linsheng on 2017/12/26.
 */
public interface HflowCustomTableService {

    public List<HflowCustomTable> select();
    public List<HflowCustomTable> selectByFlowIdAndNodeId(String flowId, String flowNodeId);
    public HflowCustomTable selectByPrimaryKey(String id);
    public int insert(HflowCustomTable hflowCustomTable);
    public int update(HflowCustomTable hflowCustomTable);
    public int delete(String id);
}
