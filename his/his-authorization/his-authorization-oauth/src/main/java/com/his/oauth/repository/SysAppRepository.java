package com.his.oauth.repository;

import com.his.oauth.domain.SysApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface SysAppRepository  extends JpaRepository<SysApp, Integer>,JpaSpecificationExecutor<SysApp> {
}
