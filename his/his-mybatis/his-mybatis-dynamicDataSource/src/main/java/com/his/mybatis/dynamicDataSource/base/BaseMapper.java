package com.his.mybatis.dynamicDataSource.base;

/**
 * Created by asus on 2017/10/24.
 */
public interface BaseMapper<T> {
    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
