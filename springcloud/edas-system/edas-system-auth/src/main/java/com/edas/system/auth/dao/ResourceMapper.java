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
import com.edas.system.auth.entity.Resource;
import com.edas.system.auth.entity.Role;

@Mapper
@Repository
public interface ResourceMapper extends BaseCrudMapper<Resource>{

    @Select("SELECT id,code,type,name,url,method,description,created_time,updated_time,created_by,updated_by" +
            " FROM shopwwi_sys_resources")
    Set<Resource> findAll();

    @Select("<script>" +
            "SELECT DISTINCT rs.code,rs.url,rs.name,rs.type,rs.method,rs.description" +
            " FROM shopwwi_sys_roles r" +
            " INNER JOIN shopwwi_sys_roles_resources_relation rrr ON r.id = rrr.role_id" +
            " INNER JOIN shopwwi_sys_resources rs ON rs.id = rrr.resource_id" +
            " WHERE r.code IN " +
            " <foreach collection='roleCodes' item='roleCode' index='index' open='(' close=')' separator=',' >" +
            "    #{roleCode}" +
            " </foreach>" +
            "</script>")
    Set<Resource> queryByRoleCodes(@Param("roleCodes") String[] roleCodes);
    
    @Select("select distinct p.* from shopwwi_sys_resources p inner join shopwwi_sys_roles_resources_relation rp on p.id = rp.resource_id inner join shopwwi_sys_users_roles_relation ru on ru.role_id = rp.role_id where ru.user_id = #{userId} ")
	List<Resource> selectByUserId(Long userId);
    
    
    @Delete("delete from shopwwi_sys_resources where parent_id = #{id}")
	int deleteByParentId(Long id);

	@Delete("delete from shopwwi_sys_roles_resources_relation where resource_id = #{resourceId}")
	int deleteRolePermission(Long resourceId);
	
	
	@Select("select * from shopwwi_sys_resources t where t.level = 1 order by t.sort")
	List<Resource> selectByParents();
	
	@Select("select p.* from shopwwi_sys_resources p inner join shopwwi_sys_roles_resources_relation rp on p.id = rp.resource_id where rp.role_id = #{roleId} order by p.sort")
	List<Resource> selectByRoleId(Long roleId);
	
	@Select("SELECT DISTINCT p.id,p.code,p.type,p.name,p.parent_id parentId,p.url,p.method,p.description from shopwwi_sys_resources p inner join " + 
   			"	    shopwwi_sys_roles_resources_relation rp on p.id = rp.resource_id " + 
   			"	    inner join shopwwi_sys_users_roles_relation ru on ru.role_id = rp.role_id where ru.user_id = #{userId} ")
    Set<Resource> selectByResources(Long userId);
	
	 List<Resource> selectlist(@Param("params") Map<String, Object> params);
}