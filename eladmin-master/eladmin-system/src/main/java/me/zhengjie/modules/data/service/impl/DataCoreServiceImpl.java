package me.zhengjie.modules.data.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import me.zhengjie.modules.data.domain.DataCore;
import me.zhengjie.modules.data.repository.DataCoreRepository;
import me.zhengjie.modules.data.service.DataCoreService;
import me.zhengjie.modules.data.service.dto.DataCoreDto;
import me.zhengjie.modules.data.service.dto.DataCoreQueryCriteria;
import me.zhengjie.modules.data.service.mapper.DataCoreMapper;

@Service
public class DataCoreServiceImpl implements DataCoreService {

	@Autowired
	private DataCoreRepository dataCoreRepository;

	@Autowired
	private DataCoreMapper dataCoreMapper;

	@Override
	public DataCoreDto save(DataCore dataCore) {
		dataCore.setCreateTime(new Date());
		return dataCoreMapper.toDto(dataCoreRepository.save(dataCore));
	}

	@Override
	public List<DataCoreDto> queryAll(DataCoreQueryCriteria criteria) {
		return dataCoreMapper.toDto(dataCoreRepository.findAll());
	}

	@Override
	public List<DataCoreDto> queryByName(DataCoreQueryCriteria criteria) {
		return dataCoreMapper.toDto(dataCoreRepository.findByProNameLike(criteria.getProName()));
	}

	@Override
	public Page<DataCoreDto> queryByPage(DataCoreQueryCriteria criteria, int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		Page<DataCore> page= dataCoreRepository.findByProNameLike(criteria.getProName(), pageable);
		System.out.println("---------------- "+page.getContent());
		Page<DataCoreDto> pageDto =new  PageImpl<DataCoreDto>(dataCoreMapper.toDto(page.getContent()));
		return pageDto;
	}
	
}
