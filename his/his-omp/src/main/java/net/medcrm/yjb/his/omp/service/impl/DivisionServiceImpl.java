package net.medcrm.yjb.his.omp.service.impl;

import net.medcrm.yjb.his.omp.configure.ResultCode;
import net.medcrm.yjb.his.omp.dao.DivisionMapper;
import net.medcrm.yjb.his.omp.dao.DivisionRePositionMapper;
import net.medcrm.yjb.his.omp.dao.EmployeeMapper;
import net.medcrm.yjb.his.omp.dao.PositionMapper;
import net.medcrm.yjb.his.omp.domain.*;
import net.medcrm.yjb.his.omp.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service(value = "divisionService")
public class DivisionServiceImpl implements DivisionService{

    @Autowired DivisionMapper divisionMapper;
    @Autowired DivisionRePositionMapper diviReposiMapper;
    @Autowired PositionMapper posiMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    //根据id获取机构、部门或工作组的基本信息
    @Override
    public Division selectBasicById(String id) {
        return divisionMapper.selectBasicById(id);
    }

    @Override
    public List<Division> selectAll() {
        List<Division> divisions = divisionMapper.selectAll();
        for (Division d:divisions){
            //查询出主要负责人这个角色下的人员姓名
            String employeeId = diviReposiMapper.selectEmployIdByDiviId(d.getId());
            if(null!=employeeId) {
                String id = employeeId.replace(",", "");
                d.setLeaderName(employeeMapper.selectNameById(id));
            }
        }
        return divisions;
    }

    @Override
    public List<Division> selectSuspendAll(int diviType) {
        return divisionMapper.selectSuspendAll(diviType);
    }

    //新增或编辑机构、部门和工作组
    @Override
    public int insertOrUpdate(Division division) {
        division.setStatus(0);
        int diviType = division.getDiviType();
        //根据pid，查询并拼接出pids
        String pids = divisionMapper.selectPidsById(division.getPid()).getPids();
        if(null!=pids){
            String p = pids+","+division.getPid();
            division.setPids(p);
        }
        division.setPids(division.getPid());

        //根据pids判断level
        String[] pidList = division.getPids().split(",");
        division.setLevel(pidList.length);

        //根据同一level下的数量，判断sort
        int sort = divisionMapper.countByLevelAndPid(division.getLevel(),division.getPid());
        division.setSort(sort);

        //id不为空，编辑
        if(null!=division.getId()){
            //先判断该机构是否有子节点，有的话则不能改变父级结构
            Division divi = divisionMapper.selectBasicById(division.getId());
            String pid = divi.getPid();
            int level = divi.getLevel()+1;
            if(divisionMapper.countByLevelAndPid(level,pid)>0){
                if(division.getPid()!=pid){
                    return ResultCode.SERVICE_ERROR;
                }
            }
            if(divisionMapper.update(division)<0){
             return ResultCode.FAIL;
            }return ResultCode.SUCCESS;
        }
        //新增
        else {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            division.setId(uuid);
            if (divisionMapper.insert(division) < 0) {
                return ResultCode.FAIL;
            }
            //绑定公有角色
            List<Position> positions = posiMapper.selectPositions(diviType);
            for(Position p:positions){
                DivisionRePosition diviRePosi = new DivisionRePosition();
                String uid = UUID.randomUUID().toString().replaceAll("-","");
                diviRePosi.setId(uid);
                diviRePosi.setDivisionId(uuid);
                diviRePosi.setPositionId(p.getId());
                if(diviReposiMapper.insert(diviRePosi)<0){
                    return ResultCode.FAIL;
                }

            }
        }
        return ResultCode.SUCCESS;
    }


    //根据listId对机构、部门或工作组批量逻辑删除
    @Override
    public int deleteByListId(String listId) {
        //先判断id下是否为父级，有子机构的不能直接删除
        String[] ids = listId.split(",");
        List<String> lists = Arrays.asList(ids);
        for(String id:lists){
            if(divisionMapper.isParentById(id)>0){
              return ResultCode.FAIL;
            }
        }
        if(divisionMapper.deleteByListId(lists)>0){
            return ResultCode.SUCCESS;
        }
        return ResultCode.FAIL;
    }

    //获取某个机构下的部门、工作组列表
    public List<Division> selectDivisionChildById(String id,String show,int status){
         List<Division> divisionList = divisionMapper.selectDivisionChildById(id,status);
         if(show.equals("N")){
             return divisionList;
         }
         //遍历机构下的部门或者工作组
         for(Division division:divisionList){
             List<DivisionRePosition> drpList = diviReposiMapper.selectPositionsById(division.getId());
             List<EmployeeBasic> employeeBasics = new ArrayList<>();
             //遍历部门或者工作组下的角色，人员
             for(DivisionRePosition d:drpList){
                 if(null!=d.getEmployeeId()){
                     String[] employs = d.getEmployeeId().split(",");
                     List<String> list = Arrays.asList(employs);
                     //根据employeeId集合，得到人员姓名
                     for(String l:list){
                         EmployeeBasic employeeBasic = new EmployeeBasic();
                         String name = employeeMapper.selectNameById(l);
                         employeeBasic.setName(name);
                         employeeBasic.setId(l);
                         employeeBasics.add(employeeBasic);
                     }

                 }
             }
             division.setEmployeeBasics(employeeBasics);
         }
        return divisionList;
    }

}
