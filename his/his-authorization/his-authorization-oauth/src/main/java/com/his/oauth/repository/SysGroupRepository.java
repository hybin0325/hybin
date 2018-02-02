package com.his.oauth.repository;

import com.his.oauth.domain.SysGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */

public interface SysGroupRepository extends JpaRepository<SysGroup, Integer>, JpaSpecificationExecutor<SysGroup> {


     List<SysGroup> getById(Integer userId);
}
