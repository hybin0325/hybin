package com.his.oauth.repository;

import com.his.oauth.domain.SysElement;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface SysElementRepository extends JpaRepository<SysElement, Integer>,JpaSpecificationExecutor<SysElement> {


    public List<SysElement> getByParentId(Integer parentId);
}
