package net.medcrm.yjb.workflow.service.impl;

import net.medcrm.yjb.workflow.domain.HflowCustomTable;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import net.medcrm.yjb.workflow.mapper.HflowCustomTableMapper;
import net.medcrm.yjb.workflow.mapper.HflowCustomTemplateMapper;
import net.medcrm.yjb.workflow.service.HflowCustomTableService;
import net.medcrm.yjb.workflow.service.HflowCustomTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by linsheng on 2017/12/26.
 */
@Service(value = "hflowCustomTableService")
@Transactional
public class HflowCustomTableServiceImpl implements HflowCustomTableService {

    @Autowired
    private HflowCustomTableMapper hflowCustomTableMapper;
    @Override
    public List<HflowCustomTable> select() {
        return hflowCustomTableMapper.select();
    }

    @Override
    public HflowCustomTable selectByPrimaryKey(String id) {
        return hflowCustomTableMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(HflowCustomTable hflowCustomTable) {
        hflowCustomTable.setId(hflowCustomTable.getId() == null ? UUID.randomUUID().toString(): hflowCustomTable.getId());
        return hflowCustomTableMapper.insert(hflowCustomTable);
    }

    @Override
    public int update(HflowCustomTable hflowCustomTable) {
        return hflowCustomTableMapper.update(hflowCustomTable);
    }

    @Override
    public int delete(String id) {
        return hflowCustomTableMapper.delete(id);
    }
    @Override
    public List<HflowCustomTable> selectByFlowIdAndNodeId(String flowId, String flowNodeId){
        return hflowCustomTableMapper.selectByFlowIdAndNodeId(flowId, flowNodeId);
    }
}
