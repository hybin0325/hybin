package net.medcrm.yjb.his.omp.service;

import net.medcrm.yjb.his.omp.domain.DivisionRePosition;

import java.util.List;

/**
 * Created by Justin on 2017/10/27.
 */
public interface DivisionRePositionService {
    //根据divisionId获取角色列表
    List<DivisionRePosition> selectPositionsById(String id);
}
