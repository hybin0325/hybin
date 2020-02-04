package me.zhengjie.modules.system.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import me.zhengjie.modules.system.domain.Group;
import me.zhengjie.modules.system.service.dto.GroupDto;
import me.zhengjie.modules.system.service.dto.GroupQueryCriteria;

public interface GroupService {
	
	/**
     * 根据ID查询
     * @param id /
     * @return /
     */
	GroupDto findById(Long id);

    /**
     * 创建
     * @param resources /
     * @return /
     */
	GroupDto create(Group resources);

    /**
     * 编辑
     * @param resources /
     */
    void update(Group resources);

    /**
     * 删除
     * @param ids /
     */
    void delete(Set<Long> ids);

    

    /**
     * 查询全部数据
     * @param criteria /
     * @return /
     */
    List<GroupDto> queryAll(GroupQueryCriteria criteria);

    /**
     * 导出数据
     * @param queryAll 待导出的数据
     * @param response /
     * @throws IOException /
     */
    void download(List<GroupDto> queryAll, HttpServletResponse response) throws IOException;

}
