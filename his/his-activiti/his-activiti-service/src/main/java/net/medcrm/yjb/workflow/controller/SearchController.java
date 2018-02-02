package net.medcrm.yjb.workflow.controller;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.Attachment;
import net.medcrm.yjb.workflow.feign.client.SearchServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by linsheng on 2017/12/4.
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {


    @Autowired
    SearchServiceClient attachmentServiceClient;

    @ResponseBody
    @PostMapping(value = "/create")
    public BaseResp<Attachment> create(@RequestBody Attachment attachment) throws  Exception{

        return attachmentServiceClient.create(attachment);
    }

    @ResponseBody
    @PostMapping(value = "/createAll")
    public BaseResp<List<Attachment>> createAll(@RequestBody List<Attachment> attachments) throws  Exception{

        return attachmentServiceClient.createAll(attachments);
    }


    @ResponseBody
    @GetMapping(value = "/getById")
    public BaseResp<Attachment> getById	(@RequestParam(value = "id") String id) throws Exception{
        return attachmentServiceClient.getById(id);
    }

}
