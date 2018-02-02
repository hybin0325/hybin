package net.medcrm.yjb.workflow.service.impl;

import net.medcrm.yjb.workflow.domain.HflowCustomField;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import net.medcrm.yjb.workflow.mapper.HflowCustomFieldMapper;
import net.medcrm.yjb.workflow.mapper.HflowCustomTemplateMapper;
import net.medcrm.yjb.workflow.service.HflowCustomFieldService;
import net.medcrm.yjb.workflow.service.HflowCustomTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by linsheng on 2017/12/26.
 */
@Service(value = "hflowCustomFieldService")
@Transactional
public class HflowCustomFieldServiceImpl implements HflowCustomFieldService {

    @Autowired
    private HflowCustomFieldMapper hflowCustomFieldMapper;
    @Override
    public List<HflowCustomField> select() {
        return hflowCustomFieldMapper.select();
    }

    @Override
    public HflowCustomField selectByPrimaryKey(String id) {
        return hflowCustomFieldMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(HflowCustomField hflowCustomField) {
        hflowCustomField.setId(hflowCustomField.getId() == null ? UUID.randomUUID().toString() : hflowCustomField.getId());
        return hflowCustomFieldMapper.insert(hflowCustomField);
    }

    @Override
    public int update(HflowCustomField hflowCustomField) {
        return hflowCustomFieldMapper.update(hflowCustomField);
    }

    @Override
    public int delete(String id) {
        return hflowCustomFieldMapper.delete(id);
    }
    public int deleteByTplId(String tplId){
        return hflowCustomFieldMapper.deleteByTplId(tplId);
    }
    @Transactional
    public boolean saveOrUpdate(HflowCustomTemplate hflowCustomTemplate){
        this.deleteByTplId(hflowCustomTemplate.getId());
        for(HflowCustomField hflowCustomField : hflowCustomTemplate.getHflowCustomFieldList()){
            hflowCustomField.setTplId(hflowCustomTemplate.getId());
            this.insert(hflowCustomField);
        }

        return true;
    }

    @Override
    public List<HflowCustomField> selectByTplId(String tplId){
        return hflowCustomFieldMapper.selectByTplId(tplId);
    }
}
