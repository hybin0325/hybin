/**
 * 
 */
package net.medcrm.yjb.workflow.ext;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.feign.PositionVO;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;

/**
 * @author hybin
 * @TIME 2016年12月26日 注意类的隐藏和实例创建
 */
// 使用自定义用户角色一般只需覆盖findGroupById和findGroupsByUser方法
@Service
public class CustomGroupEntityManager extends GroupEntityManager {
	
	private static final Log logger = LogFactory.getLog(CustomUserEntityManager.class);

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	// activiti5.20中源码GroupEntityManager类中已经不存在findGroupById方法
	public GroupEntity findGroupById(final String groupCode) {
		if (groupCode == null)
			return null;
		try {
			BaseResp<PositionVO> base=employeeServiceClient.getPosition(groupCode);
			PositionVO bGroup =(PositionVO) base.getData();
			GroupEntity e = new GroupEntity();
			e.setRevision(1);
			// activiti有3种预定义的组类型：security-role、assignment、user
			// 如果使用Activiti
			// Explorer，需要security-role才能看到manage页签，需要assignment才能claim任务
			e.setType("assignment");
			e.setId(bGroup.getId());
			e.setName(bGroup.getName());
			return e;
		} catch (EmptyResultDataAccessException e) {

			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Group> findGroupsByUser(final String userCode) {
		logger.info(" userCode:  ---------------- "+userCode);
		if (userCode == null)
			return null;
	
		BaseResp<EmployeeVO> base=employeeServiceClient.getByUserId(userCode);
		EmployeeVO user=(EmployeeVO)base.getData();
		
		BaseResp<List<PositionVO>> list= employeeServiceClient.getpositionsByUserId(user.getId());
		List<PositionVO> bGroupList = (List<PositionVO>)list.getData();
		
		List<Group> gs = new ArrayList<Group>();
		GroupEntity g;
		for (PositionVO bGroup : bGroupList) {
			g = new GroupEntity();
			g.setRevision(1);
			g.setType("assignment");
			g.setId(bGroup.getId());
			g.setName(bGroup.getName());
			gs.add(g);
		}
		return gs;
	}

	public void insertGroup(Group group) {
		throw new RuntimeException("not implement method.");// 新增用户在业务逻辑中处理不使用activiti
	}

	@Override
	public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
		return super.findGroupByQueryCriteria(query, page);
	}

	@Override
	public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
		return super.findGroupCountByQueryCriteria(query);
	}
}
