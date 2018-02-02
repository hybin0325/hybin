package net.medcrm.yjb.his.web.aggregator.fallbacks;

import net.medcrm.yjb.his.web.aggregator.dto.DivisionRePosition;
import net.medcrm.yjb.his.web.aggregator.service.PositionService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by Justin on 2017/10/31.
 */
@Component
public class PositionFallback implements PositionService{

    @Override
    public int deletePosiEmploy(DivisionRePosition divisionRePosition) {
        return 0;
    }
}
