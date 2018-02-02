package net.medcrm.yjb.his.web.aggregator.service;

import net.medcrm.yjb.his.web.aggregator.dto.Division;
import net.medcrm.yjb.his.web.aggregator.fallbacks.Division2Fallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Justin on 2017/10/27.
 */
@FeignClient(name="his-omp",fallback = Division2Fallback.class)
public interface Division2Service {


}
