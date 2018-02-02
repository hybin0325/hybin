package net.medcrm.yjb.his.omp.service;

import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import net.medcrm.yjb.his.omp.domain.Position;

import java.util.List;
import java.util.Map;

/**
 * Created by Justin on 2017/10/27.
 */
public interface PositionService {
    ResultStatus updatePosiEmploy(List<DivisionRePosition> divisionRePositions);

    int deletePosiEmploy(DivisionRePosition divisionRePosition);

    //根据type和exclusive获取角色列表
    List<Position> selectByType(int type, int exclusive);
}
