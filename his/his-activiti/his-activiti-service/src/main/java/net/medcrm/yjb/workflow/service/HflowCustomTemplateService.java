package net.medcrm.yjb.workflow.service;

import com.his.mybatis.dynamicDataSource.page.PageInfo;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.workflow.controller.vo.ImportVO;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import net.medcrm.yjb.workflow.dto.BindFlowFromDto;
import net.medcrm.yjb.workflow.dto.HflowCustomTemplateVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by linsheng on 2017/12/26.
 */
public interface HflowCustomTemplateService {

    public PageInfo<HflowCustomTemplateVO> select(String type, String name, Integer pageNum, Integer pageSize, Integer status);
    public List<HflowCustomTemplateVO> selectByPid(String pid);
    public HflowCustomTemplate selectByPrimaryKey(String id);
    public Boolean selectByName(String name);
    public int insert(HflowCustomTemplate hflowCustomTemplate);
    public int update(HflowCustomTemplate hflowCustomTemplate);
    public BaseResp delete(String id);
    public HflowCustomTemplate saveOrUpdate(HflowCustomTemplate hflowCustomTemplate);
    public BaseResp startOrStop(String id);
    public BaseResp bind(BindFlowFromDto flowFromDto);
    public BaseResp updateSort(String upId,String downId);
    public BaseResp publish(String id);
    public BaseResp export(HttpServletRequest request, HttpServletResponse response, String[] ids);
    public BaseResp importTpl(ImportVO vo);
    public BaseResp copy(String id,String type);
}
