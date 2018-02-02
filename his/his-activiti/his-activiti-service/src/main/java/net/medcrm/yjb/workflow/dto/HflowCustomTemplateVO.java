package net.medcrm.yjb.workflow.dto;

import net.medcrm.yjb.his.common.model.PersistentObject;
import net.medcrm.yjb.his.tool.NumberConvert;
import net.medcrm.yjb.workflow.domain.HflowCustomTemplate;

/**
 * Created by Administrator on 2018/1/10.
 */


public class HflowCustomTemplateVO  extends PersistentObject{

    private String name;
    private String description;
    private String type;
    private String version;
    private String pid;


    public HflowCustomTemplateVO(){

    }
    public HflowCustomTemplateVO(HflowCustomTemplate template){

        this.setId(template.getId());
        this.setCreateUser(template.getCreateUser());
        this.setUpdateDate(template.getUpdateDate());
        this.setCreateDate(template.getCreateDate());
        this.setStatus(template.getStatus());
        this.name = template.getName();
        this.description = template.getDescription();
        this.type = template.getType();
        this.version = NumberConvert.stringToOneBigDecimalPlace(template.getVersion());
        this.pid = template.getPid();
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getVersion() {
       return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
