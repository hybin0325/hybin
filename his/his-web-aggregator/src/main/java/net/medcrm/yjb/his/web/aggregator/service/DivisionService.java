package net.medcrm.yjb.his.web.aggregator.service;

import net.medcrm.yjb.his.web.aggregator.dto.Division;
import net.medcrm.yjb.his.web.aggregator.dto.DivisionRePosition;
import net.medcrm.yjb.his.web.aggregator.fallbacks.DivisionFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name="his-omp",fallback = DivisionFallback.class)
public interface DivisionService {

    @RequestMapping(method = RequestMethod.GET,value="/api/division/select")
    public Division selectBasicById(@RequestParam("id")String id);

    @RequestMapping(method = RequestMethod.GET,value="/api/division/legalentitys")
    public List<Division> selectAll();

    @RequestMapping(method = RequestMethod.GET,value="/api/division/suspend")
    public List<Division> selectSuspendAll(@RequestParam("diviType") int diviType);

    @RequestMapping(method = RequestMethod.POST,value="/api/division/division")
    public int insertOrUpdate(@RequestBody Division division);


    @RequestMapping(method = RequestMethod.POST,value = "/api/division/delete")
    public int deleteByListId(@RequestParam("listId") String listId);

    @RequestMapping(method = RequestMethod.GET,value = "/api/division/positions")
    public List<DivisionRePosition> selectPositionsById(@RequestParam("id") String id);
}
