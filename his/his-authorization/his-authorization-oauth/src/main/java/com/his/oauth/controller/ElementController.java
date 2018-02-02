package com.his.oauth.controller;

import com.his.oauth.domain.SysElement;
import com.his.oauth.repository.SysElementRepository;
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
 * Created by Administrator on 2017/10/26.
 */

@RequestMapping("/element")
@RestController
public class ElementController {

    @Autowired
    private SysElementRepository sysElementRepository;

    @ApiOperation(value="查找页面元素（如增删改查按钮）", notes="查找页面元素（如增删改查按钮）")
    @ResponseBody
    @GetMapping("/list")
    public BaseResp list() throws ExecutionException {
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(sysElementRepository.findAll());

        return resp;
    }

    @ApiOperation(value="分页查看元素操作列表", notes="分页查看元素操作列表")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "SysElement", value = "页面元素实体条件", required = true, dataType = "SysElement")
    })
    @ResponseBody
    @GetMapping("/findList")
    public BaseResp findList(@RequestParam(name = "page", defaultValue = "1")Integer page,
                             @RequestParam(name = "pageSize", defaultValue = "25")Integer pageSize,
                             SysElement element) throws ExecutionException {
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        Pageable pageable = new PageRequest(page, pageSize);
        Page<SysElement> elementPage = sysElementRepository.findAll(new Specification<SysElement>(){
            @Override
            public Predicate toPredicate(Root<SysElement> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(null!=element.getName()&&!"".equals(element.getName())){
                    list.add(criteriaBuilder.equal(root.get("name").as(String.class), element.getName()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        resp.setData(elementPage);
        return resp;
    }

   /* public BaseResp findForPage(){
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        Pageable pageable = new PageRequest(page, pageSize);
        resp.setData(sysElementRepository.findAll(pageable));
        return resp;
    }*/
    @ApiOperation(value="添加页面操作元素（如增删改查按钮）", notes="添加页面操作元素（如增删改查按钮）")
    @ApiImplicitParam(name = "SysElement", value = "页面元素实体", required = true, dataType = "SysElement")
    @ResponseBody
    @PostMapping("/saveOrUpdate")
    public BaseResp saveOrUpdate(SysElement element) throws ExecutionException{

        SysElement m = sysElementRepository.save(element);
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(m);
        return resp;
    }

    @ApiOperation(value="删除页面操作元素（如增删改查按钮）", notes="删除页面操作元素（如增删改查按钮）")
    @ApiImplicitParam(name = "id", value = "页面元素id", required = true, dataType = "id")
    @ResponseBody
    @PostMapping("/delete")
    public BaseResp delete(SysElement element) throws ExecutionException{

        SysElement delElement =  sysElementRepository.getOne(element.getId());
        if(!(element == null)){
            sysElementRepository.delete(delElement);
        }
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());

        return resp;
    }
}
