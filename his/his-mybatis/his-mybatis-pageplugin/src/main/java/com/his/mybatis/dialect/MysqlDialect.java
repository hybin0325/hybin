package com.his.mybatis.dialect;

import com.his.mybatis.pagination.Page;

/**
 * 
 * @author Administrator
 *
 */
public class MysqlDialect implements Dialect{

    public String pageSql(String sql, Page page) {

        StringBuffer querySql =
                new StringBuffer("SELECT * FROM ( ").append(sql).append(" ) AS COUNT_PAGE")
                        .append(" LIMIT ").append( page.getStart() ).append(" , ").append(page.getPageSize());
        return querySql.toString();
    }
}
