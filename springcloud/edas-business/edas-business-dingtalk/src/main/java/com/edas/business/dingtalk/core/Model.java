package com.edas.business.dingtalk.core;

import com.alibaba.fastjson.JSON;

public class Model {
    @Override
    public String toString(){
        return this.getClass().getSimpleName()+":"+JSON.toJSONString(this)+"\n";
    }
}