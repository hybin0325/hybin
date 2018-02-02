package net.medcrm.yjb.workflow.service;

import net.medcrm.yjb.workflow.domain.HflowCustomField;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;

import java.util.List;

/**
 * Created by linsheng on 2017/12/26.
 */
public interface HflowCustomFieldService {

    public List<HflowCustomField> select();
    public HflowCustomField selectByPrimaryKey(String id);
    public int insert(HflowCustomField hflowCustomField);
    public int update(HflowCustomField hflowCustomField);
    public int delete(String id);
    public int deleteByTplId(String tplId);
    public boolean saveOrUpdate(HflowCustomTemplate hflowCustomTemplate);
    public List<HflowCustomField> selectByTplId(String tplId);
}
