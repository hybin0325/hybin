package net.medcrm.yjb.workflow.feign.hystric;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.workflow.feign.client.MenuServiceClient;
import net.medcrm.yjb.workflow.feign.vo.SysMenuVO;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/24.
 */
@Component
public class MenuServiceHystric implements MenuServiceClient{
    @Override
    public BaseResp<List<String>> saveOrUpdate(SysMenuVO user) {

        System.out.println("进入熔断-> saveOrUpdate");
        return new BaseResp<>();
    }

    @Override
    public BaseResp deleteByParentId(String parentId) {

        System.out.println("进入熔断-> deleteByParentId");
        return new BaseResp<>();
    }
}
