package net.medcrm.yjb.workflow.feign.hystric;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.feign.Attachment;
import net.medcrm.yjb.workflow.feign.client.SearchServiceClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
@Component
public class SearchServiceHystric implements SearchServiceClient {
    @Override
    public BaseResp<Attachment> getById(String id) throws Exception {
        return null;
    }

    @Override
    public BaseResp<Attachment> create(Attachment attachment) throws Exception {
        return null;
    }

    @Override
    public BaseResp<List<Attachment>> createAll(List<Attachment> attachment) throws Exception {
        return null;
    }
}
