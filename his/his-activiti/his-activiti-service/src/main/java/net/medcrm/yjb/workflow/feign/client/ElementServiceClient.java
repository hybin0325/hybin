package net.medcrm.yjb.workflow.feign.client;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.ElementVO;
import net.medcrm.yjb.workflow.config.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by linsheng on 2017/12/8.
 */
@FeignClient(name = "userService", url = "${userService.ribbon.listOfServers}", configuration = {
        OAuth2FeignAutoConfiguration.class })
public interface ElementServiceClient {

    @RequestMapping(value = "/api/element/saveOrUpdateAll",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResp saveOrUpdateAll(@RequestBody List<ElementVO> elements) throws ExecutionException;
}
