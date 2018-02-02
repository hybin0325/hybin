package net.medcrm.yjb.workflow.mapper;

import net.medcrm.yjb.workflow.domain.HflowCustomTable;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by linsheng on 2017/12/26.
 */
public interface HflowCustomTableMapper {

    public List<HflowCustomTable> select();
    public List<HflowCustomTable> selectByFlowIdAndNodeId(@Param("flowId") String flowId, @Param("flowNodeId") String flowNodeId);
    public HflowCustomTable selectByPrimaryKey(String id);
    public int insert(HflowCustomTable hflowCustomTable);
    public int update(HflowCustomTable hflowCustomTable);
    public int delete(String id);
}
