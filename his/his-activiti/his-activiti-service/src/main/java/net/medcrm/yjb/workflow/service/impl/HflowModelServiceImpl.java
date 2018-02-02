package net.medcrm.yjb.workflow.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import net.medcrm.yjb.workflow.domain.HflowModel;
import net.medcrm.yjb.workflow.domain.HflowModelProcdef;
import net.medcrm.yjb.workflow.mapper.HflowModelMapper;
import net.medcrm.yjb.workflow.mapper.HflowModelProcdefMapper;
import net.medcrm.yjb.workflow.service.IHflowModelService;
import net.medcrm.yjb.workflow.service.IHflowProcdefService;
import net.medcrm.yjb.workflow.util.StringUtils;

@Service
@Transactional
public class HflowModelServiceImpl implements IHflowModelService {

	@Autowired
	private HflowModelMapper modelMapper;

	@Autowired
	private HflowModelProcdefMapper modelProcdefMapper;
	
	@Autowired
	private IHflowProcdefService procdefService;

	//@Autowired
	//private MenuServiceClient menuService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void save(HflowModel record) {
		if (modelMapper.selectMaxSort() != null) {
			record.setmSort(modelMapper.selectMaxSort() + 1);
		} else {
			record.setmSort(1);
		}
		record.createPersistentObject();
		modelMapper.insert(record);

		// 同步到菜单
		//SysMenuVO menu = new SysMenuVO();
		//menu.setTitle(record.getmName());
		//BaseResp<List<String>> base = menuService.saveOrUpdate(menu);

		//List<String> menuList = (List<String>) base.getData();
		//if (menuList != null && !menuList.isEmpty()) {
		//	record.setMenuId(StringUtils.listToString(menuList, ','));
		//	modelMapper.updateByPrimaryKeySelective(record);
		//}
	}

	@Override
	public HflowModel findById(String id) {
		return modelMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<HflowModel> findAllModel(String queryValue, int pageNum, int pageSize) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("queryValue", queryValue);
		PageHelper.startPage(pageNum, pageSize);
		return modelMapper.selectAllModel(map);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void updateDownChangeSort(String currentId, int currentSort, String downId, int downSort) {
		HflowModel model = new HflowModel();
		model.setId(currentId);
		model.setmSort(downSort);
		model.updatePersistentObject();
		modelMapper.updateByPrimaryKeySelective(model);
		model.setId(downId);
		model.setmSort(currentSort);
		model.updatePersistentObject();
		modelMapper.updateByPrimaryKeySelective(model);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void updateUpChangeSort(String currentId, int currentSort, String upId, int upSort) {
		HflowModel model = new HflowModel();
		model.setId(currentId);
		model.setmSort(upSort);
		model.updatePersistentObject();
		modelMapper.updateByPrimaryKeySelective(model);
		model.setId(upId);
		model.setmSort(currentSort);
		model.updatePersistentObject();
		modelMapper.updateByPrimaryKeySelective(model);

	}

	@Override
	public void update(HflowModel record) {
		record.updatePersistentObject();
		//SysMenuVO menu = new SysMenuVO();
		//menu.setTitle(record.getmName());
		//menuService.saveOrUpdate(menu);
		modelMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public int updateDisableModel(String id, int status) {
		if (id == null || id.equals(""))
			return 0;
		if (id.indexOf(",") != -1) {
			Map<String, Object> map = new HashMap<String, Object>();
			String[] a=id.split(",");
			map.put("status", status);
			map.put("updateDate", new Date());
			map.put("ids", a);
			modelMapper.updateBatch(map);
			for (String string : a) {
				List<String> proIdList= procdefService.getProcdefIdByModelId(string);
				String proIdStr=  StringUtils.listToString(proIdList,',');
				procdefService.updateDisable(proIdStr, status);
			}
			return 1;
		}
		HflowModel h = modelMapper.selectByPrimaryKey(id);
		if (h == null)
			return 0;
		HflowModel model = new HflowModel();
		model.setId(id);
		model.setStatus(status);
		model.updatePersistentObject();
		modelMapper.updateByPrimaryKeySelective(model);
		//修改模
		List<String> proIdList= procdefService.getProcdefIdByModelId(id);
		String proIdStr=  StringUtils.listToString(proIdList,',');
		procdefService.updateDisable(proIdStr, status);
		return 1;
	}

	@Override
	public String updateChangeSort(String currentId, String changeId) {
		HflowModel curren = modelMapper.selectByPrimaryKey(currentId);
		HflowModel change = modelMapper.selectByPrimaryKey(changeId);
		if(curren==null) {
			return currentId+"数据为空";
		}
		if(change==null) {
			return changeId+"数据为空";
		}
		Integer tempCurrentSort=curren.getmSort();
		Integer tempChangeSort=change.getmSort();
		
		curren.setmSort(tempChangeSort);
		curren.updatePersistentObject();
		modelMapper.updateByPrimaryKeySelective(curren);

		change.setmSort(tempCurrentSort);
		change.updatePersistentObject();
		modelMapper.updateByPrimaryKeySelective(change);
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
	public void saveModelContent(String Model, String[] procde) {
		for (String string : procde) {
			HflowModelProcdef pojo = new HflowModelProcdef();
			pojo.createPersistentObject();
			pojo.sethModel(Model);
			pojo.sethProcdefId(string);
			modelProcdefMapper.insert(pojo);
		}
	}

	@Override
	public int getByCode(String code) {
		if(modelMapper.selectByPrimaryCode(code)!=null) {
			return 0;
		}
		return 1;
	}
	
	public boolean isExistCode(String code) {
		if(modelMapper.selectByPrimaryCode(code)!=null) {
			return true;
		}
		return false;
		
	}

}
