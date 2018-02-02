package net.medcrm.yjb.his.omp.service;

import net.medcrm.yjb.his.omp.domain.Division;

import java.util.List;
import java.util.Map;

public interface DivisionService {
    Division selectBasicById(String id);



    List<Division> selectAll();

    //根据diviType获取已停用列表
    List<Division> selectSuspendAll(int diviType);

    //新增或编辑机构、部门和工作组
    int insertOrUpdate(Division division);

    int deleteByListId(String listId);

    //获取某个机构下的部门、工作组列表(或已停用),根据参数决定要不要展示人员信息
    List<Division> selectDivisionChildById(String id,String show,int status);
}
