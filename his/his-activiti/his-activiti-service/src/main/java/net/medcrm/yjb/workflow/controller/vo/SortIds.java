package net.medcrm.yjb.workflow.controller.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/22.
 */
public class SortIds implements Serializable{

    String upId;
    String downId;


    public String getUpId() {
        return upId;
    }

    public void setUpId(String upId) {
        this.upId = upId;
    }

    public String getDownId() {
        return downId;
    }

    public void setDownId(String downId) {
        this.downId = downId;
    }
}
