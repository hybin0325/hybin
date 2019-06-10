package com.edas.system.auth.dao;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.edas.edascommon.core.BaseCrudMapper;
import com.edas.system.auth.entity.Role;
import com.edas.system.common.model.Roles;

@Mapper
@Repository
public interface RoleMapper extends BaseCrudMapper<Role> {

    @Select("SELECT DISTINCT r.id,r.code,r.name,r.description" +
            " FROM  shopwwi_sys_users_roles_relation urr" +
            " INNER JOIN shopwwi_sys_roles r ON r.id = urr.role_id" +
            " WHERE urr.user_id = #{userId}")
    Set<Role> queryByUserId(long userId);
    
    @Select("SELECT r.id,r.code FROM shopwwi_sys_roles r where r.code=#{code}")
    public Role getByCode(String code);
    
    int saveRoleResources(@Param("roleId") Long roleId, @Param("resourceIds") List<Long> resourceIds);
    
    @Delete("delete from shopwwi_sys_roles_resources_relation where role_id = #{roleId}")
	int deleteRolePermission(Long roleId);
    
    @Delete("delete from shopwwi_sys_users_roles_relation where role_id = #{roleId}")
	int deleteRoleUser(Long roleId);
    
    List<Role> selectlist(@Param("params") Map<String, Object> params);
    
    @Select("select * from shopwwi_sys_roles r inner join shopwwi_sys_users_roles_relation ru on r.id = ru.role_id where ru.user_id = #{userId}")
	List<Role> listByUserId(Long userId);
    
    @Select("select DISTINCT r.* from shopwwi_sys_roles r LEFT JOIN shopwwi_sys_roles_resources_relation rs on r.id =rs.role_id where rs.resource_id=#{resourceId}")
    Set<Role> selectByResourceId(Long resourceId);
    
	@Select("SELECT DISTINCT r.code,r.name,r.description" +
            " FROM  shopwwi_sys_users_roles_relation urr" +
            " INNER JOIN shopwwi_sys_roles r ON r.id = urr.role_id" +
            " WHERE urr.user_id = #{userId}")
    Set<Role> selectByRole(long userId);
}