package com.edas.system.auth.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.edas.edascommon.core.BaseCrudMapper;
import com.edas.system.auth.entity.Resource;
import com.edas.system.auth.entity.SysUser;

@Mapper
@Repository
public interface UserMapper extends BaseCrudMapper<SysUser> {

    @Select("SELECT u.* FROM shopwwi_sys_users u WHERE username = #{username}")
    SysUser getByUsername(String username);
    
    
    SysUser selectByUsername (@Param("username") String username);
    
    @Select("select distinct p.* from shopwwi_sys_resources p inner join shopwwi_sys_roles_resources_relation rp on p.id = rp.resource_id inner join shopwwi_sys_users_roles_relation ru on ru.role_id = rp.role_id where ru.user_id = #{userId} ")
	List<Resource> selectByUserId(Long userId);
    
   
    
    @Delete("delete from shopwwi_sys_users_roles_relation where user_id = #{userId}")
   	int deleteUserRole(Long userId);

   	int saveUserRoles(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);
   	
   	@Update("update shopwwi_sys_users t set t.password = #{password} where t.id = #{id}")
   	int changePassword(@Param("id") Long id, @Param("password") String password);
       
   	List<SysUser> selectBylist(@Param("params") Map<String, Object> params);
   	
    @Select("select MAX(id)  from shopwwi_sys_users")
    int getLastId();
    
   	
   
   	
   	
}