package com.edas.edascommon.gen;


import com.edas.edascommon.model.SnowflakeIdWorker;

import tk.mybatis.mapper.genid.GenId;

/***
 * 自定义主键生成策略
 * @author admin
 */
public class SnowflakeId implements GenId<Long> {

    @Override
    public Long genId(String table, String column) {
        //由于注解只能配置类，不能注入，需要通过静态方法从 Spring Context 中获取，获取后就可以正常使用了
        //SnowflakeIdGenerator idGenerator = SpringContextHolder.getBean(SnowflakeIdGenerator.class);
    	SnowflakeIdWorker idGenerator = SnowflakeIdWorker.getIdWorkerInstance();
    	return idGenerator.nextId();
    }
}