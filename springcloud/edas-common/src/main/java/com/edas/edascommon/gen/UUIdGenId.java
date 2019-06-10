package com.edas.edascommon.gen;

import java.util.UUID;

import tk.mybatis.mapper.genid.GenId;

public class UUIdGenId implements GenId<String> {
    @Override
    public String genId(String s, String s1) {
        return UUID.randomUUID().toString().replace("-","");
    }

}
