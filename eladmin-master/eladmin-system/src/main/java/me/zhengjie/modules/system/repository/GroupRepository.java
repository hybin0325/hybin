package me.zhengjie.modules.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import me.zhengjie.modules.system.domain.Group;
import me.zhengjie.modules.system.domain.User;

public interface GroupRepository extends JpaRepository<Group, Long>, JpaSpecificationExecutor<Group>{

}
