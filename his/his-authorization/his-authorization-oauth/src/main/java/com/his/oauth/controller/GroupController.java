package com.his.oauth.controller;

import com.his.oauth.domain.SysGroup;
import com.his.oauth.mapper.SysGroupMapper;
import com.his.oauth.repository.SysGroupRepository;
import com.his.oauth.repository.SysManagerRepository;
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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 权限访问组控制器
 * Created by Administrator on 2017/10/25.
 */
@RequestMapping("/group")
@RestController
public class GroupController implements Serializable{


    @Autowired
    private SysGroupRepository sysGroupRepository;

    @Autowired
    private SysGroupMapper sysGroupMapper;

    @Autowired
    private SysManagerRepository sysManagerRepository;


    @ApiOperation(value="查找权限访问组）", notes="查找权限访问组")
    @ResponseBody
    @GetMapping("/list")
    public BaseResp<List<SysGroup>> list() throws ExecutionException {

        BaseResp<List<SysGroup>> resp = new BaseResp<>();
        resp.setCurrentTime(new Date().getTime());
        List<SysGroup> groups = sysGroupMapper.selectSysGroupByUserId(1);

        groups.forEach(group -> {
            group.setManagers(sysManagerRepository.getByGroupId(group.getId()));

        });
        resp.setData(groups);
        return resp;
    }
    @ApiOperation(value="分页查看权限访问控制组列表", notes="分页查看权限访问控制组列表")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "SysGroup", value = "权限组实体", required = true, dataType = "SysGroup")
    })
    @ResponseBody
    @GetMapping("/findList")
    public BaseResp findList(@RequestParam(name = "page", defaultValue = "1")Integer page,
                             @RequestParam(name = "pageSize", defaultValue = "25")Integer pageSize,
                             SysGroup group) throws ExecutionException {
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        Pageable pageable = new PageRequest(page, pageSize);
        Page<SysGroup> groupPage = sysGroupRepository.findAll(new Specification<SysGroup>(){
            @Override
            public Predicate toPredicate(Root<SysGroup> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(null!=group.getName()&&!"".equals(group.getName())){
                    list.add(criteriaBuilder.equal(root.get("name").as(String.class), group.getName()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        resp.setData(groupPage);
        return resp;
    }

    @ApiOperation(value="添加/修改权限访问组）", notes="添加/修改权限访问组")
    @ApiImplicitParam(name = "SysGroup", value = "权限访问组实体)", required = true, dataType = "SysGroup")
    @ResponseBody
    @PostMapping("/saveOrUpdate")
    public BaseResp saveOrUpdate(SysGroup group) throws ExecutionException{

        SysGroup m = sysGroupRepository.save(group);
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(m);
        return resp;
    }

    @ApiOperation(value="删除权限访问组）", notes="删除权限访问组")
    @ApiImplicitParam(name = "id", value = "权限访问组实体id", required = true, dataType = "id")
    @ResponseBody
    @PostMapping("/delete")
    public BaseResp delete(SysGroup group) throws ExecutionException{

        SysGroup delGroup =  sysGroupRepository.getOne(group.getId());
        if(!(delGroup == null)){
            sysGroupRepository.delete(delGroup);
        }
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());

        return resp;
    }

}
