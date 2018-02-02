package net.medcrm.yjb.workflow.feign.client;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.workflow.config.feign.OAuth2FeignAutoConfiguration;
import net.medcrm.yjb.workflow.feign.vo.SysMenuVO;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Administrator on 2017/11/24.
 */

@FeignClient(name = "userService",
       url = "${userService.ribbon.listOfServers}",
      configuration = {OAuth2FeignAutoConfiguration.class})
public interface MenuServiceClient {

    /**
     * 添加或更新自定义模块
     * @param sysMenuVO
     * @return
     */
    @RequestMapping(value = "/api/menu/customModelSaveOrUpdate"
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResp<List<String>> saveOrUpdate(@RequestBody SysMenuVO sysMenuVO);

    /**
     * 删除自定义模块
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/api/menu/deleteByParentId"
            , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
            , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResp deleteByParentId(@RequestParam(value = "parentId") String parentId);
}
