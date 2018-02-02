package net.medcrm.yjb.workflow.controller;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.Attachment;
import net.medcrm.yjb.his.feign.ElementVO;
import net.medcrm.yjb.workflow.feign.client.ElementServiceClient;
import net.medcrm.yjb.workflow.feign.client.SearchServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by linsheng on 2017/12/4.
 */
@RestController
@RequestMapping(value = "/element")
public class ElementController {


    @Autowired
    ElementServiceClient elementServiceClient;

    @ResponseBody
    @PostMapping(value = "/create")
    public BaseResp<ElementVO> create(@RequestBody List<ElementVO> elements) throws  Exception{

        return elementServiceClient.saveOrUpdateAll(elements);
    }


}
