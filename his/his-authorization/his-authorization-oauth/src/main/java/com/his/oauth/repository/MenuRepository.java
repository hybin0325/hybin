package com.his.oauth.repository;

import com.his.oauth.domain.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Administrator on 2017/10/25.
 */
public interface MenuRepository extends JpaRepository<SysMenu, Integer> ,JpaSpecificationExecutor<SysMenu>{

}
