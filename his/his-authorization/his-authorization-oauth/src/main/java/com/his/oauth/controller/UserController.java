package com.his.oauth.controller;

import com.his.oauth.domain.SysAuthority;
import com.his.oauth.domain.SysUser;
import com.his.oauth.mapper.SysUserMapper;
import com.his.oauth.repository.UserRepository;
import com.his.oauth.service.UserService;
import com.his.oauth.vo.SysUserVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.medcrm.yjb.his.cache.redis.RedisTemplate;
import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    @ApiOperation(value="获取当前用户信息", notes="获取当前用户信息")

    @GetMapping("/info")
    public Principal user(Principal user){
        /*System.out.println(user);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        System.out.println(userDetails);
        System.out.println(userDetails.getUsername());
        SysUser sysUser =  userRepository.findByUsernameCaseInsensitive(userDetails.getUsername());
        SysUserVO vo = new SysUserVO();
        vo.setId(sysUser.getId());
        vo.setUsername(sysUser.getUsername());
        vo.setActivated(sysUser.isActivated());
        vo.setEmail(sysUser.getEmail());
        List<String> sysAuthorities = new ArrayList<>();
        userDetails.getAuthorities().forEach(o ->{
            sysAuthorities.add(o.getAuthority());
        });
        vo.setAuthorities(sysAuthorities);
        BaseResp resp = new BaseResp();
        resp.setData(vo);*/
        return user;
    }


    @GetMapping("/user_info")
    public SysUserVO getInfo(Principal user){
        System.out.println(user);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        System.out.println(userDetails);
        System.out.println(userDetails.getUsername());
        SysUser sysUser =  userRepository.findByUsernameCaseInsensitive(userDetails.getUsername());
        SysUserVO vo = new SysUserVO();
        vo.setId(sysUser.getId());
        vo.setUsername(sysUser.getUsername());
        vo.setActivated(sysUser.isActivated());
        vo.setEmail(sysUser.getEmail());
        List<String> sysAuthorities = new ArrayList<>();
        userDetails.getAuthorities().forEach(o ->{
            sysAuthorities.add(o.getAuthority());
        });

        return vo;
    }


    @ApiOperation(value="获取系统管理用户信息", notes="获取系统管理用户信息")
    @GetMapping("/list")
    public BaseResp<List<SysUser>> findUser(){

        BaseResp resp = new BaseResp();
        List<SysUser> list = sysUserMapper.selectAllUser();
        resp.setData(list);
        return  resp;
    }

    @ApiOperation(value="添加系统用户管理员", notes="添加系统用户管理员")
    @ApiImplicitParam(name = "SysUser", value = "系统用户实体", required = true, dataType = "SysUser")
    @ResponseBody
    @PostMapping("/saveOrUpdate")
    public BaseResp<SysUser> saveOrUpdate(SysUser user) throws ExecutionException {

        SysUser sysUser =  userRepository.findByUsernameCaseInsensitive(user.getUsername());
        BaseResp resp = new BaseResp();
        if(sysUser != null){
           return new BaseResp<SysUser>(ResultStatus.user_exist);
        }else{
            SysUser u = userRepository.save(user);

            resp.setData(u);
        }
        return resp;
    }

    @ApiOperation(value="停用或启用用户", notes="停用或启用用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "系统用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "activated", value = "系统用户激活状态", required = true, dataType = "boolean")
    })
    @ResponseBody
    @PostMapping("/activated")
    public BaseResp activated(@RequestParam(name = "id") Integer id,@RequestParam(name = "activated")  boolean activated) throws ExecutionException {

        SysUser u = userRepository.getOne(id + "");
        if(u != null){
            u.setActivated(activated);
            userRepository.save(u);
        }
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        resp.setData(u);
        return resp;
    }



    @ApiOperation(value="分页查看系统管理员列表", notes="分页查看系统管理员列表")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "一页多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "SysMenu", value = "系统管理员实体", required = true, dataType = "SysMenu")
    })
    @ResponseBody
    @GetMapping("/findList")
    public BaseResp findList(@RequestParam(name = "page", defaultValue = "1")Integer page,
                             @RequestParam(name = "pageSize", defaultValue = "25")Integer pageSize,
                             SysUser user) throws ExecutionException {
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());
        Pageable pageable = new PageRequest(page, pageSize);
        Page<SysUser> userPage = userRepository.findAll(new Specification<SysUser>(){
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(null!=user.getUsername()&&!"".equals(user.getUsername())){
                    list.add(criteriaBuilder.equal(root.get("username").as(String.class), user.getUsername()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
        resp.setData(userPage);
        return resp;
    }
   /* @ApiOperation(value="删除系统用户管理员", notes="删除系统用户管理员")
    @ApiImplicitParam(name = "id", value = "系统用户实体", required = true, dataType = "id")
    @ResponseBody
    @PostMapping("/delete")
    public BaseResp delete(SysUser user) throws ExecutionException {


        SysApp delApp =  userRepository.getOne(user.getId());
        if(!(app == null)){
            sysAppRepository.delete(delApp);
        }
        BaseResp resp = new BaseResp();
        resp.setCurrentTime(new Date().getTime());

        return resp;
    }*/



}