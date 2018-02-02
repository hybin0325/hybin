package net.medcrm.yjb.his.web.aggregator.service;

import net.medcrm.yjb.his.web.aggregator.dto.DivisionRePosition;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by Justin on 2017/10/31.
 */
@FeignClient(name="his-omp")
public interface PositionService {

    @RequestMapping(method = RequestMethod.POST,value = "/api/position/delete")
    public int deletePosiEmploy(DivisionRePosition divisionRePosition);
}
