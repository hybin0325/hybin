package net.medcrm.yjb.workflow.feign.client;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.Attachment;
import net.medcrm.yjb.workflow.config.feign.OAuth2FeignAutoConfiguration;
import net.medcrm.yjb.workflow.feign.hystric.SearchServiceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by linsheng on 2017/12/4.
 */


@FeignClient(name = "searchService", url = "${searchService.ribbon.listOfServers}", configuration = {
       OAuth2FeignAutoConfiguration.class }, fallback = SearchServiceHystric.class)
public interface SearchServiceClient {

    /**
     * 根据ID查询附件
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/api/search/getById",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResp<Attachment> getById	(@RequestParam(value = "id") String id) throws Exception;
    /**
     * 添加一个附件
     *
     * @return
     */
    @RequestMapping(value = "/api/search/create",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BaseResp<Attachment> create(@RequestBody Attachment attachment) throws  Exception;


    @ResponseBody
    @RequestMapping(value = "/api/search/createAll",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResp<List<Attachment>> createAll(@RequestBody List<Attachment> attachment) throws  Exception;

}
