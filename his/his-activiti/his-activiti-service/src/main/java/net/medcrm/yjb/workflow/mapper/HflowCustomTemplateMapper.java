package net.medcrm.yjb.workflow.mapper;

import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by linsheng on 2017/12/26.
 */
public interface HflowCustomTemplateMapper {

    public List<HflowCustomTemplate> select(@Param("type")String type,@Param("name") String name,@Param("createUserId") String createUserId,@Param("status")Integer status);
    public List<HflowCustomTemplate> selectByStatus(@Param("type")String type,@Param("name") String name,@Param("createUserId") String createUserId,@Param("status")Integer status);
    public List<HflowCustomTemplate> selectByPid(@Param("pid") String pid,@Param("status")Integer status);
    public List<HflowCustomTemplate> selectByName(@Param("name") String name);
    public HflowCustomTemplate selectByPrimaryKey(String id);
    public List<HflowCustomTemplate> selectByKeys(@Param("ids") String[] ids);
    public int insert(HflowCustomTemplate hflowCustomTemplate);
    public int update(HflowCustomTemplate hflowCustomTemplate);
    public int delete(String id);
    public int updateSort(HflowCustomTemplate template);
    public int selectMaxSort();
}
