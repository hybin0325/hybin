package me.zhengjie.modules.data.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;

import java.sql.Timestamp;
import java.util.List;

/**
* @author zhanghouying
* @date 2019-08-24
*/
@Data
public class DataCoreQueryCriteria{

	/**
	 * 模糊
	 */
    @Query(type = Query.Type.LESS_THAN)
    private String proName;

	
}
