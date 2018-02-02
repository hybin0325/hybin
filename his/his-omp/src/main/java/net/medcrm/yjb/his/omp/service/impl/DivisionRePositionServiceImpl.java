package net.medcrm.yjb.his.omp.service.impl;

import net.medcrm.yjb.his.omp.dao.DivisionRePositionMapper;
import net.medcrm.yjb.his.omp.dao.EmployeeMapper;
import net.medcrm.yjb.his.omp.dao.PositionMapper;
import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import net.medcrm.yjb.his.omp.domain.Employee;
import net.medcrm.yjb.his.omp.domain.EmployeeBasic;
import net.medcrm.yjb.his.omp.service.DivisionRePositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Justin on 2017/10/27.
 */
@Service(value="divisionRePositionService")
public class DivisionRePositionServiceImpl implements DivisionRePositionService{
    @Autowired
    DivisionRePositionMapper drpMapper;
    @Autowired
    PositionMapper positionMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    //根据divisionId获取角色列表
    @Override
    public List<DivisionRePosition> selectPositionsById(String id) {
        List<DivisionRePosition> positionList = new ArrayList<>();

        List<DivisionRePosition> lists = drpMapper.selectPositionsById(id);
        for(DivisionRePosition list:lists){
            DivisionRePosition drp = new DivisionRePosition();
            drp.setPositionId(list.getPositionId());
            drp.setPositionName(positionMapper.selectNameById(list.getPositionId()));
            drp.setEmployeeId(list.getEmployeeId());
            String employeeId = list.getEmployeeId();
            if(null!=employeeId) {
                List<EmployeeBasic> employeeBasics = new ArrayList<>();
                EmployeeBasic employeeBasic = new EmployeeBasic();
                String[] ids = employeeId.split(",");
                List<String> employees = Arrays.asList(ids);
                for (String e : employees) {
                    String name = employeeMapper.selectNameById(e);
                    employeeBasic.setId(e);
                    employeeBasic.setName(name);
                    employeeBasics.add(employeeBasic);
                }
                drp.setEmployees(employeeBasics);
            }

            positionList.add(drp);
        }
        return positionList;
    }
}
