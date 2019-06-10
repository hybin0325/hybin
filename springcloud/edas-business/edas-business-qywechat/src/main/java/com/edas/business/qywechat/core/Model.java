package com.edas.business.qywechat.core;

import com.alibaba.fastjson.JSON;

public class Model {
    @Override
    public String toString(){
        return this.getClass().getSimpleName()+":"+JSON.toJSONString(this)+"\n";
    }
}