package net.medcrm.yjb.workflow.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.medcrm.yjb.workflow.domain.HflowProcdefLogs;
import net.medcrm.yjb.workflow.mapper.HflowProcdefLogsMapper;
import net.medcrm.yjb.workflow.service.IHflowProcdefLogsService;

@Service
public class HflowProcdefLogsServiceImpl implements IHflowProcdefLogsService {

	@Autowired
	private HflowProcdefLogsMapper procdefLogsMapper;

	@Override
	@Transactional
	public void save(String acReprodId, String user) {
		HflowProcdefLogs record = new HflowProcdefLogs();
		if (procdefLogsMapper.selectMaxSort()!=null) {
			record.setpSort(procdefLogsMapper.selectMaxSort() + 1);
		} else {
			record.setpSort(1);
		}
		record.createPersistentObject();
		record.setActReProId(acReprodId);
		record.setCreateUser(user);
		procdefLogsMapper.insert(record);
	}

	@Transactional
	public void update(String acReprodId, String user) {
		HflowProcdefLogs record = procdefLogsMapper.selectByPrimaryProId(acReprodId);
		if (record != null) {
			record.setUpdateDate(new Date());
			record.setUpdateUser(user);
			procdefLogsMapper.updateByPrimaryKeySelective(record);
		}
	}

	@Override
	@Transactional
	public void saveOrUpdate(String acReprodId, String user) {
		HflowProcdefLogs record = procdefLogsMapper.selectByPrimaryProId(acReprodId);
		if (record != null) {
			record.setUpdateDate(new Date());
			record.setUpdateUser(user);
			procdefLogsMapper.updateByPrimaryKeySelective(record);
		}else {
			record = new HflowProcdefLogs();
			if (procdefLogsMapper.selectMaxSort() !=null) {
				record.setpSort(procdefLogsMapper.selectMaxSort() + 1);
			} else {
				record.setpSort(1);
			}
			record.createPersistentObject();
			record.setActReProId(acReprodId);
			record.setCreateUser(user);
			procdefLogsMapper.insert(record);
		}
	}

	public String updateChangeSort(String currentId, String changeId) {
		HflowProcdefLogs curren = procdefLogsMapper.selectByPrimaryProId(currentId);
		HflowProcdefLogs change = procdefLogsMapper.selectByPrimaryProId(changeId);
		if(curren==null) {
			return currentId+"数据为空";
		}
		if(change==null) {
			return changeId+"数据为空";
		}
		Integer tempCurrentSort=curren.getpSort();
		Integer tempChangeSort=change.getpSort();
		
		curren.setpSort(tempChangeSort);
		curren.updatePersistentObject();
		procdefLogsMapper.updateByPrimaryKeySelective(curren);

		change.setpSort(tempCurrentSort);
		change.updatePersistentObject();
		procdefLogsMapper.updateByPrimaryKeySelective(change);
		return null;
	}


}
