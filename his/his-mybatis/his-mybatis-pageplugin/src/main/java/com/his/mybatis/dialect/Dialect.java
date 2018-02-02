package com.his.mybatis.dialect;

import com.his.mybatis.pagination.Page;

/**
 * 
 * @author Administrator
 *
 */
public interface Dialect {

    String pageSql(String sql, Page page);
}
