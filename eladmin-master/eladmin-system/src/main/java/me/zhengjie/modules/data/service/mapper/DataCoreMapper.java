package me.zhengjie.modules.data.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.data.domain.DataCore;
import me.zhengjie.modules.data.service.dto.DataCoreDto;

@Mapper(componentModel = "spring",uses = {ObjectIdMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DataCoreMapper extends BaseMapper<DataCoreDto, DataCore> {

	
	 @Override
	 @Mapping(source = "createTime", target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
	 DataCoreDto toDto(DataCore dataCore);
}
