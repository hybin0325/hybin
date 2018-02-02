package net.medcrm.yjb.workflow.feign.client;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.SysLogVO;
import net.medcrm.yjb.workflow.config.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linsheng on 2018/1/3.
 */
@FeignClient(name = "his-authorization",
        configuration = {OAuth2FeignAutoConfiguration.class})
public interface LogFeignClient {

    @RequestMapping(value = "/api/log/save",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResp<SysLogVO> save(@RequestBody SysLogVO vo) throws  Exception;
}
