package com.his.oauth.controller;

import com.alibaba.fastjson.JSON;
import com.his.oauth.domain.SysManager;
import com.his.oauth.repository.SysManagerRepository;
import com.his.oauth.vo.SysManagerVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 授权控制器
 * Created by lings on 2017/10/27.
 */
@RequestMapping("/manager")
@RestController
public class ManagerController {


    @Autowired
    private SysManagerRepository sysManagerRepository;

    @ApiOperation(value="权限授权(机构、部门、角色、人员)", notes="[\n" +
            "    {\n" +
            "        \"id\": 5,\n" +
            "        \"type\": 1,\n" +
            "        \"typeId\": 1,\n" +
            "        \"name\": 1,\n" +
            "        \"owerId\": 1,\n" +
            "        \"groupId\": 1,\n" +
            "        \"operate\": -1\n" +
            "    },\n" +
            "    {\n" +
            "        \"id\": 11,\n" +
            "        \"type\": 2,\n" +
            "        \"typeId\": 2,\n" +
            "        \"name\": 2,\n" +
            "        \"owerId\": 2,\n" +
            "        \"groupId\": 2,\n" +
            "        \"operate\": -1\n" +
            "    }\n" +
            "]")
    @ApiImplicitParam(name = "managers", value = "List<SysManagerVO> type(机构、部门、角色、人员类型区分),owerId(机构、部门、角色、人员Id),group(访问权限控制组),operate(操作类型：授权或删除权限)", required = true, dataType = "List<SysManagerVO>")
    @PostMapping(name = "/saveOrUpdate")
    @ResponseBody
    public BaseResp saveOrUpdate(@RequestBody List<SysManagerVO> managers){


        managers.forEach(vo -> {
            SysManager manager  = new SysManager();
            System.out.println(vo.getOperate());
            switch (vo.getOperate()){
                //添加
                case 1 :
                    /**
                     *  类型(组织机构1、角色2或者人员3)
                     */
                    manager.setType(vo.getType());
                    /**
                     *  POSITION_ORG_TYPE(1,"组织机构"),
                     *  POSITION_ROLE_TYPE(2,"组织机构"),
                     *  OPERATION_ORG(1, "机构"),
                     *  OPERATION_POS(2, "部门"),
                     *  OPERATION_GRP(3, "工作组"),
                     *  OPERATION_ORG_ROLE(1, "机构角色"),
                     *  OPERATION_POS_ROLE(2, "部门角色"),
                     *  OPERATION_GRP_ROLE(3, "工作组角色");
                     *  类型对应的类型
                     */
                    manager.setTypeId(vo.getTypeId());
                    manager.setName(vo.getName());
                    manager.setOwerId(vo.getOwerId());
                    manager.setGroupId(vo.getGroupId());
                    sysManagerRepository.save(manager);
                //删除
                case -1:

                   sysManagerRepository.delete(vo.getId());
            }
        });
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(true);
        return resp;
    }


    @ApiOperation(value="分页查看权限拥有者列表(人员、机构、角色)", notes="分页查看权限拥有者列表(人员、机构、角色)")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "SysManager", value = "权限拥有者实体(人员、机构、角色)", required = true, dataType = "SysManager")
    })
    @ResponseBody
    @GetMapping("/findList")
    public BaseResp findList(@RequestParam(name = "page", defaultValue = "1")Integer page,
                             @RequestParam(name = "pageSize", defaultValue = "25")Integer pageSize,
                             SysManager manager) throws ExecutionException {
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        Pageable pageable = new PageRequest(page, pageSize);
        Page<SysManager> managerPage = sysManagerRepository.findAll(new Specification<SysManager>(){
            @Override
            public Predicate toPredicate(Root<SysManager> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(null!=manager.getName()&&!"".equals(manager.getName())){
                    list.add(criteriaBuilder.equal(root.get("name").as(String.class), manager.getName()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        resp.setData(managerPage);
        return resp;
    }
}
