package me.zhengjie.modules.data.service;

import java.util.List;

import org.springframework.data.domain.Page;

import me.zhengjie.modules.data.domain.DataCore;
import me.zhengjie.modules.data.service.dto.DataCoreDto;
import me.zhengjie.modules.data.service.dto.DataCoreQueryCriteria;

public interface DataCoreService {
	
	DataCoreDto save(DataCore dataCore);
	
	/**
     * 查询全部数据
     * @param criteria 条件
     * @return /
     */
    List<DataCoreDto> queryAll(DataCoreQueryCriteria criteria);
	
    List<DataCoreDto> queryByName(DataCoreQueryCriteria criteria);
    
    Page<DataCoreDto> queryByPage(DataCoreQueryCriteria criteria, int pageNo, int pageSize);
}
