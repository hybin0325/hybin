package me.zhengjie.modules.system.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.system.domain.Group;
import me.zhengjie.modules.system.service.dto.GroupDto;

@Mapper(componentModel = "spring",uses = {DeptMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupMapper extends BaseMapper<GroupDto, Group>{

}
