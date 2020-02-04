package me.zhengjie.modules.system.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import me.zhengjie.modules.system.domain.Group;
import me.zhengjie.modules.system.repository.GroupRepository;
import me.zhengjie.modules.system.service.GroupService;
import me.zhengjie.modules.system.service.dto.GroupDto;
import me.zhengjie.modules.system.service.dto.GroupQueryCriteria;
import me.zhengjie.modules.system.service.mapper.GroupMapper;
import me.zhengjie.utils.FileUtil;
import me.zhengjie.utils.QueryHelp;

@Service
@CacheConfig(cacheNames = "group")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupRepository groupRepository;

	@Autowired
	private GroupMapper groupMapper;

	@Override
	@Cacheable(key = "#p0")
	public GroupDto findById(Long id) {
		Group group = groupRepository.findById(id).orElseGet(Group::new);
		return groupMapper.toDto(group);
	}

	@Override
	@CacheEvict(allEntries = true)
	@Transactional(rollbackFor = Exception.class)
	public GroupDto create(Group resources) {
		return groupMapper.toDto(groupRepository.save(resources));
	}

	@Override
	@CacheEvict(allEntries = true)
	@Transactional(rollbackFor = Exception.class)
	public void update(Group resources) {
		Group group = groupRepository.findById(resources.getId()).orElseGet(Group::new);
		resources.setId(group.getId());
		groupRepository.save(resources);
	}

	@Override
	@CacheEvict(allEntries = true)
	@Transactional(rollbackFor = Exception.class)
	public void delete(Set<Long> ids) {
		for (Long id : ids) {
			groupRepository.deleteById(id);
		}
	}

	

	@Override
	@Cacheable
	public List<GroupDto> queryAll(GroupQueryCriteria criteria) {
		return groupMapper.toDto(groupRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
	}

	@Override
	public void download(List<GroupDto> queryAll, HttpServletResponse response) throws IOException {
		List<Map<String, Object>> list = new ArrayList<>();
        for (GroupDto groupDto : queryAll) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("群组名称", groupDto.getGroupName());
            map.put("群组状态", groupDto.getStatus());
            map.put("创建日期", groupDto.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
	}

}
