/**
 * 
 */
package net.medcrm.yjb.workflow.ext;

import java.util.List;

import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.EmployeeVO;
import net.medcrm.yjb.his.feign.PositionVO;
import net.medcrm.yjb.workflow.feign.client.EmployeeServiceClient;
import net.medcrm.yjb.workflow.util.ActivitiUtils;

/**
 * @author hybin
 * @TIME 2016年12月26日 注意类的隐藏和实例创建
 */
// 使用自定义用户角色一般只需覆盖findUserById和findGroupsByUser方法
@Service
public class CustomUserEntityManager extends UserEntityManager {

	private static final Log logger = LogFactory.getLog(CustomUserEntityManager.class);

	@Autowired
	private EmployeeServiceClient employeeServiceClient;

	@Override
	public UserEntity findUserById(final String userCode) {
		if (userCode == null)
			return null;
		try {
			UserEntity userEntity = null;
			BaseResp<EmployeeVO> base = employeeServiceClient.getByUserId(userCode);
			EmployeeVO bUser = (EmployeeVO) base.getData();
			// mapper.getUserById(Long.valueOf(userCode));
			userEntity = ActivitiUtils.toActivitiUser(bUser);
			return userEntity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Group> findGroupsByUser(final String userCode) {
		if (userCode == null)
			return null;
		BaseResp<EmployeeVO> base = employeeServiceClient.getByUserId(userCode);
		EmployeeVO bUser = (EmployeeVO) base.getData();
		// List<RoleInfo> bGroups = null;
		// mapper.getGroupList(user.getUserId());
		BaseResp<List<PositionVO>> list = employeeServiceClient.getpositionsByUserId(bUser.getId());
		List<PositionVO> bGroups = (List<PositionVO>) list.getData();
		List<Group> gs = null;
		gs = ActivitiUtils.toActivitiGroups(bGroups);
		return gs;
	}

	@Override
	public long findUserCountByQueryCriteria(UserQueryImpl query) {
		// TODO Auto-generated method stub
		return super.findUserCountByQueryCriteria(query);
	}

	@Override
	public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
		// TODO Auto-generated method stub
		return super.findUserInfoByUserIdAndKey(userId, key);
	}

	@Override
	public List<String> findUserInfoKeysByUserIdAndType(String userId, String type) {
		// TODO Auto-generated method stub
		return super.findUserInfoKeysByUserIdAndType(userId, type);
	}

	@Override
	public Boolean checkPassword(String userId, String password) {
		// 防止activiti调用该方法
		throw new RuntimeException("not implement method.");
	}

	@Override
	public List<org.activiti.engine.identity.User> findPotentialStarterUsers(String proceDefId) {
		// TODO Auto-generated method stub
		throw new RuntimeException("not implement method.");
	}

}
