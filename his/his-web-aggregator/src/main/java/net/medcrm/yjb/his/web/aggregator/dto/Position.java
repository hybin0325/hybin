package net.medcrm.yjb.his.web.aggregator.dto;

public class Position {
    private String id;
    private String name;
    private Integer exclusive;
    private Integer status;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    public Integer getExclusive() {
        return exclusive;
    }

    public void setExclusive(Integer exclusive) {
        this.exclusive = exclusive;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
