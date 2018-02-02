package com.his.oauth.repository;

import com.his.oauth.domain.SysUserPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by lings on 2017/10/27.
 */
public interface UserPositionRepository extends Repository<SysUserPosition, Integer>, JpaSpecificationExecutor<SysUserPosition> {

    @Query(value="select u.id, u.userId, u.positionId,u.positionType from SysUserPosition u where u.userId = ?1")
    public List<SysUserPosition> findListByUserId(Integer userId);



}
