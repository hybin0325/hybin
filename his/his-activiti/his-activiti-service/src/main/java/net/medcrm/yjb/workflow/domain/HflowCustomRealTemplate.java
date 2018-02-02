package net.medcrm.yjb.workflow.domain;

import net.medcrm.yjb.his.common.model.PersistentObject;

/**
 * 流程真实绑定表单模板表
 * Created by linshneg on 2017/12/26.
 */
public class HflowCustomRealTemplate extends PersistentObject {

    private String name;
    private String description;
    private String tpl;
    private String version;
    private String flowId;
    private String nodeId;
    public HflowCustomRealTemplate(){}

    public HflowCustomRealTemplate(HflowCustomTemplate tpl){
        this.version = tpl.getVersion();
        this.name = tpl.getName();
        this.description = tpl.getDescription();
        this.tpl = tpl.getTpl();
        this.createPersistentObject();
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getTpl() {
        return tpl;
    }

    public void setTpl(String tpl) {
        this.tpl = tpl;
    }
}
