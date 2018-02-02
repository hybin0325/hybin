package com.his.oauth.repository;

import com.his.oauth.domain.SysManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by lings on 2017/10/27.
 */
public interface SysManagerRepository  extends JpaRepository<SysManager, Integer>, JpaSpecificationExecutor<SysManager> {

    public List<SysManager> getByGroupId(Integer groupId);
}
