package net.medcrm.yjb.workflow.mapper;

import net.medcrm.yjb.workflow.domain.HflowCustomField;
import net.medcrm.yjb.workflow.domain.HflowCustomRealTemplate;

import java.util.List;

/**
 * Created by linsheng on 2017/12/26.
 */
public interface HflowCustomFieldMapper {

    public List<HflowCustomField> select();
    public List<HflowCustomField> selectByTplId(String tplId);
    public HflowCustomField selectByPrimaryKey(String id);
    public int insert(HflowCustomField hflowCustomField);
    public int update(HflowCustomField hflowCustomField);
    public int delete(String id);
    public int deleteByTplId(String tplId);
}
