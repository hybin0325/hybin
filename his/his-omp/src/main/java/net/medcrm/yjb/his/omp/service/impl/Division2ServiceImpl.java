package net.medcrm.yjb.his.omp.service.impl;

import net.medcrm.yjb.his.omp.configure.ResultCode;
import net.medcrm.yjb.his.omp.dao.Division2Mapper;
import net.medcrm.yjb.his.omp.dao.DivisionMapper;
import net.medcrm.yjb.his.omp.dao.DivisionRePositionMapper;
import net.medcrm.yjb.his.omp.dao.PositionMapper;
import net.medcrm.yjb.his.omp.domain.Division;
import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import net.medcrm.yjb.his.omp.domain.Position;
import net.medcrm.yjb.his.omp.service.Division2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Justin on 2017/10/27.
 */
@Service(value="division2Service")
public class Division2ServiceImpl implements Division2Service {
    @Autowired
    DivisionMapper divisionMapper;
    @Autowired
    Division2Mapper division2Mapper;
    @Autowired
    PositionMapper posiMapper;
    @Autowired
    DivisionRePositionMapper diviReposiMapper;
//

    @Override
    public Division selectBaseDivisionById(String id) {
        return division2Mapper.selectBaseDivisionById(id);
    }


}
