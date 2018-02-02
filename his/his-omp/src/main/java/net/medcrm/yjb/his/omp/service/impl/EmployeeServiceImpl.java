package net.medcrm.yjb.his.omp.service.impl;

import net.medcrm.yjb.his.omp.configure.ResultCode;
import net.medcrm.yjb.his.omp.dao.DivisionMapper;
import net.medcrm.yjb.his.omp.dao.DivisionRePositionMapper;
import net.medcrm.yjb.his.omp.dao.EmployeeMapper;
import net.medcrm.yjb.his.omp.dao.PositionMapper;
import net.medcrm.yjb.his.omp.domain.Division;
import net.medcrm.yjb.his.omp.domain.DivisionRePosition;
import net.medcrm.yjb.his.omp.domain.Employee;
import net.medcrm.yjb.his.omp.domain.EmployeeRelation;
import net.medcrm.yjb.his.omp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Justin on 2017/10/28.
 */
@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employMapper;
    @Autowired
    DivisionRePositionMapper diviReposiMapper;
    @Autowired
    DivisionMapper divisionMapper;
    @Autowired
    PositionMapper positionMapper;
    //新增或者编辑人员
    @Override
    public int insertOrUpdate(Employee employee) {
        //id不为空，编辑
        if (null!=employee.getId()){
            String employeeId = employee.getId()+",";
            Date date = new Date();
            employee.setUpdateDate(date);
            if(employMapper.update(employee)<0){
                return ResultCode.FAIL;
            }
        }
        //新增
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        employee.setId(uuid);
        String employeeId = uuid+",";
        Date date = new Date();
        employee.setCreateDate(date);
        employee.setStatus(0);
        if(employMapper.insert(employee)<0){
            return ResultCode.FAIL;
        }
        List<EmployeeRelation> relations = employee.getRelations();
        for(EmployeeRelation relation:relations){
            String divisionId = relation.getDivisionId();
            String positionIds = relation.getPositionId();
            DivisionRePosition divisionRePosition = new DivisionRePosition();
            String[] positionList = positionIds.split(",");
            List<String> listId = Arrays.asList(positionList);

            for(String id:listId){
                //该角色下有人员
                DivisionRePosition divi = diviReposiMapper.isNullofEmploy(divisionId,id);
                if(null!=divi) {
                    String employ = divi.getEmployeeId()+employeeId;
                    divisionRePosition.setDivisionId(divisionId);
                    divisionRePosition.setEmployeeId(employ);
                    divisionRePosition.setPositionId(id);
                    if (diviReposiMapper.updatePosiEmploy(divisionRePosition) < 0) {
                        return ResultCode.FAIL;
                    }
                }else {
                    //该角色下没有人员
                    divisionRePosition.setPositionId(id);
                    divisionRePosition.setEmployeeId(employeeId);
                    divisionRePosition.setDivisionId(divisionId);
                    if (diviReposiMapper.updatePosiEmploy(divisionRePosition) < 0) {
                        return ResultCode.FAIL;
                    }
                }
            }


        }
        return ResultCode.SUCCESS;
    }
//    //编辑人员
//    @Override
//    public int update(Map<String, Object> map) {
//        Employee employee = (Employee)map.get("basic");
//        String employeeId = employee.getId()+",";
//        Date date = new Date();
//        employee.setUpdateDate(date);
//        if(employMapper.update(employee)<0){
//            return ResultCode.FAIL;
//        }
//        //编辑人员所属的组织关系和所属角色
//        Map<String,String> paramMap = (Map<String,String>)map.get("relation");
//        for(Map.Entry<String,String> entry:paramMap.entrySet()){
//            String divisionId = entry.getKey();
//            String positionIds = entry.getValue();
//            //判断是否添加多个角色
//            DivisionRePosition divisionRePosition = new DivisionRePosition();
//                String[] positionList = positionIds.split(",");
//                List<String> listId = Arrays.asList(positionList);
//                for(String id:listId){
//                    //该角色下有人员
//                    DivisionRePosition divi = diviReposiMapper.isNullofEmploy(divisionId,id);
//                    if(null!=divi){
//                        String employ = divi.getEmployeeId()+employeeId;
//                        divisionRePosition.setDivisionId(divisionId);
//                        divisionRePosition.setEmployeeId(employ);
//                        divisionRePosition.setPositionId(id);
//                        if (diviReposiMapper.updatePosiEmploy(divisionRePosition) < 0) {
//                            return ResultCode.FAIL;
//                        }
//                    }
//                    //该角色下没有人员
//                    divisionRePosition.setPositionId(id);
//                    divisionRePosition.setEmployeeId(employeeId);
//                    divisionRePosition.setDivisionId(divisionId);
//                    if(diviReposiMapper.updatePosiEmploy(divisionRePosition)<0){
//                        return ResultCode.FAIL;
//                    }
//
//                }
//
//            //判断该角色下是否有人员，如果有人员，则新增关系，如果没有人员，则编辑
//            //该角色下有人员，则新增
//
//        }
//        return ResultCode.SUCCESS;
//    }
    //批量停用人员
    @Override
    public int deleteByIds(String listId) {
        String[] ids = listId.split(",");
        List<String> lists = Arrays.asList(ids);
        return  employMapper.deleteByIds(lists);
    }

    //查看人员信息
    @Override
    public Employee selectById(String id) {
        List<EmployeeRelation> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        //基本信息
        Employee employee = employMapper.selectById(id);
        //组织关系
        List<DivisionRePosition> divisionRePositions = diviReposiMapper.selectByEmployId(id);
        for(DivisionRePosition d:divisionRePositions){
            EmployeeRelation employeeRelation = new EmployeeRelation();
            String divisionId = d.getDivisionId();
            String positionId = d.getPositionId();
            String divisionName = divisionMapper.selectFullNameById(divisionId);
            String positionName = positionMapper.selectNameById(positionId);
            employeeRelation.setDivisionId(divisionId);
            employeeRelation.setDivisionName(divisionName);
            employeeRelation.setPositionId(positionId);
            employeeRelation.setPositionName(positionName);;
            list.add(employeeRelation);

        }
        employee.setRelations(list);
        return employee;
    }

    //获取指定division下的人员列表
    @Override
    public List<Employee> selectEmployList(String id,int status) {
        //先根据id获取该机构下的所有子类
        List<Employee> list = new ArrayList<>();
        List<Division> divisions = divisionMapper.selectChildrenById(id);
        //
        for (Division d:divisions){
            String divisionId = d.getId();
            List<Employee> employeeList =  employMapper.selectByMajor(divisionId,status);
            list.addAll(employeeList);
        }
        return list;
    }

    @Override
    public List<Employee> selectAll(int status) {
        return employMapper.selectAll(status);
    }
}
