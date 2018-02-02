package com.his.oauth.controller;

import com.his.oauth.domain.SysElement;
import com.his.oauth.domain.SysMenu;
import com.his.oauth.mapper.SysElementAuthorityMapper;
import com.his.oauth.mapper.SysGroupMapper;
import com.his.oauth.repository.MenuRepository;
import com.his.oauth.repository.SysAuthorityRepository;
import com.his.oauth.repository.SysElementRepository;
import com.his.oauth.vo.SysElementAuthorityVO;
import com.his.oauth.vo.SysGroupVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.common.model.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
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
 * Created by Administrator on 2017/10/25.
 */
@RequestMapping("/menu")
@RestController
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private SysElementRepository sysElementRepository;

    @Autowired
    private SysElementAuthorityMapper sysElementAuthorityMapper;

    @Autowired
    private SysGroupMapper sysGroupMapper;
    @ResponseBody
    @GetMapping("/list")
    //@PreAuthorize("hasAuthority('query-demoxxxxxxxxxxxxxxxxx')")
    public BaseResp menu() throws ExecutionException{

        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(menuRepository.findAll());
        return resp;
    }
    @ApiOperation(value="根据ID查看访问控制组信息", notes="根据ID查看访问控制组信息")
    @ApiImplicitParam(name = "groupId", value = "访问控制组ID", required = true, dataType = "Integer")
    @ResponseBody
    @GetMapping("/accessList")
    public BaseResp<SysGroupVO> getMenuAndElements(Integer groupId){
        BaseResp<SysGroupVO> resp = new BaseResp<>();

        SysGroupVO groupVO = sysGroupMapper.selectSysGroupVOById(groupId);
        List<SysMenu> sysMenus = menuRepository.findAll();
        sysMenus.forEach(menu -> {
            List<SysElement> elements = sysElementRepository.getByParentId(menu.getId());

            elements.forEach(element -> {
                SysElementAuthorityVO sysElementAuthorityVO = sysElementAuthorityMapper.selectSysElementAuthorityByElementIdAndGroupId(groupId, element.getId());
                element.setStatus(sysElementAuthorityVO == null ? 0 : 1);
            });
            menu.setElements(elements);
        });

        groupVO.setMenus(sysMenus);
        resp.setData(groupVO);

        return resp;
    }

    @ApiOperation(value="分页查看菜单列表", notes="分页查看菜单列表")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "SysMenu", value = "菜单实体", required = true, dataType = "SysMenu")
    })
    @ResponseBody
    @GetMapping("/findList")
    public BaseResp findList(@RequestParam(name = "page", defaultValue = "1")Integer page,
                             @RequestParam(name = "pageSize", defaultValue = "25")Integer pageSize,
                             SysMenu menu) throws ExecutionException {
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        Pageable pageable = new PageRequest(page, pageSize);
        Page<SysMenu> appPage = menuRepository.findAll(new Specification<SysMenu>(){
            @Override
            public Predicate toPredicate(Root<SysMenu> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(null!=menu.getTitle()&&!"".equals(menu.getTitle())){
                    list.add(criteriaBuilder.equal(root.get("title").as(String.class), menu.getTitle()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        resp.setData(appPage);
        return resp;
    }

    @ApiOperation(value="添加或修改菜单", notes="添加或修改菜单")

    @ApiImplicitParam(name = "SysMenu", value = "菜单实体", required = true, dataType = "SysMenu")
    @ResponseBody
    @PostMapping("/saveOrUpdate")
    public BaseResp saveOrUpdate(SysMenu menu) throws ExecutionException{

        SysMenu m = menuRepository.save(menu);
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(m);
        return resp;
    }

    @ApiOperation(value="删除菜单", notes="删除菜单")

    @ApiImplicitParam(name = "SysMenu", value = "菜单实体(Id必填)", required = true, dataType = "SysMenu")
    @ResponseBody
    @PostMapping("/delete")
    public BaseResp delete(SysMenu menu) throws ExecutionException{

        SysMenu delMenu =  menuRepository.getOne(menu.getId());
        if(!(menu == null)){
            menuRepository.delete(delMenu);
        }
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());

        return resp;
    }


}