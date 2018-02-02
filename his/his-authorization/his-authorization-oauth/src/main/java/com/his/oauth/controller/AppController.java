package com.his.oauth.controller;

import com.his.oauth.domain.SysApp;
import com.his.oauth.domain.SysGroup;
import com.his.oauth.domain.SysMenu;
import com.his.oauth.repository.SysAppRepository;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 应用模块控制器
 * Created by Administrator on 2017/10/25.
 */
@RequestMapping("/app")
@RestController
public class AppController {

    @Autowired
    private SysAppRepository sysAppRepository;



    @ApiOperation(value="添加或修改应用模块", notes="添加或修改应用模块")
    @ApiImplicitParam(name = "SysApp", value = "应用模块实体", required = true, dataType = "SysApp")
    @ResponseBody
    @PostMapping("/saveOrUpdate")
    public BaseResp saveOrUpdate(SysApp app) throws ExecutionException{

        SysApp m = sysAppRepository.save(app);
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(m);
        return resp;
    }
    @ApiOperation(value="删除应用模块", notes="删除应用模块")
    @ResponseBody
    @PostMapping("/delete")
    public BaseResp delete(SysMenu app) throws ExecutionException{

        SysApp delApp =  sysAppRepository.getOne(app.getId());
        if(!(app == null)){
            sysAppRepository.delete(delApp);
        }
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());

        return resp;
    }


    @ApiOperation(value="查找应用模块", notes="根据UserId查找相关应用模块")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer")
    @ResponseBody
    @GetMapping("/list")
    public BaseResp menu(@RequestParam(name = "userId") Integer userId) throws ExecutionException{

        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(sysAppRepository.findAll());
        return resp;
    }

    @ApiOperation(value="分页查看系统模块列表", notes="分页查看系统模块列表")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "SysApp", value = "权限组实体", required = true, dataType = "SysApp")
    })
    @ResponseBody
    @GetMapping("/findList")
    public BaseResp findList(@RequestParam(name = "page", defaultValue = "1")Integer page,
                             @RequestParam(name = "pageSize", defaultValue = "25")Integer pageSize,
                             SysApp app) throws ExecutionException {
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        Pageable pageable = new PageRequest(page, pageSize);
        Page<SysApp> appPage = sysAppRepository.findAll(new Specification<SysApp>(){
            @Override
            public Predicate toPredicate(Root<SysApp> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(null!=app.getCode()&&!"".equals(app.getCode())){
                    list.add(criteriaBuilder.equal(root.get("code").as(String.class), app.getCode()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        resp.setData(appPage);
        return resp;
    }
}