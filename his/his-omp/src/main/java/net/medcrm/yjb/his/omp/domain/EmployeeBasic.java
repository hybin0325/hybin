package net.medcrm.yjb.his.omp.domain;

import java.io.Serializable;

/**
 * Created by Justin on 2017/11/2.
 */
public class EmployeeBasic implements Serializable{

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
