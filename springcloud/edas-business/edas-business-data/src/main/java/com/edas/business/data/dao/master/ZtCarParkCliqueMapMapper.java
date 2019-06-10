package com.edas.business.data.dao.master;

import com.edas.business.data.entity.ZtCarParkCliqueMap;

import com.edas.edascommon.core.BaseCrudMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ZtConfigkeyMapper继承基类
 */
@Repository
public interface ZtCarParkCliqueMapMapper extends BaseCrudMapper<ZtCarParkCliqueMap> {

	@Select("select * from shopwwi_zt_car_park_clique_map where `control_id` like \"%\"#{controlId}\"%\"")
	public ZtCarParkCliqueMap findZtCarparkCliqueMap(String controlId);


	@Select("select * from shopwwi_zt_car_park_clique_map where `control_id` like \"%\"#{controlId}\"%\"")
	public List<ZtCarParkCliqueMap> findZtCarparkCliqueMapAll(String controlId);

}