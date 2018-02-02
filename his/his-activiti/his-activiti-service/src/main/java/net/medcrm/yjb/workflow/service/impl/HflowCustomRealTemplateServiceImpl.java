package net.medcrm.yjb.workflow.service.impl;

import net.medcrm.yjb.workflow.domain.HflowCustomRealTemplate;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import net.medcrm.yjb.workflow.mapper.HflowCustomRealTemplateMapper;
import net.medcrm.yjb.workflow.mapper.HflowCustomTemplateMapper;
import net.medcrm.yjb.workflow.service.HflowCustomRealTemplateService;
import net.medcrm.yjb.workflow.service.HflowCustomTemplateService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by linsheng on 2017/12/26.
 */
@Service(value = "hflowCustomRealTemplateService")
@Transactional
public class HflowCustomRealTemplateServiceImpl implements HflowCustomRealTemplateService {

    @Autowired
    private HflowCustomRealTemplateMapper hflowCustomRealTemplateMapper;
    @Override
    public List<HflowCustomRealTemplate> select() {
        return hflowCustomRealTemplateMapper.select();
    }

    @Override
    public HflowCustomRealTemplate selectByPrimaryKey(String id) {
        return hflowCustomRealTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(HflowCustomRealTemplate hflowCustomRealTemplate) {
        hflowCustomRealTemplate.setCreateDate(new Date());
        hflowCustomRealTemplate.setUpdateDate(new Date());
        hflowCustomRealTemplate.setId(hflowCustomRealTemplate.getId() == null ? UUID.randomUUID().toString() : hflowCustomRealTemplate.getId());
        return hflowCustomRealTemplateMapper.insert(hflowCustomRealTemplate);
    }

    @Override
    public int update(HflowCustomRealTemplate hflowCustomRealTemplate) {

        hflowCustomRealTemplate.setUpdateDate(new Date());
        return hflowCustomRealTemplateMapper.update(hflowCustomRealTemplate);
    }

    @Override
    public int delete(String id) {
        return hflowCustomRealTemplateMapper.delete(id);
    }

    @Override
    public HflowCustomRealTemplate selectByFlowIdAndNodeId(@Param("flowId")String flowId, @Param("nodeId")String nodeId){
        return hflowCustomRealTemplateMapper.selectByFlowIdAndNodeId(flowId,nodeId);
    }
}
