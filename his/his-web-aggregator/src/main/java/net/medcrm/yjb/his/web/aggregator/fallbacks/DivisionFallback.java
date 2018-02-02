package net.medcrm.yjb.his.web.aggregator.fallbacks;

import net.medcrm.yjb.his.web.aggregator.dto.Division;
import net.medcrm.yjb.his.web.aggregator.dto.DivisionRePosition;
import net.medcrm.yjb.his.web.aggregator.service.DivisionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DivisionFallback implements DivisionService{


    @Override
    public Division selectBasicById(String id) {
        return null;
    }

    @Override
    public List<Division> selectAll() {
        return null;
    }

    @Override
    public List<Division> selectSuspendAll(int diviType) {
        return null;
    }

    @Override
    public int insertOrUpdate(Division division) {
        return 0;
    }

    @Override
    public int deleteByListId(String listId) {
        return 0;
    }

    @Override
    public List<DivisionRePosition> selectPositionsById(String id) {
        return null;
    }


}
