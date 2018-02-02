package net.medcrm.yjb.his.omp.service.impl;

import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.his.omp.configure.ResultCode;
import net.medcrm.yjb.his.omp.dao.DivisionRePositionMapper;
import net.medcrm.yjb.his.omp.dao.PositionMapper;
import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import net.medcrm.yjb.his.omp.domain.Position;
import net.medcrm.yjb.his.omp.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Justin on 2017/10/30.
 */
@Service(value = "positionService")
public class PositionServiceImpl implements PositionService{

    @Autowired
    DivisionRePositionMapper diviReposiMapper;
    @Autowired
    PositionMapper positionMapper;

    //编辑角色内的人员
    @Override
    public ResultStatus updatePosiEmploy(List<DivisionRePosition> divisionRePositions) {
        for(DivisionRePosition d:divisionRePositions){
            DivisionRePosition drp = new DivisionRePosition();
            drp.setDivisionId(d.getDivisionId());
            drp.setPositionId(d.getPositionId());
            if(null!=d.getEmployeeId()){
                drp.setEmployeeId(d.getEmployeeId()+",");
            }
           drp.setEmployeeId(null);
            if(diviReposiMapper.updatePosiEmploy(drp)<0){
             return ResultStatus.error_update_failed;
            }

        }
        return ResultStatus.SUCCESS;
    }


    //删除角色内的人员
    @Override
    public int deletePosiEmploy(DivisionRePosition divisionRePosition) {
        String employId = divisionRePosition.getEmployeeId()+",";
        DivisionRePosition drp = diviReposiMapper.selectByThreeId(divisionRePosition);
        String employeeId = drp.getEmployeeId().replace(employId,"");
        drp.setEmployeeId(employeeId);
        if(diviReposiMapper.deleteEmployId(drp)<0){
            return ResultCode.FAIL;
        }
        return ResultCode.SUCCESS;
    }
    //根据type和exclusive获取角色列表
    @Override
    public List<Position> selectByType(int type, int exclusive) {
        return positionMapper.selectByType(type,exclusive);
    }

}
